package com.boot_demo1;

import com.boot_demo1.entites.Employee;
import com.boot_demo1.entites.FullTimeEmployee;
import com.boot_demo1.entites.PartTimeEmployee;
import com.boot_demo1.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, in Hibernate Entity Inheritance example!");



        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
            fullTimeEmployee.setFirstName("ahmed");
            fullTimeEmployee.setLastName("raft");
            fullTimeEmployee.setSalary(12000.0);

            PartTimeEmployee partTimeEmployee = new PartTimeEmployee();
            partTimeEmployee.setFirstName("ahmed");
            partTimeEmployee.setLastName("reda");
            partTimeEmployee.setHours(35.0);

            em.persist(fullTimeEmployee);
            em.persist(partTimeEmployee);

            List<Employee> list =
                    em.createQuery("from Employee", Employee.class)
                            .getResultList();

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();

        } finally {
            em.close();
        }
}
    }