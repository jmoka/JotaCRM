package top.jota.db.interfaces;

import java.sql.Connection;

public interface InterfaceConnection {
	
		Connection connection();		
		void closeConnection();
	
}
