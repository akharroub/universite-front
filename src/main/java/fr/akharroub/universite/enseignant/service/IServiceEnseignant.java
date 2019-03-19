package fr.akharroub.universite.enseignant.service;

import java.util.List;

import fr.akharroub.universite.enseignant.domain.Enseignant;

public interface IServiceEnseignant {
	
	public List<Enseignant> findAll();
	
	public Enseignant getOne(Integer id);
	
	public Enseignant ajouterEnseignantVD(Enseignant enseignant);
	
	public Enseignant modifierEnseignant(Enseignant enseignant); 
	
	public void supprimerEnseignant(Integer id);

}
