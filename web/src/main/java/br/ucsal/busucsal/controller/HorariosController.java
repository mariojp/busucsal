package br.ucsal.busucsal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.HorarioDAO;
import br.ucsal.busucsal.dao.RoteiroDAO;
import br.ucsal.busucsal.model.Horario;

/**
 * Servlet implementation class ListarProdutoServlet
 */

@WebServlet("/horarios")
public class HorariosController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HorariosController() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HorarioDAO dao =  new HorarioDAO();
		List<Horario> horarios  = dao.getLista();
		request.setAttribute("horarios", horarios);
		
		RequestDispatcher requestDispatcher =   request.getRequestDispatcher("/WEB-INF/horarios.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

