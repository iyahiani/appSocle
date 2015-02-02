package com.avancial.socle.data.controller.dao;

import java.util.ArrayList;

import javax.persistence.Query;

/**
 * Classe DAO pour l'objet métier UserRole
 * 
 * @author bruno.legloahec
 * 
 */
public class UserRoleDao extends AbstractDao {

   @Override
   public ArrayList<UserRoleDao> getAll() {

      String sql = "From UserRoleDataBean";
      Query requete = this.getEntityManager().createQuery(sql);
      return (ArrayList<UserRoleDao>) requete.getResultList();
   }
}
