package com.slf.exercise.paint.shape;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Line extends Shape implements Drawable{

	public Line(Point start, Point end) {
		super(start, end);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D graphics2d = (Graphics2D)g;
		graphics2d.setColor(penColor);
		graphics2d.setStroke(new BasicStroke(thickness));
		graphics2d.drawLine((int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int)endPoint.getY());
	}
}
