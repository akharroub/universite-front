package fr.akharroub.universite.note.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.akharroub.universite.etudiant.domain.Etudiant;
import fr.akharroub.universite.etudiant.service.impl.ServiceEtudiant;
import fr.akharroub.universite.matiere.domain.Matiere;
import fr.akharroub.universite.matiere.service.impl.ServiceMatiere;
import fr.akharroub.universite.note.controller.INoteController;
import fr.akharroub.universite.note.domain.Note;
import fr.akharroub.universite.note.domain.NotePK;
import fr.akharroub.universite.note.service.impl.ServiceNote;
@Controller
public class NoteController implements INoteController {

	Logger log = LoggerFactory.getLogger(NoteController.class);
@Autowired
ServiceNote controller ;

@Autowired
ServiceEtudiant contrellerEtudiant;

@Autowired
ServiceMatiere controllerMatiere;

	@Override
	@GetMapping("/notes")
	public String findAll(Model model) {
		List<Note> ttLesNote = controller.findAll();
		model.addAttribute("note", ttLesNote);
		return "note/note";
	}

	@Override
	@GetMapping("/note-add")
	public String AddNote(Model model) {
		
		Note note = new Note();
		model.addAttribute("note", note);
		
		List<Etudiant> etudiant = contrellerEtudiant.getAll();
		model.addAttribute("etudiant", etudiant);
		
		List<Matiere> matiere = controllerMatiere.findAll();
		model.addAttribute("matiere", matiere);
		return "note/add-note";
	}

	@Override
	@PostMapping("/valider-note-add")
	public String AddNoteV(Model model, @ModelAttribute("note") Note note) {
		

		log.info("note:{} ",note.getNote());
		log.info("ID etudiant:{} ",note.getEtudiant().getId());
		log.info("ID matiere:{} ",note.getMatiere().getId());
		log.info("notePk:{} ",note.getNotePK());
		
		NotePK npk = new NotePK();//construire  un objet notepk
		npk.setEtudiant(note.getEtudiant().getId());// lui affecter l'id de l'etudiant
		npk.setMatiere(note.getMatiere().getId());// lui affecter l'id de l'matiere
		//affecter une valeur a la variable notepk
		//de l'objet note
		note.setNotePK(npk);
		
		controller.save(note);
		
		return "redirect:/notes";
	}

	@Override
	@GetMapping("/modifier-note")
	public String modifiernote(Model model,@RequestParam("idMatiere") Integer idMatiere,@RequestParam("idEtudiant") Integer idEtudiant) {
		Note n = controller.findOne(idMatiere, idEtudiant);
		model.addAttribute("note", n);
		return "note/modifier-note";
	}

}
