package ifam.edu;

import ifam.edu.model.Cidade;
import ifam.edu.model.Pessoa;
import ifam.edu.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {


        EntityManager em = JPAUtil.getEntityManager();
        Pessoa p = new Pessoa();
        p.setNome("Julia");
        p.setDocumento("234567");
        p.setEndereco("Rua A");
        p.setTelefone("3233-5678");

        Cidade c = new Cidade();
        c.setNome("Manaus");

        p.setCidade(c);

        //Persintindo no BD
        em.getTransaction().begin();

        //Persistindo Cidade (Managed)
        em.persist(c);

        c.setNome("Belem Atualizado");

        //Persistindo Pessoa (Managed)
        em.persist(p);
        em.getTransaction().commit();

        em.close();

    }
}
