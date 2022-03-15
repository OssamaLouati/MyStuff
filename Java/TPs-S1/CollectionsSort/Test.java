package triCollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test {

	public static void main(String[] args) {
		Point p = new Point(2,1);
		Point p1= new Point(-1,3);
		Point p2 = new Point(0,0);
		Point p3= new Point(-2,7);
		Point p4 = new Point(1,1);
		List points =null;
		points = new ArrayList();
		points.add(p);
		points.add(p1);
		points.add(p2);
		points.add(p3);
		points.add(p4);
		List points1 = new ArrayList(points);
		List points2 = new ArrayList(points);
		Collections.sort(points1);
		//Collections.sort(points2,new ComparateurPoint());
		ComparateurPoint cp = new ComparateurPoint();
		Collections.sort(points2,cp);	
		System.out.println(points);
		System.out.println(points1);
		System.out.println(points2);
	}

}
