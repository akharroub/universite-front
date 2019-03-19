package fr.akharroub.universite.matiere.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.akharroub.universite.matiere.domain.Matiere;
import fr.akharroub.universite.matiere.repository.IRepositoryMatiere;
import fr.akharroub.universite.matiere.service.IServiceMatiere;
@Service
public class ServiceMatiere implements IServiceMatiere{
	
	@Autowired
	IRepositoryMatiere serviceMatiere;

	@Override
	public List<Matiere> findAll() {
		List<Matiere> ma = serviceMatiere.findAll();
		return ma;
	}

	@Override
	public Matiere findOne(Integer id) {
		Matiere matiere = serviceMatiere.getOne(id);
		return matiere;
	}

	@Override
	public Matiere ajouterMatiere(Matiere matiere) {
		Matiere mt = serviceMatiere.save(matiere);
		return mt;
	}

	@Override
	public Matiere modifierMatiere(Matiere matiere) {
		
		Matiere mt = serviceMatiere.save(matiere);
		return mt;
	}

	@Override
	public void suprrimeMatiere(Integer id) {
		serviceMatiere.delete(id);
		
	}

}
