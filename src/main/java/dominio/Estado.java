package dominio;

public class Estado {

	private String nome;

	private String sigla;

	public Estado(String nome, String sigla) throws Exception {
		validarCamposObrigatorios(nome, sigla);

		this.nome = nome;
		this.sigla = sigla;
	}

	private void validarCamposObrigatorios(String nome, String sigla) throws Exception {
		if (nome == null || nome.equals("")) {
			throw new Exception("Obrigatório o nome do Estado");
		}

		if (sigla == null || sigla.equals("")) {
			throw new Exception("Obrigatório sigla do Estado");
		}

	}

	public String getSigla() {
		return sigla;
	}

	public String getNome() {
		return nome;
	}

}
