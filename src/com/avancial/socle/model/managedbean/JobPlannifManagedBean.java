/**
 * 
 */
package com.avancial.socle.model.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.avancial.socle.business.JobPlannifBean;
import com.avancial.socle.data.controller.dao.JobDao;
import com.avancial.socle.exceptions.ASocleException;
import com.avancial.socle.resources.constants.SOCLE_constants;

/**
 * @author bruno.legloahec
 *
 */
@Named("jobPlannifManagedBean")
@ViewScoped
public class JobPlannifManagedBean extends AManageBean {
   /**
    * 
    */
   private static final long    serialVersionUID = 1L;
   private List<JobPlannifBean> listeItemMetier;
   private String               libelle;

   @Inject
   private JobPlannifBean       itemSelected;
   private String               anneeJobPlannif;
   private String               heuresJobPlannif;
   private String               jourMoisJobPlannif;
   private String               jourSemaineJobPlannif;
   private String               minutesJobPlannif;
   private String               moisJobPlannif;
   private String               secondesJobPlannif;

   /**
    * Constructeur
    */
   public JobPlannifManagedBean() {
      this.listeItemMetier = new ArrayList<>();
      this.reload();

   }

   public void reload() {
      this.listeItemMetier.clear();
      this.listeItemMetier.addAll(JobPlannifBean.getAll());
   }

   public void initProperties() {
      this.libelle = "";
   }

   /**
    * @return
    * @throws ASocleException
    */
   @Override
   public String add() throws ASocleException {
      super.add();
      JobPlannifBean bean = new JobPlannifBean();
      bean.setLibelleJobPlannif(this.libelle);
      bean.setAnneeJobPlannif(this.anneeJobPlannif);
      bean.setHeuresJobPlannif(this.heuresJobPlannif);
      bean.setJourMoisJobPlannif(this.jourMoisJobPlannif);
      bean.setJourSemaineJobPlannif(this.jourSemaineJobPlannif);
      bean.setMinutesJobPlannif(this.minutesJobPlannif);
      bean.setMoisJobPlannif(this.moisJobPlannif);
      bean.setSecondesJobPlannif(this.secondesJobPlannif);

      try {
         bean.save();
         FacesContext.getCurrentInstance().addMessage(SOCLE_constants.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Le rôle a été créé."));
         RequestContext.getCurrentInstance().update(":dataTable");
         this.closeDialog = true;
      } catch (ASocleException e) {
         FacesContext.getCurrentInstance().addMessage(SOCLE_constants.DIALOG_ADD_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", e.getClientMessage()));
         throw e;
      }
      return null;
   }

   @Override
   public String update() throws ASocleException {
      super.update();
      if (null != this.itemSelected) {

         try {

            this.itemSelected.update();

            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement modifié"));
            this.closeDialog = true;
         } catch (ASocleException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.DIALOG_UPD_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", e.getClientMessage()));
            throw e;
         }
      }
      return null;
   }

   @Override
   public String delete() throws ASocleException {
      super.delete();
      if (null != this.itemSelected) {
         JobDao dao = new JobDao();
         try {
            this.itemSelected.delete();
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "message", "Enregistrement supprimé"));
            this.closeDialog = true;
            this.reload();
         } catch (ASocleException e) {
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.DIALOG_DEL_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "message", "Enregistrement non effacé"));
            throw e;
         }
      }
      return null;
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
    * sets value for roleSelected
    * 
    * @param jobSelected
    *           the roleSelected to set
    */
   public void setItemMetier(JobPlannifBean itemMetier) {
      if (null != itemMetier) {
         this.itemSelected = itemMetier;
         this.libelle = itemMetier.getLibelleJobPlannif();

      }
   }

   public Boolean getCloseDialog() {
      return this.closeDialog;
   }

   public void setCloseDialog(Boolean closeDialog) {
      this.closeDialog = closeDialog;
   }

   public List<JobPlannifBean> getJobPlannif() {
      return this.listeItemMetier;
   }

   public void setJobplannif(List<JobPlannifBean> jobPlannif) {
      this.listeItemMetier = jobPlannif;
   }

   public JobPlannifBean getItemSelected() {
      return this.itemSelected;
   }

   public List<JobPlannifBean> getListeItemMetier() {
      return this.listeItemMetier;
   }

   public void setListeItemMetier(List<JobPlannifBean> listeItemMetier) {
      this.listeItemMetier = listeItemMetier;
   }

   public String getAnneeJobPlannif() {
      return this.anneeJobPlannif;
   }

   public void setAnneeJobPlannif(String anneeJobPlannif) {
      this.anneeJobPlannif = anneeJobPlannif;
   }

   public String getHeuresJobPlannif() {
      return this.heuresJobPlannif;
   }

   public void setHeuresJobPlannif(String heuresJobPlannif) {
      this.heuresJobPlannif = heuresJobPlannif;
   }

   public String getJourMoisJobPlannif() {
      return this.jourMoisJobPlannif;
   }

   public void setJourMoisJobPlannif(String jourMoisJobPlannif) {
      this.jourMoisJobPlannif = jourMoisJobPlannif;
   }

   public String getJourSemaineJobPlannif() {
      return this.jourSemaineJobPlannif;
   }

   public void setJourSemaineJobPlannif(String jourSemaineJobPlannif) {
      this.jourSemaineJobPlannif = jourSemaineJobPlannif;
   }

   public String getMinutesJobPlannif() {
      return this.minutesJobPlannif;
   }

   public void setMinutesJobPlannif(String minutesJobPlannif) {
      this.minutesJobPlannif = minutesJobPlannif;
   }

   public String getMoisJobPlannif() {
      return this.moisJobPlannif;
   }

   public void setMoisJobPlannif(String moisJobPlannif) {
      this.moisJobPlannif = moisJobPlannif;
   }

   public String getSecondesJobPlannif() {
      return this.secondesJobPlannif;
   }

   public void setSecondesJobPlannif(String secondesJobPlannif) {
      this.secondesJobPlannif = secondesJobPlannif;
   }

   public void setItemSelected(JobPlannifBean itemSelected) {
      this.itemSelected = itemSelected;
   }

}
