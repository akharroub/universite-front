package fr.akharroub.universite.note.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.akharroub.universite.note.domain.Note;
import fr.akharroub.universite.note.domain.NotePK;
import fr.akharroub.universite.note.repository.IRepositoryNote;
import fr.akharroub.universite.note.service.IServiceNote;
@Service
public class ServiceNote  implements IServiceNote{

	@Autowired
	IRepositoryNote service;
	
	@Override
	public List<Note> findAll() {
		List<Note> nn = service.findAll();
		return nn;
	}

	@Override
	public Note save(Note note) {
		Note n = service.save(note);
		return n;
	}

	@Override
	public Note findOne(Integer idMatiere, Integer idEtudiant) {
		
		NotePK npk = new NotePK();
		npk.setEtudiant(idEtudiant);
		npk.setMatiere(idMatiere);
		
		Note n = service.getOne(npk);
		return n;
	}

}
