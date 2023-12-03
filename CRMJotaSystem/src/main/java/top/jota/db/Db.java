package top.jota.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import top.jota.db.abstracts.AbstractConnection;
import top.jota.db.exception.DbExcepition;
import top.jota.db.properties.DbProperties;

public class Db extends AbstractConnection {

	@Override
	public Connection connectionMysql() {
		if (conn == null) {
			Properties props = DbProperties.dbPropretiesMysqlLocal();
			String url = props.getProperty("dburl");
			try {
				conn = DriverManager.getConnection(url, props);
				System.out.println("Banco de dados Conectado");
			} catch (SQLException e) {
				System.err.println("Banco de dados Conectado");
				throw new DbExcepition(e.getMessage());

			}

		}
		return conn;

	}

	@Override
	public void closeConnection() {
		// TODO Auto-generated method stub

	}

}
