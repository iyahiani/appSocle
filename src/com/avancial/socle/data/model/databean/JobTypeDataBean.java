package com.avancial.socle.data.model.databean;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the socle_job_type database table.
 * 
 */
@Entity
@Table(name="socle_job_type")
@NamedQuery(name="JobTypeDataBean.findAll", query="SELECT j FROM JobTypeDataBean j")
public class JobTypeDataBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idJobType;

	@Column(nullable=false, length=35)
	private String libelleJobType;

	@Column(nullable=false, length=35)
	private String nomTechniqueJobType;

	public JobTypeDataBean() {
	}

	public int getIdJobType() {
		return this.idJobType;
	}

	public void setIdJobType(int idJobType) {
		this.idJobType = idJobType;
	}

	public String getLibelleJobType() {
		return this.libelleJobType;
	}

	public void setLibelleJobType(String libelleJobType) {
		this.libelleJobType = libelleJobType;
	}

	public String getNomTechniqueJobType() {
		return this.nomTechniqueJobType;
	}

	public void setNomTechniqueJobType(String nomTechniqueJobType) {
		this.nomTechniqueJobType = nomTechniqueJobType;
	}

}