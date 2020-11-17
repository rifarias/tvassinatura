package com.minhatv.tvassinatura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import dominio.Cidade;
import dominio.Endereco;
import dominio.Estado;

public class EnderecoTest {
	private String logradouro;
	private Integer numero;
	private String cep;
	private Cidade cidade;

	@BeforeAll
	public void setup() throws Exception {
		logradouro = "Rua Spipe Calarge, 271";
		numero = 271;
		cep = "79050220";
		Estado estado = new Estado("Paraná", "PR");
		cidade = new Cidade("Curitiba", estado);
	}

	@Test
	public void nao_deve_criar_um_logradouro_sem_nome() throws Exception {
		String nomeDoLogradouro = "Rua Spipe Calarge, 271";

		Endereco endereco = new Endereco(logradouro, numero, cep, cidade);

		assertEquals(nomeDoLogradouro, endereco.getLogradouro());

	}

	@Test
	public void nao_deve_criar_um_endereco_sem_logradouro() {
		String logradouroSelecionado = null;
		String mensagem = "Logradouro é obrigatório";

		Exception excecao = assertThrows(Exception.class,
				() -> new Endereco(logradouroSelecionado, numero, cep, cidade));

		assertEquals(mensagem, excecao.getMessage());
	}

	@Test
	public void nao_deve_criar_um_endereco_sem_numero() {
		Integer numeroSelecionado = null;
		String mensagem = "Numero do Logradouro é obrigatório";

		Exception excecao = assertThrows(Exception.class,
				() -> new Endereco(logradouro, numeroSelecionado, cep, cidade));

		assertEquals(mensagem, excecao.getMessage());

	}

	@Test
	public void nao_deve_criar_um_endereco_sem_cep() {
		String cepSelecionado = null;
		String mensagem = "Cep do logradouro é obrigatório";

		Exception excecao = assertThrows(Exception.class,
				() -> new Endereco(logradouro, numero, cepSelecionado, cidade));

		assertEquals(mensagem, excecao.getMessage());
	}

	@Test
	public void nao_deve_criar_um_endereco_sem_cidade() {
		Cidade cidadeSelecionada = null;
		String mensagem = "Cidade do logradouro obrigatório";

		Exception excecao = assertThrows(Exception.class,
				() -> new Endereco(logradouro, numero, cep, cidadeSelecionada));

		assertEquals(mensagem, excecao.getMessage());
	}

}
