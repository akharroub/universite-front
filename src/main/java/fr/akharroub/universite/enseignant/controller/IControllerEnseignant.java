package fr.akharroub.universite.enseignant.controller;

import org.springframework.ui.Model;

import fr.akharroub.universite.enseignant.domain.Enseignant;

public interface IControllerEnseignant {
	
	public String findAll(Model model);
	
	public String enseignantInfo(Model model, Integer id );
	
	public String ajouterEnseignant(Model model);
	public String ajouterEnseignantv(Model model,Enseignant enseignant);
	
	public String modifierEnseignant(Model model,Integer id);
	public String modifierEnseignantValide(Model model,Enseignant enseignant);
	
	public String supprimer(Model model,Integer id);

}
