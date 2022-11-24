package br.edu.ifam.dra.taskmanager.backendapp.repository;


import br.edu.ifam.dra.taskmanager.backendapp.model.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

    Optional<Tarefa> findByTituloContaining(String titulo);
}
