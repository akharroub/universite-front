package fr.akharroub.universite.etudiant.controller;

import org.springframework.ui.Model;

import fr.akharroub.universite.etudiant.domain.Etudiant;

public interface IControllerEtudiant {
	
	public String findAll(Model model);
	
	public String findOne(Model model, Integer id);
	
	public String ajouterEtudiant(Model model);
	
	public String ajouterEtudientV(Model model , Etudiant etudiant);
	
	public String modifierEtudiant(Model model , Integer id);
	
	public String modifierEtudientV(Model model , Etudiant etudiant);
	
	public String Supprimer(Model model , Integer id);

}
