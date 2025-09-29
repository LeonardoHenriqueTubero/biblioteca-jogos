package br.com.bibliotecajogos.bibliotecajogos.repositories;

import br.com.bibliotecajogos.bibliotecajogos.entities.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findByTituloContainingIgnoreCase(String titulo);
    List<Jogo> findByAutorContainingIgnoreCase(String autor);
    List<Jogo> findByGeneroContainingIgnoreCase(String genero);
}
