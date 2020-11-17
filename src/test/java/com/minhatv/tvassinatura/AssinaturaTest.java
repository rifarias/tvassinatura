package com.minhatv.tvassinatura;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dominio.Assinante;
import dominio.Canal;
import dominio.Categoria;
import dominio.Cidade;
import dominio.Endereco;
import dominio.Estado;
import dominio.Plano;
import junit.framework.Assert;

@SpringBootTest
public class AssinaturaTest {
	private static String nome;
	private static String cpf;
	private static LocalDateTime dataNascimento;
	private static Cidade cidade;
	private static String telefoneCelular;
	private static String telefoneFixo;
	private static Endereco endereco;
	private static Plano plano;
	private static LocalDateTime dataAssinaturaDoPlano;
	private static String nomeDoCanal1;
	private static String nomeDoCanal2;
	private static List<Canal> canais = new ArrayList<Canal>();

	@BeforeAll
	public static void setup() throws Exception {
		nome = "Ricardo Farias";
		cpf = "70082995168";
		dataNascimento = LocalDateTime.of(2020, 7, 2, 10, 1);
		Estado estado = new Estado("Mato Grosso do Sul", "MS");
		cidade = new Cidade("Campo Grande", estado);
		endereco = new Endereco("Rua Raposo Tavares", 410, "7905050", cidade);
		telefoneCelular = "991202147";
		telefoneFixo = "33125982";
		dataAssinaturaDoPlano = LocalDateTime.now();
		nomeDoCanal1 = "HBO";
		nomeDoCanal2 = "Telecine";

		Canal canal1 = new Canal(nomeDoCanal1, 300, Categoria.NOTÍCIAS);
		Canal canal2 = new Canal(nomeDoCanal2, 230, Categoria.FILMES);

		canais.add(canal1);
		canais.add(canal2);
		plano = new Plano("Full cinema HD", new BigDecimal(250.00), canais);
	}

	@Test
	public void deve_criar_uma_assinante_com_nome() throws Exception {
		String nome = "Ricardo Farias";

		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataAssinaturaDoPlano);

