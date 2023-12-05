package top.jota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.jota.controller.inteface.InterfaceControllerDao;
import top.jota.dao.entities.Nivel;
import top.jota.dao.services.factorys.FactoryServices;

@SpringBootApplication
@RestController
public class ControllerNIvel implements InterfaceControllerDao{
	
	@Autowired
	@Qualifier("newNivel")
    private String newNivel;
	
	@GetMapping("/inserir")
	public String inserir() {
			String nome = newNivel ; 		
			Nivel objNivel = new Nivel(nome);
			FactoryServices.FactoryNivel().insert_Nivel(objNivel);			
		return "Inserido com sucesso o" + " = " + objNivel ;
	}

	
	
}


