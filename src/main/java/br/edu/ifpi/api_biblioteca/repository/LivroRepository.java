package br.edu.ifpi.api_biblioteca.repository;

import br.edu.ifpi.api_biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}