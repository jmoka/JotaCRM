package top.jota.controller.inteface;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface InterfaceControllerDao {
	
	public String inserir(@RequestParam("nameNivel")String nomeNivel, Model model);
	
}
