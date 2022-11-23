package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {

  private static String URL
      = "jdbc:postgresql://localhost:5432/estoque?user=postgres&password=postgres";

  public static Connection getConexao() throws SQLException {
    Connection conexao = DriverManager.getConnection(URL);
    return conexao;
  }
}
