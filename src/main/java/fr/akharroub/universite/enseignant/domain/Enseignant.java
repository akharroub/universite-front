package fr.akharroub.universite.enseignant.domain;

import java.io.Serializable;
import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;


public class Enseignant implements Serializable{


	private static final long serialVersionUID = 7010547430508203324L;


	private Integer id;


	private Integer numero_enseignant;


	private String nom;


	private String prenom;


	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_naissance;


	private Character sexe;


	private String grade;


	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date_embauche;


	private String photo;



	public String getPhoto() {
		return photo;
	}



	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero_enseignant() {
		return numero_enseignant;
	}

	public void setNumero_enseignant(Integer numero_enseignant) {
		this.numero_enseignant = numero_enseignant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public Character getSexe() {
		return sexe;
	}

	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getDate_embauche() {
		return date_embauche;
	}

	public void setDate_embauche(Date date_embauche) {
		this.date_embauche = date_embauche;
	}

}
