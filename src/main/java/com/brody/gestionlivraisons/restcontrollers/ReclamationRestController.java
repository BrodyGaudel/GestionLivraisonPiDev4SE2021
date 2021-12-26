package com.brody.gestionlivraisons.restcontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brody.gestionlivraisons.entities.Reclamation;
import com.brody.gestionlivraisons.service.ReclamationService;



@RestController
//@RequestMapping("/reclamation")  //say to spring that to enter here we must click on api
@CrossOrigin(origins="*")
public class ReclamationRestController {

	
	@Autowired
	private ReclamationService reclamationService;
	
	@GetMapping("/reclamation/getall")
	@ResponseBody
	public List<Reclamation> getAllReclamationRest()
	{
		return reclamationService.getAllReclamation();
	}
	
	@GetMapping("/reclamation/get/{id}")
	@ResponseBody
	public Reclamation getReclamationByIdRest(@PathVariable("id") Long idReclamation)
	{
		return reclamationService.getReclamation(idReclamation);
	}
	
	@DeleteMapping("/reclamation/delete/{id}")
	@ResponseBody
	public void deleteReclamationRest(@PathVariable("id") Long idReclamation) {
		
		reclamationService.deleteReclamationById(idReclamation);
	}
	
	@PostMapping("/reclamation/save")
	//@ResponseBody
	public Reclamation saveReclamationRest(@RequestBody Reclamation reclamation) {
		
		return reclamationService.saveReclamation(reclamation);
	}
	
	@PutMapping("/reclamation/update/{id}")
	@ResponseBody
	public Reclamation updateReclamationRest(@RequestBody Reclamation reclamation, @PathVariable("id") Long idReclamation) {
		
		return reclamationService.updateReclamation(reclamation);
	} 
}
