package dev.web.mensalidades.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
            if(lj.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity< List<Jogador> > (lj, HttpStatus.OK);
        } catch(Exception e) { 
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/")
    public ResponseEntity<Jogador> createJogador(@RequestBody Jogador jogador) {
        try {
            Jogador j = jog.save(new Jogador(jogador.getNome(), jogador.getEmail(), jogador.getDatanasc()));
            return new ResponseEntity<>(j, HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }    

    @PutMapping("/{cod_jogador}")
    public ResponseEntity<Jogador> updateJogador(@PathVariable("cod_jogador") long cod_jogador, @RequestBody Jogador jogador) {

        Optional<Jogador> data = jog.findById(cod_jogador);

        if (data.isPresent()) {
            Jogador j = data.get();

            if(jogador.getNome() != null && !jogador.getNome().isEmpty()) j.setNome(jogador.getNome());
            if(jogador.getEmail() != null && !jogador.getEmail().isEmpty()) j.setEmail(jogador.getEmail());
            if(jogador.getDatanasc() != null) j.setDatanasc(jogador.getDatanasc());

            return new ResponseEntity<>(jog.save(j), HttpStatus.OK);
        }

        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }    

    @DeleteMapping("/{cod_jogador}")
    public ResponseEntity<Integer> deleteJogador(@PathVariable("cod_jogador") long cod_jogador) {

        try {
            Optional<Jogador> data = jog.findById(cod_jogador); 
            if(data.isPresent()) jog.delete(data.get());
            else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}