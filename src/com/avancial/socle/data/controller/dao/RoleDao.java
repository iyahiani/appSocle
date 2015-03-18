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

   public void save(RoleDataBean bean) throws Exception {
      try {
         this.getEntityManager().getTransaction().begin();
         this.getEntityManager().persist(bean);
         this.getEntityManager().flush();
         this.getEntityManager().getTransaction().commit();
      } catch (Exception e) {
         this.getEntityManager().getTransaction().rollback();
         StringBuffer buffer = new StringBuffer();
         System.out.println("--------------------------------------------");
         Throwable t = e.getCause();

         buffer.append(t.getCause().getMessage());
         t = t.getCause();

         System.out.println("plop " + buffer.toString());
         if (buffer.lastIndexOf("Duplicate entry") > -1)
            System.out.println("Found !!!");
         throw e;
      }
   }

   public void delete(RoleDataBean bean) throws Exception {
      try {
         this.getEntityManager().getTransaction().begin();
         this.getEntityManager().remove(bean);
         this.getEntityManager().flush();
         this.getEntityManager().getTransaction().commit();
      } catch (Exception e) {
         this.getEntityManager().getTransaction().rollback();
         throw e;
      }

   }

   public void update(RoleDataBean bean) throws Exception {
      try {
         this.getEntityManager().getTransaction().begin();
         this.getEntityManager().merge(bean);
         this.getEntityManager().flush();
         this.getEntityManager().getTransaction().commit();
      } catch (Exception e) {
         this.getEntityManager().getTransaction().rollback();
         throw e;
      }

   }

}
