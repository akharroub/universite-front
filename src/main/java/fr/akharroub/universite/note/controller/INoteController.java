package fr.akharroub.universite.note.controller;

import org.springframework.ui.Model;

import fr.akharroub.universite.note.domain.Note;

public interface INoteController {

	public String findAll(Model model);
	
	public String AddNote(Model model);
	
	public String AddNoteV(Model model,Note note);
	
	public String modifiernote(Model model , Integer idMatiere , Integer idEtudiant);
	
	
}
