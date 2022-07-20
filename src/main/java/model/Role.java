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

/**
 *
 * @author elouf
 */
@Entity
@Table(name="roles")
public class Role{
    
    @Id
    @Column(
            name="id_role",
            length = 20)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    public Role( String description, String identifiant) {
        this.description = description;
        this.identifiant = identifiant;
    }
    
    @Column(columnDefinition = "text")
    private String description;
    
    @Column(length = 20)
    private String identifiant;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", description=" + description + ", identifiant=" + identifiant + '}';
    }
    
    
    
}
