package fr.akharroub.universite.etudiant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.akharroub.universite.etudiant.domain.Etudiant;
import fr.akharroub.universite.etudiant.repository.IRepositoryEtudiant;
import fr.akharroub.universite.etudiant.service.IServiceEtudiant;
@Service
public class ServiceEtudiant implements IServiceEtudiant{
	
	@Autowired
	IRepositoryEtudiant repositoryEtudiant;

	@Override
	public List<Etudiant> getAll() {
		List<Etudiant> etudiant = repositoryEtudiant.findAll();
		
		for(int i=0 ; i < etudiant.size();i++) {
			Etudiant et = etudiant.get(i);
			if(et.getPhoto()==null || et.getPhoto().equals("")) {
				etudiant.get(i).setPhoto("https://previews.123rf.com/images/olejio/olejio1712/olejio171200029/91292716-silhouette-d-%C3%A9tudiant-au-baccalaur%C3%A9at-avec-dipl%C3%B4me-en-main-logo-de-studiyng-illustration-vectorielle.jpg");
			}
		}
		
		
		return etudiant;
	}

	@Override
	public Etudiant getOne(Integer id) {
		Etudiant ed = repositoryEtudiant.getOne(id);
		if(ed.getPhoto()==null || ed.getPhoto().equals("")) {
			ed.setPhoto("https://previews.123rf.com/images/olejio/olejio1712/olejio171200029/91292716-silhouette-d-%C3%A9tudiant-au-baccalaur%C3%A9at-avec-dipl%C3%B4me-en-main-logo-de-studiyng-illustration-vectorielle.jpg");
		}
		return ed;
	}

	@Override
	public Etudiant ajouteretudiantV(Etudiant etudiant) {
		Etudiant ed = repositoryEtudiant.save(etudiant);
		return ed;
	}

	@Override
	public Etudiant ModefierEtudientV(Etudiant etudiant) {
		Integer id = etudiant.getId();
		repositoryEtudiant.update(etudiant ,id);
		Etudiant et = repositoryEtudiant.getOne(id);
		return et;
	}

	@Override
	public void supprimerEtudiant(Integer id) {
		repositoryEtudiant.deleteById(id);
		
	}

}
