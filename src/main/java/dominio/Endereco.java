package dominio;

public class Endereco {

	private String logradouro;

	private Integer numero;

	private String cep;

	private Cidade cidade;

	public Endereco(String logradouro, Integer numero, String cep, Cidade cidade) throws Exception {
		validarCamposObrigatorios(logradouro, numero, cep, cidade);

		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
	}

	private void validarCamposObrigatorios(String logradouro, Integer numero, String cep, Cidade cidade)
			throws Exception {

		if (logradouro == null || logradouro.equals("")) {
			throw new Exception("Logradouro é obrigatório");
		}

		if (numero == null) {
			throw new Exception("Numero do Logradouro é obrigatório");
		}

		if (cep == null || cep.equals("")) {
			throw new Exception("Cep do logradouro é obrigatório");
		}

		if (cidade == null)  {
			throw new Exception("Cidade do logradouro obrigatório");
		}

	}

	public String getLogradouro() {
		return logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getCep() {
		return cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

}
