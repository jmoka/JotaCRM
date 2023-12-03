package top.jota.dao.services.factorys;

import top.jota.dao.services.ServiceNivel;
import top.jota.dao.services.interfaces.InterfaceNivel;
import top.jota.db.Db;

public class FactoryServices {

	public static InterfaceNivel FactoryNivel() {
		Db db = new Db();
		return new ServiceNivel(db.connection());
	}

}
