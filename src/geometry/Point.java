package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape {
	
	private int x;
	private int y;
	
	
	public Point(int x, int y, boolean selected, Color color) {
		this(x, y, selected);
		setColor(color);
	}
	
	public Point(int x, int y, boolean selected) {
		this.x = x;
		this.y = y;
		this.selected = selected;
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
	}
	
	public double distance(int x2, int y2) {
		int dx = x2-x;
		int dy = y2-y;
		return Math.sqrt(dx*dx+dy*dy);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	 @Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pomocna = (Point)obj;
			if(pomocna.x == this.x && pomocna.x == this.y) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	 
	public boolean contains(int x, int y) {
		return this.distance(x, y)<2;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "("+this.x+","+this.y+")";
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(x-2, y, x+2, y); //Horizontalna
		g.drawLine(x, y-2, x, y+2); //Vertikalna
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
	}
	
	public int compareTo(Object obj) {
		if(obj instanceof Point) {
			return (int) (this.distance(0, 0) - ((Point)obj).distance(0, 0));
		}else {
			return 0;
		}
	}
	 
	
}