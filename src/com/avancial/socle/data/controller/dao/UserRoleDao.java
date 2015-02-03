package com.avancial.socle.data.controller.dao;

import java.util.List;

import javax.persistence.Query;

import com.avancial.socle.data.model.databean.UserRoleDataBean;

/**
 * Classe DAO pour l'objet métier UserRole
 * 
 * @author bruno.legloahec
 * 
 */
public class UserRoleDao extends AbstractDao {

   @SuppressWarnings("unchecked")
   @Override
   public List<UserRoleDataBean> getAll() {

      String sql = "From UserRoleDataBean";
      Query requete = this.getEntityManager().createQuery(sql);
      return requete.getResultList();
   }

   public void save(UserRoleDataBean bean) {
      this.getEntityManager().getTransaction().begin();
      this.getEntityManager().persist(bean);
      this.getEntityManager().flush();
      this.getEntityManager().getTransaction().commit();
   }

}
