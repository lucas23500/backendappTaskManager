package br.edu.ifam.dra.taskmanager.backendapp.controller;

import br.edu.ifam.dra.taskmanager.backendapp.model.Tarefa;
import br.edu.ifam.dra.taskmanager.backendapp.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    //Create - Cria o Status novo
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Tarefa tarefa){

        tarefaRepository.save(tarefa);

        return "Salva com sucesso!";
    }

    //Find - Encontra pelo ID
    @GetMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tarefa find(@PathVariable Long id){

        Optional<Tarefa> status = tarefaRepository.findById(id);

        return status.orElse(null);

    }

    //FindByName - Encontrar pelo nome

    @GetMapping(value="/titulo/{titulo}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Tarefa findByTitulo(@PathVariable String titulo){

        Optional<Tarefa> status = tarefaRepository.findByTituloContaining(titulo);

        return status.orElse(null);

    }
    //Delete - Remoção dos Campos Repetidos
    @DeleteMapping(value="/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){

        tarefaRepository.deleteById(id);

        return "Status excluída!";
    }

    //Get - Trazer tudo que tem dentro da tabela Status[Pendente, Atrasado e Concluído]
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Tarefa> list(){
        List<Tarefa> status;

        status = (List<Tarefa>) tarefaRepository.findAll();

        return status;
    }



    //Populate - Criar a primeira tabela
    @GetMapping(value="/populate")
    @ResponseBody
    public String populate(){

        Tarefa status1=new Tarefa("Fazer a Atividade de DRA");
        Tarefa status2=new Tarefa("Lavar os Pratos");
        Tarefa status3=new Tarefa("Limpar a Casa");

        tarefaRepository.save(status1);
        tarefaRepository.save(status2);
        tarefaRepository.save(status3);

        return "Dados inseridos com sucesso.";

    }

}
