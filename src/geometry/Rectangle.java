package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{
	
	private Point upperLeftPoint;
	private int width;
	private int height;
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
		this.selected = selected;
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color) {
		this(upperLeftPoint, height, width, selected);
		setColor(color);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected, Color color, Color innerColor) {
		this(upperLeftPoint, height, width, selected, color);
		setInnerColor(innerColor);
	}
	
	public Rectangle() {
		
	}
	
	
	public int povrsina() {
		return this.width * this.height;
	}
	
	public int obim() {
		return 2*this.width + 2*this.height;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Upper left point: " +  this.upperLeftPoint + ", Width= " + this.width + ", Height= " + this.height;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Rectangle) {
			Rectangle pomocna = (Rectangle)obj;
			if(pomocna.upperLeftPoint.equals(this.upperLeftPoint) && this.height == pomocna.height && this.width == pomocna.width) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	
	public boolean contains(int x, int y) {
		return (x>=this.upperLeftPoint.getX()
				&& x<=this.upperLeftPoint.getX()+width 
				&& y>=this.upperLeftPoint.getY()
				&& y<=this.upperLeftPoint.getY()+height);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), this.width, this.height);
		this.fill(g);
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
			g.drawRect(getUpperLeftPoint().getX() + getWidth() - 3, getUpperLeftPoint().getY() + getHeight() - 3, 6, 6);
		}
	}
	
	@Override
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeftPoint.getX()+1, this.getUpperLeftPoint().getY()+1, width-1, height-1);
	}
}