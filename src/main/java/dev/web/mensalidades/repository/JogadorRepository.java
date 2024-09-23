package dev.web.mensalidades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.web.mensalidades.model.Jogador;


public interface JogadorRepository extends JpaRepository<Jogador, Long>{

    public List<Jogador> findAllByNome(String nome);

}
