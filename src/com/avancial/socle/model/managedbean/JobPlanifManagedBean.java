/**
 * 
 */
package com.avancial.socle.model.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.avancial.socle.business.JobPlanifBean;
import com.avancial.socle.data.controller.dao.JobPlanifDao;
import com.avancial.socle.data.controller.dao.JobPlanifTypeDao;
import com.avancial.socle.data.model.databean.JobPlanifDataBean;
import com.avancial.socle.data.model.databean.JobPlanifTypeDataBean;
import com.avancial.socle.exceptions.ASocleException;
import com.avancial.socle.resources.MessageController;
import com.avancial.socle.resources.constants.SOCLE_constants;

/**
 * @author bruno.legloahec
 *
 */
@Named("jobPlanifManagedBean")
@ViewScoped
public class JobPlanifManagedBean extends AManageBean {
   /**
    * 
    */
   private static final long   serialVersionUID = 1L;
   private List<JobPlanifBean> selectedItems;
   @Inject
   private JobPlanifDataBean   selectedItem;

   private String              libelle;
   private String              nomTechnique;
   private String              annee;
   private String              heures;
   private String              jourMois;
   private String              jourSemaine;
   private String              minutes;
   private String              mois;
   private String              secondes;

   private List<SelectItem>    listePlanifType;
   private String              jobTypeSelected;
   private long                idJobPlanifType;

   /**
    * Constructeur
    */
   public JobPlanifManagedBean() {
      this.selectedItems = new ArrayList<>();
      this.listePlanifType = new ArrayList<>();
      JobPlanifTypeDao dao = new JobPlanifTypeDao();

      for (JobPlanifTypeDataBean bean : dao.getAll()) {
         SelectItem item = new SelectItem(bean.getIdJobPlanifType(), bean.getLibelleJobPlanifType());

      }

      this.reload();

   }

   public void reload() {
      this.selectedItems.clear();
      this.selectedItems.addAll(JobPlanifBean.getAll());
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
      JobPlanifDataBean jobPlanifDataBean = new JobPlanifDataBean();
      jobPlanifDataBean.setLibelleJobPlanif(this.libelle);
      jobPlanifDataBean.setAnneeJobPlanif(this.annee);
      jobPlanifDataBean.setHeuresJobPlanif(this.heures);
      jobPlanifDataBean.setJourMoisJobPlanif(this.jourMois);
      jobPlanifDataBean.setJourSemaineJobPlanif(this.jourSemaine);
      jobPlanifDataBean.setLibelleJobPlanif(this.libelle);
      jobPlanifDataBean.setMinutesJobPlanif(this.minutes);
      jobPlanifDataBean.setMoisJobPlanif(this.mois);
      jobPlanifDataBean.setNomTechniqueJobPlanif(this.nomTechnique);
      jobPlanifDataBean.setSecondesJobPlanif(this.secondes);
      // jobPlanifDataBean.getJobPlanifTypeDataBean().setIdJobPlanifType(this.idJobPlanifType);
      // jobPlanifDataBean.setJobPlanifTypeDataBean(this.jobTypeSelected);
      jobPlanifDataBean.getJob().setIdJob(new Long(3));

      JobPlanifDao dao = new JobPlanifDao();

      try {
         dao.save(jobPlanifDataBean);
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
         JobPlanifDao dao = new JobPlanifDao();
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
         JobPlanifDao dao = new JobPlanifDao();
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

   public List<JobPlanifBean> getSelectedItems() {
      return this.selectedItems;
   }

   public void setSelectedItems(List<JobPlanifBean> selectedItems) {
      this.selectedItems = selectedItems;
   }

   public JobPlanifDataBean getSelectedItem() {
      return this.selectedItem;
   }

   public void setSelectedItem(JobPlanifDataBean selectedItem) {
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

   public long getIdJobPlanifType() {
      return this.idJobPlanifType;
   }

   public void setIdJobPlanifType(long idJobPlanifType) {
      this.idJobPlanifType = idJobPlanifType;
   }

   public String getJobTypeSelected() {
      return this.jobTypeSelected;
   }

   public void setJobTypeSelected(String jobTypeSelected) {
      this.jobTypeSelected = jobTypeSelected;
   }

   public List<SelectItem> getListePlanifType() {
      return this.listePlanifType;
   }

   public void setListePlanifType(List<SelectItem> listePlanifType) {
      this.listePlanifType = listePlanifType;
   }

}
