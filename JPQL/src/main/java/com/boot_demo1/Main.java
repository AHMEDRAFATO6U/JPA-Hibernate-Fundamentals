package com.boot_demo1;

import com.boot_demo1.entities.Product;
import com.boot_demo1.persistence.CustomPersistenceUnitInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, in Jpql demo!");

        String puName = "pu-name";

        Map<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto", "none"); // create, none, update


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new CustomPersistenceUnitInfo(puName), props);

        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();



//          String jpql = "SELECT  p FROM Product p";
//           String jpql = "SELECT  p FROM Product p where p.price >600";
//            String jpql = "select p from Product p where p.price > : price AND p.name LIKE :name";
//            TypedQuery<Product> q = em.createQuery(jpql, Product.class);
//            q.setParameter("price" ,600);
//            q.setParameter("name" ,"%l%");
//            List<Product> products = q.getResultList();
//            for(Product p : products){
//                System.out.println(p);
//            }




//            String jpql = "SELECT AVG(p.price) FROM Product p"; // AVG, SUM, MIN, MAX ....
//
//            TypedQuery<Double> q = em.createQuery(jpql, Double.class);
//
//            Double avg = q.getSingleResult();
//
//            System.out.println(avg);



//            String jpql = "SELECT COUNT(p) FROM Product p"; // AVG, SUM, MIN, MAX ....
//
//            TypedQuery<Long> q = em.createQuery(jpql, Long.class);
//
//            Long avg = q.getSingleResult();
//
//            System.out.println(avg);



            String jpql = """
                    SELECT p.name, AVG(p.price)
                    FROM Product p GROUP BY p.name
                    """;

            TypedQuery<Object[]> q = em.createQuery(jpql, Object[].class);

            q.getResultList().forEach(objects -> {
                System.out.println(objects[0] + " " + objects[1]);
            });




            em.getTransaction().commit();
        }finally{
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
                em.close();
            }
        }











    }
}