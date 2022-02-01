package bibliotecas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	
	private static String usuario = "root";
	private static String senha = "admin123";
	private static String textoDeConexao = "jdbc:mysql://localhost:3306/empresa";
	
	public static Connection obterConexao() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(textoDeConexao,usuario,senha);
			
		} catch (SQLException e) {
			System.out.println("Erro de conexao!!!!");
			e.printStackTrace();
		}
		return con;
	}
	
}
