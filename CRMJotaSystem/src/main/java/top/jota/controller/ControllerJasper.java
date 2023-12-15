package top.jota.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import top.jota.repository.jasper.Jasper2;

@RestController
public class ControllerJasper {
	
	

    @GetMapping("/jasper")
    public void jasper() {
        System.out.println("teste");        
        Jasper2.main("C:\\Users\\jotac\\JaspersoftWorkspace\\MyReports\\nivelTodos.jrxml");
    }

	
	@GetMapping("/jasper1")   
    public void jasper1() {
		Jasper2.main("C:\\Users\\jotac\\JaspersoftWorkspace\\MyReports\\teste1jrxml.jrxml");
		
	}

}
