package TD4;

import java.util.Arrays;

public interface Pile<Type> {
    void empiler(Type x) throws ExceptionPilePleine;

    Type depiler() throws ExceptionPileVide;

    boolean estVide();

    boolean estPleine();
}

class ExceptionPileVide extends Exception {

}

class ExceptionPilePleine extends Exception {

}

class PileTab<Type> implements Pile<Type> {
    int capacite;
    Type[] elements;
    int sommet = -1;

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
