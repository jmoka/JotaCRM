package top.jota.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
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
    public String nivelRelatorioId(@RequestParam("id") Long id) throws JRException {
        System.out.println("nivelRelatorioId");

        DbProperties dbProperties = null;
        Db db = new Db(dbProperties);

        ServiceJasperViewer servicie = new ServiceJasperViewer();

        servicie.addParams("idNivel", id);

        servicie.abrirJasperViewer("relatorios/jrxml/nivelPorID.jrxml", db.connection());
        db.closeConnection();
      
        return "redirect:/pageCadastroNivel";
        
    }
	
	@GetMapping("/nivelRelatorioNome")   
    public void nivelRelatorioNome() {
		System.out.println("nivelRelatorioNome");
		
	}
	
	
	
	

}
