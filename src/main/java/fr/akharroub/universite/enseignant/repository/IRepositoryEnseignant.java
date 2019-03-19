package fr.akharroub.universite.enseignant.repository;

import java.util.List;

import fr.akharroub.universite.enseignant.domain.Enseignant;

public interface IRepositoryEnseignant {

	List<Enseignant> findAll();

	Enseignant getOne(Integer id);

	Enseignant save(Enseignant enseignant);

	void deleteById(Integer id);
	
	public void update(Enseignant enseignant, Integer id);
	
	

}
