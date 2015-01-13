package com.avancial.socle.data.controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.avancial.socle.model.bean.RepertoireBean;

/**
 * Classe DAO pour le Repertoire
 * 
 * @author fabien.cuaz
 *
 */
public class RepertoireDao extends AbstractDao {
   private EntityManager entityManager;

   /**
    * Constructor
    */
   public RepertoireDao() {
      this.entityManager = AbstractEntityManager.getInstance().getEntityManager();
   }

   /**
    * @return Retourne une liste de repertoire
    */
   @SuppressWarnings("unchecked")
   public List<RepertoireBean> getAllRepertoire() {

      Query requete = this.entityManager.createQuery("SELECT r FROM Repertoire r");

      return (List<RepertoireBean>) requete.getSingleResult();
   }
}