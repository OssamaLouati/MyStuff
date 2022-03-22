package TD4;

/*
    l'idee consiste a creer une pile apartir de 2 Files . f1 et f2

    pour l'insertion :
        -  ajouter l'element a f2
        -  defiler tout les elements un par un de f1  et les inserer dans f2
        -  echanger f1 et f2
    pour le depilement :
        - depiler un element de f1 .
 */
public class Pile_from_File<Type> implements Pile<Type> {
    FileLinkedList<Type> f1, f2;

    public Pile_from_File() {
        f1 = new FileLinkedList<>();
        f2 = new FileLinkedList<>();
    }

    @Override
    public void empiler(Type x) {
        f2.enfiler(x);
        while (f1.estPleine()) {
            f2.enfiler(f1.defiler());
        }
        FileLinkedList<Type> f3 = f1;
        f1 = f2;
        f2 = f3;
    }

    @Override
    public Type depiler() {
        return f1.defiler();
    }

    @Override
    public boolean estVide() {
        return f1.estVide();
    }

    @Override
    public boolean estPleine() {
        return f1.estPleine();
    }

    @Override
    public String toString() {
        return f1.toString();
    }
}
