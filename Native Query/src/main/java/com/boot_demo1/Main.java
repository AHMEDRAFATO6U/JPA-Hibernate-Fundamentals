package com.boot_demo1;

import com.boot_demo1.entities.Student;
import com.boot_demo1.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

//             SELECT s FROM Student s  ->> JPQL
            String sql = " SELECT * FROM student";
//
//            Query q = em.createNativeQuery(sql, Student.class);
//
//            q.getResultList().forEach(
//                    s -> System.out.println(s)
//            );

//            String sql = "SELECT s FROM DistinctStudent s";
//            TypedQuery<DistinctStudent> q = em.createQuery(sql, DistinctStudent.class);
//            q.getResultList().forEach(s -> System.out.println(s));

            StoredProcedureQuery q = em.createStoredProcedureQuery("GetStudents", Student.class)
                    .registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN)
                    .setParameter("id", 2);

            q.getResultList().forEach(s -> System.out.println(s));

            em.getTransaction().commit(); // end of transaction
        } finally {
            em.close();
        }
    }
    }
