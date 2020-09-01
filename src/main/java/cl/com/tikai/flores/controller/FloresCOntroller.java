package cl.com.tikai.flores.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cl.com.tikai.flores.dto.ResultadoProcesoFlores;
import cl.com.tikai.flores.helper.ExcelHelper;


@Controller
public class FloresCOntroller {
	
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

}
