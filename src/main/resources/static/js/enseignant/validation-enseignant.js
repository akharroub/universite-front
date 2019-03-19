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
	
	
//	check grade
	let GradeElement = document.getElementById("grade");
	let Grade = GradeElement.value;

	if(Grade === "" || grade.longth > 3)

	{
		console.log("Grade non valide");
		GradeElement.classList.add("erreur");
	}else{
		GradeElement.classList.remove("erreur");
	}
	
	
//	check numero enseignant
	let numeroBlock = document.getElementById("numero_enseignant");
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
	
//	check date de embauche
	let dateEmbaucheElement = document.getElementById("date_embauche");
	let dateEmbauche = dateEmbaucheElement.value;
	
	if(dateEmbauche === ""){
		dateEmbaucheElement.classList.add("erreur");
	}else{
		dateEmbaucheElement.classList.remove("erreur");
	}
	
	// check photo 
	let photoBlock = document.getElementById("photo");
	let photo = photoBlock.value;
	
	if(photo === ""){
		photoBlock.classList.add("erreur");
	}else{
		photoBlock.classList.remove("erreur");
	}
	
	//date
	let dateDeNaissanceElement = document.getElementById("date_naissance");
	let dateDeNaissanceDate = new Date(dateDeNaissanceElement.value);
	
	let dateDeEmbaucheElement = document.getElementById("date_embauche");
	let dateDeEmbaucheDate = new Date(dateDeEmbaucheElement.value);
	
	if(dateDeNaissanceDate > dateDeEmbaucheDate){
		dateDeEmbaucheElement.classList.add("erreur");
		dateDeNaissanceElement.classList.add("erreur");
	}else{
		dateDeEmbaucheElement.classList.remove("erreur");
		dateDeNaissanceElement.classList.remove("erreur");
	}
	
	
	let lesClassErreur = document.getElementsByClassName("erreur");
	console.log(lesClassErreur);
	console.log("taille du tableau" + lesClassErreur.length);
	
	if(lesClassErreur.length === 0){
		console.log("envoyer le formulaire");
		document.getElementById("formulaire").submit();
	}
	
}