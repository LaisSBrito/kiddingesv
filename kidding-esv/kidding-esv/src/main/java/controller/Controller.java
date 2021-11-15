package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import model.DAO;
import model.UsuarioJB;

@WebServlet(urlPatterns = { "/Controller", "/home", "/insert", "/login" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	//classe - objeto
	UsuarioJB user = new UsuarioJB();
	

	
	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/home")) {
			home(request,response);
		} else if (action.equals("/insert")) {
			novoUsuario(request,response);
		} else {
			response.sendRedirect("login.html");
		}
	}
		//home
		protected void home(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			//logarUsuario
			
		}
		// Novo usuario 
		protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//teste de recebimento
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("email"));
		//System.out.println(request.getParameter("senha1"));
		
		//setar usuariosjb
		user.setUsuario(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setSenha(request.getParameter("senha"));
		//invocar o metodo inserirUsuario 
		dao.inserirUsuario(user);
		// redirecionar login
		response.sendRedirect("login");
		}
		
		
		//login
		protected void doPost(HttpServletRequest request, HttpServletResponse response) {
				
			
	        
	        try {
	        	dao.logarUsuario(user);
	        	
	        	user.setEmail(request.getParameter("email"));
				user.setSenha(request.getParameter("senha"));
	           
	            
	          
				DAO logUser = new DAO();
	            ResultSet rsusuario = logUser.logarUsuario(user);
	            if (rsusuario.next()) {
					//falta chamar a tela home
	            	
				} else {
					//erro
					JOptionPane.showMessageDialog(null, "Email ou Senha invalida");
				}
	        } catch (SQLException erro) {
	          JOptionPane.showMessageDialog(null,"login" + erro);;
	        }
	    }
	

		
		
}
