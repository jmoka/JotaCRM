package top.jota.controller;

import java.sql.Connection;
import java.util.Properties;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.jasperreports.engine.JRException;
import top.jota.dao.services.ServiceJasperViewer;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;

@Controller
public class ControleProperties {
	
	
	
	
	// ATUALIZAR E REDIRECIONAR

		@PostMapping("/atualizarDiretorioExportacaoRelatorio")
		public String atualizarDiretorioExportacaoRelatorio(@RequestParam("opcao") String opcao, Model model)
				throws JRException {

			if (opcao != null) {
				Connection conection = null;
				DbProperties dbProperties = null;
				Db db = new Db(dbProperties);
				String nomeDB = "exportarRelatorio";
				String opcaoArquivo = "src/main/resources/" + nomeDB + ".properties";

				 Properties props = dbProperties.obterProperties("opcaoStyle");        
			        

				 dbProperties.salvarOpcaoStyle(opcaoArquivo, opcao, props);    

				
				model.addAttribute("mensagem", "opcao Salvo com Sucesso no Diretório: " + opcao);

				db.closeConnection();
				return "index";

			} else {
				System.out.println("erro");
			}

			return null;

		}
		
		
		@PostMapping("/atualizarStyle")
		public String atualizarStyle(@RequestParam("opcao") String opcao, Model model)
				throws JRException {

			if (opcao != null) {
				Connection conection = null;
				DbProperties dbProperties = null;
				Db db = new Db(dbProperties);
				String nomeDB = "opcaoStyle";
				String opcaoArquivo = "src/main/resources/" + nomeDB + ".properties";

				Properties props = dbProperties.obterProperties("opcaoStyle");

				dbProperties.salvarPropertiesDiretorioRelatório(opcaoArquivo, opcao, props);

				ServiceJasperViewer service = new ServiceJasperViewer();

				service.exportarPDF(opcaoArquivo, conection, opcao);

				model.addAttribute("mensagem", "opcao Salvo com Sucesso no Diretório: " + opcao);

				db.closeConnection();
				return "index";

			} else {
				System.out.println("erro");
			}

			return null;

		}

}
