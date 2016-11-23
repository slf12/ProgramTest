package com.slf.exercise.paint.shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Circle extends Shape implements Drawable{

	public Circle(Point start, Point end) {
		super(start, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setColor(penColor);
		graphics2d.setStroke(new BasicStroke(thickness));
		graphics2d.drawOval((int)startPoint.getX(), (int)startPoint.getY(), (int)Math.abs(startPoint.getX() - endPoint.getX()),
				(int)Math.abs(startPoint.getY() - endPoint.getY()));
		
		graphics2d.setColor(brushColor);
		graphics2d.fillOval((int)startPoint.getX() + (int)thickness, 
				(int)startPoint.getY() + (int)thickness, 
				(int)Math.abs(startPoint.getX() - endPoint.getX()) - (int)thickness, 
				(int)Math.abs(startPoint.getY() - endPoint.getY()) - (int)thickness);
	}
	
}
