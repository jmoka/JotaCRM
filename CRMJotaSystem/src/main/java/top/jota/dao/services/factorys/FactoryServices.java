package top.jota.dao.services.factorys;

import org.springframework.stereotype.Component;

import top.jota.dao.services.ServiceNivel;
import top.jota.dao.services.interfaces.InterfaceNivel;
import top.jota.db.Db;
import top.jota.db.properties.DbProperties;
import top.jota.db.sql.SqlNivel;

@Component
public class FactoryServices {
	

	static DbProperties dbProperties = null;
	static SqlNivel sqlNivel = null;
	
	public FactoryServices(DbProperties dbProperties, SqlNivel sqlNivel ) {
		this.dbProperties = dbProperties;
		this.sqlNivel = sqlNivel;	
		}
	
		
	public static InterfaceNivel FactoryNivel() {		
		 Db db = new Db(dbProperties);
	     return new ServiceNivel(db, sqlNivel);
}
	}