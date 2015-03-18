package com.avancial.socle.resources.constants;

/**
 * @author bruno
 *
 */
public enum ConstantSocle {
   /**
 * 
 */
   BUNDLE_PATH("com.avancial.app.resources.internationalization.Message"), MESSAGE_ERR_TRANSLATION_NOT_FOUND("erreur_traduction_non_trouve"), NAVIGATION_ACCUEIL(
         "/pages/public/accueil?faces-redirect=true"), NAVIGATION_LOGIN("/pages/public/login?faces-redirect=true"), NAVIGATION_MDPOUBLIE("/pages/public/mdpoublie?faces-redirect=true"), NAVIGATION_ROLE(
         "/pages/private/role?faces-redirect=true"), NAVIGATION_USER("/pages/private/user?faces-redirect=true"),
   /**
    * ID du statut des messages g�n�raux � l'IHM
    */
   PAGE_ID_MESSAGES("idPageMessages"),
   /**
    * ID du statut des messages pour l'ajout des donn�es
    */
   DIALOG_ADD_MESSAGES("message_add"),
   /**
    * ID du statut des messages pour l'update des donn�es
    */
   DIALOG_UPD_MESSAGES("message_upd"),
   /**
    * ID du statut des messages pour la suppression des donn�es
    */
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
