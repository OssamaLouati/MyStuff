package TP2;
import java.util.Comparator;

public class ComparateurExemplairesDispo implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		//Puisqu'il est sur que les arguments de compare sont deux livres (dans l'implementation),
		//une gestion des exceptions est optionnelle.
		Livre l1 = (Livre) o1;
		Livre l2 = (Livre) o2;
		return (l1.getNbreExemplairesDispo() - l2.getNbreExemplairesDispo());
	}
}
