/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    
     @Id
    @Column(name = "id_utilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;
     
     @Column( columnDefinition = "TINYINT(1)")
     private Boolean actif;
     
     
      @Column( length = 100)
     private String civilite;
      
     @CreationTimestamp
     @Temporal(TemporalType.TIMESTAMP)
      @Column(name = "date_creation" ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
     private Date datecreation;
     
   
     
     
     @UpdateTimestamp
     @Column(name = "date_modification",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP" )
    @Temporal(TemporalType.TIMESTAMP)
     private Date datemodification;
     
     @Column(name = "date_naissance" ,columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
     @Temporal(TemporalType.TIMESTAMP)
     
     
     private Date datenaissance;
     
     
      @Column( length = 100)
     private String identifiant;
     
     @Column( columnDefinition = "TINYINT(1)")
     private  Boolean marquerEffacer;
     
     
      @Column( length = 100)
     private String modPass;
      
      
       @Column( length = 100)
     private String prenon;
       
       
        @ManyToOne 
        @JoinColumn( name="id_Role" )
        private Role role;
        
        @OneToMany(targetEntity=Adresse.class, mappedBy="utilisa", orphanRemoval = true, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE }) 
         private List<Adresse> adre ;
        
        
        
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Role getRole() {
        return role;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public void setDatemodification(Date datemodification) {
        this.datemodification = datemodification;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public void setMarquerEffacer(Boolean marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
    }

    public void setModPass(String modPass) {
        this.modPass = modPass;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenon(String prenon) {
        this.prenon = prenon;
    }
      
     @Column( length = 100)
     private String nom;

    public Boolean getActif() {
        return actif;
    }

    public String getCivilite() {
        return civilite;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public Date getDatemodification() {
        return datemodification;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public Boolean getMarquerEffacer() {
        return marquerEffacer;
    }

    public String getModPass() {
        return modPass;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenon() {
        return prenon;
    }

  
  

    public Utilisateur() {
    }

    public void copy(Utilisateur rData) {
        
         if (rData.getIdentifiant() != null) {
            this.setIdentifiant(rData.getIdentifiant());
        }

        if (rData.getActif() != null) {
            this.setActif(rData.getActif());
        }
        
         if (rData.getCivilite() != null) {
            this.setCivilite(rData.getCivilite());
        }
         
          if (rData.getDatenaissance() != null) {
            this.setDatenaissance(rData.getDatenaissance());
        }
          
           if (rData.getPrenon() != null) {
            this.setPrenon(rData.getPrenon());
        }
           
              if (rData.getNom() != null) {
            this.setNom(rData.getNom());
        }
              
               if (rData.getModPass() != null) {
            this.setModPass(rData.getModPass());
        }
               
           if (rData.getModPass() != null) {
            this.setModPass(rData.getModPass());
        }
         
           if (rData.getMarquerEffacer() != null) {
            this.setMarquerEffacer(rData.getMarquerEffacer());
        }
         
             if (rData.getRole() != null) {
            this.setRole(rData.getRole());
        }
  
        
         
        
    }

    public Utilisateur(Boolean actif, String civilite, Date datenaissance, String identifiant, Boolean marquerEffacer, String modPass, String prenon, Role role, String nom) {
        this.actif = actif;
        this.civilite = civilite;
        this.datenaissance = datenaissance;
        this.identifiant = identifiant;
        this.marquerEffacer = marquerEffacer;
        this.modPass = modPass;
        this.prenon = prenon;
        this.role = role;
        this.nom = nom;
    }

    public void setRole(Role role) {
        this.role = role;
    }
     
     
    
     
     
     
     
     
     
     
     
    
}
