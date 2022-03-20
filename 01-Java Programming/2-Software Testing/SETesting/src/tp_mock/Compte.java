package tp_mock;

public interface Compte {
	public String getNomUtilisateur();
	public boolean validerMotPasse(String motPasse);
	public boolean estConnecte();
	public void setConnecte(boolean valeur);
	public boolean estBloque();
	public void setBloque(boolean value);
}
