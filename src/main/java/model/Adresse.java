/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adresses")
public class Adresse {

    @Id
    @Column(name = "id_adresse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdresse;

    @JoinColumn(name = "id_utilisateur", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Utilisateur utilisateur;

    @Column(name = "rue", length = 100)
    private String rue;

    @Column(name = "code_postal", length = 100)
    private String codePostal;

    @Column(name = "ville", length = 100)
    private String ville;

    @Column(name = "pays", length = 100)
    private String pays;

    @Column(name = "principale", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean principale;

    public Adresse() {

    }

    public Adresse(Long idAdresse, Utilisateur utilisateur, String rue, String codePostal, String ville, String pays, Boolean principale) {
        this.idAdresse = idAdresse;
        this.utilisateur = utilisateur;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.principale = principale;
    }

    public Adresse(Utilisateur utilisateur, String rue, String codePostal, String ville, String pays, Boolean principale) {
        this.utilisateur = utilisateur;
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
        this.pays = pays;
        this.principale = principale;
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Utilisateur getIdUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getFullAdresse() {
        return String.format("%s, %s, %s, %s", rue, codePostal, ville, pays);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adresse)) return false;
        Adresse adresse = (Adresse) o;
        return Objects.equals(idAdresse, adresse.idAdresse) &&
                Objects.equals(utilisateur, adresse.utilisateur) &&
                Objects.equals(rue, adresse.rue) &&
                Objects.equals(codePostal, adresse.codePostal) &&
                Objects.equals(ville, adresse.ville) &&
                Objects.equals(pays, adresse.pays) &&
                Objects.equals(principale, adresse.principale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdresse, utilisateur, rue, codePostal, ville, pays, principale);
    }

    @Override
    public String toString() {
        return "AdresseDao{" +
                "idAdresse=" + idAdresse +
                ", utilisateur=" + utilisateur +
                ", rue='" + rue + '\'' +
                ", codePostal=" + codePostal +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", principale=" + principale +
                '}';
    }
    
    public void copy(Adresse data) {

        if (data.getRue() != null) {
            this.rue = data.getRue();
        }

        if (data.getCodePostal() != null) {
            this.codePostal = data.getCodePostal();
        }

        if (data.getVille() != null) {
            this.ville = data.getVille();
        }

        if (data.getPays() != null) {
            this.pays = data.getPays();
        }

        if (data.isPrincipale() != null) {
            this.principale = data.isPrincipale();
        }
    }

}