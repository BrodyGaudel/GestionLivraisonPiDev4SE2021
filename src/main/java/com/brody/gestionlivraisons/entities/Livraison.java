package com.brody.gestionlivraisons.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="livraison")
public class Livraison implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivraison;
	private double fraisLivraison;
	private String destination;
	
	@ManyToOne
	@JsonBackReference
	private Livreur livreur;
	
	public Livraison() {
		super();
	}
	public Livraison(double fraisLivraison, String destination) {
		super();
		this.fraisLivraison = fraisLivraison;
		this.destination = destination;
	}
	public Long getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(Long idLivraison) {
		this.idLivraison = idLivraison;
	}
	public double getFraisLivraison() {
		return fraisLivraison;
	}
	public void setFraisLivraison(double fraisLivraison) {
		this.fraisLivraison = fraisLivraison;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "Livraison [idLivraison=" + idLivraison + ", fraisLivraison=" + fraisLivraison + ", destination="
				+ destination + "]";
	}
	public Livreur getLivreur() {
		return livreur;
	}
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	

}
