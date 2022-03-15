package TP2;
class CodeAutException extends Exception{
	public CodeAutException () {
		super("Le code de l'auteur doit être alphanumérique et codé sur quatre chiffres!");
	}
}

class AdherentInexistantException extends Exception {
	public AdherentInexistantException() {
		super("L'adherent n'existe pas !");
	}
}

class LivreInexistantException extends Exception {
	public LivreInexistantException() {
		super("Le livre n'existe pas !");
	}
}

class AjoutEmpruntInexistantException extends Exception {
	public AjoutEmpruntInexistantException() {
		super("Ajout impossible: code livre erroné !");
	}
	
	public AjoutEmpruntInexistantException(String msg) {
		super(msg);
	}
}

