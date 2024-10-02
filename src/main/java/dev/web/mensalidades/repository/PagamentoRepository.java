package dev.web.mensalidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.web.mensalidades.model.Jogador;
import dev.web.mensalidades.model.Pagamento;
import java.util.List;
import java.util.Optional;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
        
        public Optional<List<Pagamento>> findByJogador(Jogador jogador);
}