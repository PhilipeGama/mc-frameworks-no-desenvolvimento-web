package edu.ifam.tads.frameworks.projetospring01.controller;


import edu.ifam.tads.frameworks.projetospring01.dto.PessoaInputDTO;
import edu.ifam.tads.frameworks.projetospring01.dto.PessoaOutputDTO;
import edu.ifam.tads.frameworks.projetospring01.model.Pessoa;
import edu.ifam.tads.frameworks.projetospring01.repository.CidadeRepository;
import edu.ifam.tads.frameworks.projetospring01.repository.PessoaRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @ResponseBody
    @GetMapping(value = "/population", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> popularPessoas(){
        List<Pessoa> pessoa = new ArrayList<>();

        Pessoa pessoa1 = new Pessoa();

        pessoa1.setNome("Maria");
        pessoa1.setTelefone("91234-5678");
        pessoa1.setEmail("maria@email.com");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Philipe");
        pessoa2.setTelefone("91234-5676");
        pessoa2.setEmail("philipe@email.com");

        pessoa.add(pessoa1);
        pessoa.add(pessoa2);

        pessoaRepository.save(pessoa1);
        pessoaRepository.save(pessoa2);

        return pessoa;

    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> get(){
        List<Pessoa> pessoas = pessoaRepository.list();
        return pessoas;
    }

    @ResponseBody
    @GetMapping(value="/{id}")
    public Optional<Pessoa> get(@PathParam("id") Integer id){

        return pessoaRepository.findById(id);
    }

    @ResponseBody
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaOutputDTO> create(@RequestBody PessoaInputDTO dto,
                                                  UriComponentsBuilder uriBuilder){
        Pessoa pessoa = dto.build(cidadeRepository);
        pessoaRepository.save(pessoa);

        URI path = uriBuilder.path("/api/pessoa/{id}")
                .buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(path).body(new PessoaOutputDTO(pessoa));
    }
}
