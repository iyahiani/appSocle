package com.avancial.socle.model.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "socle_user")

public class UtilisateurBean {
	
	@Id
	private Long idUser;
    private String loginUser;
    private String passwordUser;
    private String nomUser;
    private String prenomUser;
    private String cpUser;
    private String mailUser;
    private String telephonePro1User;
    private String telephonePro2User;
    private String telephonePortable1User;
    private String fax1User;
    private String adresseNumeroRueUser;
    private String adresseNomRueUser;
    private String adresseComplement1User;
    private String adresseComplement2User;
    private String adresseCodepostalUser;
    private String adresseVilleUser;
    private String attribut1User;
    private String attribut2User;
    private String attribut3User;
    private String attribut4User;
    private String attribut5User;
    @Temporal(TemporalType.TIMESTAMP)
	private Date DateCreateUser;
    @Temporal(TemporalType.TIMESTAMP)
	private Date DateUpdateUser;
    @Temporal(TemporalType.TIMESTAMP)
   	private Date dateLastUpdateUtilisateurUser;
    
    @OneToOne
	@JoinColumn(name="idUserCreateUser")
    private UtilisateurBean userCreateUser;
    @OneToOne
	@JoinColumn(name="idUserUpdateUser")
    private UtilisateurBean userUpdateUser;
   
    private String robotUser;
	private String tomcatRoleUser;	
	private String commentaireUtilisateurUser;
	
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(String loginUser) {
		this.loginUser = loginUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public String getPrenomUser() {
		return prenomUser;
	}
	public void setPrenomUser(String prenomUser) {
		this.prenomUser = prenomUser;
	}
	public String getCpUser() {
		return cpUser;
	}
	public void setCpUser(String cpUser) {
		this.cpUser = cpUser;
	}
	public String getMailUser() {
		return mailUser;
	}
	public void setMailUser(String mailUser) {
		this.mailUser = mailUser;
	}
	public String getTelephonePro1User() {
		return telephonePro1User;
	}
	public void setTelephonePro1User(String telephonePro1User) {
		this.telephonePro1User = telephonePro1User;
	}
	public String getTelephonePro2User() {
		return telephonePro2User;
	}
	public void setTelephonePro2User(String telephonePro2User) {
		this.telephonePro2User = telephonePro2User;
	}
	public String getTelephonePortable1User() {
		return telephonePortable1User;
	}
	public void setTelephonePortable1User(String telephonePortable1User) {
		this.telephonePortable1User = telephonePortable1User;
	}
	public String getFax1User() {
		return fax1User;
	}
	public void setFax1User(String fax1User) {
		this.fax1User = fax1User;
	}
	public String getAdresseNumeroRueUser() {
		return adresseNumeroRueUser;
	}
	public void setAdresseNumeroRueUser(String adresseNumeroRueUser) {
		this.adresseNumeroRueUser = adresseNumeroRueUser;
	}
	public String getAdresseNomRueUser() {
		return adresseNomRueUser;
	}
	public void setAdresseNomRueUser(String adresseNomRueUser) {
		this.adresseNomRueUser = adresseNomRueUser;
	}
	public String getAdresseComplement1User() {
		return adresseComplement1User;
	}
	public void setAdresseComplement1User(String adresseComplement1User) {
		this.adresseComplement1User = adresseComplement1User;
	}
	public String getAdresseComplement2User() {
		return adresseComplement2User;
	}
	public void setAdresseComplement2User(String adresseComplement2User) {
		this.adresseComplement2User = adresseComplement2User;
	}
	public String getAdresseCodepostalUser() {
		return adresseCodepostalUser;
	}
	public void setAdresseCodepostalUser(String adresseCodepostalUser) {
		this.adresseCodepostalUser = adresseCodepostalUser;
	}
	public String getAdresseVilleUser() {
		return adresseVilleUser;
	}
	public void setAdresseVilleUser(String adresseVilleUser) {
		this.adresseVilleUser = adresseVilleUser;
	}
	public String getAttribut1User() {
		return attribut1User;
	}
	public void setAttribut1User(String attribut1User) {
		this.attribut1User = attribut1User;
	}
	public String getAttribut2User() {
		return attribut2User;
	}
	public void setAttribut2User(String attribut2User) {
		this.attribut2User = attribut2User;
	}
	public String getAttribut3User() {
		return attribut3User;
	}
	public void setAttribut3User(String attribut3User) {
		this.attribut3User = attribut3User;
	}
	public String getAttribut4User() {
		return attribut4User;
	}
	public void setAttribut4User(String attribut4User) {
		this.attribut4User = attribut4User;
	}
	public String getAttribut5User() {
		return attribut5User;
	}
	public void setAttribut5User(String attribut5User) {
		this.attribut5User = attribut5User;
	}
	public Date getDateCreateUser() {
		return DateCreateUser;
	}
	public void setDateCreateUser(Date dateCreateUser) {
		DateCreateUser = dateCreateUser;
	}
	public Date getDateUpdateUser() {
		return DateUpdateUser;
	}
	public void setDateUpdateUser(Date dateUpdateUser) {
		DateUpdateUser = dateUpdateUser;
	}
	public Date getDateLastUpdateUtilisateurUser() {
		return dateLastUpdateUtilisateurUser;
	}
	public void setDateLastUpdateUtilisateurUser(Date dateLastUpdateUtilisateurUser) {
		this.dateLastUpdateUtilisateurUser = dateLastUpdateUtilisateurUser;
	}
	public UtilisateurBean getUserCreateUser() {
		return userCreateUser;
	}
	public void setUserCreateUser(UtilisateurBean userCreateUser) {
		this.userCreateUser = userCreateUser;
	}
	public UtilisateurBean getUserUpdateUser() {
		return userUpdateUser;
	}
	public void setUserUpdateUser(UtilisateurBean userUpdateUser) {
		this.userUpdateUser = userUpdateUser;
	}
	public String getRobotUser() {
		return robotUser;
	}
	public void setRobotUser(String robotUser) {
		this.robotUser = robotUser;
	}
	public String getTomcatRoleUser() {
		return tomcatRoleUser;
	}
	public void setTomcatRoleUser(String tomcatRoleUser) {
		this.tomcatRoleUser = tomcatRoleUser;
	}
	public String getCommentaireUtilisateurUser() {
		return commentaireUtilisateurUser;
	}
	public void setCommentaireUtilisateurUser(String commentaireUtilisateurUser) {
		this.commentaireUtilisateurUser = commentaireUtilisateurUser;
	}
	
	//private idUtilisateurCivilite
	//private idUtilisateurTitre
    //private idRegion
    
    
	}
