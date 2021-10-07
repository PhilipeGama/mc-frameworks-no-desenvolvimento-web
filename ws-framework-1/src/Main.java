import ifam.edu.model.Cidade;
import ifam.edu.model.Estado;
import ifam.edu.model.Pessoa;

public class Main {
    public  static void main(String[] args){
        Estado e1 = new Estado("AM", "Amazonas");
        Estado e2 = new Estado("PA", "Pará");
        Estado e3 = new Estado("SP", "São Paulo");


        Cidade c1 = new Cidade();
        c1.setNome("Manaus");
        c1.setEstado(e1);
        Cidade c2 = new Cidade("Belém", e2);
        Cidade c3 = new Cidade("São", e3);

        Pessoa p1 = new Pessoa();
        p1.setNome("Joao");
        p1.setEndereco("Rua A");
        p1.setTelefone("3234-1234");
        p1.setCidade(c1);

        Pessoa p2 = new Pessoa("Maria","Rua B","3911-3333",c2);
        Pessoa p3 = new Pessoa("José","Rua C","3121-4001",c3);

        System.out.println("=============================================================");
        System.out.println("ESTADOS");
        System.out.println("=============================================================");
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println("=============================================================");
        System.out.println("CIDADES");
        System.out.println("=============================================================");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println("=============================================================");
        System.out.println("PESSOAS");
        System.out.println("=============================================================");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
