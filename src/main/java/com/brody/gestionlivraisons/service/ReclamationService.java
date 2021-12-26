package com.brody.gestionlivraisons.service;

import java.util.List;

import com.brody.gestionlivraisons.entities.Reclamation;


public interface ReclamationService {
	Reclamation saveReclamation(Reclamation r);
	Reclamation updateReclamation(Reclamation r);
	void deleteReclamation(Reclamation r);
	void deleteReclamationById(Long idReclamation);
	Reclamation getReclamation(Long idReclamation);
	List<Reclamation> getAllReclamation();
	
}
