package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAO;
import model.UsuarioJB;

@WebServlet(urlPatterns = { "/Controller", "/home", "/insert", "/login" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	// classe - objeto
	UsuarioJB user = new UsuarioJB();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/home")) {
			home(request, response);
		} else if (action.equals("/insert")) {
			novoUsuario(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

	// home
	protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("home.html");

	}

	// Novo usuario
	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// teste de recebimento
		// System.out.println(request.getParameter("nome"));
		// System.out.println(request.getParameter("email"));
		// System.out.println(request.getParameter("senha"));

		// setar usuariosjb
		user.setUsuario(request.getParameter("nome"));
		user.setEmail(request.getParameter("email"));
		user.setSenha(request.getParameter("senha"));
		// invocar o metodo inserirUsuario
		dao.inserirUsuario(user);
		// redirecionar home

		response.sendRedirect("login");
	}

	// login
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		
						
			user.setEmail(request.getParameter("email"));
			user.setSenha(request.getParameter("senha"));
			        
			
			dao.logarUsuario(user);
			response.sendRedirect("home");
			
	}
}
