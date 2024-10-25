package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	/**
	 * Create the panel.
	 */
	public Drawing() {

	}
	
	public static void main(String []args) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800, 600);
		Drawing drawing = new Drawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		
		Point p1 = new Point(30,50);
		p1.draw(g);
		
		p1.setX(20);
		p1.setY(20);
		p1.draw(g);
		
		Point p2 = new Point(60,70);
		
		Line line1 = new Line(p1,p2);
		line1.draw(g);
		
		g.setColor(Color.RED);
		Circle c1 = new Circle(new Point(200,300), 100);
		c1.draw(g);
		
		Rectangle k1 = new Rectangle(new Point(150,100), 40,80);
		k1.draw(g);
	}
}
