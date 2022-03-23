package TD4;

import java.util.Arrays;

import achraf.ExceptionNotationPolonaise;
import achraf.ExceptionPilePleine;
import achraf.ExceptionPileVide;

public class Revision{
	public interface Pile<Type> {
	    void empiler(Type x) throws ExceptionPilePleine;
	
	    Type depiler() throws ExceptionPileVide;
	
	    boolean estVide();
	
	    boolean estPleine();
	}
	
	@SuppressWarnings("serial")
	public class ExceptionPileVide extends Exception {
	
	}
	
	@SuppressWarnings("serial")
	public class ExceptionPilePleine extends Exception {
	
	}
	
	public class PileTab<Type> implements Pile<Type> {
	    int capacite;
	    Type[] elements;
	    int sommet = -1;
	
	    @SuppressWarnings("unchecked")
		public PileTab(int capacite) {
	        this.capacite = capacite;
	        elements = (Type[]) new Object[capacite];
	    }
	
	    @Override
	    public void empiler(Type x) throws ExceptionPilePleine {
	        if (!estPleine()) {
	            elements[++sommet] = x;
	        } else throw new ExceptionPilePleine();
	
	    }
	
	    @Override
	    public Type depiler() throws ExceptionPileVide {
	        if(estVide()) throw new ExceptionPileVide();
	        return elements[sommet--];
	    }
	
	    @Override
	    public boolean estVide() {
	        return  sommet==-1;
	    }
	
	    @Override
	    public boolean estPleine() {
	        return  sommet==capacite-1;
	    }
	
	    @Override
	    public String toString() {
	        return "PileTab{" +
	                "capacite=" + capacite +
	                ", elements=" + Arrays.toString(elements) +
	                ", sommet=" + sommet +
	                '}';
	    }
	}
	public static int <T>  NaotationPolonaise(String a) throws ExceptionPilePleine, ExceptionNotationPolonaise, ExceptionPileVide {
        PileTab<T> tab=new PileTab<>(a.length());
        for(int i=0;i<a.length();i++) {
            char s = a.charAt(i);
            if (Character.isDigit(s)) {
                tab.empiler((int)s);
            }
            else if(s == ' ') continue;
            else {
                //if (s == ' ') break;
                //if (tab.sommet < 1) throw new ExceptionNotationPolonaise();
                int e=(int)tab.depiler();
                int r=(int)tab.depiler();
                tab.empiler(calculer(s,r,e));
            }
        }
        return (int)tab.depiler();
    }
    public static int calculer(char s, int r,int e){
        if (s == '*') return  r * e;

        if (s == '+') return r + e;

        if (s == '-') return r - e;

        if (s == '/')  return r / e;

        return 0;
    }
	
	
	
	
}