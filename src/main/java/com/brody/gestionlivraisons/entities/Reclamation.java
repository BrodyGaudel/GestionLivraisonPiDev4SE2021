package com.brody.gestionlivraisons.entities;

import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "reclamation")
public class Reclamation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	private String description;
	private String type;
	private String reponse;

	public Reclamation() {
		super();
	}

	public Reclamation(String description, String type, String reponse) {
		super();
		this.description = description;
		this.type = type;
		this.reponse = reponse;
	}

	public Long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	@Override
	public String toString() {
		return "Reclamation [idReclamation=" + idReclamation + ", description=" + description + ", type=" + type
				+ ", reponse=" + reponse + "]";
	}

}
