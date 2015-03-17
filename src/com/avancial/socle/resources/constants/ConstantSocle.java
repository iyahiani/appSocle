package com.avancial.socle.resources.constants;

/**
 * @author bruno
 *
 */
public enum ConstantSocle {
   /**
 * 
 */
   BUNDLE_PATH("com.avancial.app.resources.internationalization.Message"),
   MESSAGE_ERR_TRANSLATION_NOT_FOUND("erreur_traduction_non_trouve"),
   NAVIGATION_ACCUEIL("/pages/public/accueil?faces-redirect=true"),
   NAVIGATION_LOGIN("/pages/public/login?faces-redirect=true"),
   NAVIGATION_MDPOUBLIE("/pages/public/mdpoublie?faces-redirect=true"),
   NAVIGATION_ROLE("/pages/private/role?faces-redirect=true"),
   NAVIGATION_USER("/pages/private/user?faces-redirect=true"),
   PAGE_ID_MESSAGES("idPageMessages"),
   DIALOG_ADD_MESSAGES("message_add"),
   DIALOG_UPD_MESSAGES("message_upd"),
   DIALOG_DEL_MESSAGES("message_del");

   private String constant = "";

   private ConstantSocle(String pconstant) {
      this.constant = pconstant;
   }

   @Override
   public String toString() {
      return this.constant;
   }

}
