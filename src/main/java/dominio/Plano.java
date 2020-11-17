package dominio;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Plano {

	private String nome;

	private List<Canal> canais = new ArrayList<Canal>();

	private BigDecimal valor;

	public Plano(String nome, BigDecimal valor, List<Canal> canais) throws Exception {
		validarCamposObrigatorios(nome, valor, canais);

		this.nome = nome;
		this.setValor(valor);
		this.canais = canais;
	}

	private void validarCamposObrigatorios(String nome, BigDecimal valor, List<Canal> canais) throws Exception {

		if (nome == null || nome.equals("")) {
			throw new Exception("Nome do plano é obrigatório.");
		}

		if (valor == null || valor.equals("")) {
			throw new Exception("Valor do plano é obrigatório.");
		}

		if (canais == null || canais.isEmpty()) {
			throw new Exception("É obrigatório o plano ter canais.");
		}

	}

	private void listarCanaisDoPlano(Plano plano) {
		for (int i = 0; i < plano.canais.size(); i++) {
			System.out.println(plano.getCanais().get(i).getNome());
		}
	}

	public void adicionarCanal(Canal canal) throws Exception {
		validarCanal(canal);
		canais.add(canal);
	}

	public void removerCanal(Canal canal) throws Exception {
		validarCanal(canal);
		boolean canalExisteNoPlano = canais.contains(canal);
		if (canalExisteNoPlano) {
			validarSePodeExcluirCanal();
			canais.remove(canal);
		}
	}

	private void validarCanal(Canal canal) throws Exception {
		if (canal == null) {
			throw new Exception("É necessário um canal válido.");
		}

	}

	private void validarSePodeExcluirCanal() throws Exception {
		int quantidadeDeCanais = this.canais.size();

		if (quantidadeDeCanais == 1) {
			throw new Exception("Não é possível remover o último canal do plano.");
		}
	}

	public void alterarCanais(List<Canal> canais) throws Exception {
		if (canais != null && !canais.isEmpty()) {
			this.canais = canais;
		} else {
			throw new Exception("A lista de canais está vazia"); // pensar em uma mensagem melhor
		}
	}

	public String getNome() {
		return nome;
	}

	public List<Canal> getCanais() {
		return canais;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
