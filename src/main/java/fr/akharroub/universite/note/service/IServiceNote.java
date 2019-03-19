package fr.akharroub.universite.note.service;

import java.util.List;

import fr.akharroub.universite.note.domain.Note;

public interface IServiceNote {

	public List<Note> findAll();
	
	public Note save(Note note);
	
	public Note findOne(Integer idMatiere, Integer idEtudiant);
}
