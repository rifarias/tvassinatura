package com.minhatv.tvassinatura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import dominio.Estado;

public class EstadoTest {
	String nome;
	String sigla;

	@BeforeAll
	public void setup() {
		nome = "Mato Grosso do Sul";
		sigla = "MS";
	}

	@Test
	public void deve_criar_um_estado_com_nome() throws Exception {
		String nomeDoEstado = "Mato Grosso do Sul";

		Estado estado = new Estado(nome, sigla);

		assertEquals(nomeDoEstado, estado.getNome());
	}

	@Test
	public void nao_deve_criar_um_estado_sem_nome() {
		String nomeDoEstado = null;
		String mensagem = "Obrigatório o nome do Estado";

		Exception excessao = assertThrows(Exception.class, () -> new Estado(nomeDoEstado, sigla));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void deve_criar_um_estado_com_sigla() throws Exception {
		String siglaDoEstado = "MS";

		Estado estado = new Estado(nome, sigla);

		assertEquals(siglaDoEstado, estado.getSigla());

	}

	@Test
	public void nao_deve_criar_uma_sigla_sem_nome() {
		String nomeDaSigla = null;
		String mensagem = "Obrigatório sigla do Estado";

		Exception excecao = assertThrows(Exception.class, () -> new Estado(nome, nomeDaSigla));

		assertEquals(mensagem, excecao.getMessage());
	}

}
