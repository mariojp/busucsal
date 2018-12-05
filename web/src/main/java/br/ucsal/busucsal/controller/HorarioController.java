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
import br.ucsal.busucsal.model.Roteiro;



@WebServlet("/horario")
public class HorarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HorarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Horario horario = null;
		if(id !=null && !id.trim().isEmpty()){
			Long pk = Long.parseLong(id);
			horario = new HorarioDAO().get(pk);
		}
		request.setAttribute("horario", horario);
		request.setAttribute("roteiros", new RoteiroDAO().getLista());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/horario.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String diaDaSemana = request.getParameter("diaDaSemana");
		String horaInicio = request.getParameter("horaInicio");
		Long roteiroId = 	Long.parseLong(request.getParameter("roteiroId"));

		Horario horario = new Horario();
		horario.setDiaDaSemana(diaDaSemana);
		horario.setHoraInicio(horaInicio);
		Roteiro roteiro = new Roteiro();
		roteiro.setId(roteiroId);
		horario.setRoteiro(roteiro);
		
		HorarioDAO dao = new HorarioDAO();
		
		if(id !=null && !id.trim().isEmpty()){
			Long pk = Long.parseLong(id);
			horario.setId(pk);
			dao.altera(horario);
		}else {
			dao.inserir(horario);
		}
		
		response.sendRedirect("/horarios");

	}

}
