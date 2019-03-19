package fr.akharroub.universite.note.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.akharroub.universite.note.domain.Note;
import fr.akharroub.universite.note.domain.NotePK;
import fr.akharroub.universite.note.repository.IRepositoryNote;
@Repository
public class RepositoryNote implements IRepositoryNote{

	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note save(Note note) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note getOne(NotePK npk) {
		// TODO Auto-generated method stub
		return null;
	}

}
