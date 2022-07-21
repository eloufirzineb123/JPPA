/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Role;

public class DoaHebernate {

    public static void main(String[] args) {
        RoleDao roleDao = new RoleDao();

        // Select role
        //Role roleAdmin = roleDao.findById(1);
        //System.out.println("Role with id 1 : " + roleAdmin.getDescription());
        //System.out.println("A role that doesn't exist : " + roleDao.findById(1000L));       
        // Create a new role
       Role role = new Role();
        role.setIdentifiant("Prestataire");
        role.setDescription("Le rôle prestataire");
        
        roleDao.create(role);
        
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
//     
    }
}
