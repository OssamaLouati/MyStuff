package TP2;
public class Livre{
	private int codeLivre;
	private String titreLivre;
	private Auteur auteur;
	private int nbreExemplaires;
	private int nbreExemplairesDispo;
	
	public int getCodeLivre() {
		return codeLivre;
	}

	public void setCodeLivre(int codeLivre) {
		this.codeLivre = codeLivre;
	}

	public String getTitreLivre() {
		return titreLivre;
	}

	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public int getNbreExemplaires() {
		return nbreExemplaires;
	}

	public void setNbreExemplaires(int nbreExemplaires) {
		this.nbreExemplaires = nbreExemplaires;
	}

	public int getNbreExemplairesDispo() {
		return nbreExemplairesDispo;
	}

	public void setNbreExemplairesDispo(int nbreExemplairesDispo) {
		this.nbreExemplairesDispo = nbreExemplairesDispo;
	}

	public Livre(int codeL, String titreL, Auteur auteur, int nbreExemplaires, int nbreExemplaireDispo) {
		this.codeLivre=codeL;
		this.titreLivre=titreL;
		this.auteur=auteur;
		this.nbreExemplaires=nbreExemplaires;
		this.nbreExemplairesDispo=nbreExemplaireDispo;
	}
	
	public boolean LivreDisponible() {
		return this.nbreExemplairesDispo>0;
	}
	
	public void retourLivre() {
		this.nbreExemplairesDispo++;
	}

	@Override
	public String toString() {
		return this.getCodeLivre()+" "+this.getTitreLivre()+" "+this.getNbreExemplairesDispo();
	}
}
