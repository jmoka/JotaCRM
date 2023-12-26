package top.jota.controller;

import java.sql.Connection;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JRException;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;

@Controller
public class ControllerStyle {
	
	// ATUALIZAR E REDIRECIONAR

		@PostMapping("/atualizarStyle")
		public String atualizarStyle(@RequestParam("opcao") String opcao, Model model)
				throws JRException {

				System.out.println("opcao "+opcao );
			
			
				if (opcao != null) {
				System.out.println(opcao);
				/*
				Connection conection = null;
				DbProperties dbProperties = null;
				Db db = new Db(dbProperties);
				String nomeDB = "opcaoStyle";
				String caminhoArquivo = "src/main/resources/" + nomeDB + ".properties";

				Properties props = dbProperties.obterProperties();

				dbProperties.salvarOpcaoStyle(caminhoArquivo, opcao, props);			
			

				model.addAttribute("mensagem", "Style Salvo com Sucesso no Diretório: " + opcao);

				db.closeConnection();
				*/
				return "index";
				

			} else {
				System.out.println("erro");
			}

			return null;

		}

}
