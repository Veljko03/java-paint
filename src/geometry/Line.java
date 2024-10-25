package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color color) {
		this(startPoint, endPoint, selected);
		setColor(color);
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.selected = selected;
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line() {
		
	}
	
	double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.startPoint + "-->" + this.endPoint;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line pomocna = (Line)obj;
			if(this.startPoint.equals(pomocna.startPoint) && this.endPoint.equals(pomocna.endPoint)) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		double d = this.getStartPoint().distance(x, y) + this.getEndPoint().distance(x, y);
		return d - this.length() <= 2;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(this.startPoint.getX() - 3, this.startPoint.getY() - 3, 6, 6);
			g.drawRect(this.endPoint.getX() - 3, this.endPoint.getY() - 3, 6, 6);
		}if(!isSelected()) {
			g.setColor(getColor());
		}
	}
}