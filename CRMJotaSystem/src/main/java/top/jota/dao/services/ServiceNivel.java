package top.jota.dao.services;

import java.sql.Connection;
import java.util.List;

import top.jota.dao.entities.Nivel;
import top.jota.dao.services.interfaces.InterfaceNivel;

public class ServiceNivel implements InterfaceNivel {
	
	private Connection conn;
	
	
	public ServiceNivel(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Nivel> findAll_Nivel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nivel findById_Nivel(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nivel insert_Nivel(Nivel objNivel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nivel update_Nivel(Long idNivel, Nivel objNivel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete_Nivel(Long idNivel) {
		// TODO Auto-generated method stub
		
	}

}
