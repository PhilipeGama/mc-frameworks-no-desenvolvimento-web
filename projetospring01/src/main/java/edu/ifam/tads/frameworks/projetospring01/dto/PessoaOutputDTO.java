package edu.ifam.tads.frameworks.projetospring01.dto;

import edu.ifam.tads.frameworks.projetospring01.model.Pessoa;

public class PessoaOutputDTO {

    private Integer id;
    private String nome;
    private String telefone;
    private String email;

    public PessoaOutputDTO(Pessoa pessoa) {
        id = pessoa.getId();
        nome = pessoa.getNome();
        telefone = pessoa.getTelefone();
        email = pessoa.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
