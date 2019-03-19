 console.log("ca marche ");
function validerLeFormulaire() {


	let nomElement = document.getElementById("nom");
	let nom = nomElement.value;
	if(nom === ""){
		nomElement.classList.add("erreur");
	}else{
		nomElement.classList.remove("erreur");
	}
	

//	check prenom
	let prenomBlock = document.getElementById("prenom");
	let prenom = prenomBlock.value;

	if(prenom === ""){
		prenomBlock.classList.add("erreur");
	}else{
		prenomBlock.classList.remove("erreur");
	}
	
	

	
	
//	check numero enseignant
	let numeroBlock = document.getElementById("numero");
	let numero = numeroBlock.value;
	
	if(numero === "" ){
		numeroBlock.classList.add("erreur");
	}else{
		numeroBlock.classList.remove("erreur");
	}
	
//	check date de naissance
	let dateNaissanceElement = document.getElementById("date_naissance");
	let dateNaissance = dateNaissanceElement.value;
	
	if(dateNaissance === ""){
		dateNaissanceElement.classList.add("erreur");
	}else{
		dateNaissanceElement.classList.remove("erreur");
	}
	

	
	// check photo 
	let photoBlock = document.getElementById("photo");
	let photo = photoBlock.value;
	
	if(photo === ""){
		photoBlock.classList.add("erreur");
	}else{
		photoBlock.classList.remove("erreur");
	}
	
	
	
	let lesClassErreur = document.getElementsByClassName("erreur");
	console.log(lesClassErreur);
	console.log("taille du tableau" + lesClassErreur.length);
	
	if(lesClassErreur.length === 0){
		console.log("envoyer le formulaire");
		document.getElementById("formulaire").submit();
	}
	
}