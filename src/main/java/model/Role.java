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
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "id_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Column(name = "identifiant", length = 50)
    private String identifiant;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Role() {
    }

    public Role(String identifiant, String description) {
        this.identifiant = identifiant;
        this.description = description;
    }

    public Role(Long idRole, String identifiant, String description) {
        this.idRole = idRole;
        this.identifiant = identifiant;
        this.description = description;
    }

    public Role(Long idRole, String identifiant, String description, Integer version) {
        this.idRole = idRole;
        this.identifiant = identifiant;
        this.description = description;
    }
    
    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void copy(Role roleData) {
        if (roleData.getIdentifiant() != null) {
            this.setIdentifiant(roleData.getIdentifiant());
        }

        if (roleData.getDescription() != null) {
            this.setDescription(roleData.getDescription());
        }
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("[idRole=%s, identifiant=%s, description=%s]", idRole, identifiant, description);
    }
}

