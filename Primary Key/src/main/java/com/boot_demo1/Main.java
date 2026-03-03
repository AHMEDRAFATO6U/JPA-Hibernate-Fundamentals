package com.boot_demo1;

import com.boot_demo1.entities.Employee;
import com.boot_demo1.entities.Product;
import com.boot_demo1.entities.Student;
import com.boot_demo1.keys.StudentKey;
import com.boot_demo1.persistance.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "update"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
//            Employee emp = new Employee();
//            emp.setName("Jack");
//            emp.setAddress("cairo_egypt");
//            em.persist(emp);

//            Product p = new Product();
//            p.setName("product1");
//            p.setCode(10L);
//            p.setNumber(1235L);
//            em.persist(p);

            StudentKey id = new StudentKey();
            id.setCode(202205969L);
            id.setNumber(2L);
//            Student student = new Student();
//            student.setId(id);
//            student.setName("Ahmed Raft");
//            em.persist(student);

            Student student = em.find(Student.class ,id);
            System.out.println(student);


        }finally {
            em.getTransaction().commit();
        }


    }
}