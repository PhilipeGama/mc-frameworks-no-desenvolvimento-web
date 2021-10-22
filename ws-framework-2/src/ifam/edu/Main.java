package ifam.edu;

import ifam.edu.dao.CidadeDAO;
import ifam.edu.dao.DAOGenerico;
import ifam.edu.dao.EstadoDAO;
import ifam.edu.dao.PessoaDAO;
import ifam.edu.model.Cidade;
import ifam.edu.model.Estado;
import ifam.edu.model.Pessoa;
import ifam.edu.model.SexoEnum;
import ifam.edu.util.JPAUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class Main {


    public static void inserirPessoaComCidadeNoBD() {
        EntityManager em = JPAUtil.getEntityManager();

        Estado estado = new Estado();
        estado.setNome("Amazonas");
        estado.setSigla("AM");

        //Transient
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Paula");
        pessoa.setDocumento("2212112");
        pessoa.setTelefone("3113-5678");
        pessoa.setSexo(SexoEnum.FEMININO);

        Cidade cidade = new Cidade();
        cidade.setEstado(estado);
        cidade.setNome("Manaus");



        pessoa.setCidade(cidade);


        //Persintindo no BD
        em.getTransaction().begin();

        //Persistindo Cidade (Managed)
        em.persist(estado);

        //Persistindo Cidade (Managed)
        em.persist(cidade);

        //cidade.setNome("Belem Atualizado");

        //Persistindo Pessoa (Managed)
       em.persist(pessoa);
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
        DAOGenerico<Estado> estadoDAO = new DAOGenerico<>(entityManager, Estado.class);

        entityManager.getTransaction().begin();
        estadoDAO.salvar(estado);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public static void listaPorNomeAtravesPessoaDAO(){
        EntityManager entityManager = JPAUtil.getEntityManager();

        PessoaDAO pessoaDAO = new PessoaDAO(entityManager);
        List<Pessoa> pessoas = pessoaDAO.listarPorNomeParcial("P");

        for(Pessoa p:pessoas){
            System.out.println(p);
        }
        entityManager.close();;
    }


    public static void testandoEnumeration(){
        Pessoa pessoa1 = new Pessoa();

        pessoa1.setNome("Jose");
        pessoa1.setTelefone("3222-1156");
        pessoa1.setSexo(SexoEnum.MASCULINO);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Julianna");
        pessoa2.setSexo(SexoEnum.FEMININO);

        System.out.println("Pessoa: "+pessoa1.getNome()+", "+pessoa1.getSexo());
        System.out.println("Pessoa: "+pessoa2.getNome()+", "+pessoa2.getSexo());
    }

    public static void main(String[] args) {
// Pessoa DAO
      //  inserirPessoaComCidadeNoBD();

//      Estado DAO
//        inserirEstadoAtravesDoDao();
//        consultarEstadoAtravesDoDao();
//        removerEstadoAtravesDoDao();
//        listarEstadoAtravesDoDao();

        //Generico DAO


//      DAO Generic
//        inserirAtravesDAOGenerico();
listaPorNomeAtravesPessoaDAO();
        //testandoEnumeration();
    }

}

