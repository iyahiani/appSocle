package com.avancial.socle.model.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "socle_repertoire")
public class RepertoireBean {

   @Id
   private Long idUser;
   private String nomTechnique;
   private String valeur;

}
