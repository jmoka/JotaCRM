package top.jota.dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import top.jota.dao.entities.Nivel;
import top.jota.dao.services.interfaces.InterfaceNivel;
import top.jota.db.Db;
import top.jota.db.sql.SqlNivel;


@Service
public class ServiceNivel implements InterfaceNivel {
	
	

	private final Db conn;
	private final SqlNivel sql;
	private final Nivel nivel;

	
	public ServiceNivel(Db conn, SqlNivel sql) {
		this.conn = conn;
		this.sql = sql;
		this.nivel = null;
	}
	
	

	@Override
	public List<Nivel> findAll_Nivel() {
	    List<Nivel> list = new ArrayList<>();
	    
	    try (Connection con = conn.connection();
	         PreparedStatement st = con.prepareStatement(sql.findAll_Nivel());
	         ResultSet rs = st.executeQuery()) {

	        while (rs.next()) {
	            Nivel nivel = new Nivel(); // Crie uma nova instância de Nivel
	            nivel.setIdNivel(rs.getLong("idNivel"));
	            nivel.setNomeNivel(rs.getString("nomeNivel"));
	            list.add(nivel);
	        }

	        return list;

	    } catch (SQLException e) {
	        System.out.println("Ocorreu algum erro ao buscar a lista");
	        e.printStackTrace();
	    }
	    return null;
	}


	@Override
	public Nivel findById_Nivel(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nivel insert_Nivel(Nivel objNivel) {
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = conn.connection().prepareStatement(sql.SqlInserir_Nivel(), Statement.RETURN_GENERATED_KEYS);
			st.setString(1, objNivel.getNomeNivel());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {

				rs = st.getGeneratedKeys();
				if (rs.next()) {
					Long idNivel = rs.getLong(1);
					objNivel.setIdNivel(idNivel);
					System.out.println("Nivel cadastrado " + objNivel.getIdNivel() + "-" + objNivel.getNomeNivel());
				}
			} else {
				// Mensagem de erro mais informativa
				System.out.println("Falha ao inserir o Nivel: Nenhuma Linha Afetada");
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			// Trate a exceção específica de violação de chave única
			System.out.println("Nome ja existe no banco de dados");

		} catch (Exception e) {
			System.out.println("Erro ao conectar o banco ao inserir Nivel");

		} finally {
			// Certifique-se de fechar os recursos
			conn.closeConnection();
			conn.closeResultSet(rs);
			conn.closeStatement(st);

		}

		return objNivel;
	}

	@Override
	public Nivel update_Nivel(Long idNivel, Nivel objNivel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete_Nivel(Long idNivel) {
		// TODO Auto-generated method stub
	}
}
