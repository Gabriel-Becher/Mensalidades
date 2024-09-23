package dev.web.mensalidades.controller;


import dev.web.mensalidades.model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import dev.web.mensalidades.repository.PagamentoRepository;
import java.util.List;
import org.springframework.http.HttpStatus;

@RestController
public class PagamentoController {
    
    @Autowired
    PagamentoRepository pr;

    @GetMapping("/pagamentos")
    public ResponseEntity<List<Pagamento>> getAllPagamento(){
        List<Pagamento> pagamentos = pr.findAll();
        return new ResponseEntity<>(pagamentos, HttpStatus.OK);
    }

    


}
