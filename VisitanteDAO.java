
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.resource.spi.Connector;
import javax.swing.JOptionPane;
import modelo.Visitante;


public class VisitanteDAO {
    
     Connector c;
    private static VisitanteDAO SINGLETON = null;

    public static VisitanteDAO getInstance() throws SQLException {
        if (SINGLETON == null) {
            SINGLETON = new VisitanteDAO();
        }
        return SINGLETON;
    }

    public VisitanteDAO() throws SQLException {
        this.c = new Connector() {};
    }

    public void incluir(Visitante v) {
        try {
            try (PreparedStatement ps = c.getConnection().prepareStatement(
                         "INSERT INTO Visitante (nome,endereco,cpf,rg,cnh) VALUES (?,?,?,?,?)")) {
                ps.setInt(1, v.getNome());
                ps.setString(2, v.getEndereco());
                ps.setString(3, v.getCpf());
                ps.setString(4, v.getRg());
                ps.setString(5, v.getCnh());
                ps.execute(); //executa
                ResultSet rs = ps.executeQuery("select id from Visitante order by id desc limit 1");
                rs.next();
                v.setcpf(rs.getInt("cpf"));
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir Visitante"); //emite uma mensagem caso haja erro
        }

    }
}

 
