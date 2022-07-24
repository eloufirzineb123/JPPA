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
import model.Produit;

/**
 *
 * @author elouf
 */
public class ProduitDao {

    public List<Produit> findAll() {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query findAllQuery = entityManager.createQuery("from Produit ");
        return findAllQuery.getResultList();
    }
    
    
    public List<Produit> findByNom(String name) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query finQuery = entityManager.createQuery("select p from Produit p where p.nom=?1");
       finQuery.setParameter(1, name);
         return  (List<Produit>) finQuery.getResultList();
    }
    
     public List<Produit> findByDescription(String description1) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query finQuery = entityManager.createQuery("select p from Produit p where p.description=?1");
       finQuery.setParameter(1, description1);
         return  (List<Produit>) finQuery.getResultList();
    }
     
       public List<Produit> findByReference(String ref ) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query finQuery = entityManager.createQuery("select p from Produit p where p.reference=?1");
       finQuery.setParameter(1, ref);
         return  (List<Produit>) finQuery.getResultList();
    }
 
     
        public List<Produit> findByPrix(Double prix1) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Query finQuery = entityManager.createQuery("select p from Produit p where p.prix=?1");
       finQuery.setParameter(1, prix1);
         return  (List<Produit>) finQuery.getResultList();
    }
        
         public List<Produit> findByMostQuantity() {
        EntityManager entityManager = SessionHelper.getEntityManager();
       Query finQuery = entityManager.createQuery("select p from Produit p where p.stock =( select max(pp.stock)from Produit pp) ");
        return  (List<Produit>) finQuery.getResultList();
    }
        
           
    

    public Produit findById(Long id) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        Produit pFounded = entityManager.find(Produit.class, id);

        if (pFounded == null) {
            System.out.println("Attention le produit avec l'id: " + id + " n'existe pas !");
        }

        return pFounded;
    }

    public void create(Produit pToCreate) {
        // On vérifie les données que l'on reçoit en paramètre
        if (pToCreate == null) {
            System.out.println("L'objet produit ne peut pas être null");
            return;
        }

        EntityManager entityManager = SessionHelper.getEntityManager();

        // On déclare notre transaction avec pour valeur par défaut null
        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(pToCreate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }
        }
    }

    public void remove(Produit pData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le utilisateur qu'on souhaite modifier
        Produit pToDelete = entityManager.find(Produit.class, pData.getIdProduit());

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.remove(pToDelete);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Produit ppData) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        // On récupère le adresse qu'on souhaite modifier
        Produit ppToUpdate = entityManager.find(Produit.class, id);

        // Si le adresse n'existe pas on ne fait pas d'update
        if (ppToUpdate == null) {
            System.out.println("Le adresse avec l'id:" + id + " n'existe pas");
            return;
        }

        // on set les données uniquement si elle ne sont pas null
        ppToUpdate.copy(ppData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.merge(ppToUpdate);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

}
