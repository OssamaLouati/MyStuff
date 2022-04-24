package TP2;
public class Auteur extends Personne {
	private String codeAuteur;

	private Auteur(String nom,String prenom, String codeAuteur) throws CodeAutException {
		super(nom,prenom);
		if (verifierCodeAut(codeAuteur)) {this.codeAuteur = codeAuteur;}
		else {throw new CodeAutException();}
	}
	
	private static boolean verifierCodeAut(String code) {
		if (code.length() == 4) {
			int i;
			for (i = 0; i < code.length(); ++i) {
				if (Character.isDigit(code.charAt(i)) == false) {
					break;
				}
				if (i == code.length() - 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String getCodeAuteur() {
		return codeAuteur;
	}

	public void setCodeAuteur(String codeAuteur) {
		this.codeAuteur = codeAuteur;
	}
	
	@Override
	public String toString() {
		return this.getCodeAuteur()+"_"+super.toString();
	}

}
