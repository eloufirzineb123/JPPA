/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import helper.SessionHelper;
import javax.persistence.EntityManager;

/**
 *
 * @author elouf
 */
public class MainRole {
      public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();

        System.out.println("Hello World!");

        entityManager.close();
    }
}
