	package top.jota.controller;
	
	import java.sql.Connection;
import java.util.Properties;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import top.jota.dao.services.ServiceJasperViewer;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;
	
	
	@RestController
	public class ControllerRelatorioNivel {
		
				
		// TODOS NIVEIS
		
			// TELA TODOS NIVEIS
	    @GetMapping("/relatorioNivelTodosTela")
	    public void relatorioNivelTodosTela() throws JRException {
	    	System.out.println("nivelRelatorio");
	    	
	    	 DbProperties dbProperties = null;
			 Db db = new Db(dbProperties);		
			 ServiceJasperViewer servicie = new ServiceJasperViewer();	 
			 String jrxml = "relatorios/jrxml/nivelTodos.jrxml";
			 
			 servicie.abrirJasperViewer(jrxml,  db.connection());
			 db.closeConnection();
	    }
	    
	    @GetMapping("/relatorioNivelTodosPDF")
	    public void relatorioNivelTodosPDF() throws JRException {
	       

	        DbProperties dbProperties = null;
	        Db db = new Db(dbProperties);
	        ServiceJasperViewer service = new ServiceJasperViewer();

	        Properties props = dbProperties.obterProperties();

	        // Gere uma UUID
	        UUID extencao = UUID.randomUUID();
	       

	        // Obtenha o caminho de saída do arquivo do properties
	        String caminhoSaida = props.getProperty("caminhoSaida");

	        // Gere o nome do arquivo com a extensão ".pdf"
	        String nomeArquivo = "\\relatorio-"+extencao + ".pdf";

	        // Concatene o caminho de saída com o nome do arquivo
	        String caminhoCompleto = caminhoSaida + nomeArquivo;

	        System.out.println("Caminho completo do arquivo: " + caminhoCompleto);

	        String jrxml = "relatorios/jrxml/nivelTodos.jrxml";

	        try {
	            service.exportarPDF(jrxml, db.connection(), caminhoCompleto);
	            db.closeConnection();
	        } catch (JRException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @PostMapping("/atualizarDiretorioExportacaoRelatorio")
	    public void atualizarDiretorioExportacaoRelatorio(@RequestParam("caminho")  String caminho) throws JRException {
	    	
	    		
	    	    
	    	if(caminho != null) {
	    		Connection conection = null;
	    		DbProperties dbProperties = null;
		        Db db = new Db(dbProperties);
	    		String nomeDB = "exportarRelatorio";
	    		String caminhoArquivo = "src/main/resources/"+nomeDB+".properties";
	    		
	    		 Properties props = dbProperties.obterProperties();		       

			      dbProperties.salvarPropertiesDiretorioRelatório(caminhoArquivo,caminho, props);	
			      
			      ServiceJasperViewer service = new ServiceJasperViewer();
			      
			      service.exportarPDF(caminhoArquivo, conection, caminho);
			      
			      
	    	}else {
	    		System.out.println("erro");
	    	}
	    		
	    		 
			        
	    		 
	    	 }

		        
	 
	    
	
	    @PostMapping("/nivelRelatorioId")
	    public ModelAndView nivelRelatorioId(@RequestParam("id") Long id) {
	        System.out.println("nivelRelatorioId");
	
	        DbProperties dbProperties = null;
	        Db db = new Db(dbProperties);
	        ServiceJasperViewer service = new ServiceJasperViewer();
	
	        try {
	            // Adiciona parâmetros e obtém JasperPrint
	            service.addParams("idNivel", id);
	            service.abrirJasperViewer("relatorios/jrxml/nivelPorID.jrxml", db.connection());
	             
	            return service.redirecionar();
	        } catch (Exception e) {
	            // Trate a exceção, imprima mensagens ou redirecione para uma página de erro
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    
	    
		@GetMapping("/nivelRelatorioNome")   
	    public void nivelRelatorioNome() {
			System.out.println("nivelRelatorioNome");
			
		}
		
		
		
		
		
		
	
	}
