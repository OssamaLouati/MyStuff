import java.util.Arrays;

//import TD4.Pile;

public interface pile<T> {
	void emplier(T x) throws ExceptionPilePleine;
	
	T depiler() throws ExceptionPileVide;
	
	boolean estVide();
	boolean estPleine();
	
}
class PileTab<Type> implements pile<Type> {
    int capacite;
    Type[] elements;
    int sommet = -1;
    
    public PileTab(int cap) {
    	this.capacite= cap;
    	elements = (Type[]) new Object[cap];
    }
    
	@Override
	public void emplier(Type x) throws ExceptionPilePleine {
		if(!estPleine()) {
			//elements[++sommet]=x;
			elements[sommet+1] =x;
			this.sommet++;
		} else {
			throw new ExceptionPilePleine();
		}
		
	}
	@Override
	public Type depiler() throws ExceptionPileVide {
		if(estVide()) throw new ExceptionPileVide();
		else {
			return elements[sommet--];			
		}
	}
	
	@Override
	public boolean estVide() {
		
		return sommet==-1;
	}
	@Override
	public boolean estPleine() {
		return sommet==capacite-1;
	}
	public String toString() {
        return "PileTab{" +
                "capacite=" + capacite +
                ", elements=" + Arrays.toString(elements) +
                ", sommet=" + sommet +
                '}';
    }
}