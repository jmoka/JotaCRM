package top.jota.dao.entities;

import top.jota.dao.entities.abstracts.AbstractNivel;

public class Nivel extends  AbstractNivel{
	private static final long serialVersionUID = 1L;
		
	public Nivel() {
		
	}
	
    public Nivel(String nomeNivel) {		
		this.nomeNivel = nomeNivel;
	}
    

}
