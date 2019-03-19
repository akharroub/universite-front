package fr.akharroub.universite.matiere.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.akharroub.universite.matiere.domain.Matiere;
import fr.akharroub.universite.matiere.repository.IRepositoryMatiere;
@Repository
public class RepositoryMatiere implements IRepositoryMatiere{

	RestTemplate ret = new RestTemplate();
	
	@Override
	public List<Matiere> findAll() {
		List<Matiere> ma = ret.exchange("http://localhost:8080/matieres", HttpMethod.GET,null,new ParameterizedTypeReference<List<Matiere>>(){}).getBody(); 
		return ma;
	}

	@Override
	public Matiere getOne(Integer id) {
		Matiere mt = ret.getForObject("http://localhost:8080/matieres/" + id, Matiere.class);
		return mt;
	}

	@Override
	public Matiere save(Matiere matiere) {
		Matiere mtr = ret.postForObject("http://localhost:8080/matieres", matiere, Matiere.class);
		return mtr;
	}

	@Override
	public void delete(Integer id) {
		ret.delete("http://localhost:8080/matieres/" + id, Matiere.class);
		
	}

	@Override
	public void update(Matiere matiere, Integer id) {
		ret.put("http://localhost:8080/matieres/" + id, matiere, Matiere.class);
		
	}

	
}
