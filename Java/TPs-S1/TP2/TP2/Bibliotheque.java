package TP2;
import java.util.Date;

import java.util.List;
import java.util.ArrayList;

import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Bibliotheque {
	//Les elements d'une meme liste sont de meme type (on peut l'omettre mais on doit a chaque fois utiliser un cast)
	private List<Livre> livres = new ArrayList<Livre>();
	private List<Adherent> adherents = new ArrayList<Adherent>();
	private List<Emprunt> emprunts = new ArrayList<Emprunt>();
	
	public Bibliotheque() {
		
	}
	
	public Adherent rechercherAdherent(int codeAd) throws AdherentInexistantException {
		for(int i=0;i<adherents.size();i++) {
			if(this.adherents.get(i).getCodeAdherent()==codeAd) { 
				return this.adherents.get(i);
			}
		}
		throw new AdherentInexistantException();
	}
	
	public Livre rechercherLivre(int codeL) throws LivreInexistantException{
		for(int i=0;i<livres.size();i++) {
			if(this.livres.get(i).getCodeLivre()==codeL) {
				return this.livres.get(i);
			}
		}
		throw new LivreInexistantException();
	}
	
	public void ajouterLivre(int codeL, String titreL, Auteur auteurL, int nbreExemplaires) throws LivreInexistantException {
		Livre l=this.rechercherLivre(codeL);
		if(l!=null) {
			l.setNbreExemplaires(l.getNbreExemplaires()+nbreExemplaires);
			l.setNbreExemplairesDispo(l.getNbreExemplairesDispo()+nbreExemplaires);
		}
		else {
			l = new Livre(codeL, titreL, auteurL, nbreExemplaires, nbreExemplaires);
			this.livres.add(l);
		}
	}
	
	public void ajouterAdherent(String nom, String prenom) {
		Adherent adherent = new Adherent(nom, prenom);
		this.adherents.add(adherent);
		//possible de cont�ler l'ajout ; unicit� de la cl� (nom,pr�nom)
	}
	
	
	public void ajouterEmprunt(int codeA, int codeL) throws AdherentInexistantException, 
		LivreInexistantException, AjoutEmpruntInexistantException{
		try {
		Livre livre = this.rechercherLivre(codeL);
		if(livre!=null && livre.LivreDisponible()) {
			Adherent adherent = this.rechercherAdherent(codeA);
			if(adherent!=null) {
				Date dateEmprunt= new Date();
				Date dateRetourPrevue = new Date();
				dateRetourPrevue.setDate(dateEmprunt.getDate()+3);
				Emprunt emprunt = new Emprunt(livre, adherent,dateEmprunt,dateRetourPrevue);
				emprunt.getLivre().setNbreExemplairesDispo(emprunt.getLivre().getNbreExemplairesDispo()-1);
				//possible de decr�menter le nombre d'exemplaires disponibles � l'instanciation ou une m�thode d�di�e (Livre, Emprunt??) Discussion sur l'affectation des responsabilit�s
				this.emprunts.add(emprunt);
			}
		}
	}
		catch (LivreInexistantException e) {
			throw new AjoutEmpruntInexistantException();
			}
		catch (AdherentInexistantException e) {
		throw new AjoutEmpruntInexistantException("Ajout impossible: code adhérent erroné !");
		}
	}
	
	public void retourLivre(int codeE) {
		if(codeE<=this.livres.size()+1 && codeE>0) {
			Emprunt emprunt=this.emprunts.get(codeE-1);
			emprunt.retourEmprunt();
		}
	}
	
	public String DetailsEmprunt(int codeE) {
		if(codeE<=this.emprunts.size()+1 && codeE>0) {
			return this.emprunts.get(codeE-1).toString();
		}
		return "Aucun Emprunt";
	}
	
	public List<Adherent> emprunteurs() {
    	HashSet<Adherent> resultat = new HashSet<Adherent>();
    	for(int i = 0; i < emprunts.size(); ++i) {
    		if(emprunts.get(i).etatEmprunt().equals("EN COURS") || emprunts.get(i).etatEmprunt().equals("NON RENDU")) {
    			resultat.add(emprunts.get(i).getEmprunteur());
    		}
    	}
    	return new ArrayList<Adherent>(resultat);
    }
	

	@SuppressWarnings("unchecked")
	public void livresTriesParExemplairesDispo() {
		Collections.sort(livres, new ComparateurExemplairesDispo());	    
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Livre topEmprunt() {
		Map map = new HashMap<Livre, Integer>(); 
		for (Livre l : livres) {
			map.put(l, l.getNbreExemplaires() - l.getNbreExemplairesDispo()); //nbEmprunts = nbExpl - nbExpldispo
		}
		Set<Entry> set = map.entrySet(); //No Duplicate numbers.
		List<Entry> lst = new ArrayList<>();
		lst.addAll(set);
		Collections.sort(lst, new ComparateurEmprunts());
		Livre topEmprunt = (Livre) lst.get(0).getKey();
		return topEmprunt;
		
	}
	@Override
	public String toString() {
		return "Bibliotheque [livres=" + livres + ", adherents=" + adherents + ", emprunts=" + emprunts
				+ ", emprunteurs()=" + emprunteurs() + ", topEmprunt()=" + topEmprunt() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}
