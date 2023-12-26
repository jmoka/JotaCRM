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
		public String atualizarDiretorioExportacaoRelatorio(@RequestParam("caminho") String caminho, Model model)
				throws JRException {

			if (caminho != null) {
				Connection conection = null;
				DbProperties dbProperties = null;
				Db db = new Db(dbProperties);
				String nomeDB = "exportarRelatorio";
				String caminhoArquivo = "src/main/resources/" + nomeDB + ".properties";

				Properties props = dbProperties.obterProperties("exportarRelatorio");

				dbProperties.salvarPropertiesDiretorioRelatório(caminhoArquivo, caminho, props);

				ServiceJasperViewer service = new ServiceJasperViewer();

				service.exportarPDF(caminhoArquivo, conection, caminho);

				model.addAttribute("mensagem", "Caminho Salvo com Sucesso no Diretório: " + caminho);

				db.closeConnection();
				return "index";

			} else {
				System.out.println("erro");
			}

			return null;

		}

}
