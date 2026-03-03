package com.boot_demo1;

import com.boot_demo1.entites.Department;
import com.boot_demo1.entites.Employee;
import com.boot_demo1.entites.SchoolClass;
import com.boot_demo1.entites.Student;
import com.boot_demo1.persistance.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, With you for learnning one to many relationships!");
        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "create"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Department department = new Department();
            department.setDepartment_name("Software Engineering");

            Employee employee = new Employee();
            employee.setFirstName("Ahmed");
            employee.setLastName("Raft");

            Employee employee2 = new Employee();
            employee2.setFirstName("Ahmed");
            employee2.setLastName("Reda");


            employee2.setDepartment(department);
            employee.setDepartment(department);

            department.setEmployees(List.of(employee, employee2));
            em.persist(department);

            em.getTransaction().commit();

        }finally{
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            emf.close();
            em.close();
        }






















//        try{
//            em.getTransaction().begin();
//            SchoolClass schoolClass = new SchoolClass();
//            schoolClass.setName("School Class1");
//
//
//            Student student1 = new Student();
//            student1.setName("Ahmed Raft");
//
//            Student student2 = new Student();
//            student2.setName("Ahmed Reda");
//
//            student1.setSchoolClass(schoolClass);
//            student2.setSchoolClass(schoolClass);
//
//           schoolClass.setStudents(List.of(student1, student2));
//
//           em.persist(schoolClass);
//
//
//            em.getTransaction().commit();
//        }finally {
//            if (em.getTransaction().isActive()) {
//                em.getTransaction().rollback();
//            }
//            em.close();
//            emf.close();
//        }

    }
}