package top.jota.dao.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import top.jota.dao.entities.Nivel;
import top.jota.dao.services.interfaces.InterfaceNivel;
import top.jota.db.Db;
import top.jota.db.exception.DbExcepition;
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

            // Executando comando e verificando linhas afetadas
            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                // Caso tenha sido inserido com sucesso, você pode obter as chaves geradas
                rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long idNivel = rs.getLong(1);
                    objNivel.setIdNivel(idNivel);
                }
            } else {
                // Se nenhuma linha foi afetada, algo deu errado
                System.out.println("Nenhuma Linha Afetada");
                // Aqui você pode lançar uma exceção ou fazer algum tratamento adequado
            }
        } catch (Exception e) {
            // Trate a exceção adequadamente
            e.printStackTrace();
        } finally {
            // Certifique-se de fechar os recursos
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
