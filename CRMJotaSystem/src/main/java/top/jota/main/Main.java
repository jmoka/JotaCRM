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
    	
        String argumento = "valorDoArgumento";

        
        Properties resultado = dbProperties.obterProperties("opcaoStyle");    
        
        String conteudo = resultado.getProperty("style");
      
        System.out.println("RESULTADO" + conteudo);
     
        for (String key : resultado.stringPropertyNames()) {
            System.out.println(key + ": " + resultado.getProperty(key));
        }
    	
    
    	
    	
    	
    	    	
    }
    
    
    
}
