package top.jota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import top.jota.controller.inteface.InterfaceControllerDao;
import top.jota.dao.entities.Nivel;
import top.jota.dao.services.factorys.FactoryServices;


@Controller
public class ControllerNIvel implements InterfaceControllerDao{

	
	@PostMapping("/inserir")	
	
	public String inserir(@RequestParam("nomeNivel")String nomeNivel, Model model) {	// recebe do formulario o input			
			
		System.out.println("nomeNivel  "+ nomeNivel);
		
			Nivel objNivel = new Nivel(nomeNivel);
			Nivel obj = FactoryServices.FactoryNivel().insert_Nivel(objNivel);	
			
			
			if(obj.getIdNivel() == null) {
				
				model.addAttribute("mensagem", "Erro ao cadastrar nome ja existe = " + nomeNivel);
				
				
			}else{
				
				model.addAttribute("mensagem", "Nível cadastrado com sucesso: " + nomeNivel);
				
			}
			
			
			 return "cadastroNivel";
		
	}
	
	

	
	
}


