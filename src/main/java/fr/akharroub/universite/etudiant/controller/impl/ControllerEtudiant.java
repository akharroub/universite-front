package fr.akharroub.universite.etudiant.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.akharroub.universite.etudiant.controller.IControllerEtudiant;
import fr.akharroub.universite.etudiant.domain.Etudiant;
import fr.akharroub.universite.etudiant.service.impl.ServiceEtudiant;

@Controller
public class ControllerEtudiant implements IControllerEtudiant {

	@Autowired
	ServiceEtudiant serviceEtudiant;
	
	@Override
	@GetMapping("/etudiants")
	public String findAll(Model model) {
		List<Etudiant> liste = serviceEtudiant.getAll();
		model.addAttribute("etudiant", liste);
		return "etudiant/etudiant";
	}

	@Override
	@GetMapping("/etudiant-info")
	public String findOne(Model model, Integer id) {
		Etudiant ed = serviceEtudiant.getOne(id);
		model.addAttribute("etudiant", ed);
		return "etudiant/info-etudiant";
	}

	@Override
	@GetMapping("/formulaire-ajouter")
	public String ajouterEtudiant(Model model) {
		Etudiant etudiant = new Etudiant();
		model.addAttribute("etudiant", etudiant);
		return "etudiant/ajouter";
	}

	@Override
	@PostMapping("/ajouter-v")
	public String ajouterEtudientV(Model model,@ModelAttribute Etudiant etudiant) {
		Etudiant eu = serviceEtudiant.ajouteretudiantV(etudiant);
		
		if(eu == null) {
			return "redirect:/formulaire-ajouter";
		}else {
			return "redirect:/etudiants";
		}
		
		
	}

	@Override
	@GetMapping("/modifier")
	public String modifierEtudiant(Model model,@RequestParam("id") Integer id) {
		Etudiant etu = serviceEtudiant.getOne(id);
		model.addAttribute("etudiant", etu);
		return "etudiant/modefier";
	}

	@Override
	@PostMapping("/modifier-V")
	public String modifierEtudientV(Model model, @ModelAttribute Etudiant etudiant) {
		Etudiant et = serviceEtudiant.ModefierEtudientV(etudiant);
		if(et == null) {
			return "redirect:/modifier";
		}else {
			return "redirect:/etudiants";
		}
	}

	@Override
	@GetMapping("/supprimer_etudiant")
	public String Supprimer(Model model,@RequestParam("id") Integer id) {
		serviceEtudiant.supprimerEtudiant(id);
		return "redirect:/etudiants";
	}

}
