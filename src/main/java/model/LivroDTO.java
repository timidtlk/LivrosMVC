package model;

import java.time.LocalDate;
import java.time.Period;

public record LivroDTO(
		String titulo, 
		String autor, 
		String genero, 
		String editora, 
		String[] linguas,
		String avaliacao,
		LocalDate anoLancamento,
		int qtdPaginasTotal,
		int qtdPaginasLidas
	) {
	
	public int getIdadeLivro() {
		LocalDate now = LocalDate.now();
		
		return Period.between(anoLancamento, now).getYears();		
	}
	
	public int[] getEstimativaLeitura() {
		int tempoTotal = this.qtdPaginasTotal * 60;
		
		int s = 0, m = 0, h = 0;
		
		s += tempoTotal;
		
		m += s/60;
		s = s % 60;
		
		h += m/60;
		m = m % 60;
		
		int[] tempo = {h, m, s};
		
		return tempo;
	}
	
	public int getProgressoPcent() {
		return (int) Math.round((qtdPaginasLidas / qtdPaginasTotal) * 100);
	}
	
	public int getQtdLinguas() {
		return linguas.length;
	}
}
