package top.jota.dao.entities.abstracts;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractNivel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected Long idNivel;
	protected String nomeNivel;
	
	
	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idNivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractNivel other = (AbstractNivel) obj;
		return Objects.equals(idNivel, other.idNivel);
	}

	@Override
	public String toString() {
		return "AbstractNivel [idNivel=" + idNivel + ", nomeNivel=" + nomeNivel + "]";
	}

		
}
