package dominio;

public class Canal {

	private String nome;

	private Integer numero;

	private Categoria categoria;

	public Canal(String nome, Integer numero, Categoria categoria) throws Exception {
		validarAtributosObrigatorios(nome, numero, categoria);

		this.nome = nome;
		this.numero = numero;
		this.categoria = categoria;
	}

	private void validarAtributosObrigatorios(String nome, Integer numero, Categoria categoria) throws Exception {
		if (nome == null || nome.equals("")) {
			throw new Exception("Nome do canal é obrigatório");
		}

		if (numero == null) {
			throw new Exception("Número do canal é obrigatório");
		}

		if (categoria == null) {
			throw new Exception("Categoria do canal é obrigatória");

		}

	}

	public String getNome() {
		return nome;
	}

	public Integer getNumero() {
		return numero;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canal other = (Canal) obj;
		if (categoria != other.categoria)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
