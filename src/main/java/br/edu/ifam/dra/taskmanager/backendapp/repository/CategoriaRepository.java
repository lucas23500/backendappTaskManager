package br.edu.ifam.dra.taskmanager.backendapp.repository;


import br.edu.ifam.dra.taskmanager.backendapp.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {

    Optional<Categoria> findByTituloContaining(String titulo);
}
