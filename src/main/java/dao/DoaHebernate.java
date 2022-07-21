/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Adresse;
import model.Role;
import model.Utilisateur;

public class DoaHebernate {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();
        Adresse ads=new Adresse();
        // Select role
        //Role roleAdmin = roleDao.findById(1);
        //System.out.println("Role with id 1 : " + roleAdmin.getDescription());
        //System.out.println("A role that doesn't exist : " + roleDao.findById(1000L));       
        // Create a new role
       Role role = new Role();
        Role role2 = new Role();
        role.setIdentifiant("Prestataire");
        role.setDescription("Le rôle prestataire");
        
        roleDao.create(role);
        
        role2.setIdentifiant("Prestataire4");
        role2.setDescription("Le rôle prestataire4");
        
        roleDao.create(role2);
        
           
        
         UtilisateurDao UtiDao = new UtilisateurDao();
        

        // Select role
        //Role roleAdmin = roleDao.findById(1);
        //System.out.println("Role with id 1 : " + roleAdmin.getDescription());
        //System.out.println("A role that doesn't exist : " + roleDao.findById(1000L));       
        // Create a new role
       Utilisateur uti = new Utilisateur();
        
       
        uti.setIdentifiant("Prestataire");
        uti.setActif(true);
        uti.setMarquerEffacer(true);
        uti.setModPass("aaaaa");
        uti.setNom("eloufir");
        uti.setPrenon("zineb");
        uti.setCivilite("zineb");
        uti.setRole(roleDao.findById(1));
        String dDate="28 07 1994";   
        DateFormat df = new SimpleDateFormat("dd mm yyyy");   
        Date cDate;
        try {
            cDate = df.parse(dDate);
            uti.setDatenaissance(cDate);
            UtiDao.create(uti);
            
        } catch (Exception e) {
        }
        
        Utilisateur uData = new Utilisateur();
        uData.setNom("oufir");

        UtiDao.update(1L, uData);
        
        Utilisateur utiPresta = UtiDao.findById(1L);
//        
        if (utiPresta != null) {
            System.out.println("The utili has been updated updated : " + utiPresta.getNom());
        }
        
        
        List<Utilisateur> resu = UtiDao.findAll();
         for( Utilisateur r: resu) {
                System.out.println( "aaaaaaaaaaaaaaaaaaaaaaaa" + r );
            }
        /*
          SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = sdf.parse("12-05-2022");
            
        } catch (ParseException ex) {
           
        }   // garder en memoire (transformation )
         
         */
        
        // Update a role
        Role roleData = new Role();
        roleData.setIdentifiant("pres");
        roleData.setDescription("Le rôle prestataire");
//
        roleDao.update(1L, roleData);
//        
        Role rolePresta = roleDao.findById(1L);
//        
        if (rolePresta != null) {
            System.out.println("The role has been updated updated : " + rolePresta.getDescription());
        }
        
        
        List<Role> results = roleDao.findAll();
         for( Role rr: results) {
                System.out.println( "BBB" + rr );
            }
//     
    }
}
