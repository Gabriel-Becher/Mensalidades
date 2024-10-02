package dev.web.mensalidades.controller;


import dev.web.mensalidades.model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dev.web.mensalidades.repository.PagamentoRepository;
import dev.web.mensalidades.repository.JogadorRepository;
import java.util.List;
import java.util.Optional;
import dev.web.mensalidades.model.Jogador;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class PagamentoController {
    
    @Autowired
    PagamentoRepository pr;
    @Autowired
    JogadorRepository jr;

    @GetMapping("/pagamentos")
    public ResponseEntity<List<Pagamento>> getAllPagamento(@RequestParam(name = "nome", required = false) String nome){
        try{

            if (nome!=null) { 
                Optional<Jogador> jogador = jr.findByNome(nome);
                if(jogador.isPresent()){
                    Optional<List<Pagamento>> pagamentos = pr.findByJogador(jogador.get());
                    if (pagamentos.isPresent()) {
                        return new ResponseEntity<>(pagamentos.get(), HttpStatus.OK);
                    } else {
                        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                    }
                }else{
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                }   
            }
            
            List<Pagamento> pagamentos = pr.findAll();
            return new ResponseEntity<>(pagamentos, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> createPagamento(@PathVariable long id,@RequestBody Pagamento pagamento) {
        try{
            Optional<Jogador> jogador = jr.findById(id);
            if(jogador.isPresent()){
                Pagamento pag = new Pagamento(pagamento.getAno(), pagamento.getMes(), pagamento.getValor());
                pag.setJogador(jogador.get());
                return new ResponseEntity<>(pr.save(pag) ,HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pagamentos/{id}")
    public ResponseEntity<Pagamento> putMethodName(@PathVariable long id, @RequestBody Pagamento pagamento) {
        try{
            Optional<Pagamento> data = pr.findById(id);
            if(data.isPresent()){
                Pagamento pag = data.get();
                if(pagamento.getAno() != 0) pag.setAno(pagamento.getAno());
                if(pagamento.getMes() != 0) pag.setMes(pagamento.getMes());
                if(pagamento.getValor() != 0) pag.setValor(pagamento.getValor());
                return new ResponseEntity<>(pr.save(pag), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }


        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/pagamentos/{id}")
    public ResponseEntity<HttpStatus> deletePagamento(@PathVariable long id) {
        try{
            Optional<Pagamento> data = pr.findById(id);
            if(data.isPresent()){
                pr.delete(data.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    


}
