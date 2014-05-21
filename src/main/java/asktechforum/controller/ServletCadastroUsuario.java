package asktechforum.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asktechforum.dominio.Usuario;
import asktechforum.repositorio.UsuarioDAO;
import asktechforum.util.UsuarioUtil;
import asktechforum.util.Util;

/**
 * Implementação do Servlet de Cadastro de Usuario.
 */
@WebServlet("/ServletCadastroUsuario")
public class ServletCadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String SUCESSOCADASTRO = "cadastroUsuarioSucesso.jsp";
    //private static String ERROCADASTRO = "cadastroUsuario.jsp";
	
    private UsuarioDAO dao;
 
    /**
     * Construtor do Servlet de Cadastro de Usuario.
     */
    public ServletCadastroUsuario() {
        super();
        this.dao = new UsuarioDAO();
    }

	/**
	 * Implementacao do metodo doGet() Servlet de Cadastro de Usuario.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * Implementacao do metodo doPost() Servlet de Cadastro de Usuario.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		try {
			usuario.setDataNascimento(Util.converterStringToDate("dd/MM/yyyy",request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuario.setEmail(request.getParameter("email"));
		usuario.setLocalizacao(request.getParameter("localizacao"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setConfSenha(request.getParameter("confsenha"));
		
		dao.adicionarUsuario(usuario);
		
		RequestDispatcher view = request.getRequestDispatcher(SUCESSOCADASTRO);
		request.setAttribute("usuario", usuario);
        view.forward(request, response);
	}
}
