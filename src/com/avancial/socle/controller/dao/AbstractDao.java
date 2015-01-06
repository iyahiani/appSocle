/**
 * 
 */
package com.avancial.socle.controller.dao;

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

   public EntityManager getEntityManager() {
      return this.entityManager;
   }

   public void setEntityManager(EntityManager entityManager) {
      this.entityManager = entityManager;
   }
}
