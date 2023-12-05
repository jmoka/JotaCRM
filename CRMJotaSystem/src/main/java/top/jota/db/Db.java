package top.jota.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.jota.db.abstracts.AbstractConnection;
import top.jota.db.exception.DbExcepition;
import top.jota.db.properties.DbProperties;

@Component
public class Db extends AbstractConnection {
	
	private final DbProperties dbProperties;

    @Autowired
    public Db(DbProperties dbProperties) {
        this.dbProperties = dbProperties;
    }

	
    @Override
    public Connection connection() {
        if (conn == null) {
            Properties props = dbProperties.dbPropretiesMysqlLocal();
            String url = props.getProperty("dburl");

            try {
                conn = DriverManager.getConnection(url, props);
                System.out.println("Banco de dados Conectado");

            } catch (SQLException e) {
                System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());

            }
        }
        return conn;
    }

    @Override
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Banco de Dados desconectado");
            } catch (SQLException e) {
                System.out.println("Banco de Dados encontrou um problema para desconectar");

            }
        }
    }

    @Override
    public void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                System.out.println("ResultSet Desconectado");
            }
        } catch (SQLException e) {
            System.out.println("O ResultSet não conseguiu Desconectar");

        }
    }

    @Override
    public void closeStatement(PreparedStatement st) {
        try {
            if (st != null) {
                st.close();
                System.out.println("PreparedStatement Desconectado");
            }
        } catch (SQLException e) {
            System.out.println("O PreparedStatement não conseguiu Desconectar");
            throw new DbExcepition(e.getMessage());
        }
    }
}
