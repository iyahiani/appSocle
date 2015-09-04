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
import com.avancial.socle.data.controller.dao.JobPlannifDao;
import com.avancial.socle.data.model.databean.JobPlannifDataBean;
import com.avancial.socle.exceptions.ASocleException;
import com.avancial.socle.resources.MessageController;
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
   private List<JobPlannifBean> selectedItems;
   @Inject
   private JobPlannifDataBean   selectedItem;

   private String               libelle;
   private String               nomTechnique;
   private String               annee;
   private String               heures;
   private String               jourMois;
   private String               jourSemaine;
   private String               minutes;
   private String               mois;
   private String               secondes;

   /**
    * Constructeur
    */
   public JobPlannifManagedBean() {
      this.selectedItems = new ArrayList<>();
      this.reload();

   }

   public void reload() {
      this.selectedItems.clear();
      this.selectedItems.addAll(JobPlannifBean.getAll());
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
      JobPlannifDataBean jobPlannifDataBean = new JobPlannifDataBean();
      jobPlannifDataBean.setLibelleJobPlannif(this.libelle);
      JobPlannifDao dao = new JobPlannifDao();

      try {
         dao.save(jobPlannifDataBean);
         FacesContext.getCurrentInstance().addMessage(SOCLE_constants.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", MessageController.getTraduction("p_message_add_ok")));
         RequestContext.getCurrentInstance().update(":dataTable");
         this.closeDialog = true;
      } catch (ASocleException e) {
         FacesContext.getCurrentInstance().addMessage(SOCLE_constants.DIALOG_ADD_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getClientMessage()));
         e.printStackTrace();
      }

      return null;
   }

   @Override
   public String update() throws ASocleException {
      super.update();
      if (null != this.selectedItem) {
         JobPlannifDao dao = new JobPlannifDao();
         try {
            dao.update(this.selectedItem);
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", MessageController.getTraduction("p_message_update_ok")));
            this.closeDialog = true;
         } catch (ASocleException e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.DIALOG_UPD_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getClientMessage()));
         }
      }
      return null;
   }

   @Override
   public String delete() throws ASocleException {
      super.delete();
      if (null != this.selectedItem) {
         JobPlannifDao dao = new JobPlannifDao();
         try {
            dao.delete(this.selectedItem);
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.PAGE_ID_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_INFO, "", MessageController.getTraduction("p_message_delete_ok")));
            this.closeDialog = true;
         } catch (ASocleException e) {
            FacesContext.getCurrentInstance().addMessage(SOCLE_constants.DIALOG_DEL_MESSAGES.toString(), new FacesMessage(FacesMessage.SEVERITY_ERROR, "", MessageController.getTraduction("p_message_delete_ko")));
         }
      }
      return null;
   }

   public Boolean getCloseDialog() {
      return this.closeDialog;
   }

   public void setCloseDialog(Boolean closeDialog) {
      this.closeDialog = closeDialog;
   }

   public List<JobPlannifBean> getSelectedItems() {
      return this.selectedItems;
   }

   public void setSelectedItems(List<JobPlannifBean> selectedItems) {
      this.selectedItems = selectedItems;
   }

   public JobPlannifDataBean getSelectedItem() {
      return this.selectedItem;
   }

   public void setSelectedItem(JobPlannifDataBean selectedItem) {
      this.selectedItem = selectedItem;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String libelle) {
      this.libelle = libelle;
   }

   public String getNomTechnique() {
      return this.nomTechnique;
   }

   public void setNomTechnique(String nomTechnique) {
      this.nomTechnique = nomTechnique;
   }

   public String getAnnee() {
      return this.annee;
   }

   public void setAnnee(String annee) {
      this.annee = annee;
   }

   public String getHeures() {
      return this.heures;
   }

   public void setHeures(String heures) {
      this.heures = heures;
   }

   public String getJourMois() {
      return this.jourMois;
   }

   public void setJourMois(String jourMois) {
      this.jourMois = jourMois;
   }

   public String getJourSemaine() {
      return this.jourSemaine;
   }

   public void setJourSemaine(String jourSemaine) {
      this.jourSemaine = jourSemaine;
   }

   public String getMinutes() {
      return this.minutes;
   }

   public void setMinutes(String minutes) {
      this.minutes = minutes;
   }

   public String getMois() {
      return this.mois;
   }

   public void setMois(String mois) {
      this.mois = mois;
   }

   public String getSecondes() {
      return this.secondes;
   }

   public void setSecondes(String secondes) {
      this.secondes = secondes;
   }

}
