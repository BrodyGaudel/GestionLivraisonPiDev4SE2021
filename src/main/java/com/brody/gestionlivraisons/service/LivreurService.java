package com.brody.gestionlivraisons.service;

import java.util.List;

import com.brody.gestionlivraisons.entities.Livreur;

public interface LivreurService {
	
	Livreur saveLivreur(Livreur l);
	Livreur updateLivreur(Livreur livreur);
	void deleteLivreur(Livreur l);
	void deleteLivreurById(Long matricule);
	Livreur getLivreur(Long matricule);
	List<Livreur> getAllLivreur();
	List<Livreur> getAllLivreurDispo();
	List<Livreur> getAllLivreurNonDispo();

}
