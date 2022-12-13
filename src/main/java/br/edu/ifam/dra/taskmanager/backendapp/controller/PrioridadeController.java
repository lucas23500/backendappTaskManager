package br.edu.ifam.dra.taskmanager.backendapp.controller;

import br.edu.ifam.dra.taskmanager.backendapp.model.Prioridade;
import br.edu.ifam.dra.taskmanager.backendapp.repository.PrioridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/prioridade")
public class PrioridadeController {

    @Autowired
    private PrioridadeRepository prioridadeRepository;

    //Create - Cria o Status novo
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Prioridade prioridade){

        prioridadeRepository.save(prioridade);

    }

    //Find - Encontra pelo ID
    @GetMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Prioridade find(@PathVariable Long id){

        Optional<Prioridade> prioridade = prioridadeRepository.findById(id);

        return prioridade.orElse(null);

    }

    //FindByName - Encontrar pelo nome

    @GetMapping(value="/titulo/{titulo}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Prioridade findByTitulo(@PathVariable String titulo){

        Optional<Prioridade> prioridade = prioridadeRepository.findByTituloContaining(titulo);

        return prioridade.orElse(null);

    }
    //Delete - Remoção dos Campos Repetidos
    @DeleteMapping(value="/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){

        prioridadeRepository.deleteById(id);

        return "Status excluída!";
    }

    //Get - Trazer tudo que tem dentro da tabela Status[Pendente, Atrasado e Concluído]
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Prioridade> list(){
        List<Prioridade> status;

        status = (List<Prioridade>) prioridadeRepository.findAll();

        return status;
    }



    //Populate - Criar a primeira tabela
    @GetMapping(value="/populate")
    @ResponseBody
    public String populate(){

        Prioridade status1=new Prioridade("Alta");
        Prioridade status2=new Prioridade("Média");
        Prioridade status3=new Prioridade("Baixa");

        prioridadeRepository.save(status1);
        prioridadeRepository.save(status2);
        prioridadeRepository.save(status3);

        return "Dados inseridos com sucesso.";

    }

}
