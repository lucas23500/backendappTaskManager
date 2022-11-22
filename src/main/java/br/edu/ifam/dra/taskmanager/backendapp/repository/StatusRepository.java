package br.edu.ifam.dra.taskmanager.backendapp.repository;


import br.edu.ifam.dra.taskmanager.backendapp.model.Status;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StatusRepository extends CrudRepository<Status, Long> {

    Optional<Status> findByTituloContaining(String titulo);
}
