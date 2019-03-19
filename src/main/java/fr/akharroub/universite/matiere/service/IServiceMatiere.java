package fr.akharroub.universite.matiere.service;

import java.util.List;

import fr.akharroub.universite.matiere.domain.Matiere;

public interface IServiceMatiere {
	
	public List<Matiere> findAll();
	
	public Matiere findOne(Integer id);
	
	public Matiere ajouterMatiere(Matiere matiere);
	
	public Matiere modifierMatiere(Matiere matiere);
	
	public void suprrimeMatiere(Integer id);

}
