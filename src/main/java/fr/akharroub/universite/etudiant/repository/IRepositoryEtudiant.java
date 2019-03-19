package fr.akharroub.universite.etudiant.repository;

import java.util.List;

import fr.akharroub.universite.etudiant.domain.Etudiant;

public interface IRepositoryEtudiant {

	List<Etudiant> findAll();

	Etudiant getOne(Integer id);

	Etudiant save(Etudiant etudiant);

	void deleteById(Integer id);
	
	public void update(Etudiant etudiant, Integer id);

}
