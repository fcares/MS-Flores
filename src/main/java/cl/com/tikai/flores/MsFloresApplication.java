package cl.com.tikai.flores;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MsFloresApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(MsFloresApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MsFloresApplication.class, args);
		LOG.info("Iniciando el servidor");
		
	}
	@Override
	public void run(String... args) throws Exception {
		LOG.info("............run");
		
	}
	

}
