import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/aps?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "";

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			System.out.println("CONECTADO COM SUCESSO!");
			return DriverManager.getConnection(URL, USER, PASS);
			
		} catch (ClassNotFoundException | SQLException ex) {
			throw new RuntimeException("ERRO NA CONEXÃO", ex);
		}
	}

	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (Exception ex) {
				System.out.println("ERRO" + ex);

			}
		}
	}

	public static void closeConnection(Connection con, PreparedStatement start) {
		if (start != null) {
			try {
				start.close();
			} catch (Exception ex) {
				System.out.println("ERRO" + ex);

			}
		}
		closeConnection(con);
	}

	public static void closeConnection(Connection con, PreparedStatement start, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				System.out.println("ERRO" + ex);

			}
		}
		closeConnection(con, start);
	}

	public static void main(String[] args) {
		ConexaoBD conn = new ConexaoBD();
		conn.getConnection();

	}
}
