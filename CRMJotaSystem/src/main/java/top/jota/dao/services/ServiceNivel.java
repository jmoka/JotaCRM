package top.jota.dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

import top.jota.dao.entities.Nivel;
import top.jota.dao.services.interfaces.InterfaceNivel;
import top.jota.db.Db;
import top.jota.db.sql.SqlNivel;

public class ServiceNivel implements InterfaceNivel {

	private Connection conn;
	private SqlNivel sql = new SqlNivel();
	private Db db; // Remova a declaração de Db aqui

	public ServiceNivel(Connection conn) {
		this.conn = conn;
		this.db = new Db(); // Adicione a inicialização de Db aqui
	}

	@Override
	public List<Nivel> findAll_Nivel() {
		// TODO Auto-generated method stub
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
		System.out.println("gggg " + objNivel);

		try {
		    st = conn.prepareStatement(sql.SqlInserir_Nivel(), Statement.RETURN_GENERATED_KEYS);
		    st.setString(1, objNivel.getNomeNivel());

		    int rowsAffected = st.executeUpdate();

		    if (rowsAffected > 0) {
		    	
		        rs = st.getGeneratedKeys();
		        if (rs.next()) {
		            Long idNivel = rs.getLong(1);
		            objNivel.setIdNivel(idNivel);
		            System.out.println("Nivel cadastrado " + objNivel.getIdNivel() + "" + objNivel.getNomeNivel() );
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
			db.closeConnection();
		    db.closeResultSet(rs);
		    db.closeStatement(st);
		    
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
