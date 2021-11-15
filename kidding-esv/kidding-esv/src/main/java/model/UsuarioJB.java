package model;

public class UsuarioJB {
	
	private String Usuario_Id;
	private String Usuario;
	private String Email;
	private String Senha;
	
	
	
	public UsuarioJB(String usuario_Id, String usuario, String email, String senha) {
		super();
		Usuario_Id = usuario_Id;
		Usuario = usuario;
		Email = email;
		Senha = senha;
	}
	public UsuarioJB() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsuario_Id() {
		return Usuario_Id;
	}
	public void setUsuario_Id(String usuario_Id) {
		Usuario_Id = usuario_Id;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	

}
