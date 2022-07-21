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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author elouf
 */
@Entity
@Table(name = "adresses")
public class Adresse {
    
    @Id
    @Column(name = "id_adresse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column( length = 100, name ="code_postal")
    private String codePostal;
    
    @Column( length = 100)
    private String pays;
    
    @Column( columnDefinition = "TINYINT(1)")
    private Boolean principale;

    public Adresse(String codePostal, String pays, Boolean principale, String rue, String ville, Utilisateur utilisa) {
        this.codePostal = codePostal;
        this.pays = pays;
        this.principale = principale;
        this.rue = rue;
        this.ville = ville;
        this.utilisa = utilisa;
    }

    public Adresse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Utilisateur getUtilisa() {
        return utilisa;
    }

    public void setUtilisa(Utilisateur utilisa) {
        this.utilisa = utilisa;
    }
    
    @Column( length = 100)
    private String rue;
    
    @Column( length = 100)
    private String ville;
    
     @ManyToOne 
     @JoinColumn( name="id_utilisateur" )
     private Utilisateur utilisa;

    @Override
    public String toString() {
        return "Adresse{" + "id=" + id + ", codePostal=" + codePostal + ", pays=" + pays + ", principale=" + principale + ", rue=" + rue + ", ville=" + ville + ", utilisa=" + utilisa + '}';
    }
     
     
     
     
}
