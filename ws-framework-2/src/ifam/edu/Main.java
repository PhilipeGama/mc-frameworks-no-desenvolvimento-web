package ifam.edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPAAula");

        EntityManager entityManager = factory.createEntityManager();
        System.out.println("Conexão realizada com sucesso!");

    }
}
