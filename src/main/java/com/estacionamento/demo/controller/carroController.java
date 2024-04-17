package com.estacionamento.demo.controller;

import com.estacionamento.demo.carro.Carro;
import com.estacionamento.demo.carro.CarroRegisterDTO;
import com.estacionamento.demo.carro.CarroRepository;
import com.estacionamento.demo.carro.CarroUpdateDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carro")
public class carroController {

    @Autowired
    private CarroRepository repository;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id) {
        Carro carro = repository.findById(id).orElse(null);
        if (carro != null) {
            return new ResponseEntity<>(carro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity testeOk(){
        var TesteTudo = repository.findAll();
        System.out.println(" to no get get");
        return ResponseEntity.ok(TesteTudo);

    }

    @PostMapping
    @Transactional
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity salvarUser(@RequestBody CarroRegisterDTO data ){
        System.out.println("chegou algo aqui no post");
        Carro carro = new Carro(data);
        repository.save(carro);
        return ResponseEntity.ok(data);
    }

    @PutMapping
    @Transactional
    public ResponseEntity Atualizar(@RequestBody CarroUpdateDTO data){
        Optional<Carro> carro = repository.findById(data.id());
        if(carro.isPresent()){
           Carro carro1 = carro.get();
           carro1.setNome(data.nome()) ;
           carro1.setModelo(data.modelo());
           carro1.setCor(data.cor());
           return ResponseEntity.ok(carro1);
        }
        else {
            throw new EntityNotFoundException();

        }
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity deletarCarro(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }









}
