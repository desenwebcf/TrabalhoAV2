package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import singletonbd.modelo.Carro;
import singletonbd.persistencia.Connector;




/**
 * Classe DAO respons�vel pela persist�ncia do banco de dados da classe usuario.
 * */
public class CarroDAO {

    Connector c = new Connector();
    private static CarroDAO SINGLETON = null; //Cria  a conex�o como um singleton, ou seja, �o poder� haver duas instancias na memoria

    public static CarroDAO getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new CarroDAO();
        }
        return SINGLETON;
    }

    /**
     * Inclui um usuario no banco de dados
     * */
    public void incluir(Carro c) { //Inclui no banco de dados
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "INSERT INTO TRABALHOAV2.CARRO (placa, cor, modelo, fabricante, renavan) VALUES (?,?,?,?,?)"); //Cria o statemente e passa o sql, cada ? � um paramento
            ps.setString(1, c.getPlaca());
            ps.setString(2, c.getCor());
            ps.setString(3, c.getModelo());
            ps.setString(4, c.getFabricante());
            ps.setString(5, c.getRenavan());
            
            ps.execute(); //executa
           // ResultSet rs = ps.executeQuery("select id from usuario order by id desc limit 1");
            //	rs.next();
            //	u.setId(rs.getInt("id"));
            ps.close(); //fecha
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Carro"); //emite uma mensagem caso haja erro
        }

    }

    /**
     * Altera as informa��es de um usuario no banco de dados
     * */
    public void alterar(Carro c) {
       // Usuario.getEndereco().alterar();
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "UPDATE TRABALHOAV2.CARRO set placa = ?, cor =?, modelo=?, fabricante=?, WHERE renavan =?");
            ps.setString(1, c.getPlaca());
            ps.setString(2, c.getCor());
            ps.setString(3, c.getModelo());
            ps.setString(4, c.getFabricante());
            ps.setString(5, c.getRenavan());
                        
            ps.setString(3, String.valueOf(c.getId()));
            ps.execute();
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar Carro" );
        }

    }

    /**
     * Retorna as informa��es de um usuario do banco de dados a partir do nome
     * */
    public void pesquisar(Carro c) {

        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.usuario WHERE nome like ?");
            ps.setString(1, "%" + c.getLogin() + "%");
            ResultSet rs = ps.executeQuery();
            rs.next();
            fillObj(c, rs);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "O usuario nao foi localizado");
        }

    }
    public void pesquisarID(Carro c) {

        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.usuario WHERE id = ?");
            ps.setInt(1, c.getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            fillObj(c, rs);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "O usuario nao foi localizado");
        }

    }


    public Vector pesquisarTodos(Carro c) {
        Vector<Carro> vetor = new Vector<Carro>();
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.usuario order by login");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carro u2 = new Carro();
                fillObj(u2, rs);
                vetor.add(u2);
            }

            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuarios");
        } finally {
            return vetor;
        }
    }

    

    private void fillObj(Carro c, ResultSet rs) throws SQLException {
        c.setId(rs.getInt("id"));
        c.setLogin(rs.getString("login"));
        c.setSenha("senha");

    }

    /**
     * Exclui um usuario no banco de dados
     * */
    public void excluir(Carro c) {

      try{
           PreparedStatement ps = c.getConnection().prepareStatement(
                    "DELETE FROM ROOT.usuario WHERE id = ?");
            ps.setInt(1, c.getId());
            ps.execute();
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuario");
        }

    }


}
