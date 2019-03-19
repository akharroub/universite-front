package fr.akharroub.universite.note.domain;

import java.io.Serializable;



public class NotePK implements Serializable{


	private static final long serialVersionUID = -8334815162066288070L;

	
	private Integer etudiant;
	
	
	private Integer matiere;

	public Integer getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Integer etudiant) {
		this.etudiant = etudiant;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}
	
}
