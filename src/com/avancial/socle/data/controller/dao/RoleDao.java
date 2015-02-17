package com.avancial.socle.data.controller.dao;

import java.util.List;

import javax.persistence.Query;

import com.avancial.socle.data.model.databean.RoleDataBean;

/**
 * Classe DAO pour l'objet Role
 * 
 * @author bruno.legloahec
 * 
 */
public class RoleDao extends AbstractDao {

   @SuppressWarnings("unchecked")
   @Override
   public List<RoleDataBean> getAll() {

      String sql = "From RoleDataBean";
      Query requete = this.getEntityManager().createQuery(sql);
      return requete.getResultList();
   }

   public void save(RoleDataBean bean) {
      this.getEntityManager().getTransaction().begin();
      this.getEntityManager().persist(bean);
      this.getEntityManager().flush();
      this.getEntityManager().getTransaction().commit();
   }

   public void delete(RoleDataBean bean) {
      this.getEntityManager().getTransaction().begin();
      this.getEntityManager().remove(bean);
      this.getEntityManager().flush();
      this.getEntityManager().getTransaction().commit();
   }

   public void update(RoleDataBean bean) {
      this.getEntityManager().getTransaction().begin();
      this.getEntityManager().merge(bean);
      this.getEntityManager().flush();
      this.getEntityManager().getTransaction().commit();
   }

}