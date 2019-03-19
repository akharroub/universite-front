package fr.akharroub.universite.etudiant.service;

import java.util.List;

import fr.akharroub.universite.etudiant.domain.Etudiant;

public interface IServiceEtudiant {

	public List<Etudiant> getAll();

	public Etudiant getOne(Integer id);

	public Etudiant ajouteretudiantV(Etudiant etudiant);
	
	public Etudiant ModefierEtudientV(Etudiant etudiant);
	
	public void supprimerEtudiant(Integer id);

}
