package com.slf.exercise.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import com.slf.exercise.paint.shape.Circle;
import com.slf.exercise.paint.shape.Drawable;
import com.slf.exercise.paint.shape.Line;
import com.slf.exercise.paint.shape.Rectangle;
import com.slf.exercise.paint.shape.Shape;

@SuppressWarnings("serial")
public class DrawPanel extends JPanel{
	private ArrayList<Drawable> shapes;
	private ArrayList<Point> points;
	private Shape currentShape;
	private Point startPoint;
	private Point endPoint;
	private Point currentPoint;
	
	private ToolBoxPanel toolBoxPanel;
	
	public DrawPanel(ToolBoxPanel toolBoxPanel) {
		// TODO Auto-generated constructor stub
		setBackground(Color.white);
		setPreferredSize(new Dimension(400, 400));
		
		this.toolBoxPanel = toolBoxPanel;
		
		shapes = new ArrayList<Drawable>();
		points = new ArrayList<Point>();
		startPoint = new Point();
		endPoint = new Point();
		currentPoint = null;
		registerMouseListener();
	}

	private void registerMouseListener() {
		// TODO Auto-generated method stub
		MouseListener listener = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (currentShape != null) {
					shapes.add((Drawable) currentShape);
					currentShape = null;
					
				}
				repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (!toolBoxPanel.getCurrentShape().isReady()) {
					points.add(new Point(e.getPoint()));
					
				} else {
					if (toolBoxPanel.getCurrentShape() instanceof Line) {
						currentShape = new Line(e.getPoint(), e.getPoint());						
						currentShape.setPenColor(toolBoxPanel.getCurrentShape().getPenColor());
					} else if (toolBoxPanel.getCurrentShape() instanceof Circle) {
						currentShape = new Circle(e.getPoint(), e.getPoint());
						currentShape.setPenColor(toolBoxPanel.getCurrentShape().getPenColor());
						currentShape.setBrushColor(toolBoxPanel.getCurrentShape().getBrushColor());
						currentShape.setThickness(toolBoxPanel.getCurrentShape().getThickness());
						
					} else if (toolBoxPanel.getCurrentShape() instanceof Rectangle) {
						currentShape = new Rectangle(e.getPoint(), e.getPoint());
						currentShape.setPenColor(toolBoxPanel.getCurrentShape().getPenColor());
						System.out.println(currentShape.getPenColor());
						System.out.println(toolBoxPanel.getCurrentShape().getPenColor());
						currentShape.setBrushColor(toolBoxPanel.getCurrentShape().getBrushColor());
						currentShape.setThickness(toolBoxPanel.getCurrentShape().getThickness());
					}
				}
				
				startPoint = e.getPoint();
				//ToolBoxPanel.ShapeEnum userChoise = toolBoxPanel.getShapeChoice();
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		MouseMotionListener motionListener = new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				if (!toolBoxPanel.getCurrentShape().isReady()) {
					points.add(new Point(e.getPoint()));
				} else {
					currentShape.setEndPoint(e.getPoint());
				}
				repaint();
			}
		};
		
		addMouseListener(listener);
		addMouseMotionListener(motionListener);
	}
	
	void addShape(Drawable s){
		shapes.add(s);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentShape != null) {
			Drawable d = (Drawable) currentShape;
			d.draw(g);
		}
		
		for(Drawable shape : shapes){
			shape.draw(g);
		}
		
		for(Point p : points){
			g.setColor(toolBoxPanel.getCurrentPenColor());
			g.drawOval((int)p.getX(), (int)p.getY(), 2, 2);
		}
	}
}

