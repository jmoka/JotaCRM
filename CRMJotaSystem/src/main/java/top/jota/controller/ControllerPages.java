package top.jota.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerPages {
	
	@GetMapping("/pageCadastroNivel")   
    public String pageCadastroNivel() {
		
		return "cadastroNivel";
		
	}
	
	@GetMapping("/atualizarDiretorioRelatorio")   
    public String atualizarDiretorioRelatorio() {
		return "atualizarDiretorioRelatorio";
		
	}
	



	
}
