package TP2;
import java.util.Date;

public class Emprunt {
	private int codeEmprunt;
	private Livre livre;
	private Adherent emprunteur;
	private Date dateEmprunt;
	private Date dateRetourPrevue;
	private Date dateRetourEffective;
	private static int NbreEmprunts=0;
	
	
	
	public Emprunt(Livre livre, Adherent emprunteur, Date dateEmprunt, Date dateRetourPrevue) {
		this.codeEmprunt=++Emprunt.NbreEmprunts;
		this.livre=livre;
		this.emprunteur=emprunteur;
		this.dateEmprunt=dateEmprunt;
		this.dateRetourPrevue=dateEmprunt;
		this.dateRetourPrevue=dateRetourPrevue;
		//dur�e normal emprunt =3 jours
		//this.dateRetourPrevue.setDate(this.dateRetourPrevue.getDate()+3);
		this.dateRetourEffective=null;
	}
	
	public Livre getLivre() {
		return this.livre;
	}
	
	public Adherent getEmprunteur() {
		return this.emprunteur;
	}
	
	public EtatEmprunt etatEmprunt() {
		if(this.dateRetourEffective!=null) return EtatEmprunt.RENDU;
		else if(this.dateRetourPrevue.after(new Date())) return EtatEmprunt.ENCOURS;
		else return EtatEmprunt.NONRENDU;
	}
	
	public void retourEmprunt() {
		this.dateRetourEffective= new Date();
		this.livre.retourLivre();
	}
	
	public String toString() {
		return this.codeEmprunt+" "+this.livre.getTitreLivre()+" "+this.emprunteur+" "+this.etatEmprunt();
	}
	
}
