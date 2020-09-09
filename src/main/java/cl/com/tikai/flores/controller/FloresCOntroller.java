package cl.com.tikai.flores.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.com.tikai.flores.dto.ResultadoProcesoFlores;
import cl.com.tikai.flores.helper.ExcelHelper;
import cl.com.tikai.flores.services.EnvioCorreoService;


@Controller
public class FloresCOntroller {
	
   @Autowired
	EnvioCorreoService envioCorreoInterface;
	  
	private static Logger LOG = LoggerFactory.getLogger(FloresCOntroller.class);

	
	@PostMapping(value="/informacionFlores")
	public String informacionFlores(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		LOG.info("+++++ informacionFlores:[" + file.getOriginalFilename()+ "]");
		ArrayList<ResultadoProcesoFlores> resultadoProcesoFlores = null;
		 if (ExcelHelper.hasExcelFormat(file)) {
			 
			 resultadoProcesoFlores = ExcelHelper.leeExcel(file.getInputStream());
		 }
		
		 model.addAttribute("nombreArchivoFlores", file.getOriginalFilename());
		model.addAttribute("resultadoProcesoFlores", resultadoProcesoFlores);
		return "resultadoFlores";
	}
	
	@GetMapping(value="/correos")
	public String correo() throws IOException {
		LOG.info("+++++ envioCorreo");
		
		return "correo";
	}
	
	
	@PostMapping(value="/envioCorreo")
	public String envioCorreo(@RequestParam("file_correos") MultipartFile file_correos,@RequestParam("file_cuerpo") MultipartFile file_cuerpo,@RequestParam("AsuntoCorreo") String AsuntoCorreo, Model model) throws IOException {
		LOG.info(">>> Correos:[" + file_correos.getOriginalFilename() + "] Cuerpo[" + file_cuerpo.getOriginalFilename() + "] AsuntoCorreo:[" + AsuntoCorreo + "]");

	try {
		String cuerpo = new String(file_cuerpo.getBytes());
		ArrayList<String> cooreosEnviados = ExcelHelper.leeCorreosDeExcel(file_correos.getInputStream());
		envioCorreoInterface.enviarCorreo(AsuntoCorreo,null,cooreosEnviados, null,cuerpo);
		model.addAttribute("archivoConCorreos", file_correos.getOriginalFilename());
		model.addAttribute("ArchivosConHTML", file_cuerpo.getOriginalFilename());
		model.addAttribute("AsuntoCorreo", AsuntoCorreo);
		model.addAttribute("correos", cooreosEnviados);
	} catch ( IOException | MessagingException e) {
		e.printStackTrace();
	}
		return "correoEnviado";
	}

}
