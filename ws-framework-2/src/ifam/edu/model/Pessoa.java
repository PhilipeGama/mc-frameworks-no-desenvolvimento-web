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
	private String telefone;


	@Enumerated(EnumType.ORDINAL)
	private SexoEnum sexo;

	public Pessoa() {
	}

	public Pessoa(String nome, String telefone) {
		this.nome = nome;
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

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Pessoa{" +
				"documento='" + documento + '\'' +
				", nome='" + nome + '\'' +
				", telefone='" + telefone + '\'' +
				", sexo=" + sexo +
				", cidade=" + cidade +
				'}';
	}
}
