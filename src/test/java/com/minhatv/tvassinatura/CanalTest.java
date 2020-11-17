package com.minhatv.tvassinatura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import dominio.Canal;
import dominio.Categoria;

public class CanalTest {
	private String nome;
	private Integer numero;
	private Categoria categoria;

	@BeforeAll
	public void setup() {
		nome = "HBO";
		numero = 500;
		categoria = categoria.FILMES;
	}

	@Test
	public void deve_criar_um_canal_com_nome() throws Exception {
		nome = "HBO";

		Canal canal = new Canal(nome, numero, categoria);

		assertEquals(nome, canal.getNome());
	}

	@Test
	public void nao_deve_criar_um_canal_sem_nome() {
		String nomeDocanal = null;
		String mensagem = "Nome do canal é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Canal(nomeDocanal, numero, categoria));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void deve_criar_uma_canal_com_numero() throws Exception {
		Integer numero = 3;

		Canal canal = new Canal(nome, numero, categoria);

		assertEquals(numero, canal.getNumero());

	}

	@Test
	public void nao_deve_criar_um_canal_sem_numero() {
		Integer numeroDoCanal = null;
		String mensagem = "Numero do canal é Obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Canal(nome, numeroDoCanal, Categoria.FILMES));

		assertEquals(mensagem, excessao.getMessage());

	}

	@Test
	public void deve_criar_um_canal_com_categoria() throws Exception {
		Categoria tipoDaCategoria = Categoria.FILMES;

		Canal canal = new Canal(nome, numero, categoria);

		assertEquals(tipoDaCategoria, canal.getCategoria());

	}

	@Test
	public void nao_deve_criar_um_canal_sem_categoria() {
		Categoria categoriaselecionada = null;
		String mensagem = "Categoria do canal é obrigatória";

		Exception excessao = assertThrows(Exception.class, () -> new Canal(nome, numero, categoriaselecionada));

		assertEquals(mensagem, excessao.getMessage());

	}

}