		assertEquals(nome, assinante.getNome());
	}

	@Test
	public void nao_deve_criar_um_assinante_sem_nome() throws Exception {
		String nome = null;
		String mensagem = "Nome do assinante é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void deve_criar_um_assinante_com_cpf() throws Exception {
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataAssinaturaDoPlano);

		assertEquals(cpf, assinante.getCpf());
	}

	@Test
	public void nao_deve_criar_um_assinante_sem_cpf() throws Exception {
		String cpf = null;
		String mensagem = "Cpf do assinante é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void nao_deve_criar_um_assinante_sem_endereco() throws Exception {
		Endereco enderecoSelecionado = null;
		String mensagem = "Endereço do assinante é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento,
				enderecoSelecionado, telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void nao_deve_criar_um_assinante_sem_data_nascimento() throws Exception {
		LocalDateTime dataNascimentoSelecionada = null;
		String mensagem = "Data de nascimento do assinante é obrigatória";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimentoSelecionada,
				endereco, telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void nao_deve_criar_um_assinante_sem_um_telefone() throws Exception {
		String telefoneCelular = null;
		String telefoneFixo = null;
		String mensagem = "O assinante deve possuir ao menos um telefone";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());

	}

	@Test
	public void nao_deve_criar_um_assinante_sem_um_plano() {
		Plano planoSelecionado = null;
		String mensagem = "O assinante precisa ter um plano de tv";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, planoSelecionado, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());
	}

	@Test
	public void deve_alterar_o_plano_do_assinante() throws Exception {
		Canal canal1 = new Canal("CNN", 343, Categoria.NOTÍCIAS);
		Canal canal2 = new Canal("Globonews", 345, Categoria.NOTÍCIAS);
		List<Canal> canais = new ArrayList<Canal>();
		canais.add(canal1);
		canais.add(canal2);
		Plano plano1 = new Plano("Plano Basico", new BigDecimal(50.00), canais);
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataAssinaturaDoPlano);

		assinante.alterarPlano(plano1);

		assertEquals(plano1, assinante.getPlano());
	}

	@Test
	public void deve_alterar_a_data_de_assinatura() throws Exception {
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				LocalDateTime.now());

		assinante.alterarPlano(plano);

		assertEquals(LocalDate.now(), assinante.getDataAssinaturaDoPlano());

	}

	@Test
	public void nao_deve_alterar_os_dados_do_assinante_sem_o_nome() {
		String nome = null;
		String mensagem = "Nome do assinante é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());

	}

	public void nao_deve_alterar_os_dados_do_assinante_sem_a_data_de_nascimento() {
		LocalDateTime dataNascimento = null;
		String mensagem = "Data de nascimento do assinante é obrigatória";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());

	}

	public void nao_deve_alterar_os_dados_do_assinante_sem_o_endereco_do_assinante() {
		Endereco endereco = null;
		String mensagem = "Endereço do assinante é obrigatório";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				telefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());

	}

	public void nao_deve_alterar_os_dados_do_assinante_sem_um_telefone() {
		String tefoneCelular = null;
		String telefoneFixo = null;
		String mensagem = "O assinante deve possuir ao menos um telefone";

		Exception excessao = assertThrows(Exception.class, () -> new Assinante(nome, cpf, dataNascimento, endereco,
				tefoneCelular, telefoneFixo, plano, dataAssinaturaDoPlano));

		assertEquals(mensagem, excessao.getMessage());

	}

	@Test
	public void deve_alterar_os_dados_do_assinante() throws Exception {
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				LocalDateTime.now());

		assinante.alterarDadosDoAssinante(nome, dataNascimento, endereco, telefoneCelular, telefoneFixo);

		assertEquals(nome, assinante.getNome());
		assertEquals(dataNascimento, assinante.getDataNascimento());
		assertEquals(endereco, assinante.getEndereco());
		assertEquals(telefoneCelular, assinante.getTelefoneCelular());
		assertEquals(telefoneFixo, assinante.getTelefoneFixo());
	}

	@Test
	public void nao_deve_aterar_o_plano_se_nao_existir_um_plano() throws Exception {
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataAssinaturaDoPlano);
		Plano plano = null;
		String mensagem = "O assinante precisa ter um plano de tv";

		Exception excecao = assertThrows(Exception.class, () -> assinante.alterarPlano(plano));

		assertEquals(mensagem, excecao.getMessage());

	}

	@Test
	public void deve_alterar_o_plano() throws Exception {
		BigDecimal valorDoPlano = new BigDecimal(350.00);
		Plano novoPlano = new Plano("Premier Sport ", valorDoPlano, canais);
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataAssinaturaDoPlano);

		assinante.alterarPlano(novoPlano);

		assertEquals(novoPlano, assinante.getPlano());

	}

	@Test
	public void deve_alterar_a_data_da_assinatura_do_plano() throws Exception {
		DateTimeFormatter formatadorDeData = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dataAssinaturaDoPlano = LocalDateTime.now();
		String dataEsperada = dataAssinaturaDoPlano.format(formatadorDeData);
		LocalDateTime dataAnteriorDeAssinaturaDoPlano = LocalDateTime.of(2018, Month.MARCH, 15, 1, 10);
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataAnteriorDeAssinaturaDoPlano);

		assinante.alterarPlano(plano);

		String dataObtida = assinante.getDataAssinaturaDoPlano().format(formatadorDeData);
		assertEquals(dataEsperada, dataObtida);
	}

	@Test
	public void deve_verificar_se_e_um_assinante_vip() throws Exception {
		BigDecimal valorDoPlano = new BigDecimal(350.00);
		Plano plano = new Plano("Premier Sport ", valorDoPlano, canais);
		LocalDateTime dataDeAssinaturaDoPlano = LocalDateTime.of(2018, Month.MARCH, 15, 1, 10);
		Assinante assinante = new Assinante(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano,
				dataDeAssinaturaDoPlano);

		assinante.verificarSeEUmAssinanteVip();

		assertTrue(assinante.verificarSeEUmAssinanteVip());
	}

}
