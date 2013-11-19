import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import singletonbd.modelo.Usuario;
import singletonbd.persistencia.Connector;




/**
 * Classe DAO respons�vel pela persist�ncia do banco de dados da classe usuario.
 * */
public class UsuarioDAO {

    Connector c = new Connector();
    private static UsuarioDAO SINGLETON = null; //Cria  a conex�o como um singleton, ou seja, �o poder� haver duas instancias na memoria

    public static UsuarioDAO getInstance() {
        if (SINGLETON == null) {
            SINGLETON = new UsuarioDAO();
        }
        return SINGLETON;
    }

    /**
     * Inclui um usuario no banco de dados
     * */
    public void incluir(Usuario u) { //Inclui no banco de dados
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "INSERT INTO ROOT.USUARIO (login, senha) VALUES (?,?)"); //Cria o statemente e passa o sql, cada ? � um paramento
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            ps.execute(); //executa
           // ResultSet rs = ps.executeQuery("select id from usuario order by id desc limit 1");
            //	rs.next();
            //	u.setId(rs.getInt("id"));
            ps.close(); //fecha
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuario"); //emite uma mensagem caso haja erro
        }

    }

    /**
     * Altera as informa��es de um usuario no banco de dados
     * */
    public void alterar(Usuario u) {
       // Usuario.getEndereco().alterar();
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "UPDATE ROOT.USUARIO set login = ?, senha = ? WHERE id = ?");
            ps.setString(1, u.getLogin());
            ps.setString(2, u.getSenha());
            ps.setString(3, String.valueOf(u.getId()));
            ps.execute();
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario" );
        }

    }

    /**
     * Retorna as informa��es de um usuario do banco de dados a partir do nome
     * */
    public void pesquisar(Usuario u) {

        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.usuario WHERE nome like ?");
            ps.setString(1, "%" + u.getLogin() + "%");
            ResultSet rs = ps.executeQuery();
            rs.next();
            fillObj(u, rs);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "O usuario nao foi localizado");
        }

    }
    public void pesquisarID(Usuario u) {

        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.usuario WHERE id = ?");
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();
            rs.next();
            fillObj(u, rs);
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "O usuario nao foi localizado");
        }

    }


    public Vector pesquisarTodos(Usuario u) {
        Vector<Usuario> vetor = new Vector<Usuario>();
        try {
            PreparedStatement ps = c.getConnection().prepareStatement(
                    "SELECT * FROM ROOT.usuario order by login");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario u2 = new Usuario();
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

    

    private void fillObj(Usuario u, ResultSet rs) throws SQLException {
        u.setId(rs.getInt("id"));
        u.setLogin(rs.getString("login"));
        u.setSenha("senha");

    }

    /**
     * Exclui um usuario no banco de dados
     * */
    public void excluir(Usuario u) {

      try{
           PreparedStatement ps = c.getConnection().prepareStatement(
                    "DELETE FROM ROOT.usuario WHERE id = ?");
            ps.setInt(1, u.getId());
            ps.execute();
            ps.close();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir usuario");
        }

    }


}
