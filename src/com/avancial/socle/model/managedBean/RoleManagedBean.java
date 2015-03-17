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

import org.primefaces.context.RequestContext;

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
   private static final long serialVersionUID = 1L;
   private List<RoleDataBean> roles;
   private String nomTechnique;
   private String libelle;
   @Inject
   private RoleDataBean roleSelected;

   /**
    * Constructeur
    */
   public RoleManagedBean() {
      this.roles = new ArrayList<>();
      this.reload();

   }

   public void reload() {
      this.roles.clear();
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
         FacesContext.getCurrentInstance().addMessage(ConstantSocle.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Le rôle a été créé."));
         RequestContext.getCurrentInstance().update(":dataTable");
      } catch (Exception e) {
         FacesContext.getCurrentInstance().addMessage(ConstantSocle.DIALOG_ADD_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", "Enregistrement non sauvé"));
      }

      return null;
   }

   public String updateRole() {
      if (null != this.roleSelected) {
         RoleDao dao = new RoleDao();
         try {
            dao.update(this.roleSelected);
            FacesContext.getCurrentInstance().addMessage(ConstantSocle.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement modifié"));
         } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(ConstantSocle.DIALOG_UPD_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", "Enregistrement non modifié"));
         }
      }
      return null;
   }

   public String deleteRole() {
      if (null != this.roleSelected) {
         RoleDao dao = new RoleDao();
         try {
            dao.delete(this.roleSelected);
            FacesContext.getCurrentInstance().addMessage(ConstantSocle.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement supprimé"));
         } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(ConstantSocle.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", "Enregistrement non effacé"));
         }
      }
      return null;
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
