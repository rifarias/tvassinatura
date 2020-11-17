package dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

public class Assinante {

	private String nome;

	private String cpf;

	private LocalDateTime dataNascimento;

	private Endereco endereco;

	private String telefoneCelular;

	private String telefoneFixo;

	private Plano plano;

	private LocalDateTime dataAssinaturaDoPlano;

	public Assinante(String nome, String cpf, LocalDateTime dataNascimento, Endereco endereco, String telefoneCelular,
			String telefoneFixo, Plano plano, LocalDateTime dataAssinaturaDoPlano) throws Exception {

		validarAtributosObrigatorios(nome, cpf, dataNascimento, endereco, telefoneCelular, telefoneFixo, plano);

		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefoneCelular = telefoneCelular;
		this.telefoneFixo = telefoneFixo;
		this.plano = plano;
		this.dataAssinaturaDoPlano = dataAssinaturaDoPlano;
	}

	private void validarAtributosObrigatorios(String nome, String cpf, LocalDateTime dataNascimento, Endereco endereco,
			String telefoneCelular, String telefoneFixo, Plano plano) throws Exception {

		validarDadosDoAssinante(nome, dataNascimento, endereco, telefoneCelular, telefoneFixo);

		if (cpf == null || cpf.trim().equals("")) {
			throw new Exception("Cpf do assinante é obrigatório");
		}

		if (plano == null) {
			throw new Exception("O assinante precisa ter um plano de tv");
		}

	}

	private void validarDadosDoAssinante(String nome, LocalDateTime dataNascimento, Endereco endereco,
			String telefoneCelular, String telefoneFixo) throws Exception {

		if (nome == null || nome.trim().equals("")) {
			throw new Exception("Nome do assinante é obrigatório");
		}

		if (dataNascimento == null) {
			throw new Exception("Data de nascimento do assinante é obrigatória");
		}

		if (endereco == null) {
			throw new Exception("Endereço do assinante é obrigatório");
		}

		if (telefoneCelular == null
				|| telefoneCelular.equals("") && (telefoneFixo == null || telefoneFixo.equals(""))) {
			throw new Exception("O assinante deve possuir ao menos um telefone");
		}

	}

	public void alterarDadosDoAssinante(String nome, LocalDateTime dataNascimento, Endereco endereco,
			String telefoneCelular, String telefoneFixo) throws Exception {

		validarDadosDoAssinante(nome, dataNascimento, endereco, telefoneCelular, telefoneFixo);

		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefoneCelular = telefoneCelular;
		this.telefoneFixo = telefoneFixo;
	}

	public void alterarPlano(Plano plano) throws Exception {
		if (plano == null) {
			throw new Exception("O assinante precisa ter um plano de tv");
		}

		this.dataAssinaturaDoPlano = LocalDateTime.now();
		this.plano = plano;
	}

	public BigDecimal obterValorAtualDoPlano() {
		if (verificarSeEUmAssinanteVip()) {
			return this.plano.getValor().multiply(new BigDecimal(0.90));
		}

		return this.plano.getValor();
	}

	public boolean verificarSeEUmAssinanteVip() {
		BigDecimal valorMinimoParaDesconto = new BigDecimal(150);
		BigDecimal valorDoPlano = this.plano.getValor();
		boolean valorDoPlanoEMaiorQueMinimoParaDesconto = valorDoPlano.compareTo(valorMinimoParaDesconto) > 0;
		LocalDateTime dataAtual = LocalDateTime.now();
		boolean tempoDeAssinaturaEMaiorQueUmAno = this.dataAssinaturaDoPlano.until(dataAtual, ChronoUnit.YEARS) >= 1;

		return valorDoPlanoEMaiorQueMinimoParaDesconto && tempoDeAssinaturaEMaiorQueUmAno;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public String getTelefoneFixo() {
		return telefoneFixo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Plano getPlano() {
		return plano;
	}

	public LocalDateTime getDataAssinaturaDoPlano() {
		return dataAssinaturaDoPlano;
	}

	public LocalDateTime getDataNascimento() {
		return dataNascimento;
	}

}
