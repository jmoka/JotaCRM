package top.jota.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import top.jota.dao.entities.Nivel;
import top.jota.dao.services.factorys.FactoryServices;
import top.jota.dao.services.interfaces.InterfaceNivel;


@SpringBootApplication
public class TesteNivel implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TesteNivel.class, args);
    }

    @Override
    public void run(String... args) {
    
    	Nivel n  = new Nivel("super");
    	System.out.println(n);
    	FactoryServices fabricaNivel = new FactoryServices();
    	fabricaNivel.FactoryNivel().insert_Nivel(n);
    	
		
  }
}
