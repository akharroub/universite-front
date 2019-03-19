package fr.akharroub.universite.enseignant.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.akharroub.universite.enseignant.domain.Enseignant;
import fr.akharroub.universite.enseignant.repository.IRepositoryEnseignant;
import fr.akharroub.universite.enseignant.service.IServiceEnseignant;

@Service
public class ServiceEnseignant implements IServiceEnseignant{
	
	Logger log =LoggerFactory.getLogger(ServiceEnseignant.class);
	
	@Autowired
	IRepositoryEnseignant repository;

	@Override
	public List<Enseignant> findAll() {
		List<Enseignant> ttLesEnseignant = repository.findAll();
		
		//vérifier l'image pour chaque enseignant
		//Si l'enseignant ne posséde pas d'image on lui donne une image par default
		//http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg
		
		for( int i=0 ; i < ttLesEnseignant.size() ; i++) {
			Enseignant e = ttLesEnseignant.get(i);
			log.info("Image de l'enseignant : {} ", e.getPhoto());
			if(e.getPhoto()== null || e.getPhoto().equals("")) {
				ttLesEnseignant.get(i).setPhoto("http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg");
			}
		}
		return ttLesEnseignant;
	}

	@Override
	public Enseignant getOne(Integer id) {
		Enseignant en = repository.getOne(id);
		if(en.getPhoto()== null || en.getPhoto().equals("")) {
			en.setPhoto("http://bibliotheque.sciencespo-lyon.fr/wp-content/uploads/2018/10/des-enseignants-de-lecture_318-28655.jpg");
		}
		return en;
	}

	@Override
	public Enseignant ajouterEnseignantVD(Enseignant enseignant) {
		Enseignant es = repository.save(enseignant);
		return es;
	}

	@Override
	public Enseignant modifierEnseignant(Enseignant enseignant) {
		Integer id = enseignant.getId();
		 repository.update(enseignant ,id);
		 Enseignant eg = repository.getOne(id);
		return eg;
	}

	@Override
	public void supprimerEnseignant(Integer id) {
		repository.deleteById(id);
		
	}

	

}
