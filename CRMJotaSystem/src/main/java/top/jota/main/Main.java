package top.jota.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import top.jota.repository.jasper.Jasper2;

@SpringBootApplication
@ComponentScan(basePackages = "top.jota")
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
       
       
        
        // Inicie a aplicação Spring Boot
        SpringApplication.run(Main.class, args);        
    }

    @Override
    public void run(String... args) throws Exception {
        // Implemente lógica adicional, se necessário
    }
}
