package fr.akharroub.universite.enseignant.repository.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import fr.akharroub.universite.enseignant.domain.Enseignant;
import fr.akharroub.universite.enseignant.repository.IRepositoryEnseignant;
@Repository
public class RepositoryEnseignant implements IRepositoryEnseignant{

	RestTemplate rt = new RestTemplate();
	
	@Override
	public List<Enseignant> findAll() {
		
		List<Enseignant> liste = rt.exchange("http://localhost:8080/enseignants", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Enseignant>>(){}).getBody() ; 
		return liste;
	}

	@Override
	public Enseignant getOne(Integer id) {
		
		Enseignant e = rt.getForObject("http://localhost:8080/enseignants/" + id, Enseignant.class);
		return e;
	}

	@Override
	public Enseignant save(Enseignant enseignant) {
		Enseignant en = rt.postForObject("http://localhost:8080/enseignants", enseignant, Enseignant.class);
		return en;
	}

	@Override
	public void deleteById(Integer id) {
		rt.delete("http://localhost:8080/enseignants/" + id, Enseignant.class);
		
	}

	@Override
	public void update(Enseignant enseignant, Integer id) {
		rt.put("http://localhost:8080/enseignants/" + id, enseignant, Enseignant.class);
		
	}

}
