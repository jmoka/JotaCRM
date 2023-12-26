package top.jota.main;

import java.util.Properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import top.jota.db.properties.DbProperties;

@SpringBootApplication
@ComponentScan(basePackages = "top.jota")
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
       
       
        
        // Inicie a aplicação Spring Boot
        SpringApplication.run(Main.class, args);        
    }

    @Override
    public void run(String... args) throws Exception {
        
    	DbProperties dbProperties = null;    	
    	String nomeDB = "opcaoStyle";
    	String opcaoArquivo = "src/main/resources/" + nomeDB + ".properties";
        
        Properties props = dbProperties.obterProperties("opcaoStyle");      
        String style = props.getProperty("style");
       
            	
    
    	
    	
    	
    	    	
    }
    
    
    
}
