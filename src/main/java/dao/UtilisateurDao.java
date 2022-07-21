/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import model.Utilisateur;


public class UtilisateurDao {
    
    public Utilisateur findById(long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Utilisateur roleFound = entityManager.find(Utilisateur.class, id);
        if (roleFound == null) {
            System.out.println("Attention le role avec l'id: " + id + " n'existe pas !");
        }
        return roleFound;
    }
    public void create(Utilisateur roleToCreate) {
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
    
    public List<Utilisateur> findAll(){
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query findAllQuery = entityManager.createQuery("select p from Utilisateur p");
        return findAllQuery.getResultList();
    }
    
    
    public void update(Long id, Utilisateur rData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le role qu'on souhaite modifier
        Utilisateur rToUpdate = entityManager.find(Utilisateur.class, id);
        // Si le role n'existe pas on ne fait pas d'update
        if (rToUpdate == null) {
            System.out.println("Le role avec l'id:" + id + " n'existe pas");
            return;
        }
        // on set les données uniquement si elle ne sont pas null
        rToUpdate.copy(rData);
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(rToUpdate);           
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
}
