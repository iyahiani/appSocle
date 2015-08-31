package com.avancial.socle.data.model.databean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the socle_job_plannif database table.
 * 
 */
@Entity
@Table(name = "socle_job_plannif")
public class JobPlannifDataBean implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(unique = true, nullable = false)
   private int               idJobPlannif;

   @Column(length = 10)
   private String            anneeJobPlannif;

   @Column(length = 10)
   private String            heuresJobPlannif;

   @Column(length = 10)
   private String            jourMoisJobPlannif;

   @Column(length = 10)
   private String            jourSemaineJobPlannif;

   @Column(nullable = false, length = 50)
   private String            libelleJobPlannif;

   @Column(length = 10)
   private String            minutesJobPlannif;

   @Column(length = 10)
   private String            moisJobPlannif;

   @Column(length = 10)
   private String            secondesJobPlannif;

   @OneToOne
   @JoinColumn(name = "idJobType", nullable = false)
   private JobTypeDataBean   jobType;

   public JobPlannifDataBean() {
   }

   public int getIdJobPlannif() {
      return this.idJobPlannif;
   }

   public void setIdJobPlannif(int idJobPlannif) {
      this.idJobPlannif = idJobPlannif;
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

   public String getLibelleJobPlannif() {
      return this.libelleJobPlannif;
   }

   public void setLibelleJobPlannif(String libelleJobPlannif) {
      this.libelleJobPlannif = libelleJobPlannif;
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

   public JobTypeDataBean getJobType() {
      return this.jobType;
   }

   public void setJobType(JobTypeDataBean jobType) {
      this.jobType = jobType;
   }

}