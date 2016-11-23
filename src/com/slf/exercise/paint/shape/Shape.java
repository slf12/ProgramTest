package com.slf.exercise.paint.shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Shape {
	protected Point startPoint;
	protected Point endPoint;
	protected Color penColor;
	protected Color brushColor;
	protected float thickness;
	protected boolean ready;
	public Shape(Point start, Point end){
		startPoint = start;
		endPoint = end;
		thickness = 1.0f;
		penColor = Color.black;
		brushColor = Color.gray;
	}
	
	public Shape(Point start, Point end, float thickness, Color  color){
		startPoint = start;
		endPoint = end;
		this.thickness = thickness;
		this.penColor = color;
		
	}
	
	public boolean isReady(){
		return ready;
	}
	
	public void setReady(boolean ready){
		this.ready = ready;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Color getPenColor() {
		return penColor;
	}

	public void setPenColor(Color penColor) {
		this.penColor = penColor;
	}

	public Color getBrushColor() {
		return brushColor;
	}

	public void setBrushColor(Color brushColor) {
		this.brushColor = brushColor;
	}

	public void setThickness(float thickness) {
		this.thickness = thickness;
	}

	public float getThickness(){
		return thickness;
	}
	
	public void setThinkness(float thickness) {
		this.thickness = thickness;
	}
	
	
} 
