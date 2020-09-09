package cl.com.tikai.flores.services;

import java.util.ArrayList;
import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;


public interface EnvioCorreoService {
	

	public boolean enviarCorreo(String asunto, String contenido, ArrayList<String> destinatarios, ArrayList<String> destinatarioCC, String cuerpo) throws AddressException, MessagingException;
		
}
