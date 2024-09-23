package dev.web.mensalidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.web.mensalidades.model.Pagamento;


public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{

}