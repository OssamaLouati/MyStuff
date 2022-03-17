package TD3;

import java.util.Iterator;

@SuppressWarnings("rawtypes")
public class LinkedList<T>{
	
	static class Maillon<T>{
		public Maillon<T> suivant;
		public T valeur;
		public Maillon(T valeur) {
			this.suivant = null;
			this.valeur=valeur;
		}
		public Maillon(Maillon<T> s) {
			this.suivant = s.suivant;
		}
	}
	
	public Maillon<T> tete;
	
	private boolean estVide() {
		return this.tete==null;
	}
	
	public LinkedList() {
		this.tete= null;
	}
	public void  insererTete( T v) {
		Maillon<T> m  =new Maillon<T>(v);
		/*
		if(this.estVide()) {
			this.tete=m;
		}
		else {
			m.suivant=this.tete;
			this.tete=m;
		}
		*/
		m.suivant=this.tete;
		this.tete=m;
	}
	
	
	public void insererQueue(T val) {
		Maillon<T> m = new Maillon<T>(val);
		LinkedList<T> list=this;
		if(this.estVide()) {
			this.tete=m;
		}
		else {
			/*
			list.supprimerTete();
			list.insererQueue(val);
			
			*/
			
			Maillon<T> q = this.tete;
			while(q.suivant!=null) {
				q=q.suivant;
			}
			q=m;
		}
	}
	
	
	
	public void supprimerTete() {
		if(!this.estVide()) {
			this.tete=this.tete.suivant;
		}
		else{
			System.out.println("impossible de supprimer");
			
		}
	}
	public void supprimerQueue() {
		if(!this.estVide()) {
			if(this.tete.suivant==null) {
				this.tete=null;
			}
			Maillon<T> q = this.tete;
			while((q.suivant).suivant!=null) {
				q=q.suivant;
			}
			q.suivant= null;
			
		}
		else {
			System.out.println("shieeeeeeeee");
		}
		
	}
	
	
	
	
	public LinkedList(Maillon<T> suiv, T val){
		Maillon<T> a =  new Maillon<T>(val);
		a.suivant = suiv;
		
		
	}

	

	

}
