package com.avancial.socle.data.controller.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import com.avancial.socle.data.model.databean.UtilisateurDataBean;

/**
 * Classe DAO pour l'objet métier Utilisateur
 * 
 * @author guillaume.bouziou
 * 
 */
public class UtilisateurDao extends AbstractDao {

   /**
    * Retourne un UserBean à partir du login
    * 
    * @param login
    * @return l'utilisateur ayant comme login le parametre
    */
   public UtilisateurDataBean getUserByLogin(String login) {

      Query requete = this.getEntityManager().createQuery("SELECT user FROM UtilisateurDataBean user WHERE user.loginUser = :login");
      requete.setParameter("login", login);

      return (UtilisateurDataBean) requete.getSingleResult();

   }

   /*
    * (non-Javadoc)
    * 
    * @see com.avancial.socle.data.controller.dao.AbstractDao#getAll()
    */
   @Override
   public ArrayList<?> getAll() {
      // TODO to be implemented later
      return null;
   }
}
