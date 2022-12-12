package br.edu.ifam.dra.taskmanager.backendapp.controller;

import br.edu.ifam.dra.taskmanager.backendapp.model.Categoria;
import br.edu.ifam.dra.taskmanager.backendapp.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //Create - Cria o Status novo
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Categoria categoria){

        categoriaRepository.save(categoria);

    }

    //Find - Encontra pelo ID
    @GetMapping(value="/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Categoria find(@PathVariable Long id){

        Optional<Categoria> status = categoriaRepository.findById(id);

        return status.orElse(null);

    }

    //FindByName - Encontrar pelo nome

    @GetMapping(value="/titulo/{titulo}", produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Categoria findByTitulo(@PathVariable String titulo){

        Optional<Categoria> status = categoriaRepository.findByTituloContaining(titulo);

        return status.orElse(null);

    }
    //Delete - Remoção dos Campos Repetidos
    @DeleteMapping(value="/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id){

        categoriaRepository.deleteById(id);

        return "Status excluída!";
    }

    //Get - Trazer tudo que tem dentro da tabela Status[Pendente, Atrasado e Concluído]
    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Categoria> list(){
        List<Categoria> status;

        status = (List<Categoria>) categoriaRepository.findAll();

        return status;
    }



    //Populate - Criar a primeira tabela
    @GetMapping(value="/populate")
    @ResponseBody
    public String populate(){

        Categoria status1=new Categoria("Escola");
        Categoria status2=new Categoria("Trabalho");
        Categoria status3=new Categoria("Vida Pessoal");

        categoriaRepository.save(status1);
        categoriaRepository.save(status2);
        categoriaRepository.save(status3);

        return "Dados inseridos com sucesso.";

    }

}
