package model;

import java.time.LocalDate;
import java.time.Period;

public record LivroDTO(
		String titulo, 
		String autor, 
		String genero, 
		String editora, 
		String linguas,
		String avaliacao,
		LocalDate anoLancamento,
		double qtdPaginasTotal,
		double qtdPaginasLidas
	) {
	
	public int getIdadeLivro() {
		LocalDate now = LocalDate.now();
		
		return Period.between(anoLancamento, now).getYears();		
	}
	
	public int[] getEstimativaLeitura() {
		double tempoTotal = this.qtdPaginasTotal * 60;
		
		int s = 0, m = 0, h = 0;
		
		s += tempoTotal;
		
		m += s/60;
		s = s % 60;
		
		h += m/60;
		m = m % 60;
		
		int[] tempo = {h, m, s};
		
		return tempo;
	}
	
	public double getProgressoPcent() {
		return (double) Math.round((qtdPaginasLidas / qtdPaginasTotal) * 100.0);
	}
	
	public int getQtdLinguas() {
		return linguas.split(",").length;
	}
}
