package com.boot_demo1;

import com.boot_demo1.dto.CountedEnrollmentForStudent;
import com.boot_demo1.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, in Hibernate Joins and Inner Queries!");
        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();


//            String jpql = """
//                    SELECT s, e FROM Student s INNER JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s, Enrollment e WHERE s.id = e.student.id
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s, Enrollment e WHERE s = e.student
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s LEFT JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT s, e FROM Student s RIGHT JOIN s.enrollments e
//                    """;

//            String jpql = """
//                    SELECT NEW org.example.dto.EnrolledStudent(s, e) FROM Student s RIGHT JOIN s.enrollments e
//                    """;


//            String jpql = """
//                    SELECT s FROM Student s WHERE
//                        (SELECT COUNT(e) FROM Enrollment e WHERE e.student.id = s.id) > 1
//                    """;

//            String jpql =
//                    SELECT NEW com.boot_demo1.dto.CountedEnrollmentForStudent
//                    (s, (SELECT count(e) FROM Enrollment e WHERE e.student = s) )
//                    FROM Student s
//                    """;
//            TypedQuery<CountedEnrollmentForStudent> q = em.createQuery(jpql, CountedEnrollmentForStudent.class);
//            q.getResultList().forEach(o -> System.out.println(o.s() + " " + o.count()));


//            TypedQuery<EnrolledStudent> q = em.createQuery(jpql, EnrolledStudent.class);
//            q.getResultList().forEach(o -> System.out.println(o.student() + " " + o.enrollment()));

//            TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);
//            q.getResultList().forEach(o -> System.out.println(o[0] + " " + o[1]));

            /**
             [s1, e1],
             [s1, e2],
             ...
             **/
            em.getTransaction().commit();
        }finally{
            if(em.getTransaction().isActive()){
                em.getTransaction().commit();
                em.close();
            }
        }

    }
}