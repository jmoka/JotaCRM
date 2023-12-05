package top.jota.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.jota.controller.inteface.InterfaceControllerDao;
import top.jota.dao.entities.Nivel;
import top.jota.dao.services.factorys.FactoryServices;

@SpringBootApplication
@ComponentScan(basePackages = "top.jota")
@RestController
public class ControllerNIvel implements InterfaceControllerDao{

	
	@RequestMapping("/inserir")
	@Override
	public String inserir() {
			String nome = "faxineiro";
		
			Nivel adm = new Nivel(nome);
			FactoryServices.FactoryNivel().insert_Nivel(adm);			
		
		
		return "Inserido com sucesso o ," + "" + nome ;
	}

	


}


