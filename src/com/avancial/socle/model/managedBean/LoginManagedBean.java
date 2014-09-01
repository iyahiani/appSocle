package com.avancial.socle.model.managedBean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.avancial.socle.controller.dao.UtilisateurDao;
import com.avancial.socle.resources.ContextController;
import com.avancial.socle.resources.constants.ConstantSocle;

/**
 * Managed bean de gestion du login
 * 
 * @author guillaume.bouziou
 * 
 */
@Named("login")
@RequestScoped
public class LoginManagedBean implements Serializable {

   private static final long serialVersionUID = 1L;
   private String login;
   private String password;

   @Inject
   private IhmManagedBean ihmManagedBean;

   // Dao de gestion des utilisateurs
   private UtilisateurDao utilisateurDao = new UtilisateurDao();

   /**
    * Initialisation de l'url courante
    */
   @PostConstruct
   public void init() {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      if (ihmManagedBean.getOriginalURL() == null) {
         ihmManagedBean.setOriginalURL((String) externalContext.getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI));
         if (ihmManagedBean.getOriginalURL() == null) {
            ihmManagedBean.setOriginalURL(((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURL().toString());
         }
      }
   }

   /**
    * Execute la connexion
    * 
    * @throws IOException
    */
   public void login() throws IOException {
      ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
      HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

      try {
         request.login(login, password);
         ihmManagedBean.setCurrentUser(utilisateurDao.getUserByLogin(login));
         String url = ihmManagedBean.getOriginalURL();
         ihmManagedBean.setOriginalURL(null);
         externalContext.redirect(url);
      } catch (ServletException e) {
         ContextController.addErrorMessage("login_connexion_erreur");
      }
   }

   /**
    * Execute la déconnexion et renvoi l'utilisateur sur la page d'accueil
    * 
    * @return l'url de la page d'accueil
    */
   public String logout() {
      try {
         HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
         request.logout();
         ihmManagedBean.setCurrentUser(null);
         ContextController.addInfoMessage("login_deconnexion_ok");
      } catch (ServletException e) {
      }
      return ConstantSocle.NAVIGATION_ACCUEIL.toString();
   }

   /**
    * Gère le bouton annuler pour retourner à la page d'accueil
    * 
    * @return l'url de la page d'accueil
    */
   public String cancel() {
      return ConstantSocle.NAVIGATION_ACCUEIL.toString();
   }

   /**
    * getter password
    * 
    * @return the password
    */
   public String getPassword() {
      return password;
   }

   /**
    * setter the password
    * 
    * @param password
    */
   public void setPassword(String password) {
      this.password = password;
   }

   /**
    * getter login
    * 
    * @return the login
    */
   public String getLogin() {
      return login;
   }

   /**
    * setter the login
    * 
    * @param login
    */
   public void setLogin(String login) {
      this.login = login;
   }

}
