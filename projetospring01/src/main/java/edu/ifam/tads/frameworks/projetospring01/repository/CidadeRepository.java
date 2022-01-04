package edu.ifam.tads.frameworks.projetospring01.repository;

import edu.ifam.tads.frameworks.projetospring01.model.Cidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CidadeRepository extends CrudRepository<Cidade, Integer> {


    @Query("select c from Cidade c where c.nome = :pNome")
    Cidade findCidadeByNome(@Param("pNome") String nome);

    Cidade findByNome(String nome);

}

