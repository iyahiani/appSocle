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
    
    
	public Long getIdUser() {
		return this.idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getNomTechnique() {
		return this.nomTechnique;
	}
	public void setNomTechnique(String nomTechnique) {
		this.nomTechnique = nomTechnique;
	}
	public String getValeur() {
		return this.valeur;
	}
	public void setValeur(String valeur) {
		this.valeur = valeur;
	}
    

}
