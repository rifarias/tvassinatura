package com.minhatv.tvassinatura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import dominio.Canal;
import dominio.Categoria;
import dominio.Plano;

public class PlanoTest {
	static String nome;
	static BigDecimal valor;
	static List<Canal> canais = new ArrayList<>();
	static LocalDateTime dataAssinatura;

	@BeforeAll
	public static void setup() throws Exception {
		nome = "Full Cinema";
		valor = new BigDecimal(385.00);
		Canal canal1 = new Canal("HBO", 485, Categoria.FILMES);
		Canal canal2 = new Canal("Fox Sports", 200, Categoria.ESPORTES);
		canais.add(canal1);
		canais.add(canal2);
	}

	@Test // criar um test para cada construtor
	public void deve_criar_um_plano_com_nome() throws Exception {
		String nomeSelecionado = "Full Cinema";

		Plano plano = new Plano(nome, valor, canais);

		assertEquals(nomeSelecionado, plano.getNome());
	}

	@Test
	public void nao_deve_criar_um_plano_sem_nome() {
		String nomeSelecionado = null;
		String mensagem = "Nome do plano é obrigatório.";

		Exception excecao = assertThrows(Exception.class, () -> new Plano(nomeSelecionado, valor, canais));

		assertEquals(mensagem, excecao.getMessage());
	}

	@Test
	public void nao_deve_criar_um_plano_sem_valor() {
		BigDecimal valorSelecionado = null;
		String mensagem = "Valor do plano é obrigatório.";

		Exception excecao = assertThrows(Exception.class, () -> new Plano(nome, valorSelecionado, canais));

		assertEquals(mensagem, excecao.getMessage());

	}

	@Test
	public void nao_deve_criar_um_plano_sem_canal() {
		List<Canal> canalSelecionados = new ArrayList<Canal>();
		String mensagem = "É obrigatório o plano ter canais.";

		Exception excecao = assertThrows(Exception.class, () -> new Plano(nome, valor, canalSelecionados));

		assertEquals(mensagem, excecao.getMessage());

	}

	@Test
	public void nao_deve_adicionar_canal_se_nao_existir() throws Exception {
		Plano plano = new Plano(nome, valor, canais);
		Canal canalNulo = null;
		String mensagem = "É necessário um canal válido.";

		Exception excecao = assertThrows(Exception.class, () -> plano.adicionarCanal(canalNulo));

		assertEquals(mensagem, excecao.getMessage());
	}

	@Test
	public void nao_deve_remover_canal_se_nao_existir() throws Exception {
		Plano plano = new Plano(nome, valor, canais);
		Canal canalNulo = null;
		String mensagem = "É necessário um canal válido.";

		Exception excecao = assertThrows(Exception.class, () -> plano.removerCanal(canalNulo));

		assertEquals(mensagem, excecao.getMessage());

	}

	@Test
	public void nao_deve_remover_o_canal_se_for_o_ultimo() throws Exception {
		Canal canal1 = new Canal("HBO", 485, Categoria.FILMES);
		List<Canal> canaisDoPlano = new ArrayList<Canal>();
		canaisDoPlano.add(canal1);
		Plano plano = new Plano(nome, valor, canaisDoPlano);
		String mensagem = "Não é possível remover o último canal do plano.";

		Exception excecao = assertThrows(Exception.class, () -> plano.removerCanal(canal1));

		assertEquals(mensagem, excecao.getMessage());

	}

	@Test
	public void deve_alterar_os_canais() throws Exception {
		Plano plano = new Plano(nome, valor, canais);

		plano.alterarCanais(canais);

		assertEquals(canais, plano.getCanais());

	}

}
