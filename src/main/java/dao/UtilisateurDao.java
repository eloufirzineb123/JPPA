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
    public List<Utilisateur> findAll(){
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query findAllQuery = entityManager.createQuery("select c from Utilisateur c");
        return findAllQuery.getResultList();
    }
    
    public Utilisateur findById(Long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Utilisateur utilisateurFounded = entityManager.find(Utilisateur.class, id);

        if (utilisateurFounded == null) {
            System.out.println("Attention le utilisateur avec l'id: " + id + " n'existe pas !");
        }

        return utilisateurFounded;
    }

    public void create(Utilisateur utilisateurToCreate) {
        // On vérifie les données que l'on reçoit en paramètre
        if (utilisateurToCreate == null) {
            System.out.println("L'objet utilisateur ne peut pas être null");
            return;
        }

        EntityManager entityManager = SessionHelper.getEntityManager();

        // On déclare notre transaction avec pour valeur par défaut null
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(utilisateurToCreate);

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
    // public void update(Long id, String civilite, String prenom, String nom, ......) {
    // => utiliser l'id en paramètre pour récupérer le utilisateur que l'on souhaite modifier
    // puis set les données :
    // ...
    // utilisateurToUpdate.setCivilite(civilite);
    // utilisateurToUpdate.setPrenom(prenom);
    // ...

    // Différente manière pour l'update :
    // public void update(Long id, Utilisateur utilisateurData) {
    // => utiliser l'id en paramètre pour récupérer le utilisateur que l'on souhaite modifier
    // puis set les données :
    // ...
    // utilisateurToUpdate.copy(utilisateurData); -> on set les données uniquement si elle ne sont pas null
    // ...

    // Différente manière pour l'update :
    // public void update(Utilisateur utilisateurData) {
    // => utiliser utilisateur.getId(); pour récupérer le utilisateur que l'on souhaite modifier
    // puis set les données :
    // ...
    // utilisateurToUpdate.copy(utilisateurData); -> on set les données uniquement si elle ne sont pas null
    // ...

    public void update(Long id, Utilisateur utilisateurData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le utilisateur qu'on souhaite modifier
        Utilisateur utilisateurToUpdate = entityManager.find(Utilisateur.class, id);

        // Si le utilisateur n'existe pas on ne fait pas d'update
        if (utilisateurToUpdate == null) {
            System.out.println("Le utilisateur avec l'id:" + id + " n'existe pas");
            return;
        }

        // on set les données uniquement si elle ne sont pas null
        utilisateurToUpdate.copy(utilisateurData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(utilisateurToUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    public void remove(Utilisateur utilisateurData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le utilisateur qu'on souhaite modifier
        Utilisateur utilisateurToDelete = entityManager.find(Utilisateur.class, utilisateurData.getIdUtilisateur());


        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(utilisateurToDelete);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
