/**
 * 
 */
package com.avancial.socle.data.controller.dao;

import java.util.List;

import javax.persistence.EntityManager;

/**
 * @author bruno.legloahec
 *
 */
public abstract class AbstractDao {
   private EntityManager entityManager;

   /**
    * Constructeur
    */
   public AbstractDao() {
      this.setEntityManager(AbstractEntityManager.getInstance().getEntityManager());
   }

   public abstract List<?> getAll();

   protected EntityManager getEntityManager() {
      return this.entityManager;
   }

   protected void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
   }
}
