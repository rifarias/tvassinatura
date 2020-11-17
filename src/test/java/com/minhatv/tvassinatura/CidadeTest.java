package com.minhatv.tvassinatura;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dominio.Cidade;
import dominio.Estado;

public class CidadeTest {
	String nome;
	Estado estado;

	@BeforeAll
	public void Setup() throws Exception {
		nome = "Campo Grande";
		estado = new Estado("Mato Grosso do Sul", "MS");
	}

	@Test
	public void deve_criar_uma_cidade_com_nome() throws Exception {
		String nomeDaCidade = "Campo Grande";
		Estado estadoSelecionado = new Estado("Mato Grosso do Sul", "MS");

		Cidade cidade = new Cidade(nome, estado);

		assertAll("cidade", 
				() -> assertEquals(nomeDaCidade, cidade.getNome()),
				() -> assertEquals(estadoSelecionado, cidade.getEstado()));
	}

	@Test
	public void nao_deve_criar_uma_cidade_sem_nome() throws Exception {
		String nomeDaCidade = null;
		String mensagem = "Nome da cidade é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Cidade(nomeDaCidade, estado));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void nao_deve_criar_uma_cidade_sem_estado() {
		Estado estadoNulo = null;
		String mensagem = "Estado da cidade é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Cidade(nome, estadoNulo));

		assertEquals(mensagem, excessao.getMessage());

	}

}
