package com.estacionamento.demo.carro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class arrumaBanco {

    public static void main(String[] args) {


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("estacionamento");

        EntityManager em = emf.createEntityManager();

        Carro carro = new Carro("fusca", "VW", "azul");


        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
        em.close();


    }}
