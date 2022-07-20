/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import helper.SessionHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Role;


/**
 *
 * @author elouf
 */
public class RoleDAO {
    
   public  Role findById(long id){
       EntityManager entityManager = SessionHelper.getEntityManager();
        return entityManager.find(Role.class, id);
    }
   
   void create( Role r){
        EntityManager entityManager = SessionHelper.getEntityManager();
     
       entityManager.persist(r);
   }
   
   
   void  update (Role rr){
       EntityManager entityManager = SessionHelper.getEntityManager();
        
        rr.setDescription("cc");
   }
   
       public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        
      Role role;
        
            EntityTransaction trans =null;
            try {
                trans=entityManager.getTransaction();
                trans.begin();
                Role r =new Role("aa","bb");
                Role rr=entityManager.merge(role);
                  create(r);
                  
                  Role e = findById(1);
                  
                trans.commit();

              } catch(Exception e){
                  if( trans!=null) trans.rollback();
               }


        
        // Role findById(int id);

        System.out.println("Hello World!");

        entityManager.close();
    }
    
    
}
