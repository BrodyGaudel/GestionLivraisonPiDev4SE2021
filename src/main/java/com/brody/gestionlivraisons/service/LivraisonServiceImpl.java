package com.brody.gestionlivraisons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brody.gestionlivraisons.entities.Livraison;
import com.brody.gestionlivraisons.entities.Livreur;
import com.brody.gestionlivraisons.repository.LivraisonRepository;
import com.brody.gestionlivraisons.repository.LivreurRepository;

@Service
public class LivraisonServiceImpl implements LivraisonService{
	
	@Autowired
	LivraisonRepository livraisonRepository;
	
	@Autowired
	LivreurRepository livreurRepository;

	@Override
	public Livraison saveLivraison(Livraison livraison) {
		return livraisonRepository.save(livraison);
	}

	@Override
	public Livraison updateLivraison(Livraison livraison) {
		return livraisonRepository.save(livraison);
	}


	@Override
	public void deleteLivraisonById(Long idLivraison) {
		livraisonRepository.deleteById(idLivraison);
		
	}

	@Override
	public Livraison getLivraison(Long idLivraison) {
		return livraisonRepository.findById(idLivraison).get();
	}

	@Override
	public List<Livraison> getAllLivraison() {
		return livraisonRepository.findAll();
	}

	@Override
	public Livraison affectLivreurToLivraison(Long idLivreur, Livraison livraison) {
		Livreur livreur = livreurRepository.findById(idLivreur).get();
		if((livreur!=null)&&(livraison!=null)) {
			livraison.setLivreur(livreur);
			livraisonRepository.save(livraison);
			return livraison;
		}
		else {
			return null;
		}
	
	}

	@Override
	public List<Livraison> getLivraisonsByLivreur(Long matricule) {
		List<Livraison> tout = this.livraisonRepository.findAll();
		List<Livraison> res = new ArrayList<Livraison>();
		for(Livraison livraison:tout) {
			if(livraison.getLivreur().getMatricule().equals(matricule))
			{
				res.add(livraison);
			}
		}
		return res;
	}

}
