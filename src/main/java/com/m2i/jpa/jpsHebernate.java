
package com.m2i.jpa;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class jpsHebernate  {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_jpa");
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("Hello World!");
    }
}