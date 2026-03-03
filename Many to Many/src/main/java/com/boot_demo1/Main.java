package com.boot_demo1;

import com.boot_demo1.entities.Group;
import com.boot_demo1.entities.User;
import com.boot_demo1.persistance.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, in hibernate! many to many relationships example");

        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            User user = new User();
            user.setEmail("user1 email@email.com");
            user.setFirstName("Ahmed");
            user.setLastName("raft");


            User user2 = new User();
            user2.setEmail("user2 email@email.com");
            user2.setFirstName("Ahmed");
            user2.setLastName("reda");

            Group group = new Group();
            group.setName("group1");
            group.setDescription("group1 description");

            Group group2 = new Group();
            group2.setName("group2");
            group2.setDescription("group2 description");

          user.getGroups().add(group);
          user.getGroups().add(group2);

          user2.getGroups().add(group);



            em.persist(user);
            em.persist(user2);





            em.getTransaction().commit();

        }finally{
            em.close();
        }
    }

}