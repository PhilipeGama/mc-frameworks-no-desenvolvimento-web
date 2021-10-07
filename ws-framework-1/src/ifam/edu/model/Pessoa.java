package ifam.edu.model;

import ifam.edu.model.Cidade;

public class Pessoa {
	private String nome;
	private String endereco;
	private String telefone;
	private Cidade cidade;

	public Pessoa(){}

	public Pessoa(String nome, String endereco, String telefone, Cidade cidade) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
				+ ", telefone=" + telefone
				+ ", cidade=" + cidade.toString();
	}




}
