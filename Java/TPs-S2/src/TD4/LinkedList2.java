package TD4;

public class LinkedList2<Type> {
    public Maillon<Type> tete;
    public Maillon<Type> queue;

    public LinkedList2(Maillon<Type> tete) {
        this.tete = tete;
        this.queue = tete;
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
        queue.suivant = t;
        queue = t;
    }

    public void supprimerTete() {
        if (!estVide())
            tete = tete.suivant;

    }

    public void supprimerQueue() {
        Maillon<Type> ind = tete;
        if (!estVide())
            if (tete.suivant == null) {
                tete = null;
            } else {
               queue=null;
            }
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
