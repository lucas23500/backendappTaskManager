package br.edu.ifam.dra.taskmanager.backendapp.repository;


import br.edu.ifam.dra.taskmanager.backendapp.model.Prioridade;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrioridadeRepository extends CrudRepository<Prioridade, Long> {

    Optional<Prioridade> findByTituloContaining(String titulo);
}
