package com.estacionamento.demo.carro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    private  String nome;
    private String modelo;
    private String cor;

    public Carro(String nome, String modelo, String cor) {
        this.nome = nome;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Carro(CarroRegisterDTO data){
        this.nome = data.nome();
        this.modelo = data.modelo();
        this.cor = data.cor();
    }

    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
