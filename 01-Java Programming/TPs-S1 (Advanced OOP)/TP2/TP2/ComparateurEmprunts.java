package TP2;
import java.util.Comparator;
import java.util.Map.Entry;

public class ComparateurEmprunts implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		//Puisqu'il est sur que les arguments de compare sont deux "Entry" (dans l'implementation),
		//une gestion des exceptions est optionnelle.
		Entry e1 = (Entry) o1;
		Entry e2 = (Entry) o2;
		Livre l1 = (Livre) e1.getKey();
		Livre l2 = (Livre) e2.getKey();
		int i1 = (int) e1.getValue();
		int i2 = (int) e2.getValue();
		return (i2 - i1); // ici le tri est decroissant donc la comparaison est inversee.
	}
}


