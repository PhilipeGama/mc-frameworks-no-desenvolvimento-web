package edu.ifam.tads.frameworks.projetospring01.dto;

import edu.ifam.tads.frameworks.projetospring01.model.Cidade;
import edu.ifam.tads.frameworks.projetospring01.model.Pessoa;
import edu.ifam.tads.frameworks.projetospring01.repository.CidadeRepository;

public class PessoaInputDTO {

    private String nome;
    private String telefone;
    private String email;
    private String cidade;

    public Pessoa build(CidadeRepository cidadeRepository){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(this.nome);
        pessoa.setTelefone(this.telefone);
        pessoa.setEmail(this.email);
        Cidade cidade1 = cidadeRepository.findCidadeByNome(cidade);
        System.out.println(cidade1.getId());
        pessoa.setCidade(cidade1);

        return pessoa;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
