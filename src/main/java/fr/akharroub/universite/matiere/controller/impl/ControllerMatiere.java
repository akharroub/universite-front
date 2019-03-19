package fr.akharroub.universite.matiere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.akharroub.universite.enseignant.domain.Enseignant;
import fr.akharroub.universite.enseignant.service.impl.ServiceEnseignant;
import fr.akharroub.universite.matiere.controller.IControllerMatiere;
import fr.akharroub.universite.matiere.domain.Matiere;
import fr.akharroub.universite.matiere.service.impl.ServiceMatiere;
@Controller
public class ControllerMatiere implements IControllerMatiere{
	
	@Autowired
	ServiceMatiere controllereMatiere;
	@Autowired
	ServiceEnseignant controlEnseignant;

	@Override
	@GetMapping("/matieres")
	public String findAll(Model model) {
		List<Matiere> ttMatiere = controllereMatiere.findAll();
		model.addAttribute("matiere", ttMatiere);
		return "matiere/matiere";
	}

	@Override
	@GetMapping("/matiere-info")
	public String findOne(Model model, Integer id) {
		Matiere ma = controllereMatiere.findOne(id);
		model.addAttribute("matiere", ma);
		List<Enseignant> liste = controlEnseignant.findAll();
		model.addAttribute("listeEnseignant", liste);
		return "matiere/matiere-info";
	}

	@Override
	@GetMapping("/ajouter-matiere")
	public String AjouterMatiere(Model model) {
		Matiere mm = new Matiere();
		model.addAttribute("matiere", mm);
		List<Enseignant> liste = controlEnseignant.findAll();
		model.addAttribute("listeEnseignants", liste);
		return"matiere/ajouter";
	}

	@Override
	@PostMapping("/modifier_v")
	public String AjouterMatiereV(Model model, @ModelAttribute Matiere matiere) {
		controllereMatiere.ajouterMatiere(matiere);
		return "redirect:/matiers";
	}

	@Override
	@GetMapping("/modifier-matiere")
	public String modifierMatiere(Model model, @RequestParam("id") Integer id) {
		Matiere mtr = controllereMatiere.findOne(id);
		model.addAttribute("matiere", mtr);
		
		List<Enseignant> liste = controlEnseignant.findAll();
		model.addAttribute("listeEnseignants", liste);
		return "matiere/modifiereMatiere";
	}

	@Override
	@PostMapping("/modifiere-v-m")
	public String modifierMatiereV(Model model, @ModelAttribute Matiere matiere) {
		Matiere m = controllereMatiere.modifierMatiere(matiere);
		if(m == null) {
			return "redirect:/modifier-matiere";
		}else {
			return "redirect:/matiers";
		}
		
	}

	@Override
	@GetMapping("/supprimer-matiere")
	public String supprimer(Model model,@RequestParam("id") Integer id) {
		controllereMatiere.suprrimeMatiere(id);
		return "redirect:/matieres";
	}

}
