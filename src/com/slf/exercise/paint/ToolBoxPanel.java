package com.slf.exercise.paint;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.slf.exercise.paint.shape.Circle;
import com.slf.exercise.paint.shape.Line;
import com.slf.exercise.paint.shape.Rectangle;
import com.slf.exercise.paint.shape.Shape;

@SuppressWarnings("serial")
public class ToolBoxPanel extends JPanel{
	private JButton lineButton;
	private JButton circleButton;
	private JButton rectButton;
	private ShapeEnum shapeChoice;
	private Shape currentShape;
	private Color color;
	private JPanel colorPanel;
	private JButton colorButton;
	private Color currentPenColor;
	private Color currentBrushColor;
	
	public Color getCurrentPenColor() {
		return currentPenColor;
	}

	public void setCurrentPenColor(Color currentPenColor) {
		this.currentPenColor = currentPenColor;
	}

	public Color getCurrentBrushColor() {
		return currentBrushColor;
	}

	public void setCurrentBrushColor(Color currentBrushColor) {
		this.currentBrushColor = currentBrushColor;
	}

	private ColorOptionButtonControl colorOptionButtonControl;
	public enum ShapeEnum{
		S_LINE, S_CIRCLE,S_RECTANGLE, S_TRIANGLE, S_NOT_READY,S_POINTS,
	};
	
	public ToolBoxPanel(){
		setBackground(Color.cyan);
		setPreferredSize(new Dimension(30, 30));
		
		currentShape = new Line(new Point(), new Point());
		currentShape.setReady(false);
		shapeChoice = ShapeEnum.S_NOT_READY;
		currentPenColor = Color.white;
		currentBrushColor = Color.gray;
		buildToolBoxArea();
	}

	public ShapeEnum getShapeChoice() {
		return shapeChoice;
	}

	public void setShapeChoice(ShapeEnum shapeChoice) {
		this.shapeChoice = shapeChoice;
	}

	public Shape getCurrentShape() {
		return currentShape;
	}

	public void setCurrentShape(Shape currentShape) {
		this.currentShape = currentShape;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public JPanel getColorPanel() {
		return colorPanel;
	}

	public void setColorPanel(JPanel colorPanel) {
		this.colorPanel = colorPanel;
	}

	public JButton getColorButton() {
		return colorButton;
	}

	public void setColorButton(JButton colorButton) {
		this.colorButton = colorButton;
	}

	public ColorOptionButtonControl getColorOptionButtonControl() {
		return colorOptionButtonControl;
	}

	public void setColorOptionButtonControl(ColorOptionButtonControl colorOptionButtonControl) {
		this.colorOptionButtonControl = colorOptionButtonControl;
	}

	private void buildToolBoxArea() {
		// TODO Auto-generated method stub
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		// 1
		addBrushesSection();
		// 2
		addShapeSection();
		// 3
		addColorSection();
		
		
	}


	private void addBrushesSection() {
		// TODO Auto-generated method stub
		
	}

	private void registerMouseEventForButton(final JButton button) {
		button.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (button.getBackground() == Color.gray) {
					button.setBackground(null);
				} else {
					 button.setBackground(Color.gray);
				}
			}
		});
	}
	
	private void addShapeSection(){
		lineButton = new JButton("Line");
		rectButton = new JButton("Rect");
		circleButton = new JButton("Circle");
		
		registerMouseEventForButton(lineButton);
		lineButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentShape = new Line(new Point(), new Point());
				currentShape.setPenColor(currentPenColor);
				currentShape.setBrushColor(currentBrushColor);
				if (lineButton.getBackground() == Color.gray) {
					currentShape.setReady(true);
					circleButton.setBackground(null);
					rectButton.setBackground(null);
				} else {
					currentShape.setReady(false);
					lineButton.setBackground(null);
					shapeChoice = shapeChoice.S_NOT_READY;
				}
			}
		});
		
		registerMouseEventForButton(circleButton);
		circleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentShape = new Circle(new Point(), new Point());
				currentShape.setPenColor(currentPenColor);
				currentShape.setBrushColor(currentBrushColor);
				if (circleButton.getBackground() == Color.gray) {
					currentShape.setReady(true);
					lineButton.setBackground(null);
					rectButton.setBackground(null);
				} else {
					currentShape.setReady(false);
					circleButton.setBackground(null);
					shapeChoice = shapeChoice.S_NOT_READY;
				}
			}
		});
		
		registerMouseEventForButton(rectButton);
		rectButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentShape = new Rectangle(new Point(), new Point());
				currentShape.setPenColor(currentPenColor);
				currentShape.setBrushColor(currentBrushColor);
				if (rectButton.getBackground() == Color.gray) {
					currentShape.setReady(true);
					lineButton.setBackground(null);
					circleButton.setBackground(null);
				} else {
					currentShape.setReady(false);
					rectButton.setBackground(null);
					shapeChoice = shapeChoice.S_NOT_READY;
				}
			}
		});
		
		JPanel shapePanel = new JPanel();
		GridLayout gridLayout = new GridLayout(2, 2);
		gridLayout.setHgap(2);
		gridLayout.setVgap(2);
		shapePanel.setLayout(gridLayout);
		shapePanel.add(lineButton);
		shapePanel.add(circleButton);
		shapePanel.add(rectButton);
		add(shapePanel);
	}
	
	private void addColorSection() {
		JPanel colorMainPanel = new JPanel();
		colorOptionButtonControl = new ColorOptionButtonControl(this);
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(new GridLayout(3, 10));
		for(int i = 0; i < 3; i++){
			for (int j = 0; j < 10; j++) {
				final JButton colorButton = new JButton();
				colorButton.setPreferredSize(new Dimension(20, 20));
				colorPanel.add(colorButton);
				if (i == 0) {
					colorButton.setBackground(Constant.colorArray[j]);
					colorButton.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							if (currentShape != null) {
								currentShape.setBrushColor(colorButton.getBackground());
								colorOptionButtonControl.setColor(colorButton.getBackground());
							}
						}
					});
				} else {
					colorButton.setBackground(Color.white);
				}
				
			}
		}
		
		colorMainPanel.add(colorOptionButtonControl);
		colorMainPanel.add(colorPanel);
		add(colorMainPanel);
	}
	
}
