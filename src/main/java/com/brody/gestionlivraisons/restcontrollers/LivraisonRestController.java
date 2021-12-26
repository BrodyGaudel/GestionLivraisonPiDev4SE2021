package com.brody.gestionlivraisons.restcontrollers;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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

import com.brody.gestionlivraisons.entities.Livraison;
import com.brody.gestionlivraisons.service.LivraisonService;

@RestController
@CrossOrigin(origins="*")
public class LivraisonRestController {
	
	@Autowired
	LivraisonService livraisonService;
	
	@GetMapping("/livraison/getall")
	@ResponseBody
	List<Livraison> getAllLivraisonRest()
	{
		return livraisonService.getAllLivraison();
	}
	
	@GetMapping("/livraison/getbyid/{id}")
	@ResponseBody
	public Livraison getLivraisonRest(@PathVariable("id") Long id) {
		
		return livraisonService.getLivraison(id);
	}
	
	@DeleteMapping("/livraison/delete/{id}")
	@ResponseBody
	public void deleteLivraisonRest(@PathVariable("id") Long id) {
		
		livraisonService.deleteLivraisonById(id);
	}
	
	@PostMapping("/livraison/save")
	@ResponseBody
	public Livraison saveLivraisonRest(@RequestBody Livraison livraison) {
		
		return livraisonService.saveLivraison(livraison);
	}
	
	@PutMapping("/livraison/update/{id}")
	@ResponseBody
	public Livraison updateLivraisonRest(@RequestBody Livraison newlivraison, @PathVariable("id") Long id) {
		
		return livraisonService.updateLivraison(newlivraison);
	} 
	
	@GetMapping("/livraison/getlivreurs/{id}")
	@ResponseBody
	public List<Livraison> rechercheLivraison(@PathVariable("id") Long matricule) {
		
		return livraisonService.getLivraisonsByLivreur(matricule);
	}
	
	@PutMapping("/livraison/affect/{id}")
	@ResponseBody
	public Livraison affectLivreur(@PathVariable("id") Long id, @RequestBody Livraison livraison) {
		
		return livraisonService.affectLivreurToLivraison(id, livraison);
	}
	
	
	
	
	
	@GetMapping("/livraison/listpdf")
	public ResponseEntity<InputStreamResource> getlivraisonsListPfd(){
		
		List<Livraison> livraisons =  this.livraisonService.getAllLivraison();
		
		ByteArrayInputStream bis = GeneratePdf.livraisonsReporte(livraisons);
		
		
		HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=citiesreport.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}

}
