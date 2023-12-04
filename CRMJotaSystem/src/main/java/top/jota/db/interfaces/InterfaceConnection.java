package top.jota.db.interfaces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface InterfaceConnection {
	
		Connection connection();		
		void closeConnection();
		void closeResultSet(ResultSet rs);
		void closeStatement(PreparedStatement st);
	
}
