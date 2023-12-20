	package top.jota.controller;
	
	import java.io.FileOutputStream;
import java.io.IOException;
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

		
				
		// TELA
		
			// TELA TODOS NIVEIS ID
	    @GetMapping("/relatorioNivelTodosTelaPorId")
	    public ModelAndView relatorioNivelTodosTelaPorId() throws JRException {
	    	System.out.println("nivelRelatorio");
	    	
	    	 DbProperties dbProperties = null;
			 Db db = new Db(dbProperties);		
			
			 
			 try {
				 ServiceJasperViewer service = new ServiceJasperViewer();	
				 String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";
				 
				 service.abrirJasperViewer(jrxml,  db.connection());
				 db.closeConnection();
				  return service.redirecionar();
			 }catch (Exception e) {
				 e.printStackTrace();
		           
			}
			 db.closeConnection();
			return null;
			 
	    }
	    
	
		
	 			// TELA TODOS NIVEIS NOME
	 	    @GetMapping("/relatorioNivelTodosTelaNome")
	 	    public ModelAndView relatorioNivelTodosTelaNome() throws JRException {
	 	    	System.out.println("nivelRelatorio");
	 	    	
	 	    	 DbProperties dbProperties = null;
	 			 Db db = new Db(dbProperties);		
	 			
	 			 
	 			 try {
	 				 ServiceJasperViewer service = new ServiceJasperViewer();	
	 				 String jrxml = "relatorios/jrxml/nivelTodos.jrxml";
	 				 
	 				 service.abrirJasperViewer(jrxml,  db.connection());
	 				 db.closeConnection();
	 				  return service.redirecionar();
	 			 }catch (Exception e) {
	 				 e.printStackTrace();
	 		           
	 			}
	 			 db.closeConnection();
	 			return null;
	 			 
	 	    }
	 	    
	 	    
	    
	 	    
	 	    // PDF
	 	    
	 	    
	 	// PDF TODOS NIVEIS ID
	 	    
	 	    
	    @GetMapping("/relatorioNivelTodosPDFPorID")
	    public ModelAndView relatorioNivelTodosPDFPorID() throws JRException, IOException {
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

	            return service.redirecionar();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            db.closeConnection();
	        }

	        return null;
	    }

	    
	 // PDF TODOS NIVEIS NOME
	    
	    @GetMapping("/relatorioNivelTodosPDFPorNome")
	    public ModelAndView relatorioNivelTodosPDFPorNome() throws JRException, IOException {
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

	            return service.redirecionar();

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
	    public ModelAndView relatorioNivelTodosHTMLID() throws JRException {
	    		
	    		DbProperties dbProperties = new DbProperties(); 
		        Db db = new Db(dbProperties);
		       

		        Properties props = dbProperties.obterProperties();

		        // Gere uma UUID
		        UUID extencao = UUID.randomUUID();
		       

		        // Obtenha o caminho de saída do arquivo do properties
		        String caminhoSaida = props.getProperty("caminhoSaida");

		        // Gere o nome do arquivo com a extensão ".pdf"
		        String nomeArquivo = "\\relatorio-"+extencao + ".html";

		        // Concatene o caminho de saída com o nome do arquivo
		        String caminhoCompleto = caminhoSaida + nomeArquivo;

		    
		       
		        
		        try {
		        	 String jrxml = "relatorios/jrxml/nivelTodosOrderID.jrxml";
		        	 ServiceJasperViewer service = new ServiceJasperViewer();
		        	 service.exportarHTML(jrxml, db.connection(), caminhoCompleto);
		        	 db.closeConnection();
			         return service.redirecionar();
		        	
		        }catch (Exception e) {
		        	 e.printStackTrace();
		        }
		        db.closeConnection();
		        
				return null;
				
	    }
	    
	    
	 // HTML TODOS NIVEIS NOME
	    
	    @GetMapping("/relatorioNivelTodosHTMLNome")
	    public ModelAndView relatorioNivelTodosHTML() throws JRException {
	    		
	    		DbProperties dbProperties = new DbProperties(); 
		        Db db = new Db(dbProperties);
		       

		        Properties props = dbProperties.obterProperties();

		        // Gere uma UUID
		        UUID extencao = UUID.randomUUID();
		       

		        // Obtenha o caminho de saída do arquivo do properties
		        String caminhoSaida = props.getProperty("caminhoSaida");

		        // Gere o nome do arquivo com a extensão ".pdf"
		        String nomeArquivo = "\\relatorio-"+extencao + ".html";

		        // Concatene o caminho de saída com o nome do arquivo
		        String caminhoCompleto = caminhoSaida + nomeArquivo;

		    
		       
		        
		        try {
		        	 String jrxml = "relatorios/jrxml/nivelTodos.jrxml";
		        	 ServiceJasperViewer service = new ServiceJasperViewer();
		        	 service.exportarHTML(jrxml, db.connection(), caminhoCompleto);
		        	 db.closeConnection();
			         return service.redirecionar();
		        	
		        }catch (Exception e) {
		        	 e.printStackTrace();
		        }
		        db.closeConnection();
		        
				return null;
				
	    }
	    
	    
		    // ATUALIZAR E REDIRECIONAR
	    
	    @PostMapping("/atualizarDiretorioExportacaoRelatorio")
	    public ModelAndView atualizarDiretorioExportacaoRelatorio(@RequestParam("caminho")  String caminho) throws JRException {
	    	
	    			    	    
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
	    	 
	    	ServiceJasperViewer service = new ServiceJasperViewer();
			return service.redirecionar();
	    		
	       		 
	    	 }

		        	 
	    // RELATÓRIO POR ID
	
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
	            db.closeConnection();
	            return service.redirecionar();
	        } catch (Exception e) {
	            // Trate a exceção, imprima mensagens ou redirecione para uma página de erro
	            e.printStackTrace();
	            return null;
	        }
	    }
	    
	    
	  		
		
		
	
	}