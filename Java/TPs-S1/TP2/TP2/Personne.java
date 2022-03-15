package TP2;

public abstract class Personne {
	private String nom;
	private String prenom;
	
	public Personne() {
		
	}
	public Personne(String nom, String prenom) {
		this.nom=nom;
		this.prenom=prenom;
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
	
	
	@Override
	public String toString() {
		return this.getNom()+" "+this.getPrenom();
	}
	
	@Override
	public boolean equals(Object o) {
		try {
			Personne p = (Personne) o;
			return this.getNom().equals(p.getNom()) && this.getPrenom().equals(p.getPrenom());
		}
		catch (ClassCastException e) {
			return false;
		}
		
	}
	
}
