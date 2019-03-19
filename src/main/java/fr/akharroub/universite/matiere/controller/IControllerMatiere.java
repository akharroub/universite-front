package fr.akharroub.universite.matiere.controller;

import org.springframework.ui.Model;

import fr.akharroub.universite.matiere.domain.Matiere;

public interface IControllerMatiere {
	
	public String findAll(Model model);
	
	public String findOne(Model model,Integer id);
	
	public String AjouterMatiere(Model model);
	public String AjouterMatiereV(Model model, Matiere matiere);
	
	public String modifierMatiere(Model model, Integer id);
	public String modifierMatiereV(Model model, Matiere matiere);
	
	public String supprimer(Model model,Integer id);

}
