package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LivroDTO;
import model.LivroDAO;

@WebServlet("/Livro")
public class LivroController extends HttpServlet {
	
	private static final long serialVersionUID = 820928843794152937L;
	
	private LivroDAO lDAO;
	@Resource(name="bancoTarefas")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException{
		lDAO = new LivroDAO(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
    	operacao = operacao.toLowerCase();
		
		switch (operacao) {
			case "listar":
				listarLivro(request, response);
				break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
    	operacao = operacao.toLowerCase();
		
		switch (operacao) {
			case "adicionar":
				cadastrarLivro(request, response);
				break;
		}
	}
	
	private void cadastrarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String genero = request.getParameter("genero");
		String editora = request.getParameter("editora");
		String linguas = request.getParameter("linguas");
		String avaliacao = request.getParameter("avaliacao");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate anoLancamento = LocalDate.now();
		
		try {
			anoLancamento = formatter.parse(request.getParameter("anoLancamento")).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} catch (ParseException e) {
			e.printStackTrace();
		};
		
		double qtdPgsTotal = Double.parseDouble(request.getParameter("qtdPgsTotal"));
		double qtdPgsLidas = Double.parseDouble(request.getParameter("qtdPgsLidas"));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resposta.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listarLivro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
