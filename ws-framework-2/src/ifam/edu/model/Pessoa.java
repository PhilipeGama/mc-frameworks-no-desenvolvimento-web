package ifam.edu.model;

import javax.persistence.*;

@Entity(name="pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true, nullable = false)
	private String documento;

	private String nome;
	private String endereco;
	private String telefone;

	public Pessoa() {
	}

	public Pessoa(String nome, String endereco, String telefone) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	@ManyToOne
	private Cidade cidade;

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome
				+ ", endereco=" + endereco
				+ ", telefone=" + telefone;
	}

}
