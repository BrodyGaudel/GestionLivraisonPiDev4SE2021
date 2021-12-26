package com.brody.gestionlivraisons.service;

import java.util.List;

import com.brody.gestionlivraisons.entities.Livraison;

public interface LivraisonService {
	
	Livraison saveLivraison(Livraison livraison);
	
	Livraison updateLivraison(Livraison livraison);
	
	void deleteLivraisonById(Long idLivraison);
	
	Livraison getLivraison(Long idLivraison);
	
	List<Livraison> getAllLivraison();
	
	Livraison affectLivreurToLivraison(Long idLivreur, Livraison livraison);
	
	List<Livraison> getLivraisonsByLivreur(Long matricule);

}
