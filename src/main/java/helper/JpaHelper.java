/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import javax.persistence.EntityManager;
import model.Adresse;

/**
 *
 * @author elouf
 */
public class JpaHelper {
    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        
         
         Adresse adr= entityManager.find(Adresse.class, 1L);
          System.out.println(adr);
        System.out.println("Hello World!");

        entityManager.close();
    }
}


