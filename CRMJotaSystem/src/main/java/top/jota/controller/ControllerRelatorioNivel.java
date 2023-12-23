package top.jota.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import top.jota.dao.services.ServiceJasperViewer;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;

@Controller
public class ControllerRelatorioNivel {

	// TELA

	// TELA TODOS NIVEIS ORDENAR POR ID
	@GetMapping("/relatorioNivelTodosTelaPorId")
	public String relatorioNivelTodosTelaPorId(Model model) throws JRException {

		DbProperties dbProperties = null;
		Db db = new Db(dbProperties);

		try {
			ServiceJasperViewer service = new ServiceJasperViewer();
			String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";

			service.abrirJasperViewer(jrxml, db.connection());

			model.addAttribute("mensagem", "Relatório Gerado com Sucesso organizado por ID, abra o Relatório na Tela!");

			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();

		}
		db.closeConnection();
		return null;

	}

	// TELA TODOS NIVEIS NOME
	@GetMapping("/relatorioNivelTodosTelaNome")
	public String relatorioNivelTodosTelaNome(Model model) throws JRException {
		System.out.println("nivelRelatorio");

		DbProperties dbProperties = null;
		Db db = new Db(dbProperties);

		try {
			ServiceJasperViewer service = new ServiceJasperViewer();
			String jrxml = "relatorios/jrxml/nivelTodos.jrxml";

			service.abrirJasperViewer(jrxml, db.connection());
			model.addAttribute("mensagem",
					"Relatório Gerado com Sucesso organizado por NOME, abra o Relatório na Tela!");

			db.closeConnection();
			return "cadastroNivel";
		} catch (Exception e) {
			e.printStackTrace();

		}
		db.closeConnection();
		return null;

	}

	// PDF

	// PDF TODOS NIVEIS ID

