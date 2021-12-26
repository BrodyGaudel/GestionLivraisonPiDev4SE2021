package com.brody.gestionlivraisons.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brody.gestionlivraisons.entities.Livreur;
import com.brody.gestionlivraisons.repository.LivreurRepository;

@Service
public class LivreurServiceImpl implements LivreurService {

	@Autowired
	LivreurRepository livreurRepository;
	
	public Livreur saveLivreur(Livreur l) {
		
		return livreurRepository.save(l);
	}

	public Livreur updateLivreur(Livreur livreur) {
		return livreurRepository.save(livreur);
	}

	public void deleteLivreur(Livreur l) {
		
		livreurRepository.delete(l);
		
	}

	public void deleteLivreurById(Long matricule) {
		livreurRepository.deleteById(matricule);
		
	}

	public Livreur getLivreur(Long matricule) {
		
		return livreurRepository.findById(matricule).get();
	}

	public List<Livreur> getAllLivreur() {
		
		return livreurRepository.findAll();
	}

	public List<Livreur> getAllLivreurDispo() {
		
		List<Livreur> res = new ArrayList<Livreur>();
		List<Livreur> toutLesLivreurs = this.livreurRepository.findAll();
		String dispo = "disponible";
		
		for(Livreur l:toutLesLivreurs) {
			if(l.getDisponibility().equals(dispo))
			{
				res.add(l);
			}
		}
		return res;
	}

	public List<Livreur> getAllLivreurNonDispo() {
		// TODO Auto-generated method stub
		List<Livreur> non = new ArrayList<Livreur>();
		List<Livreur> toutLesLivreurs = this.livreurRepository.findAll();
		String dispo = "disponible";
		for(Livreur l:toutLesLivreurs) {
			if(!l.getDisponibility().equals(dispo))
			{
				non.add(l);
			}
		}
		return non;
	}

}
