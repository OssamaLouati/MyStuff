package TD4;

public class LinkedList<Type> {
    public Maillon<Type> tete;

    public LinkedList(Maillon<Type> tete) {
        this.tete = tete;
    }

    public boolean estVide() {
        return tete == null;
    }

    public void insererTete(Type valeur) {
        Maillon<Type> t = new Maillon<>(valeur);
        t.suivant = tete;
        tete = t;
    }

    public void insererQueue(Type valeur) {
        Maillon<Type> t = new Maillon<>(valeur);
        Maillon<Type> ind = tete;
        while (ind.suivant != null) {
            ind = ind.suivant;
        }
        ind.suivant = t;
    }

    public void supprimerTete() {
        if (!estVide())
            tete = tete.suivant;

    }

    public void supprimerQueue() {
        Maillon<Type> ind = tete;
        Maillon<Type> queue = tete;
        if (!estVide())
            if (tete.suivant == null)
                tete = null;
            else
                while (ind.suivant != null) {
                    queue = ind;
                    ind = ind.suivant;
                }
        queue.suivant = null;
    }

    static class Maillon<Type> {
        public Maillon<Type> suivant;
        public Type valeur;

        public Maillon(Type valeur) {
            this.suivant = null;
            this.valeur = valeur;
        }
    }

}
