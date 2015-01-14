package com.avancial.socle.data.controller.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import com.avancial.socle.data.model.databean.RefDirectoryDataBean;

/**
 * Classe DAO pour l'objet technique RefDirectory
 * 
 * @author bruno
 * 
 */
public class RefDirectoryDao extends AbstractDao {

   /**
    * Retourne un RefDirectoryDataBean à partir du nom technique
    * 
    * @param technicalName
    * 
    * @return l'utilisateur ayant comme login le parametre
    */
   public RefDirectoryDataBean getRefDirectoryByTechnicalName(String technicalName) {

      Query requete = this.getEntityManager().createQuery("SELECT refDirectory FROM RefDirectoryDataBean refDirectory WHERE refDirectory.technicalNameRefDirectory = :technicalName");
      requete.setParameter("technicalName", technicalName);

      return (RefDirectoryDataBean) requete.getSingleResult();

   }

   /**
    * @return une collection de bean
    */
   @Override
   public ArrayList<?> getAll() {
      Query requete = this.getEntityManager().createQuery("From RefDirectoryDataBean");
      return (ArrayList<?>) requete.getResultList();
   }
}
