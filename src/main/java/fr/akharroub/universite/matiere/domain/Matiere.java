package fr.akharroub.universite.matiere.domain;

import java.io.Serializable;

import fr.akharroub.universite.enseignant.domain.Enseignant;


public class Matiere implements Serializable{
	

	private static final long serialVersionUID = 2670707118455237473L;


	private Integer id;
	
	
	private Integer numero ;

	private String nom ;
	
	
	private Integer coef;
	
	
	private Enseignant enseignant;
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCoef() {
		return coef;
	}

	public void setCoef(Integer coef) {
		this.coef = coef;
	}
	

}
