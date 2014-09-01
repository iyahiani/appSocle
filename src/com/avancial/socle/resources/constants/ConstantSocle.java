package com.avancial.socle.resources.constants;

/**
 * @author bruno
 *
 */
public enum ConstantSocle {
   /**
 * 
 */
   BUNDLE_PATH("com.app.resources.internationalization.Message"), MESSAGE_ERR_TRANSLATION_NOT_FOUND("erreur_traduction_non_trouve"), NAVIGATION_ACCUEIL("/pages/public/accueil?faces-redirect=true"), NAVIGATION_LOGIN(
         "/pages/public/login?faces-redirect=true")

   ;

   private String constant = "";

   private ConstantSocle(String pconstant) {
      this.constant = pconstant;
   }

   @Override
   public String toString() {
      return this.constant;
   }

}
