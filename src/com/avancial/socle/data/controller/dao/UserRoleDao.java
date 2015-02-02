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
   public ArrayList<?> getAll() {

      String sql = "From UserRole";
      Query requete = this.getEntityManager().createQuery(sql);
      return (ArrayList<?>) requete.getResultList();
   }
}
