package com.igor.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.igor.socialbooks.client.LivrosClient;
import com.igor.socialbooks.client.domain.Livro;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		
		LivrosClient cliente = new LivrosClient("http://localhost:8080", "igor", "123");
		List<Livro> listaLivros = cliente.listar();
		
		for (Livro livro : listaLivros) {
			System.out.println("Livro: " + livro.getNome());
		}
		
		Livro livro = new Livro();
		livro.setNome("Git passo-a-passo");
		livro.setEditora("Editora sem tempo");
		
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		livro.setPublicacao(publicacao.parse("01/01/2020"));
		
		livro.setResumo("este livro aborda técnicas de desenvolvimentos de API");
		
		String localizacao = cliente.salvar(livro);
		
		System.out.println("URI do livro salvo: " + localizacao);
		
		Livro livroBuscado = cliente.buscar(localizacao);
		
		System.out.println("Livro buscado: " + livroBuscado.getNome());
	}
	
	
}
