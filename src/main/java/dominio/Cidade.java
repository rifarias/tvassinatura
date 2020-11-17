package dominio;

public class Cidade {

	private String nome;

	private Estado estado;

	public Cidade(String nome, Estado estado) throws Exception {
		validarCamposObrigatorios(nome, estado);

		this.nome = nome;
		this.estado = estado;
	}

	private void validarCamposObrigatorios(String nome, Estado estado) throws Exception {

		if (nome == null || nome.equals("")) {
			throw new Exception("Nome da cidade é obrigatório");
		}

		if (estado == null) {
			throw new Exception("Estado da cidade é obrigatório");
		}

	}

	public String getNome() {
		return nome;
	}

	public Estado getEstado() {
		return estado;
	}

}
