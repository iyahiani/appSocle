package com.avancial.socle.controller.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.avancial.socle.model.bean.UtilisateurBean;

/**
 * Classe DAO pour l'objet métier Utilisateur
 * 
 * @author guillaume.bouziou
 * 
 */
public class UtilisateurDao {

	private EntityManager entityManager;

	/**
	 * Constructor
	 */
	public UtilisateurDao() {
		entityManager = AbstractEntityManager.getInstance().getEntityManager();
	}

	
	

	/**
	 * Retourne un UserBean à partir du login
	 * 
	 * @param login
	 * @return l'utilisateur ayant comme login le parametre
	 */
	public UtilisateurBean getUserByLogin(String login) {

		Query requete = entityManager.createQuery("SELECT user FROM UtilisateurBean user WHERE user.loginUser = :login");
		requete.setParameter("login", login);

		return (UtilisateurBean) requete.getSingleResult();
	}
}
