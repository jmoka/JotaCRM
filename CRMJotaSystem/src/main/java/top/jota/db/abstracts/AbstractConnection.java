package top.jota.db.abstracts;

import java.sql.Connection;

import top.jota.db.interfaces.InterfaceConnection;

public abstract class AbstractConnection implements InterfaceConnection {	
	
		public Connection conn = null;		
	
}
