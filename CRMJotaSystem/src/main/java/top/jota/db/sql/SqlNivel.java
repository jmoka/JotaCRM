package top.jota.db.sql;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import top.jota.db.sql.interfacs.InterfacesSqlNivel;

@Component
public class SqlNivel implements InterfacesSqlNivel {

	@Override
	public String SqlInserir_Nivel() {
	    return "INSERT INTO Tbl_Nivel (nomeNivel) VALUES (?)";
	}


	@Override
	public String SqlFindById_Nivel() {

		return "SELECT Tbl_Nivel.*, Tbl_Nivel.nomeNivel as nomeNivel " 
				+ "FROM Tbl_Nivel "
				+ "WHERE Tbl_Nivel.idNivel = ?;";
	}

	@Override
	public String findAll_Nivel() {
		return "SELECT * FROM Tbl_Nivel;";
	}

	@Override
	public String SqlUpdate_Nivel() {
		return "UPDATE Tbl_Nivel " 
				+ "SET nomeNivel = ?, " 
				+ "WHERE Id = ?; ";
	}

	@Override
	public String SqlDeleteId_NIvel() {
		return "DELETE FROM Tbl_Nivel " 
				+ "WHERE Id = ? ";
	}

}
