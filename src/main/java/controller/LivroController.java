package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.LivroDTO;

@WebServlet("/Livro")
public class LivroController extends HttpServlet {
	
	private static final long serialVersionUID = 820928843794152937L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulo = request.getParameter("titulo");
		String autor = request.getParameter("autor");
		String genero = request.getParameter("genero");
		String editora = request.getParameter("editora");
		String[] linguas = request.getParameterValues("linguas");
		String avaliacao = request.getParameter("avaliacao");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate anoLancamento = LocalDate.now();
		
		try {
			anoLancamento = formatter.parse(request.getParameter("anoAvaliacao")).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		} catch (ParseException e) {
			e.printStackTrace();
		};
		
		int qtdPgsTotal = Integer.parseInt(request.getParameter("qtdPgsTotal"));
		int qtdPgsLidas = Integer.parseInt(request.getParameter("qtdPgsLidas"));
		
		LivroDTO livro = new LivroDTO(titulo, autor, genero, editora, linguas, avaliacao, anoLancamento, qtdPgsTotal, qtdPgsLidas);
		
		request.setAttribute("titulo", titulo);
		request.setAttribute("autor", autor);
		
		request.setAttribute("idade", livro.getIdadeLivro());
		request.setAttribute("estimativa", livro.getEstimativaLeitura());
		request.setAttribute("porcentagem", livro.getProgressoPcent());
		request.setAttribute("linguas", livro.getQtdLinguas());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resposta.jsp");
		dispatcher.forward(request, response);
	}

}
