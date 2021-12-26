package com.brody.gestionlivraisons.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity
@Table(name="livreur")
public class Livreur implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long matricule;
	private String cin;
	private double salaire;
	private String moyenTransport;
	private String disponibility;
	private String nom;
	private String prenom;
	
	//@JsonIgnore   //to avoid that spring return us all the list
	@JsonManagedReference
	@OneToMany(mappedBy = "livreur")
	private List<Livraison> livraisons;

	public Livreur() {
		super();
	}

	public Livreur(double salaire, String cin, String moyenTransport, String disponibility, String nom, String prenom) {
		super();
		this.cin = cin;
		this.salaire = salaire;
		this.moyenTransport = moyenTransport;
		this.disponibility = disponibility;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Long getMatricule() {
		return matricule;
	}

	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}
	
	public String getCin()
	{
		return cin;
	}
	
	public void setCin(String cin)
	{
		this.cin = cin;
	}

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}

	public String getMoyenTransport() {
		return moyenTransport;
	}

	public void setMoyenTransport(String moyenTransport) {
		this.moyenTransport = moyenTransport;
	}

	public String getDisponibility() {
		return disponibility;
	}

	public void setDisponibility(String disponibility) {
		this.disponibility = disponibility;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public List<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(List<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	@Override
	public String toString() {
		return "Livreur [matricule=" + matricule + ", cin=" + cin + ", salaire=" + salaire + ", moyenTransport="
				+ moyenTransport + ", disponibility=" + disponibility + ", nom=" + nom + ", prenom=" + prenom + "]";
	}

	

}
