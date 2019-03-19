package fr.akharroub.universite.enseignant.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.akharroub.universite.enseignant.controller.IControllerEnseignant;
import fr.akharroub.universite.enseignant.domain.Enseignant;
import fr.akharroub.universite.enseignant.service.impl.ServiceEnseignant;

@Controller
public class ControllerEnseignant implements IControllerEnseignant{

	Logger log = LoggerFactory.getLogger(ControllerEnseignant.class);
	
	@Autowired
	ServiceEnseignant service ;

	@Override
	@GetMapping("/enseignants")
	public String findAll(Model model) {
		List<Enseignant> list = service.findAll();
		model.addAttribute("enseignant", list);
		return "enseignant/enseignant";
	}

	@Override
	@GetMapping("/enseignant-info")
	public String enseignantInfo(Model model, Integer id) {
		Enseignant ens = service.getOne(id);
		model.addAttribute("enseignant", ens);
		return "enseignant/enseignant-info";
	}

	@Override
	@GetMapping("/ajouter-enseignant")
	public String ajouterEnseignant(Model model) {
		Enseignant enseignant = new Enseignant();
		model.addAttribute("enseignant", enseignant);
		return "enseignant/ajouter";
	}

	@Override
	@PostMapping("/ajouter-enseignant-v")
	public String ajouterEnseignantv(Model model,@ModelAttribute Enseignant enseignant) {
		log.info("nom enseignant = {}" , enseignant.getNom());
		log.info("Prenom enseignant = {}" , enseignant.getPrenom());
		log.info("Date_naissance enseignant = {}" , enseignant.getDate_naissance());
		log.info("Numero_enseignant enseignant = {}" , enseignant.getNumero_enseignant());
		log.info("Date_embauche enseignant = {}" , enseignant.getDate_embauche());
		log.info("Grade enseignant = {}" , enseignant.getGrade());
		log.info("sexe enseignant = {}" , enseignant.getSexe());
		log.info("Photo enseignant = {}" , enseignant.getPhoto());
		
		Enseignant en = service.ajouterEnseignantVD(enseignant);
		
		if(en==null) {
			return "redirect:/ajouter-enseignant";
		}else {
			return "redirect:/enseignants";
		}
		
	}

	@Override
	@GetMapping("/modifier-enseignante")
	public String modifierEnseignant(Model model, @RequestParam("id") Integer id) {
		Enseignant enseignant = service.getOne(id);
		model.addAttribute("enseignant", enseignant);
		return "enseignant/modifier";
	}

	@Override
	@PostMapping("/modifier-enseignante-v")
	public String modifierEnseignantValide(Model model,@ModelAttribute Enseignant enseignant) {
		Enseignant es = service.modifierEnseignant(enseignant);
		
		if(es ==null) {
			return "redirect:/modifier-enseignante";
		}else {
			return "redirect:/enseignants";
		}
		
	}

	@Override
	@GetMapping("/supprimer-enseignante")
	public String supprimer(Model model,@RequestParam("id") Integer id) {
		service.supprimerEnseignant(id);
		return "redirect:/enseignants";
	}
}
