import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *Classe que faz a conexao um banco de dados 
 */
public class Connector {
    Connection connection = null;
    ResultSet rs;
    /**Carrega o driver JDBC e faz a conexao com o banco de dados local*/
    public Connector() {

        try {
// Carregando o JDBC Driver
            String driverName = "org.apache.derby.jdbc.ClientDriver"; 
            Class.forName(driverName);

// Criando a conexao com o Banco de Dados
            String serverName = "127.0.0.1:1527";
            String mydatabase = "aulaSingleton";
            String url = "jdbc:derby://" + serverName + "/" + mydatabase; // a JDBC url
            String username = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
//Driver nao encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
        } catch (SQLException e) {
//Nao estou conseguindo se conectar ao banco
            System.out.println("Nao foi possovel conectar ao Banco de Dados");
        }

    }

    public Connection getConnection() {
        return connection;
    }


}
