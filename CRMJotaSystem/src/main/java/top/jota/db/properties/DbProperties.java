package top.jota.db.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import top.jota.db.exception.DbExcepition;

public class DbProperties {

	public static Properties dbPropretiesMysqlLocal() {

		try (FileInputStream fs = new FileInputStream("src/main/resources/cpanel.properties")) {
		
			Properties props = new Properties();
			props.load(fs);
			System.out.println("Arquivo properties encontrado");
			return props;

		} catch (IOException e) {
			System.out.println("Arquivo properties não encontrado");
			throw new DbExcepition(e.getMessage());
		}
	}

}
