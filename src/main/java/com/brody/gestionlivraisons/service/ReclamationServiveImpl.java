package com.brody.gestionlivraisons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brody.gestionlivraisons.entities.Reclamation;
import com.brody.gestionlivraisons.repository.ReclamationRepository;



@Service
public class ReclamationServiveImpl implements ReclamationService{
	
	@Autowired
	ReclamationRepository reclamationRepository;

	public Reclamation saveReclamation(Reclamation r) {
		
		return reclamationRepository.save(r);
	}

	public Reclamation updateReclamation(Reclamation r) {
		
		return reclamationRepository.save(r);
	}

	public void deleteReclamation(Reclamation r) {
		
		reclamationRepository.delete(r);
		
	}

	public void deleteReclamationById(Long idReclamation) {
		
		reclamationRepository.deleteById(idReclamation);
		
	}

	public Reclamation getReclamation(Long idReclamation) {
		
		return reclamationRepository.findById(idReclamation).get();
	}

	public List<Reclamation> getAllReclamation() {
	
		return reclamationRepository.findAll();
	}

}
