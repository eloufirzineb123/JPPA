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
import model.Adresse;
import model.Role;
import model.Utilisateur;

/**
 *
 * @author elouf
 */
public class AddressDao {
    
    public List<Adresse> findAll(){
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query findAllQuery = entityManager.createQuery("select c from Adresse c");
        return findAllQuery.getResultList();
    }
    
    public Adresse findById(Long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Adresse adresseFounded = entityManager.find(Adresse.class, id);

        if (adresseFounded == null) {
            System.out.println("Attention le adresse avec l'id: " + id + " n'existe pas !");
        }

        return adresseFounded;
    }
    
    public List<Adresse> findByUtilisateur(Utilisateur user) {
        
        if (user == null || user.getIdUtilisateur() < 1) {
            System.out.println("L'utilisateur n'existe pas");
            return null;
        }

        EntityManager entityManager = SessionHelper.getEntityManager();
        Query query = entityManager.createQuery("select a from Adresse a where a.utilisateur = ?1");
        query.setParameter(1, user);
        
        return query.getResultList();
    }

    public void create(Adresse adresseToCreate) {
        // On vérifie les données que l'on reçoit en paramètre
        if (adresseToCreate == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;
        }

        EntityManager entityManager = SessionHelper.getEntityManager();

        // On déclare notre transaction avec pour valeur par défaut null
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(adresseToCreate);

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
    // public void update(Long id, String rue, Integer codePostal, String ville, ......) {
    // => utiliser l'id en paramètre pour récupérer le adresse que l'on souhaite modifier
    // puis set les données :
    // ...
    // adresseToUpdate.setRue(rue);    
    // ...

    // Différente manière pour l'update :
    // public void update(Long id, Adresse adresseData) {
    // => utiliser l'id en paramètre pour récupérer le adresse que l'on souhaite modifier
    // puis set les données :
    // ...
    // adresseToUpdate.copy(adresseData); -> on set les données uniquement si elle ne sont pas null
    // ...

    // Différente manière pour l'update :
    // public void update(Adresse adresseData) {
    // => utiliser adresse.getId(); pour récupérer le adresse que l'on souhaite modifier
    // puis set les données :
    // ...
    // adresseToUpdate.copy(adresseData); -> on set les données uniquement si elle ne sont pas null
    // ...

    public void update(Long id, Adresse adresseData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le adresse qu'on souhaite modifier
        Adresse adresseToUpdate = entityManager.find(Adresse.class, id);

        // Si le adresse n'existe pas on ne fait pas d'update
        if (adresseToUpdate == null) {
            System.out.println("Le adresse avec l'id:" + id + " n'existe pas");
            return;
        }

        // on set les données uniquement si elle ne sont pas null
        adresseToUpdate.copy(adresseData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(adresseToUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
