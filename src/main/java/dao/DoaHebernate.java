/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import java.text.DateFormat;

import java.util.Date;

import javax.persistence.EntityManager;
import model.Adresse;
import model.Role;
import model.Utilisateur;

public class DoaHebernate {

    public static void main(String[] args) {
        
   
        
        EntityManager entityManager = SessionHelper.getEntityManager();
        
        UtilisateurDao userDao = new UtilisateurDao();
        RoleDao roleDao = new RoleDao();
       
        AddressDao  adresseDao= new AddressDao();
        
        
        Role role = new Role();
        role.setIdentifiant("Perstataire");
        role.setDescription("Le rôle perstataire");
        
        roleDao.create(role);
        
        Role userRole = roleDao.findById(1L);
        Utilisateur newUser = new Utilisateur("Mme", "Madame Untel", "Untel", "Untel@gmail.com", "passw0rd", new Date(), new Date(), new Date(), userRole);
        
        userDao.create(newUser);
        
        
        newUser.addAddress(new Adresse(newUser, "10 rue de l'insurection", "75000", "Paris", "France", false));
        
        userDao.update(1L, newUser);
        
        //Adresse addressToRemove = newUser.getAdresses().get(newUser.getAdresses().size() - 1);
        //newUser.removeAddress(addressToRemove);
        //userDao.update(newUser.getIdUtilisateur(), newUser);
        
       // userDao.remove(newUser);
        entityManager.close();
       
     /*   
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
        
        
             Adresse adDao =new Adresse("45100", "france", true, "rue aa", "orleans", UtiDao.findById(1L));
             adresseDao.create(adDao);
             
             
              Adresse adDao2 =new Adresse("100", "maroc", false, "rue aa", "orleans", UtiDao.findById(1L));
             adresseDao.create(adDao2);
             
             Adresse adDao3 =new Adresse("20", "maroc",false, "rue 2aa", "rabat", UtiDao.findById(1L));
             adresseDao.create(adDao3);
        
             
             
        
        List<Adresse> add = adresseDao.findAll();
         for( Adresse r: add) {
                System.out.println( "liste des adresses " + r );
            }  
         
        
         
          Utilisateur utii = UtiDao.findById(1L);
           for( Adresse adr : utii.getAdre() ) {
               // System.out.println( "mon adr" + adr );
            }
         
       //  adresseDao.findByUtilisateur(utii);
         
        
        Utilisateur utiPresta = UtiDao.findById(1L);
        
        
//        
        if (utiPresta != null) {
            System.out.println("The utili has been updated updated : " + utiPresta.getNom());
        }
        
        
        List<Utilisateur> resu = UtiDao.findAll();
         for( Utilisateur r: resu) {
                System.out.println( "aaaaaaaaaaaaaaaaaaaaaaaa" + r );
            }
      
        
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

*/
    }

}
