package fr.akharroub.universite.note.repository;

import java.util.List;

import fr.akharroub.universite.note.domain.Note;
import fr.akharroub.universite.note.domain.NotePK;

public interface IRepositoryNote {

	List<Note> findAll();

	Note save(Note note);

	Note getOne(NotePK npk);

}
