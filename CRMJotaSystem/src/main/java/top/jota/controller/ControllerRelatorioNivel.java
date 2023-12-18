package top.jota.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import top.jota.dao.services.ServiceJasperViewer;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;


@RestController
public class ControllerRelatorioNivel {
	
	

    @GetMapping("/relatorioNivelTodos")
    public void nivelRelatorio() throws JRException {
    	System.out.println("nivelRelatorio");
    	
    	 DbProperties dbProperties = null;
		 Db db = new Db(dbProperties);		
		 ServiceJasperViewer servicie = new ServiceJasperViewer();	 
		 
		 
		 servicie.abrirJasperViewer("relatorios/jrxml/nivelTodosOrderID.jrxml",  db.connection());
		 db.closeConnection();
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
