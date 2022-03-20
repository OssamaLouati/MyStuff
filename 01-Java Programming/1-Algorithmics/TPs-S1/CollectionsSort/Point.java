package triCollections;

public class Point implements Comparable{
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "("+this.getX()+","+this.getY()+")";
	}
	
	@Override
	public boolean equals(Object o) {
		System.out.println("Appel à equals");
		if(o==this) return true;
		if(o==null) return false;
		if(!(o instanceof Point)) return false;
		Point p = (Point) o;
		if(p.getX()==this.getX() && p.getY()==this.getY()) return true;
		return false;
	}
	
	@Override
	public int hashCode() {
		int result=1;
		result= result*13+this.getX();
		result= result*13+this.getY();
		return result;
	}
	
	public double distanceOrigine() {
		return Math.sqrt(x*x+y*y);
	}
	
	@Override
	public int compareTo(Object o) {
		double d1= this.distanceOrigine();
		double d2 = ((Point) o).distanceOrigine();
		if(d1<d2) return -1;
		if(d1>d2) return 1;
		return 0;
	}
	
}
