package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class DAO {

	/** modulo de conexao **/
	// parametros
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/kidding_esv?useTimezonee=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "123@start";

	// conexao
	// metodos
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;

		}
	}
	// teste conexao
	/**public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}**/
	
 /**CRUD USUARIO CREATE**/
	
	public void inserirUsuario(UsuarioJB user) {
		String criar = "insert into USUARIO (Usuario,Email,Senha) values (?,?,?)";
		try {
			Connection con = conectar();
			//preparar query execuçao no banco
			PreparedStatement pst = con.prepareStatement(criar);
			//substituir as (?)
			pst.setString(1, user.getUsuario());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getSenha());
			//Execução da query
			pst.executeUpdate();
			//encerrar a conexao
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	
	/** CRUD USUARIO LOGIN **/
	
	public ResultSet logarUsuario(UsuarioJB user) {
		Connection con = conectar();
		
		try {
			String logar = "select * from USUARIO where Email = ? and Senha = ?";
		
			PreparedStatement pst = con.prepareStatement(logar);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getSenha());
			
		
			ResultSet rs = pst.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			JOptionPane.showConfirmDialog(null,"dao: " + e);
			return null;
		}
		
		

	}
	
}
}
