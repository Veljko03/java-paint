package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	private int innerRadius;

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}

	public Donut() {
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color) { 
		this(center, radius, innerRadius, selected);
		setColor(color);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected, Color color, Color innerColor) { 
		this(center, radius, innerRadius, selected, color);
		setInnerColor(innerColor);
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}

	@Override
	public double obim() {
		// TODO Auto-generated method stub
		return super.obim()+this.innerRadius*2*Math.PI;
	}

	@Override
	public double povrsina() {
		// TODO Auto-generated method stub
		return super.povrsina()-this.innerRadius*this.innerRadius*Math.PI;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + ", Inner Radius= " + this.innerRadius;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if(getCenter().equals(pomocna.getCenter()) && getRadius() == pomocna.getInnerRadius() && this.innerRadius == pomocna.getInnerRadius()) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return super.contains(x, y) && getCenter().distance(x, y) >= innerRadius;
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return super.contains(p) && getCenter().distance(p.getX(), p.getY()) >= innerRadius;
	}

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.setColor(getColor());
		g.drawOval(getCenter().getX()-innerRadius, getCenter().getY()-innerRadius, innerRadius*2, innerRadius*2);
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX()-innerRadius-2, getCenter().getY()-2, 4,4);
			g.drawRect(getCenter().getX()+innerRadius-2, getCenter().getY()-2, 4,4);
			g.drawRect(getCenter().getX()-2, getCenter().getY()-innerRadius-2, 4,4);
			g.drawRect(getCenter().getX()-2, getCenter().getY()+innerRadius-2, 4,4);
			fill(g);
		}if(!isSelected()) {
			g.setColor(getColor());
		}
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.WHITE);
		g.fillOval(getCenter().getX() - this.innerRadius, getCenter().getY() - this.innerRadius, this.innerRadius * 2, this.innerRadius * 2);
	}
	
	
}