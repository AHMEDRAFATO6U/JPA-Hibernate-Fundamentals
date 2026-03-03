package com.boot_demo1;

import com.boot_demo1.entities.Pasport;
import com.boot_demo1.entities.Person;
import com.boot_demo1.entities.User;
import com.boot_demo1.persistance.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, In ONE TO ONE RELATIONSHIP IN Hibernate!");


        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();


        try{
            em.getTransaction().begin();

            Person person = new Person();
            person.setName("Ahmed reda");


            Pasport pasport = new Pasport();
            pasport.setName("reda Pasport");

            person.setPasport(pasport);
            em.persist(person);
           em.persist(pasport);
            em.getTransaction().commit();

            User user = new User();
            user.setName("Jack");
            user.setDescription("Jack is backend developer");
            em.persist(user);


            em.getTransaction().commit();

        }finally{
            em.close();
        }

    }
}