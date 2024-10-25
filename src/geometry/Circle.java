package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape{

	private Point center;
	private int radius;

	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center, radius, selected);
		setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		setInnerColor(innerColor);
	} 
	
	public Circle(Point center, int radius, boolean selected) {
		this.center = center;
		this.radius = radius;
		this.selected = selected;
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle() {
		
	}

	public double obim() {
		return radius*2*Math.PI;
	}
	
	public double povrsina() {
		return radius*radius*Math.PI;
	}
	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public Point getCenter() {
		return center;
	}
	
	public int getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Center= " + this.center + "Radius= " + this.radius;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Circle) {
			Circle pomocna = (Circle)obj;
			if(this.center.equals(pomocna.center) && this.radius == pomocna.radius) {
				return true;
			}else{
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.center.distance(x, y)<=this.radius;
	}
	
	public boolean contains(Point p) {
		return (this.center.distance(p.getX(), p.getY())<=radius);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		fill(g);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.center.getX() - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - radius - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() + radius - 3, this.center.getY() - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() - radius - 3, 6, 6);
			g.drawRect(this.center.getX() - 3, this.center.getY() + radius - 3, 6, 6);
		}if(!isSelected()) {
			g.setColor(getColor());
		}
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX() - radius	 + 1, this.center.getY() - radius + 1, radius*2 - 2, radius*2 - 2);
	}
}