	@GetMapping("/relatorioNivelTodosPDFPorID")
	public String relatorioNivelTodosPDFPorID(Model model) throws JRException, IOException {
		DbProperties dbProperties = null;
		Db db = new Db(dbProperties);

		try {
			Properties props = dbProperties.obterProperties();

			// Gere uma UUID
			UUID extensao = UUID.randomUUID();

			// Obtenha o caminho de saída do arquivo do properties
			String caminhoSaida = props.getProperty("caminhoSaida");

			// Gere o nome do arquivo com a extensão ".pdf"
			String nomeArquivo = "\\relatorio-" + extensao + ".pdf";

			// Concatene o caminho de saída com o nome do arquivo
			String caminhoCompleto = caminhoSaida + nomeArquivo;

			System.out.println("Caminho completo do arquivo: " + caminhoCompleto);

			String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";

			ServiceJasperViewer service = new ServiceJasperViewer();

			// Abra um FileOutputStream
			try (FileOutputStream outputStream = new FileOutputStream(caminhoCompleto)) {
				service.exportarPDFcloseOutputStream(jrxml, db.connection(), outputStream);
			}

			model.addAttribute("mensagem",
					"Relatório PDF Gerado com Sucesso Organizado por ID !! verifique o Caminho:  " + caminhoCompleto);

			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return null;
	}

	// PDF TODOS NIVEIS NOME

	@GetMapping("/relatorioNivelTodosPDFPorNome")
	public String relatorioNivelTodosPDFPorNome(Model model) throws JRException, IOException {
		DbProperties dbProperties = null;
		Db db = new Db(dbProperties);

		try {
			Properties props = dbProperties.obterProperties();

			// Gere uma UUID
			UUID extensao = UUID.randomUUID();

			// Obtenha o caminho de saída do arquivo do properties
			String caminhoSaida = props.getProperty("caminhoSaida");

			// Gere o nome do arquivo com a extensão ".pdf"
			String nomeArquivo = "\\relatorio-" + extensao + ".pdf";

			// Concatene o caminho de saída com o nome do arquivo
			String caminhoCompleto = caminhoSaida + nomeArquivo;

			System.out.println("Caminho completo do arquivo: " + caminhoCompleto);

			String jrxml = "relatorios/jrxml/nivelTodos.jrxml";

			ServiceJasperViewer service = new ServiceJasperViewer();

			// Abra um FileOutputStream
			try (FileOutputStream outputStream = new FileOutputStream(caminhoCompleto)) {
				service.exportarPDFcloseOutputStream(jrxml, db.connection(), outputStream);

			}

			model.addAttribute("mensagem",
					"Relatório PDF Gerado com Sucesso Organizado por NOME !! verifique o Caminho:  " + caminhoCompleto);

			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return null;
	}

	// HTML

	// HTML TODOS NIVEIS ID

	@GetMapping("/relatorioNivelTodosHTMLID")
	public String relatorioNivelTodosHTMLID(Model model) throws JRException {

		DbProperties dbProperties = new DbProperties();
		Db db = new Db(dbProperties);

		Properties props = dbProperties.obterProperties();

		// Gere uma UUID
		UUID extencao = UUID.randomUUID();

		// Obtenha o caminho de saída do arquivo do properties
		String caminhoSaida = props.getProperty("caminhoSaida");

		// Gere o nome do arquivo com a extensão ".pdf"
		String nomeArquivo = "\\relatorio-" + extencao + ".html";

		// Concatene o caminho de saída com o nome do arquivo
		String caminhoCompleto = caminhoSaida + nomeArquivo;

		try {
			String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";
			ServiceJasperViewer service = new ServiceJasperViewer();
			service.exportarHTML(jrxml, db.connection(), caminhoCompleto);

			model.addAttribute("mensagem",
					"Relatório HTML Gerado com Sucesso Organizado por ID !! verifique o Caminho:  " + caminhoCompleto);
			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();

		return null;

	}

	// HTML TODOS NIVEIS NOME

	@GetMapping("/relatorioNivelTodosHTMLNome")
	public String relatorioNivelTodosHTML(Model model) throws JRException {

		DbProperties dbProperties = new DbProperties();
		Db db = new Db(dbProperties);

		Properties props = dbProperties.obterProperties();

		// Gere uma UUID
		UUID extencao = UUID.randomUUID();

		// Obtenha o caminho de saída do arquivo do properties
		String caminhoSaida = props.getProperty("caminhoSaida");

		// Gere o nome do arquivo com a extensão ".pdf"
		String nomeArquivo = "\\relatorio-" + extencao + ".html";

		// Concatene o caminho de saída com o nome do arquivo
		String caminhoCompleto = caminhoSaida + nomeArquivo;

		try {
			String jrxml = "relatorios/jrxml/nivelTodos.jrxml";
			ServiceJasperViewer service = new ServiceJasperViewer();
			service.exportarHTML(jrxml, db.connection(), caminhoCompleto);
			model.addAttribute("mensagem",
					"Relatório HTML Gerado com Sucesso Organizado por NOME !! verifique o Caminho:  "
							+ caminhoCompleto);
			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();

		return null;

	}

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

			Properties props = dbProperties.obterProperties();

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

	// RELATÓRIO POR ID

	// TELA
	@PostMapping("/nivelRelatorioIdTela")
	public String nivelRelatorioId(@RequestParam("id") Long id, Model model) {
		System.out.println("nivelRelatorioId");

		DbProperties dbProperties = null;
		Db db = new Db(dbProperties);
		ServiceJasperViewer service = new ServiceJasperViewer();

		try {
			// Adiciona parâmetros e obtém JasperPrint
			service.addParams("idNivel", id);
			service.abrirJasperViewer("relatorios/jrxml/nivelPorID.jrxml", db.connection());
			model.addAttribute("mensagem", "Relatório na Tela Gerado com Sucesso com ID Escolhido nº " + id
					+ ", abra o relatório Minimizado ");

			db.closeConnection();
			return "cadastroNivel";
		} catch (Exception e) {
			// Trate a exceção, imprima mensagens ou redirecione para uma página de erro
			e.printStackTrace();
			return null;
		}
	}

	// PDF
	@PostMapping("/nivelRelatorioIdPDF")
	public String nivelRelatorioIdPDF(@RequestParam("id") Long id, Model model) {
		DbProperties dbProperties = new DbProperties(); // Corrigir a criação do objeto DbProperties
		Db db = new Db(dbProperties);

		try {
			Properties props = dbProperties.obterProperties();

			// Gere uma UUID
			UUID extensao = UUID.randomUUID();

			// Obtenha o caminho de saída do arquivo do properties
			String caminhoSaida = props.getProperty("caminhoSaida");

			// Gere o nome do arquivo com a extensão ".pdf"
			String nomeArquivo = "\\relatorio-" + extensao + ".pdf";

			// Concatene o caminho de saída com o nome do arquivo
			String caminhoCompleto = caminhoSaida + nomeArquivo;

			System.out.println("Caminho completo do arquivo: " + caminhoCompleto);

			String jrxml = "relatorios/jrxml/nivelPorID.jrxml";

			ServiceJasperViewer service = new ServiceJasperViewer();

			// Adiciona parâmetros antes de exportar o PDF
			service.addParams("idNivel", id);

			// Abra um FileOutputStream
			try (FileOutputStream outputStream = new FileOutputStream(caminhoCompleto)) {
				service.exportarPDFcloseOutputStream(jrxml, db.connection(), outputStream);
			}

			// Redirecionar para a visualização do relatório
			model.addAttribute("mensagem",
					"Relatório PDF Gerado com Sucesso com ID Escolhido nº " + id + " no Caminho:  " + caminhoCompleto);

			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeConnection();
		}

		return null;
	}

	// HTML
	@PostMapping("/nivelRelatorioIdHTML")
	public String nivelRelatorioIdHTML(@RequestParam("id") Long id, Model model) {
		DbProperties dbProperties = new DbProperties();
		Db db = new Db(dbProperties);

		Properties props = dbProperties.obterProperties();

		// Gere uma UUID
		UUID extencao = UUID.randomUUID();

		// Obtenha o caminho de saída do arquivo do properties
		String caminhoSaida = props.getProperty("caminhoSaida");

		// Gere o nome do arquivo com a extensão ".pdf"
		String nomeArquivo = "\\relatorio-" + extencao + ".html";

		// Concatene o caminho de saída com o nome do arquivo
		String caminhoCompleto = caminhoSaida + nomeArquivo;

		try {
			String jrxml = "relatorios/jrxml/nivelTodos.jrxml";
			ServiceJasperViewer service = new ServiceJasperViewer();
			service.exportarHTML(jrxml, db.connection(), caminhoCompleto);
			// Adiciona parâmetros antes de exportar o PDF
			service.addParams("idNivel", id);
			model.addAttribute("mensagem",
					"Relatório HTML Gerado com Sucesso com ID Escolhido nº " + id + " no Caminho:  " + caminhoCompleto);

			db.closeConnection();
			return "cadastroNivel";

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();

		return null;

	}
	
	
	
	// RELATÓRIO POR NOME

		// TELA
		@PostMapping("/nivelRelatorioNomeTela")
		public String nivelRelatorioNomeTela(@RequestParam("nomeNivel") String nomeNivel, Model model) {
		

			DbProperties dbProperties = null;
			Db db = new Db(dbProperties);
			ServiceJasperViewer service = new ServiceJasperViewer();

			try {
				// Adiciona parâmetros e obtém JasperPrint
				service.addParams("nomeNivel", nomeNivel);
				service.abrirJasperViewer("relatorios/jrxml/nivelPorNome.jrxml", db.connection());
				model.addAttribute("mensagem", "Relatório na Tela Gerado com Sucesso com Nome Escolhido " + nomeNivel
						+ ", abra o relatório Minimizado ");

				db.closeConnection();
				return "cadastroNivel";
			} catch (Exception e) {
				// Trate a exceção, imprima mensagens ou redirecione para uma página de erro
				e.printStackTrace();
				return null;
			}
		}
		
		
		// PDF
		@PostMapping("/nivelRelatorioNomePDF")
		public String nivelRelatorioNomePDF(@RequestParam("nomeNivel") String nomeNivel, Model model) {
			DbProperties dbProperties = new DbProperties(); // Corrigir a criação do objeto DbProperties
			Db db = new Db(dbProperties);

			try {
				Properties props = dbProperties.obterProperties();

				// Gere uma UUID
				UUID extensao = UUID.randomUUID();

				// Obtenha o caminho de saída do arquivo do properties
				String caminhoSaida = props.getProperty("caminhoSaida");

				// Gere o nome do arquivo com a extensão ".pdf"
				String nomeArquivo = "\\relatorio-" + extensao + ".pdf";

				// Concatene o caminho de saída com o nome do arquivo
				String caminhoCompleto = caminhoSaida + nomeArquivo;

				System.out.println("Caminho completo do arquivo: " + caminhoCompleto);

				String jrxml = "relatorios/jrxml/nivelPorNome.jrxml";

				ServiceJasperViewer service = new ServiceJasperViewer();

				// Adiciona parâmetros antes de exportar o PDF
				service.addParams("nomeNivel", nomeNivel);

				// Abra um FileOutputStream
				try (FileOutputStream outputStream = new FileOutputStream(caminhoCompleto)) {
					service.exportarPDFcloseOutputStream(jrxml, db.connection(), outputStream);
				}

				// Redirecionar para a visualização do relatório
				model.addAttribute("mensagem",
						"Relatório PDF Gerado com Sucesso com NOME Escolhido  " + nomeNivel + " no Caminho:  " + caminhoCompleto);

				db.closeConnection();
				return "cadastroNivel";

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				db.closeConnection();
			}

			return null;
		}
		
		// HTML
		@PostMapping("/nivelRelatorioNomeHTML")
		public String nivelRelatorioNomeHTML(@RequestParam("nomeNivel") String nomeNivel, Model model) {
			DbProperties dbProperties = new DbProperties();
			Db db = new Db(dbProperties);

			Properties props = dbProperties.obterProperties();

			// Gere uma UUID
			UUID extencao = UUID.randomUUID();

			// Obtenha o caminho de saída do arquivo do properties
			String caminhoSaida = props.getProperty("caminhoSaida");

			// Gere o nome do arquivo com a extensão ".pdf"
			String nomeArquivo = "\\relatorio-" + extencao + ".html";

			// Concatene o caminho de saída com o nome do arquivo
			String caminhoCompleto = caminhoSaida + nomeArquivo;

			try {
				String jrxml = "relatorios/jrxml/nivelPorNome.jrxml";
				ServiceJasperViewer service = new ServiceJasperViewer();
				service.exportarHTML(jrxml, db.connection(), caminhoCompleto);
				// Adiciona parâmetros antes de exportar o PDF
				service.addParams("nomeNivel", nomeNivel);
				model.addAttribute("mensagem",
						"Relatório HTML Gerado com Sucesso com Nome Escolhido " + nomeNivel + " no Caminho:  " + caminhoCompleto);

				db.closeConnection();
				return "cadastroNivel";

			} catch (Exception e) {
				e.printStackTrace();
			}
			db.closeConnection();

			return null;

		}
		
	

}