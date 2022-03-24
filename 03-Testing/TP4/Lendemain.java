package TP4;

public class Lendemain {
	public Lendemain()
	{ 
		
	}
	
	
	/*********************************************************
	**M�thode: jourSuivant
	**Retour: string
	**Description: la m�thode renvoie une chaine de caract�res correspondant � la date 
	du lendemain selon le format JJ/MM/AA 
	***********************************************************/
	
	public String jourSuivant( int jour, int mois, int annee) {
		
		//Restrictions s'appliquant sur les arguments
		
		if ( jour>31 || jour < 1 || mois < 1 || mois >12 || annee < 1801 || annee > 2021)
			return "Date invalide";
		
		//Ces variables capturent les informations sur la date du lendemain
		int jourLendemain = jour;
		int moisLendemain = mois;
		int anneeLendemain = annee;
		
		
		if(moisDe31Jours(mois))
		{
			if(jour < 31) 
				jourLendemain = jour +1;
			else{ 
				jourLendemain = 1;
				moisLendemain = mois + 1;
			}
		}
		else if (moisDe30Jours(mois))
		{
			if(jour <30) 
				jourLendemain = jour + 1;
			else {
				if(jour == 30){
					jourLendemain = 1;
					moisLendemain = mois +1;
				}
				else 
					return "Date invalide";
			}
		}
		else if(estDecembre(mois))
		{
			if (jour <= 31) 
				jourLendemain = jour +1;
			else { 
				jourLendemain = 1;
				moisLendemain = 1;
				if(annee == 2021) 
					return "Ann�e invalide";
				else  
					anneeLendemain = annee +1;
			}
				
		}
		else if(estFevrier(mois))
		{
			if(jour < 28) 
				jourLendemain =jour +1;
			else {
				if(jour == 28) {  
					if(estAnneeBissextile(annee)) 
						jourLendemain = 29;
					else { 
						jourLendemain = 1;
						moisLendemain = 3;
					}
				}
				else if(jour == 29){ 
					if(estAnneeBissextile(annee)){  
						jourLendemain = 1;
						moisLendemain = 3;
					}
					else
						return "Date invalide";
				}
				else if(jour > 29) 
					return "Date invalide";
			}
		}
		return jourLendemain + "/" + moisLendemain + "/" + anneeLendemain;
	}
	
	

	
	private static boolean moisDe31Jours(int mois)
	{
		return mois == 1 || mois == 3 || mois == 5 || mois == 8 || mois == 10;
	}
	
	
	
	private static boolean moisDe30Jours(int mois)
	{
		return mois == 4 || mois == 6 || mois == 9 || mois == 11;
	}
	
	
	
	
	private static boolean estDecembre(int mois)
	{
		return mois == 12;
	}
	
	
	private static boolean estFevrier(int mois)
	{
		return mois == 2;
	}
	
	
	private static boolean estAnneeBissextile(int annee)
	{
		if((annee % 100) == 0)
			return (annee % 400) == 0;
		else
			return (annee % 4) == 0;
	}

}
