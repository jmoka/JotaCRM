package top.jota.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigNIvel {
	

    @Bean(name="newNivel")    
    public String newNivel() {       	
    	String nome = "jornalista";    	
        return nome;
        }
    
    
}
