package com.avancial.socle.data.model.databean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the socle_job_type database table.
 * 
 */
@Entity
@Table(name = "socle_job_type_plannif")
// @NamedQuery(name="JobTypePlannifDataBean.findAll", query="SELECT j FROM JobTypeDataBean j")
public class JobTypePlannifDataBean implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(unique = true, nullable = false)
   private int               idJobTypePlannif;

   @Column(nullable = false, length = 35)
   private String            libelleJobTypePlannif;

   @Column(nullable = false, length = 35)
   private String            nomTechniqueJobTypePlannif;

   public JobTypePlannifDataBean() {
   }

   public int getIdJobTypePlannif() {
      return this.idJobTypePlannif;
   }

   public void setIdJobTypePlannif(int idJobTypePlannif) {
      this.idJobTypePlannif = idJobTypePlannif;
   }

   public String getLibelleJobTypePlannif() {
      return this.libelleJobTypePlannif;
   }

   public void setLibelleJobTypePlannif(String libelleJobTypePlannif) {
      this.libelleJobTypePlannif = libelleJobTypePlannif;
   }

   public String getNomTechniqueJobTypePlannif() {
      return this.nomTechniqueJobTypePlannif;
   }

   public void setNomTechniqueJobTypePlannif(String nomTechniqueJobTypePlannif) {
      this.nomTechniqueJobTypePlannif = nomTechniqueJobTypePlannif;
   }

}