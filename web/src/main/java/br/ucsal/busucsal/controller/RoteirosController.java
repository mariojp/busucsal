package br.ucsal.busucsal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.busucsal.dao.RoteiroDAO;
import br.ucsal.busucsal.model.Roteiro;

@WebServlet("/roteiros")
public class RoteirosController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Roteiro roteiro = new Roteiro();
		roteiro.setTitulo("Roteiro 1");
		roteiro.setDescricao("Metro - UCSal");
		RoteiroDAO dao = new RoteiroDAO();
		dao.inserir(roteiro);
		
		Roteiro roteiro2 = new Roteiro();
		roteiro2.setTitulo("Roteiro 2");
		roteiro2.setDescricao("UCSal - CAB");
		dao.inserir(roteiro2);

		Roteiro roteiro3 = new Roteiro();
		roteiro3.setTitulo("Roteiro 3");
		roteiro3.setDescricao("UCSal - IMBUI");
		dao.inserir(roteiro3);

		
	}

}
