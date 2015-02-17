/**
 * 
 */
package com.avancial.socle.model.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.UserRoleDao;
import com.avancial.socle.data.model.databean.UserRoleDataBean;
import com.avancial.socle.resources.constants.ConstantSocle;

/**
 * @author bruno.legloahec
 *
 */
@Named("userRoleManagedBean")
@ViewScoped
public class UserRoleManagedBean implements Serializable {
   /**
    * 
    */
   private static final long      serialVersionUID = 1L;
   private List<UserRoleDataBean> userRoles;
   private String                 nomTechnique;
   private String                 libelle;
   @Inject
   private UserRoleDataBean       userRoleSelected;

   /**
    * Constructeur
    */
   public UserRoleManagedBean() {
      this.userRoles = new ArrayList<>();
      this.userRoles.addAll(new UserRoleDao().getAll());

   }

   /**
    * @return
    */
   public String addUserRole() {
      UserRoleDataBean userRoleDataBean = new UserRoleDataBean();
      userRoleDataBean.setLabelUserRole(this.libelle);
      userRoleDataBean.setTechnicalNameUserRole(this.nomTechnique);
      UserRoleDao dao = new UserRoleDao();

      dao.save(userRoleDataBean);
      // try {
      // } catch (Exception e) {
      // FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),
      // new FacesMessage("Plop"));
      // }

      return ConstantSocle.NAVIGATION_USER_ROLE.toString();
   }

   public String updateUserRole() {

      if (null != this.userRoleSelected) {
         UserRoleDao dao = new UserRoleDao();
         dao.update(this.userRoleSelected);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement modifié"));
      }

      else
         System.out.println("Aucun rôle sélectionné");
      return ConstantSocle.NAVIGATION_USER_ROLE.toString();
   }

   public String deleteUserRole() {
      if (null != this.userRoleSelected) {
         UserRoleDao dao = new UserRoleDao();
         dao.delete(this.userRoleSelected);
      }

      else
         System.out.println("Aucun rôle sélectionné");
      return ConstantSocle.NAVIGATION_USER_ROLE.toString();
   }

   /**
    * @return the userRoleList
    */
   public List<UserRoleDataBean> getUserRoles() {
      return this.userRoles;
   }

   /**
    * @return the nomtechnique
    */
   public String getNomTechnique() {
      return this.nomTechnique;
   }

   /**
    * @param nomtechnique
    *           the nomtechnique to set
    */
   public void setNomTechnique(String nomtechnique) {
      this.nomTechnique = nomtechnique;
   }

   /**
    * @return the libelle
    */
   public String getLibelle() {
      return this.libelle;
   }

   /**
    * @param libelle
    *           the libelle to set
    */
   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   /**
    * get value for userRoleSelected
    * 
    * @return the userRoleSelected
    */
   public UserRoleDataBean getUserRoleSelected() {

      return this.userRoleSelected;
   }

   /**
    * sets value for userRoleSelected
    * 
    * @param userRoleSelected
    *           the userRoleSelected to set
    */
   public void setUserRoleSelected(UserRoleDataBean userRoleSelected) {
      if (null != userRoleSelected) {
         this.userRoleSelected = userRoleSelected;
         this.libelle = userRoleSelected.getLabelUserRole();
         this.nomTechnique = userRoleSelected.getTechnicalNameUserRole();
      }

   }

   public void valorise(UserRoleDataBean bean) {

      this.userRoleSelected = bean;
   }
}
