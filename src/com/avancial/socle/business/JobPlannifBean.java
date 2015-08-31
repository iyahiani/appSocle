/**
 * 
 */
package com.avancial.socle.business;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import com.avancial.socle.data.controller.dao.JobPlannifDao;
import com.avancial.socle.data.model.databean.JobPlannifDataBean;
import com.avancial.socle.data.model.databean.JobTypeDataBean;
import com.avancial.socle.exceptions.ASocleException;

/**
 * @author bruno.legloahec
 *
 */
public class JobPlannifBean {
   @Inject
   private JobPlannifDataBean jobPlannifDataBean;

   /**
    * Constructeur
    */
   public JobPlannifBean(JobPlannifDataBean jobPlannifDataBean) {
      this.jobPlannifDataBean = jobPlannifDataBean;
   }

   /**
    * Constructeur
    */
   public JobPlannifBean() {
      super();
      this.jobPlannifDataBean = new JobPlannifDataBean();
   }

   /**
    * @return
    */
   public static Collection<? extends JobPlannifBean> getAll() {
      ArrayList<JobPlannifBean> liste = new ArrayList<>();
      JobPlannifDao dao = new JobPlannifDao();
      for (JobPlannifDataBean bean : dao.getAll()) {
         JobPlannifBean job = new JobPlannifBean(bean);
         liste.add(job);
      }

      return liste;
   }

   /**
    * @throws ASocleException
    * 
    */
   public void save() throws ASocleException {

      JobPlannifDao dao = new JobPlannifDao();
      dao.save(this.jobPlannifDataBean);

   }

   /**
    * @throws ASocleException
    * 
    */
   public void update() throws ASocleException {
      JobPlannifDao dao = new JobPlannifDao();
      dao.update(this.jobPlannifDataBean);
   }

   /**
    * @throws ASocleException
    * 
    */
   public void delete() throws ASocleException {
      JobPlannifDao dao = new JobPlannifDao();
      dao.delete(this.jobPlannifDataBean);
   }

   public Boolean isExisteClasse(String classe) {

      try {
         Class.forName(classe);
         return true;
      } catch (ClassNotFoundException e) {
         return false;
      }

   }

   public String getAnneeJobPlannif() {
      return this.jobPlannifDataBean.getAnneeJobPlannif();
   }

   public void setAnneeJobPlannif(String anneeJobPlannif) {
      this.jobPlannifDataBean.setAnneeJobPlannif(anneeJobPlannif);
   }

   public String getHeuresJobPlannif() {
      return this.jobPlannifDataBean.getHeuresJobPlannif();
   }

   public void setHeuresJobPlannif(String heuresJobPlannif) {
      this.jobPlannifDataBean.setHeuresJobPlannif(heuresJobPlannif);
   }

   public String getJourMoisJobPlannif() {
      return this.jobPlannifDataBean.getJourMoisJobPlannif();
   }

   public void setJourMoisJobPlannif(String jourMoisJobPlannif) {
      this.jobPlannifDataBean.setJourMoisJobPlannif(jourMoisJobPlannif);
   }

   public String getJourSemaineJobPlannif() {
      return this.jobPlannifDataBean.getJourSemaineJobPlannif();
   }

   public void setJourSemaineJobPlannif(String jourSemaineJobPlannif) {
      this.jobPlannifDataBean.setJourSemaineJobPlannif(jourSemaineJobPlannif);
   }

   public String getLibelleJobPlannif() {
      return this.jobPlannifDataBean.getLibelleJobPlannif();
   }

   public void setLibelleJobPlannif(String libelleJobPlannif) {
      this.jobPlannifDataBean.setLibelleJobPlannif(libelleJobPlannif);
   }

   public String getMinutesJobPlannif() {
      return this.jobPlannifDataBean.getMinutesJobPlannif();
   }

   public void setMinutesJobPlannif(String minutesJobPlannif) {
      this.jobPlannifDataBean.setMinutesJobPlannif(minutesJobPlannif);
   }

   public String getMoisJobPlannif() {
      return this.jobPlannifDataBean.getMoisJobPlannif();
   }

   public void setMoisJobPlannif(String moisJobPlannif) {
      this.jobPlannifDataBean.setMoisJobPlannif(moisJobPlannif);
   }

   public String getSecondesJobPlannif() {
      return this.jobPlannifDataBean.getSecondesJobPlannif();
   }

   public void setSecondesJobPlannif(String secondesJobPlannif) {
      this.jobPlannifDataBean.setSecondesJobPlannif(secondesJobPlannif);
   }

   public JobTypeDataBean getSocleJobType() {
      return this.jobPlannifDataBean.getSocleJobType();
   }

   public void setSocleJobType(JobTypeDataBean socleJobType) {
      this.jobPlannifDataBean.setSocleJobType(socleJobType);
   }

}
