package ifam.edu.model;

import java.util.ArrayList;

public class Estado {
    private String sigla;
    private String nome;
    private ArrayList<Cidade> cidades;

    public Estado() {
        cidades = new ArrayList<Cidade>();
    }

    public Estado(String sigla, String nome) {
        cidades = new ArrayList<Cidade>();
        this.sigla = sigla;
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public ArrayList<Cidade> getCidades() {
        return cidades;
    }

    public void addCidade(Cidade cidade) {
        cidades.add(cidade);
        //cidade.setEstado(this.estado);
    }


    @Override
    public String toString() {
        return "Estado{" +
                "sigla='" + sigla + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
