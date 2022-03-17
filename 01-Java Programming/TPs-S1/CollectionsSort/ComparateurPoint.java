package triCollections;

import java.util.Comparator;

public class ComparateurPoint implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Point p1 = (Point) o1;
		Point p2 = (Point) o2;
		
		if(p1.getX()<p2.getX()) return -1;
		if(p1.getX()>p1.getX()) return 1;
		return 0;
	
		
	}

}
