/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author elouf
 */

@Entity
@Table(name = "produits")
public class Produit {
    
    
    @Id
    @Column(name = "id_produit", length = 20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    
     @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean  active;
    
     @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
     @Column( length = 100)
    private String nom;
    
      @Column( columnDefinition = "FLOAT")
    private Double prix;
    
    @Column( length = 100)
    private String reference;
    
    @Column( length = 11)
    private Integer stock;

    public Produit(Boolean active, String description, String nom, Double prix, String reference, Integer stock) {
        this.active = active;
        this.description = description;
        this.nom = nom;
        this.prix = prix;
        this.reference = reference;
        this.stock = stock;
    }

    public Produit() {
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", active=" + active + ", description=" + description + ", nom=" + nom + ", prix=" + prix + ", reference=" + reference + ", stock=" + stock + '}';
    }
    
    
      public void copy(Produit data) {

        if (data.getActive() != null) {
            this.active = data.getActive();
        }

        if (data.getDescription() != null) {
            this.description = data.getDescription();
        }

        if (data.getNom() != null) {
            this.nom = data.getNom();
        }

        if (data.getReference() != null) {
            this.reference = data.getReference();
        }
        
         if (data.getStock() != null) {
            this.stock= data.getStock() ;
        }
        
          if (data.getPrix() != null) {
            this.prix = data.getPrix();
        }
    
    }       
            
    
    
    
    
}
