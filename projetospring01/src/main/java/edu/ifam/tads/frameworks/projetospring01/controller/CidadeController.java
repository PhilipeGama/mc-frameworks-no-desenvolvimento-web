package edu.ifam.tads.frameworks.projetospring01.controller;

import edu.ifam.tads.frameworks.projetospring01.model.Cidade;
import edu.ifam.tads.frameworks.projetospring01.model.Pessoa;
import edu.ifam.tads.frameworks.projetospring01.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping(value = "/api/cidade/popular", produces = MediaType.APPLICATION_JSON_VALUE)
    public String popularCidade() {
        List<Pessoa> pessoa = new ArrayList<>();

        Cidade cidade1 = new Cidade();

        cidade1.setNome("Manaus");


        Cidade cidade2 = new Cidade();
        cidade2.setNome("São Paulo");


        cidadeRepository.save(cidade1);
        cidadeRepository.save(cidade2);

        return "Cidade cadastradas com sucesso!";

    }

    @ResponseBody
    @GetMapping(value = "/api/cidade/getByNome", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cidade getByName() {
        Cidade cidade = cidadeRepository.findByNome("Manaus");
        System.out.println(cidade.toString());
        return cidade;
    }

}