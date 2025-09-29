package br.com.bibliotecajogos.bibliotecajogos.service;

import br.com.bibliotecajogos.bibliotecajogos.entities.Jogo;
import br.com.bibliotecajogos.bibliotecajogos.repositories.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    private final JogoRepository repository;

    @Autowired
    public JogoService(JogoRepository repository) {
        this.repository = repository;
    }

    public List<Jogo> listarTodos(String sortBy) {
        return repository.findAll(Sort.by(sortBy));
    }

    public Jogo inserir(Jogo jogo) {
        return repository.save(jogo);
    }

    public Jogo buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    public List<Jogo> pesquisar(String termo, String tipoPesquisa) {
        return switch (tipoPesquisa) {
            case "titulo" -> repository.findByTituloContainingIgnoreCase(termo);
            case "autor" -> repository.findByAutorContainingIgnoreCase(termo);
            case "genero" -> repository.findByGeneroContainingIgnoreCase(termo);
            default -> List.of();
        };
    }
}
