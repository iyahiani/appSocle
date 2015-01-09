package com.avancial.socle.data.controller.dao;

import javax.persistence.Query;

import com.avancial.socle.data.model.databean.UtilisateurBean;

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
   public UtilisateurBean getUserByLogin(String login) {

      Query requete = this.getEntityManager().createQuery("SELECT user FROM UtilisateurBean user WHERE user.loginUser = :login");
      requete.setParameter("login", login);

      return (UtilisateurBean) requete.getSingleResult();

   }
}
