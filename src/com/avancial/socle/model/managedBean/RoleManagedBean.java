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

import com.avancial.socle.data.controller.dao.RoleDao;
import com.avancial.socle.data.model.databean.RoleDataBean;
import com.avancial.socle.resources.constants.ConstantSocle;

/**
 * @author bruno.legloahec
 *
 */
@Named("roleManagedBean")
@ViewScoped
public class RoleManagedBean implements Serializable {
   /**
    * 
    */
   private static final long  serialVersionUID = 1L;
   private List<RoleDataBean> roles;
   private String             nomTechnique;
   private String             libelle;
   @Inject
   private RoleDataBean       roleSelected;

   /**
    * Constructeur
    */
   public RoleManagedBean() {
      this.roles = new ArrayList<>();
      this.roles.addAll(new RoleDao().getAll());

   }

   /**
    * @return
    */
   public String addRole() {
      RoleDataBean roleDataBean = new RoleDataBean();
      roleDataBean.setLabelRole(this.libelle);
      roleDataBean.setTechnicalNameRole(this.nomTechnique);
      RoleDao dao = new RoleDao();

      dao.save(roleDataBean);
      // try {
      // } catch (Exception e) {
      // FacesContext.getCurrentInstance().addMessage(FacesMessage.SEVERITY_ERROR.toString(),
      // new FacesMessage("Plop"));
      // }

      return ConstantSocle.NAVIGATION_ROLE.toString();
   }

   public String updateRole() {

      if (null != this.roleSelected) {
         RoleDao dao = new RoleDao();
         dao.update(this.roleSelected);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement modifié"));
      }

      else
         System.out.println("Aucun rôle sélectionné");
      return ConstantSocle.NAVIGATION_ROLE.toString();
   }

   public String deleteRole() {
      if (null != this.roleSelected) {
         RoleDao dao = new RoleDao();
         dao.delete(this.roleSelected);
      }

      else
         System.out.println("Aucun rôle sélectionné");
      return ConstantSocle.NAVIGATION_ROLE.toString();
   }

   /**
    * @return the roleList
    */
   public List<RoleDataBean> getRoles() {
      return this.roles;
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
    * get value for roleSelected
    * 
    * @return the roleSelected
    */
   public RoleDataBean getRoleSelected() {

      return this.roleSelected;
   }

   /**
    * sets value for roleSelected
    * 
    * @param roleSelected
    *           the roleSelected to set
    */
   public void setRoleSelected(RoleDataBean roleSelected) {
      if (null != roleSelected) {
         this.roleSelected = roleSelected;
         this.libelle = roleSelected.getLabelRole();
         this.nomTechnique = roleSelected.getTechnicalNameRole();
      }
   }

}
