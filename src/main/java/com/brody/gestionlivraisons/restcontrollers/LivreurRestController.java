package com.brody.gestionlivraisons.restcontrollers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brody.gestionlivraisons.entities.Livreur;
import com.brody.gestionlivraisons.service.LivreurService;

@RestController
@CrossOrigin(origins="*")
public class LivreurRestController {
	
	@Autowired
	private LivreurService livreurService;
	
	@GetMapping("/livreur/getbyid/{id}")
	@ResponseBody
	public Livreur getLivreurRest(@PathVariable("id") Long matricule) {
		
		return livreurService.getLivreur(matricule);
	}
	
	@GetMapping("/livreur/getall")
	@ResponseBody
	public List<Livreur> getAllLivreurRest() {
		
		return livreurService.getAllLivreur();
	}
	
	@DeleteMapping("/livreur/delete/{id}")
	@ResponseBody
	public void deleteLivreurRest(@PathVariable("id") Long matricule) {
		
		livreurService.deleteLivreurById(matricule);
	}
	
	@PostMapping("/livreur/save")
	@ResponseBody
	public Livreur saveLivreurRest(@RequestBody Livreur l) {
		
		return livreurService.saveLivreur(l);
	}
	
	@PutMapping("/livreur/update/{id}")
	@ResponseBody
	public Livreur updateLivreurRest(@RequestBody Livreur livreur, @PathVariable("id") Long matricule) {
		
		return livreurService.updateLivreur(livreur);
	} 
	
	@GetMapping("/livreurdispo/get")
	@ResponseBody
	public List<Livreur> getAllLivreurDispoRest() {
		return livreurService.getAllLivreurDispo();
	}
	
	@GetMapping("/livreurnondispo/get")
	@ResponseBody
	public List<Livreur> getAllLivreurNonDispoRest() {
		
		return livreurService.getAllLivreurNonDispo();
	}
	
	@GetMapping("/livreur/listpdf")
	public ResponseEntity<InputStreamResource> getlivraisonsListPfd() {
		List<Livreur> livreurs = livreurService.getAllLivreur();
		ByteArrayInputStream bis = GenerateLivreurPdf.livreursReporte(livreurs);
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");
        
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
	
	

}
