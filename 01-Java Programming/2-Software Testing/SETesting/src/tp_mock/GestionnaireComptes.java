package tp_mock;

public interface GestionnaireComptes {
	public Compte rechercherParNomUtilisateur(String nomUtilisateur) 
			throws CompteInexistantException;
	public Compte creerCompte(String nomUtilisateur, String motPasse);
	public boolean supprimerCompte(Compte compte);
}
