package TD5;

public class Mondico<K,V> {
	private int taille;
	private int capacite;
	@SuppressWarnings("unchecked")
	private Entree<K,V>[] elements = new Entree[capacite];
	class Entree<K,V> {
		private final K cle;
		private V valeur;
		
		public Entree(K cle, V valeur) {
			super();
			this.cle = cle;
			this.valeur = valeur;
		}
		public V getValeur() {
			return valeur;
		}
		public void setValeur(V valeur) {
			this.valeur = valeur;
		}
		public K getCle() {
			return cle;
		}
		
	}
	public V recherche(K cle) {
		for (int i =0; i< this.elements.length ; i++) {
			if(this.elements[i] != null) {
				if( this.elements[i].getCle().equals(cle)) {
					return (V) this.elements[i].getValeur();
				}
			}
		}
		return null;
				
		
	}
	public void inserer(V valeur, K cle) {
		int j =0;
		for (int i =0; i< this.elements.length ; i++) {
			if(this.elements[i] != null) {
				if( this.elements[i].getCle().equals(cle)) {
					this.elements[i].setValeur(valeur);
					j=1;
					break;
				}
			}
		}
		if(j==0) {
			Entree<K,V> entree = new Entree<>(cle, valeur);
			elements[taille++] = entree;
		}
	}
	public void supprimer(K cle) {
		for(int i = 0; i<this.taille;i++) {
			if(this.elements[i].getCle().equals(cle)) {
				for(int j = 0;j<this.taille; j++) {
					this.elements[j] = this.elements[j+1];
				}
				taille--;
			}
		}
	}
	public void hashing(K cle, V valeur) {
		
		
	}
	
}
