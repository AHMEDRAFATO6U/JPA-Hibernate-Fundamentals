package com.boot_demo1;

import com.boot_demo1.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            Product p = new Product();
            p.setId(3L);
            p.setName("chicken");

            em.persist(p);


            em.getTransaction().commit();
        }finally{
            em.close();
        }

    }
}