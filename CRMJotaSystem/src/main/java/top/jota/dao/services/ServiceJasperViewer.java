package top.jota.dao.services;

import java.awt.GraphicsEnvironment;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class ServiceJasperViewer {

	
	
	
	public ServiceJasperViewer() {
		initializeGraphicsEnvironment();
	}


	// Terá métodos para a geração dos relatorios
	// Variável de Instancia, MAP, chave tipo string e valor object.
	// servirá para incluir parametros nos relatório

	private Map<String, Object> params = new LinkedHashMap<>();

	
	
	
	// possui duas maneiras utilizando o arquivo compilado (.jasper) e o não
	// compilado (.jrxml)

	// Método para Trabalhar com arquivos .jrxml não compilado
	// Necessário criar um método que faça a compilação

	// O método vai retornar um arquivo do tipo JasperReport
	// Vai receber como parametro o caminho e o nome do arquivo
	
	
	
	private JasperReport compilandoJrxml(String caminho) {

		// O retorno ira trabalhar com a parte de compilação e realizar a compilação
		try {
			// Para ter acesso ao arquivo temos que ter uma instrução para retornar um
			// InputStream
			// O arquivo tem que esta dentro de resource
			InputStream is = getClass().getClassLoader().getResourceAsStream(caminho);

			return JasperCompileManager.compileReport(is);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	};
	
	
	
	
	

	// Responsavel por adicionar os paramentros na variavel params
	// sempre que form preciso adicionar um parametro nos relatorios esse metodo
	// sera usado
	
	public void addParams(String kay, Object obj) {
		this.params.put(kay, obj);

	}
	
	
	
	
	

	// Método que inicializa o ambiente gráfico. Chame este método no início do seu programa.
	
	
	private static void initializeGraphicsEnvironment() {
		System.setProperty("java.awt.headless", "false");
	}
	
	
	
	
	

	// criar métodop para abrir o relatório
	
	public void abrirJasperViewer(String jrxml, Connection connection) throws JRException {

		JasperReport report = compilandoJrxml(jrxml);

		try {
			if (GraphicsEnvironment.isHeadless()) {
				throw new RuntimeException("O ambiente é headless. Não é possível exibir a interface gráfica.");
			}

			JasperPrint print = JasperFillManager.fillReport(report, params, connection);
			JasperViewer viewer = new JasperViewer(print);
			viewer.setVisible(true);
			System.out.println("Relatório Gerado com Sucesso!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	public void exportarPDF(String jrxml, Connection connection, String saida) throws JRException {

		JasperReport report = compilandoJrxml(jrxml);

		try {
			OutputStream out = new FileOutputStream(saida);
			
			if (GraphicsEnvironment.isHeadless()) {
				throw new RuntimeException("O ambiente é headless. Não é possível exibir a interface gráfica.");
			}

			JasperPrint print = JasperFillManager.fillReport(report, params, connection);
			
			
			JasperExportManager.exportReportToPdfStream(print, out);
			System.out.println("Relatório Gerado com Sucesso!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public void exportarHTML(String jrxml, Connection connection, String saida) throws JRException {

			JasperReport report = compilandoJrxml(jrxml);

			try {
				OutputStream out = new FileOutputStream(saida);
				
				if (GraphicsEnvironment.isHeadless()) {
					throw new RuntimeException("O ambiente é headless. Não é possível exibir a interface gráfica.");
				}

				JasperPrint print = JasperFillManager.fillReport(report, params, connection);
				
				JasperExportManager.exportReportToHtmlFile(print, saida);
				
				System.out.println("Relatório Gerado com Sucesso!!");

			} catch (Exception e) {
				e.printStackTrace();
			}
	};

	
	
	
}
