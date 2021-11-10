package model;

public class UsuarioJB {

	private String Usuario;
	private String Email;
	private String Senha;

	public UsuarioJB(String usuario, String email, String senha) {
		super();
		Usuario = usuario;
		Email = email;
		Senha = senha;
	}

	public UsuarioJB() {
		super();
		// TODO Auto-generated constructor stub
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
