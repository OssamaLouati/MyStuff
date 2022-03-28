package TD5;


import java.util.Arrays;
import java.util.Objects;

public class TD5 {
	public interface Dictionnaire{}
	
    public static class mondic<K,V>{
        private int taille=0;
        private int capacity=16;
        
        
        @SuppressWarnings("unchecked")
        
	public entry<K,V>[] tab=new entry[capacity];
        
        @SuppressWarnings("hiding")
        
	public class entry<K,V>{
            private final K key;
            private V value;

            public entry(K key,V value) {
                this.key = key;
                this.value=value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }

            public void setValue(V value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                @SuppressWarnings("unchecked")
				entry<K, V> entry = (entry<K, V>) o;
                return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
            }

            @Override
            public int hashCode() {
                return Objects.hash(key, value);
            }
        }

        public mondic( int capacity) {
            this.capacity = capacity;
        }

        public int getTaille() {
            return taille;
        }

        public void setTaille(int taille) {
            this.taille = taille;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public entry<K, V>[] getTab() {
            return tab;
        }

        public void setTab(entry<K, V>[] tab) {
            this.tab = tab;
        }

        public V recherche(K key){
            for(int i=0;i<taille;i++){
                if(tab[i]!=null){
			if (tab[i].getKey().equals(key)) return tab[i].getValue();
		}
	    }
            return null;}

        public void inserer(K key,V value){
            int j=0;
            for(int i=0;i<taille;i++){
                if(tab[i]!=null){
			if (tab[i].getKey().equals(key)){
                    tab[i].setValue(value);
                    j++;
             }
		}
	    }
            if(j==0){
                if(taille>=capacity){this.setCapacity(capacity*2);
                    this.setTab(Arrays.copyOf(tab,capacity));
                }
                entry<K,V> entry=new entry<>(key, value);
                tab[taille++]=entry;}
        }
        public void supprimer(K key){
            for(int i=0;i<taille;i++){
                if(tab[i]!=null){if (tab[i].getKey().equals(key))  tab[i].setValue(null);}}
        }


    }
    public class Hashtable implements Dictionnaire {
        public int taille=11;
        public Element[] table=new Element[11];
        class Element {
            Object cle;
            Object valeur;
            Element suivant ;
            Element (Object cle, Object valeur){
                this.cle=cle ;
                this.valeur=valeur;
                this.suivant=null;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Element element = (Element) o;
                return Objects.equals(cle, element.cle) && Objects.equals(valeur, element.valeur) && Objects.equals(suivant, element.suivant);
            }

            @Override
            public int hashCode() {
                return Objects.hash(cle, valeur, suivant);
            }
        }


        public Object rechercheelt(Object key){
            for(int i=0;i<taille;i++){
                Element suivant=table[i];
                while(suivant!=null){
                    if(suivant.cle.equals(key)){
                        return suivant.valeur;
                    }
                    suivant=suivant.suivant;
                }
            }
            return null;
        }
        public void insererelt(Object key,Object value){
            Element element=new Element(key,value);
            int z=element.hashCode()%11;
            Element suivant=table[z];
            while(suivant!=null){
                suivant=suivant.suivant;
            }
            suivant=element;
        }
        public void supprimerelt(Object key){
            int j=0;
            for(int i=0;i<taille;i++){
                Element suivant=table[i];
                while(suivant!=null){
                    if(suivant.cle.equals(key)){
                        suivant=null;
                        j++;
                        break;
                    }
                suivant=suivant.suivant;}
                if(j!=0){
                  break;
                }

            }
        }



    }




















}

/*public class Mondico<K,V> {
        private int taille;
        private int capacité=16;
        private Entree<K,V>[] elements=new Entree[capacité];
        class Entree<K,V> {
            private final   K cle ;
            private V valeur;

            public Entree(K cle, V valeur) {
                this.cle = cle;
                this.valeur = valeur;
            }

            public K getCle() {
                return cle;
            }

            public V getValeur() {
                return valeur;
            }



            public void setValeur(V valeur) {
                this.valeur = valeur;
            }
        }
        public V recherche(K cle){
            for(int i=0;i< elements.length;i++){
                if(elements[i]!=null){
                     if(elements[i].getCle().equals(cle)){
                        return (V)elements[i].getValeur();
                    }
                }
            }
            return null;
        }
        public void inserer(K cle,V valeur){
            int j=0;
            for(int i=0;i< elements.length;i++){
                if(elements[i].getCle().equals(cle)){
                    elements[i].setValeur(valeur);
                    j=1;
                    break;
                }
            }
            if(j==0){
                Entree<K,V> entree=new Entree<>(cle, valeur);
                elements[taille++]=entree;
            }
        }
        public void supprimer(K cle){
            for(int i=0;i< elements.length;i++){
                if(elements[i].getCle().equals(cle)){
                    taille--;
                    for(int j=i;j<taille;j++){
                        elements[j]=elements[j+1];
                    }
                }
            }
        }


    }
    public class Hashtable implements Dictionnaire {
        class Element {
            Object cle;
            Object valeur;
            Element suivant ;
            Element (Object cle, Object valeur){
                this.cle=cle ;
                this.valeur=valeur;
                this.suivant=null;
            }}
        int taille=11;
        Element[] table= new Element[taille];
        public void supprimer(Object cle, Object valeur){
            Element element=new Element(cle,valeur);
            for(int i=0;i<taille;i++){
                if(table[i]!=null){
                    if(table[i].cle.equals(element.cle)){

                        Element suivant=table[i];
                        int j=0;
                        while(j==0){
                            j=1;
                            if(suivant.valeur.equals(valeur)){
                                suivant=suivant.suivant;
                            }
                            suivant=suivant.suivant;
                        }
                        suivant=element;

                    }
                }
            }
        }
        public void inserer(Object cle, Object valeur){
            Element element=new Element(cle,valeur);
            for(int i=0;i<taille;i++){
                if(table[i]!=null){
                    if(table[i].cle.equals(element.cle)){
                        if(table[i].valeur==null){
                            table[i].valeur=element.valeur;
                        }
                        else {
                            Element suivant=table[i].suivant;
                            while(suivant!=null){
                                suivant=suivant.suivant;
                            }
                            suivant=element;
                        }
                    }
                }
            }
        }
    }*/
