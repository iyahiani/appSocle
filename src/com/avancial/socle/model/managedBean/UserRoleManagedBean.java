/**
 * 
 */
package com.avancial.socle.model.managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.avancial.socle.data.controller.dao.UserRoleDao;
import com.avancial.socle.data.model.databean.UserRoleDataBean;
import com.avancial.socle.resources.constants.ConstantSocle;

/**
 * @author bruno.legloahec
 *
 */
@Named("userRoleManagedBean")
@RequestScoped
public class UserRoleManagedBean {
   private List<UserRoleDataBean> userRoles;
   private String nomTechnique = "";
   private String libelle = "";
   private UserRoleDataBean userRoleSelected;

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

   public String deleteUserRole() {
      if (null != this.userRoleSelected)
         System.out.println("deleting role : " + this.userRoleSelected.getTechnicalNameUserRole());
      else
         System.out.println("Aucun rôle séléctionné");
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
      return userRoleSelected;
   }

   /**
    * sets value for userRoleSelected
    * 
    * @param userRoleSelected
    *           the userRoleSelected to set
    */
   public void setUserRoleSelected(UserRoleDataBean userRoleSelected) {
      this.userRoleSelected = userRoleSelected;
   }

}
