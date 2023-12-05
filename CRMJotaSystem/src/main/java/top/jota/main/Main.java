package top.jota.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import top.jota.db.Db;

@SpringBootApplication
@ComponentScan(basePackages = "top.jota")
public class Main implements CommandLineRunner {
	
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);        
    }

	@Override
	public void run(String... args) throws Exception {
		//Db db = new Db();
		//db.connection();
		
	}

}
