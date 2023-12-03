package top.jota.dao.services.interfaces;

import java.util.List;

import top.jota.dao.entities.Nivel;

public interface InterfaceNivel {

	List<Nivel> findAll_Nivel();
	Nivel findById_Nivel(Long id);
	Nivel insert_Nivel(Nivel objUser);
	Nivel update_Nivel(Long id, Nivel obj);	
	void delete_Nivel(Long id);	
	
	
}
