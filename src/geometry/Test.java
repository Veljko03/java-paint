package geometry;



public class Test {

	public static void main(String[] args) {
		
		Point p1 = new Point();
		Point p2 = new Point();
		Line l1 = new Line();
		Rectangle r1 = new Rectangle();
		Circle c1 = new Circle();
		
		p1.setX(3);
		p2.setY(5);
		
		p2.setX(15);
		p2.setY(10);
		
		p1.setX(p2.getY());
		
		l1.setStartPoint(p1);
		l1.setEndPoint(p2);
		
		l1.getStartPoint().setX(l1.getEndPoint().getY());
		
		
		System.out.println(l1.length());
		
		
		l1.getEndPoint().setX((int)l1.length()-(l1.getStartPoint().getX()+l1.getStartPoint().getY()));
		r1.setUpperLeftPoint(new Point());
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);
		
		r1.setWidth(20);
		r1.setHeight(10);
		
		//System.out.println("Povrsina " + r1.povrsina());
		//System.out.println("Obim: " + r1.obim());
		
		c1.setCenter(r1.getUpperLeftPoint());
		System.out.println("X krug " + c1.getCenter().getX() + "Y " + c1.getCenter().getY());
		
		//c1.getCenter().setX(r1.povrsina()-l1.getStartPoint().getY());
		
		System.out.println("X kruga " + c1.getCenter().getX());
		
		System.out.println(p1);
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		Point tacka1 = new Point(2,2);
		Point tacka2 = new Point(2,2);
		
		
		Line linija1 = new Line(tacka1, tacka2);
		Line linija2 = new Line(tacka1, tacka2);
		
		System.out.println("-----------------------");
		System.out.println(tacka1.equals(tacka2));
		System.out.println(linija1.equals(linija2));
		
	}
	
}
