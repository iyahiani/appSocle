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

   public void initProperties() {
      this.libelle = "";
      this.nomTechnique = "";
   }

   /**
    * @return
    */
   public String addRole() {
      RoleDataBean roleDataBean = new RoleDataBean();
      roleDataBean.setLabelRole(this.libelle);
      roleDataBean.setTechnicalNameRole(this.nomTechnique);
      RoleDao dao = new RoleDao();

      try {
         dao.save(roleDataBean);
         FacesContext.getCurrentInstance().addMessage("page_messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement sauvegardé"));
      } catch (Exception e) {
         FacesContext.getCurrentInstance().addMessage("page_messages", new FacesMessage(FacesMessage.SEVERITY_FATAL, "message", "Enregistrement non sauvé"));
      }

      return ConstantSocle.NAVIGATION_ROLE.toString();
   }

   public String updateRole() {

      if (null != this.roleSelected) {
         RoleDao dao = new RoleDao();
         try {
            dao.update(this.roleSelected);
            FacesContext.getCurrentInstance().addMessage("page_messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement modifié"));
         } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("page_messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", "Enregistrement non modifié"));
         }
      }

      else
         System.out.println("Aucun rôle sélectionné");
      return ConstantSocle.NAVIGATION_ROLE.toString();
   }

   public String deleteRole() {
      if (null != this.roleSelected) {
         RoleDao dao = new RoleDao();
         try {
            dao.delete(this.roleSelected);
            FacesContext.getCurrentInstance().addMessage("page_messages", new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement supprimé"));
         } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("page_messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", "Enregistrement non effacé"));
         }
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
