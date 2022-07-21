/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Role;

public class RoleDao {
    public Role findById(long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Role roleFound = entityManager.find(Role.class, id);
        if (roleFound == null) {
            System.out.println("Attention le role avec l'id: " + id + " n'existe pas !");
        }
        return roleFound;
    }
    public void create(Role roleToCreate) {
        // On vérifie les données que l'on reçoit en paramètre
        if (roleToCreate == null) {
            System.out.println("L'objet role ne peut pas être null");
            return;
        }
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On déclare notre transaction avec pour valeur par défaut null
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(roleToCreate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }
        }
    }
    // Différente manière pour l'update :
    // public void update(Long id, String identifiant, String description) {
    // => utiliser l'id en paramètre pour récupérer le role que l'on souhaite modifier
    // puis set les données :
    // ...
    // roleToUpdate.setIdentifiant(identifiant);
    // ...
    // Différente manière pour l'update :
    // public void update(Long id, Role roleData) {
    // => utiliser l'id en paramètre pour récupérer le role que l'on souhaite modifier
    // puis set les données :
    // ...
    // roleToUpdate.copy(roleData); -> on set les données uniquement si elle ne sont pas null
    // ...
    // Différente manière pour l'update :
    // public void update(Role roleData) {
    // => utiliser role.getId(); pour récupérer le role que l'on souhaite modifier
    // puis set les données :
    // ...
    // roleToUpdate.copy(roleData); -> on set les données uniquement si elle ne sont pas null
    // ...
    public void update(Long id, Role roleData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le role qu'on souhaite modifier
        Role roleToUpdate = entityManager.find(Role.class, id);
        // Si le role n'existe pas on ne fait pas d'update
        if (roleToUpdate == null) {
            System.out.println("Le role avec l'id:" + id + " n'existe pas");
            return;
        }
        // on set les données uniquement si elle ne sont pas null
        roleToUpdate.copy(roleData);
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(roleToUpdate);           
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
