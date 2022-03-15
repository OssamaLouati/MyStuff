package GenMeth;

import java.util.List;

public class EXOS {
	public static  <T> void fill(List<T> liste , T elem) {
		int size = liste.size();
		for (int i =0; i < size; i++) {
			liste.set(i, elem);
		}
	}

}