package br.com.bibliotecajogos.bibliotecajogos.repositories;

import br.com.bibliotecajogos.bibliotecajogos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
