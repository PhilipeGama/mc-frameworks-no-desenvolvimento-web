package ifam.edu;

import ifam.edu.model.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAAula");

        EntityManager em = factory.createEntityManager();

        Pessoa p = new Pessoa();
        p.setNome("Jose");
        p.setEndereco("Rua A");
        p.setTelefone("3233-5678");

        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

        em.close();

    }
}
