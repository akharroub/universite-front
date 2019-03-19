package fr.akharroub.universite.matiere.repository;

import java.util.List;

import fr.akharroub.universite.matiere.domain.Matiere;

public interface IRepositoryMatiere {

	List<Matiere> findAll();

	Matiere getOne(Integer id);

	Matiere save(Matiere matiere);
	
	public void delete(Integer id);
	
	public void update(Matiere matiere, Integer id);

}
