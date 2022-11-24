package br.edu.ifam.dra.taskmanager.backendapp.controller;

import br.edu.ifam.dra.taskmanager.backendapp.model.Status;
import br.edu.ifam.dra.taskmanager.backendapp.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    //Create - Cria o Status novo
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Status status){

        statusRepository.save(status);

        return "Salva com sucesso!";
    }

    //Find - Encontra pelo ID
    @GetMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Status find(@PathVariable Long id){

        Optional<Status> status = statusRepository.findById(id);

        return status.orElse(null);

    }

    //FindByName - Encontrar pelo nome

    @GetMapping(value="/titulo/{titulo}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Status findByTitulo(@PathVariable String titulo){

        Optional<Status> status = statusRepository.findByTituloContaining(titulo);

        return status.orElse(null);

    }
    //Delete - Remoção dos Campos Repetidos
    @DeleteMapping(value="/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){

        statusRepository.deleteById(id);

        return "Status excluída!";
    }

    //Get - Trazer tudo que tem dentro da tabela Status[Pendente, Atrasado e Concluído]
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Status> list(){
        List<Status> status;

        status = (List<Status>) statusRepository.findAll();

        return status;
    }



    //Populate - Criar a primeira tabela
    @GetMapping(value="/populate")
    @ResponseBody
    public String populate(){

        Status status1=new Status("Pendente");
        Status status2=new Status("Atrasado");
        Status status3=new Status("Concluído");

        statusRepository.save(status1);
        statusRepository.save(status2);
        statusRepository.save(status3);

        return "Dados inseridos com sucesso.";

    }

}
