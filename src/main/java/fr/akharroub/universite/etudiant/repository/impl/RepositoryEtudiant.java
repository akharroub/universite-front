package fr.akharroub.universite.etudiant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.akharroub.universite.etudiant.domain.Etudiant;
import fr.akharroub.universite.etudiant.repository.IRepositoryEtudiant;
@Repository
public class RepositoryEtudiant implements IRepositoryEtudiant{

	RestTemplate rest = new RestTemplate();
	
	@Override
	public List<Etudiant> findAll() {
		
		List<Etudiant> liste = rest.exchange("http://localhost:8080/etudiants", HttpMethod.GET,null,new ParameterizedTypeReference<List<Etudiant>>(){}).getBody();
		return liste;
	}

	@Override
	public Etudiant getOne(Integer id) {
		
		Etudiant et = rest.getForObject("http://localhost:8080/etudiants/" + id, Etudiant.class);

		return et;
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		Etudiant etd = rest.postForObject("http://localhost:8080/etudiants", etudiant, Etudiant.class);
		return etd;
	}

	@Override
	public void deleteById(Integer id) {
		rest.delete("http://localhost:8080/etudiants/" + id,Etudiant.class);
		
	}

	@Override
	public void update(Etudiant etudiant, Integer id) {
		rest.put("http://localhost:8080/etudiants/" + id , etudiant ,Etudiant.class);
		
	}

}
