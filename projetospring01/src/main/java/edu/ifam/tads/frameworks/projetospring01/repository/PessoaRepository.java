package edu.ifam.tads.frameworks.projetospring01.repository;

import edu.ifam.tads.frameworks.projetospring01.model.Pessoa;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer> {

    @Query("select p from Pessoa p")
    public List<Pessoa> list();
}
