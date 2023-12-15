package top.jota.db.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.springframework.stereotype.Component;

import top.jota.db.exception.DbExcepition;

@Component
public class DbProperties {

	public static Properties dbPropretiesMysqlLocal() {
		
		String nomeDB = "cpanel";

		try (FileInputStream fs = new FileInputStream("src/main/resources/"+nomeDB+".properties")) {
		
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
