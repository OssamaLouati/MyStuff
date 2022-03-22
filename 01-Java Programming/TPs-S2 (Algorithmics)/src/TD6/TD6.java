package TD6;

public class TD6 {
	public class Ex1<T>{
		Ex1<T> gauche, droit;
		
		static class element<T>{
			public element<T> pere;
			public T valeur;
			
			public element(element<T> pere, T valeur) {
				super();
				this.pere = pere;
				this.valeur = valeur;
			}
			public element<T> getPere() {
				return pere;
			}
			public void setPere(element<T> pere) {
				this.pere = pere;
			}

			public void setValeur(T valeur) {
				this.valeur = valeur;
			}	
		}
		
		public element<T> racine;
		
		public Ex1(element<T> racine){
			this.racine=racine;
		}

		public element<T> getRacine() {
			return racine;
		}

		public void setRacine(element<T> racine) {
			this.racine = racine;
		}
		public int getHauteur(Ex1<T> arbre){
			if(arbre==null) return 0;			
			return 1+Math.max(getHauteur(arbre.droit), getHauteur(arbre.gauche) );
			
		}
		public boolean rechercher(Ex1<T> arbre, element<T> noeud) {
			if(arbre ==null || noeud ==null) return false;
			if(arbre.racine.equals(noeud)) {
				return true;
			}
			return rechercher(arbre.droit, noeud) || rechercher(arbre.gauche, noeud);
			
			
			
		}
		
		
	}
		

}
