package top.jota.dao.services;

import java.awt.GraphicsEnvironment;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.WindowConstants;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

@Service
public class ServiceJasperViewer {

    private Map<String, Object> params = new LinkedHashMap<>();

    public ServiceJasperViewer() {
        initializeGraphicsEnvironment();
    }

    private JasperReport compilandoJrxml(String caminho) {
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(caminho);
            return JasperCompileManager.compileReport(is);
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addParams(String key, Object obj) {
        this.params.put(key, obj);
    }

    private static void initializeGraphicsEnvironment() {
        System.setProperty("java.awt.headless", "false");
    }

    public JasperPrint abrirJasperViewer(String jrxml, Connection connection) throws JRException {
        JasperReport report = compilandoJrxml(jrxml);

        try {
            if (GraphicsEnvironment.isHeadless()) {
                throw new RuntimeException("O ambiente é headless. Não é possível exibir a interface gráfica.");
            }

            JasperPrint print = JasperFillManager.fillReport(report, params, connection);
            JasperViewer viewer = new JasperViewer(print, false); // false indica que o fechamento não deve encerrar o aplicativo
            viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
            System.out.println("Relatório Gerado com Sucesso!!");
            return print;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }

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
    
    
    public void closeOutputStream(FileOutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.close();
        }
    }
    
    
 // Novo método com FileOutputStream
    public void exportarPDFcloseOutputStream(String jrxml, Connection connection, FileOutputStream outputStream) throws JRException, IOException {
        JasperReport report = compilandoJrxml(jrxml);

        try {
            if (GraphicsEnvironment.isHeadless()) {
                throw new RuntimeException("O ambiente é headless. Não é possível exibir a interface gráfica.");
            }

            JasperPrint print = JasperFillManager.fillReport(report, params, connection);
            JasperExportManager.exportReportToPdfStream(print, outputStream);
            System.out.println("Relatório Gerado com Sucesso!!");
        } finally {
            closeOutputStream(outputStream);
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
    }
    
    
    public ModelAndView redirecionar () {
    	// Cria um objeto RedirectView que aponta para a URL desejada
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/atualizarListaNivel");

        // Retorna o ModelAndView com a RedirectView
        ModelAndView modelAndView = new ModelAndView(redirectView);
        
        
        
        return modelAndView;
    }
   
 
    
}
