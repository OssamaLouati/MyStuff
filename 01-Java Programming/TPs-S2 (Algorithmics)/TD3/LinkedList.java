package TD3;

public class LinkedList<T> {
		static class Maillon<T>{
			public Maillon<T> suivant;
			public T valeur;
			public Maillon(T valeur) {
				this.suivant=null;
				this.valeur=valeur;
			}
		}

	public Maillon<T> tete;
	
	public LinkedList(Maillon<T> tete) {
		super();
		this.tete = tete;
	}
	

	public boolean estVide() {
		return this.tete==null;
	}
	public void insererTete(T valeur) {
			Maillon<T> maillon = new Maillon<T>(valeur);
			this.tete.suivant = this.tete;
			this.tete= maillon;
	}
	public void insererQueue(T valeur) {
		Maillon<T> maillon = new Maillon<T>(valeur);
		if(estVide()) {
			this.insererTete(valeur);
		}
		Maillon<T> m = this.tete;
		while(m.suivant.suivant != null) {
			m=m.suivant;
		}
		m.suivant=maillon;
	}
	public void supprimerTete() {
		if(!estVide()) {
			this.tete=this.tete.suivant;
		}
	}
	public void supprimerQueue() {
		if(!estVide()) {
			Maillon<T> m = this.tete;
			if(this.tete.suivant == null) {
				this.tete = null;
			}else {
				while(m.suivant.suivant != null) {
					m = m.suivant;
				}
				m.suivant= null;
			}
		}
	}
	
	/*-------- Exercice 3---------------*/
	
	public Maillon<T> Queue;

	public LinkedList(Maillon<T> tete, Maillon<T> queue) {
		super();
		this.tete = tete;
		Queue = queue;
	}
	
	public boolean estVide0() {
		return this.tete.suivant ==null;
	}
	public void insererTete0(T valeur) {
		Maillon<T> m = new Maillon<T>(valeur);
		if(estVide0()) {
			this.tete.suivant = m;
			this.Queue.suivant=m;			
		}else {
			m.suivant=this.tete.suivant;
			this.tete.suivant=m;
		}
	}
	public void insererQueue0(T valeur) {
		Maillon<T> m = new Maillon<T>(valeur);
		if(estVide0()) {
			insererTete0(valeur);
		} else {
			this.Queue.suivant= m;
			this.Queue=m;
		}
	}
	public void supprimerTete0() {
		if(!estVide()) {
			if(this.tete.suivant.suivant != null) {
				this.tete.suivant = this.tete.suivant.suivant;
			}else {
				this.tete=null;
				this.Queue=this.tete;
			}
		}
	}
	public void supprimerQueue0() {
		if(!estVide0()) {
			if(this.tete.suivant.suivant == null) {
				this.tete.suivant = null;
				this.Queue = this.tete;
			}else {
				Maillon<T> m = this.tete;
				while(m.suivant.suivant != null) {
					m = m.suivant;
				}
				m.suivant = null;
				this.Queue= m;
			}
		}
	}
}
	
	

	

