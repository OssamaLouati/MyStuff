package tp_mock;

import java.util.HashMap;
import java.util.Map;

public class GestionnaireSessions {
	public class Etat {
		int tentativesInfructueuses;
	}
	private GestionnaireComptes gestionnaireComptes;
	private Map<Compte, Etat> etats; 
	public GestionnaireSessions(GestionnaireComptes gestionnaireComptes) {
		this.gestionnaireComptes = gestionnaireComptes;
		this.etats = new HashMap<Compte, Etat>();
	}
	private Etat getEtat(Compte compte) {
		Etat etat = etats.get(compte);
		if (etat == null) {
			etat = new Etat();
			etats.put(compte, etat);
		}
		return etat;
	}
	public GestionnaireComptes getGestionnaireComptes() {
		return this.gestionnaireComptes;
	}
	public boolean connecter(String nomUtilisateur, String motPasse) {
		Compte compte;
		try {
			compte = this.gestionnaireComptes.rechercherParNomUtilisateur(nomUtilisateur);
			if (compte.estBloque()) return false;
			if (compte.estConnecte()) return false;
			if (compte.validerMotPasse(motPasse)) {
				compte.setConnecte(true);
				return true;
			}
			Etat etat = getEtat(compte);
			etat.tentativesInfructueuses += 1;
			if (etat.tentativesInfructueuses >= 3) {
				compte.setBloque(true);
			}
		} catch (CompteInexistantException e) {
			//e.printStackTrace();
		}
		return false;
	}
}
