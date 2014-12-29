package com.avancial.app.model.managedBean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.avancial.socle.resources.constants.ConstantSocle;

/**
 * Managed Bean de gestion de la page liste utilisateurs public
 * 
 * @author guillaume.bouziou
 * 
 */
@Named("menu")
@SessionScoped
public class MenuManagedBean implements Serializable {

   private static final long serialVersionUID = 1L;

   public String goAccueil() {
      return ConstantSocle.NAVIGATION_ACCUEIL.toString();
   }

   public String goMdpOublie() {
      return ConstantSocle.NAVIGATION_MDPOUBLIE.toString();
   }
}
