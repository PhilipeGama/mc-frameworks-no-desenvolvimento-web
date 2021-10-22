package ifam.edu;

import ifam.edu.dao.CidadeDAO;
import ifam.edu.dao.DAOGenerico;
import ifam.edu.dao.EstadoDAO;
import ifam.edu.model.Cidade;
import ifam.edu.model.Estado;
import ifam.edu.model.Pessoa;
import ifam.edu.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {


    public static void inserirPessoaComCidadeNoBD() {
        EntityManager em = JPAUtil.getEntityManager();

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");

//        Cidade cidade = new Cidade();
//        cidade.setNome("Manaus");
//        cidade.setEstado(estado);

        //Transient
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Jose");
        pessoa.setDocumento("2345678");
        pessoa.setEndereco("Rua A");
        pessoa.setTelefone("3233-5678");

        Cidade cidade = em.find(Cidade.class, 10);


        pessoa.setCidade(cidade);


        //Persintindo no BD
        em.getTransaction().begin();

        //Persistindo Cidade (Managed)
        em.persist(estado);

        //Persistindo Cidade (Managed)
        //em.persist(cidade);

        //cidade.setNome("Belem Atualizado");

        //Persistindo Pessoa (Managed)
//        em.persist(pessoa);
        em.getTransaction().commit();

        em.close();
    }

    public static void consultar() {
        EntityManager em = JPAUtil.getEntityManager();
        Cidade cidade = em.find(Cidade.class, 1);

        System.out.println("Cidade - Id" + cidade.getId());
        System.out.println("Cidade - Nome" + cidade.getNome());

        Pessoa pessoa = em.find(Pessoa.class, 1);

        System.out.println("Pessoa - Id" + cidade.getId());
        System.out.println("Pessoa - Nome" + pessoa.getNome());
        System.out.println("Pessoa - Cidade" + pessoa.getCidade().getNome());
        System.out.println("Pessoa - Estado" + pessoa.getCidade().getEstado().getNome());
    }

    private static void remover() {

        //Removendo do BD

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        Pessoa pessoa = em.find(Pessoa.class, 1);
        em.remove(pessoa);
        em.getTransaction().commit();
    }

    public static void inserirEstadoAtravesDoDao() {

        Estado estado = new Estado();
        estado.setSigla("SC");
        estado.setNome("Espírito Santos");

        EntityManager entityManager = JPAUtil.getEntityManager();

        //Injeção de Dependência (Dependece Injection - DI)
        EstadoDAO dao = new EstadoDAO(entityManager);

        entityManager.getTransaction().begin();
        dao.salvar(estado);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static void consultarEstadoAtravesDoDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();
        EstadoDAO dao = new EstadoDAO(entityManager);

        entityManager.getTransaction().begin();

        Estado estado = dao.consultar(22);
        System.out.println(estado.toString());

        entityManager.getTransaction().commit();
        entityManager.close();


    }

    public static void removerEstadoAtravesDoDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();
        EstadoDAO dao = new EstadoDAO(entityManager);

        entityManager.getTransaction().begin();

        dao.remover(20);

        entityManager.getTransaction().commit();
        entityManager.close();


    }

    public static void listarEstadoAtravesDoDao() {

        EntityManager entityManager = JPAUtil.getEntityManager();
        EstadoDAO dao = new EstadoDAO(entityManager);

        List<Estado> estados = dao.listar();

        for (Estado estado : estados) {
            System.out.println(estado.toString());
        }
        entityManager.close();

    }

    public static void inserirAtravesDAOGenerico() {

        Estado estado = new Estado();
        estado.setSigla("RJ");
        estado.setNome("Rio de Janeiro");

        EntityManager entityManager = JPAUtil.getEntityManager();

        //Injeção de Dependência (Dependece Injection - DI)
        DAOGenerico dao = new DAOGenerico<Estado>(entityManager, Estado.class);

        entityManager.getTransaction().begin();
        dao.salvar(estado);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


    public static void main(String[] args) {


//      Estado DAO
//        inserirEstadoAtravesDoDao();
//        consultarEstadoAtravesDoDao();
//        removerEstadoAtravesDoDao();
//        listarEstadoAtravesDoDao();

        //Generico DAO


//      DAO Generic
        inserirAtravesDAOGenerico();
    }

}

