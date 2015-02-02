package com.avancial.socle.data.model.databean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the socle_user_role database table.
 * 
 */
@Entity
@Table(name = "socle_user_role")
public class SocleUserRoleDataBean implements Serializable {
   private static final long serialVersionUID = 1L;
   private int               idUserRole;
   private String            labelUserRole;
   private String            technicalNameUserRole;

   public SocleUserRoleDataBean() {
   }

   @Id
   public int getIdUserRole() {
      return this.idUserRole;
   }

   public void setIdUserRole(int idUserRole) {
      this.idUserRole = idUserRole;
   }

   public String getLabelUserRole() {
      return this.labelUserRole;
   }

   public void setLabelUserRole(String labelUserRole) {
      this.labelUserRole = labelUserRole;
   }

   public String getTechnicalNameUserRole() {
      return this.technicalNameUserRole;
   }

   public void setTechnicalNameUserRole(String technicalNameUserRole) {
      this.technicalNameUserRole = technicalNameUserRole;
   }

}