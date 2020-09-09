package cl.com.tikai.flores.services;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EnvioCorreoServiceImpl implements EnvioCorreoService{
	
	private static Logger LOG = LoggerFactory.getLogger(EnvioCorreoService.class);

	/**
	 *
	 * @param contenido
	 * @param destinatario
	 * @param destinatarioCC
	 * @throws AddressException
	 * @throws MessagingException
	 */
		
	public boolean enviarCorreo(String asunto, String contenido, ArrayList<String> destinatarios, ArrayList<String> destinatarioCC, String cuerpo)	
			throws AddressException, MessagingException {
		LOG.info("   >> AsuntoCorreo :[" + asunto + "]");
		LOG.info("   >> correos:[" + destinatarios.toString() + "]");
		LOG.info("   >> cuerpo :[" + cuerpo + "]");
		
		Properties prop = new Properties();
		try {
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.smtp.user", "francisco.cares@gmil.com");

			Session mailSession = Session.getDefaultInstance(prop);
			mailSession.setDebug(true);
			MimeMessage mensaje = new MimeMessage(mailSession);

			mensaje.setFrom(new InternetAddress("francisco.cares@gmil.com"));
			if (destinatarios != null) {
				for (String d : destinatarios) {
					if (d != null) {
						if(!d.equalsIgnoreCase("")) {
							mensaje.addRecipient(RecipientType.TO, new InternetAddress(d));
						}
					}
					
				}
			}
			System.out.println("Copia : " + destinatarioCC);
			if (destinatarioCC != null) {
				for (String s : destinatarioCC) {
					mensaje.addRecipient(RecipientType.CC, new InternetAddress(s));
				}
			}

			mensaje.setSubject(asunto, "UTF-8");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(cuerpo, "UTF-8", "html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			mensaje.setContent(multipart);
			Transport transporte = mailSession.getTransport("smtp");
			transporte.connect("francisco.cares@gmail.com", "francisco1203");
			transporte.sendMessage(mensaje, mensaje.getAllRecipients());
			transporte.close();
		} catch (Exception e) {
			System.out.println("Error en Mail");
			return false;
		}
		return true;
	}
	
}
