package dev.web.mensalidades.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.web.mensalidades.model.Jogador;
import dev.web.mensalidades.repository.JogadorRepository;

@RestController
public class JogadorController {

    @Autowired
    JogadorRepository jog;

    @GetMapping("/")
    public ResponseEntity < List<Jogador> > getAllJogador(@RequestParam (required = false)String nome) {

        try {
            List<Jogador> lj = null;
            if(nome == null) lj = jog.findAll();
            else lj = jog.findAllByNome(nome);
            return new ResponseEntity< List<Jogador> > (lj, HttpStatus.OK);
        } catch(Exception e) { 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
