package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;






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
	
 /** USUARIO CREATE**/
	
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

			int k = pst.executeUpdate();
			if (k==1) {
				System.out.println("Registrado com sucesso");
			} else {
				System.out.println("Tente novamente");
				
			}
			
			//encerrar a conexao
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	
	
	/** USUARIO LOGIN **/
	
	public void logarUsuario(UsuarioJB user)  {
		String logar = "select * from USUARIO where Email = ? and Senha = ?";

		try {
		
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(logar);
			pst.setString(1, user.getEmail());
			pst.setString(2, user.getSenha());
			
			System.out.println(pst);
			ResultSet rs = pst.executeQuery();
			if  (rs.next()) {
				//vai pra home
			} else {	
				//encaminha pra tela de cadastro
			}
			
		} catch (Exception e) {
			System.out.println(e);
		
		}
		return ;
	
  }
}
