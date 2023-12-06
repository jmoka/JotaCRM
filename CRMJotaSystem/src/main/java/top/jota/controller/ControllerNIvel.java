package top.jota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import ch.qos.logback.core.model.Model;
import top.jota.controller.inteface.InterfaceControllerDao;
import top.jota.dao.entities.Nivel;
import top.jota.dao.services.factorys.FactoryServices;


@Controller
public class ControllerNIvel implements InterfaceControllerDao{
	
	@Autowired
	@Qualifier("newNivel")
    private String newNivel;
	
	@PostMapping("/inserir")	
	public String inserir(@RequestParam("nameNivel")String nomeNivel, Model model) {	// recebe do formulario o input			
			Nivel objNivel = new Nivel(nomeNivel);
			Nivel obj = FactoryServices.FactoryNivel().insert_Nivel(objNivel);	
			
			if(obj.getIdNivel() == null) {
				model.addAttribute("mensagem", "Erro ao cadastrar nome ja existe = " + nomeNivel);
				
				
			}else {
				model.addAttribute("mensagem", "Nível cadastrado com sucesso: " + nomeNivel);
				
			}
			
				
			 return "pageCadastroNivel";
		
	}
	
	

	
	
}


