/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_brush;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Abdelrahman Elsayed_
 */
class Paint_Panel extends JPanel{
    private List<Shape_Properties> shapes;
   
    private Path2D currentPencilPath;
    private Shape currentShape;
    private Color currentColor;
    private boolean fillShape;
    private int x1, x2, y1, y2;
    private ShapeType currentShapeType;
    


     public enum ShapeType {
        RECTANGLE, LINE, OVAL, PENCIL,ERASER
    }
     
     public Paint_Panel() {
        shapes = new ArrayList<>();
        currentColor = Color.BLACK;
        currentShapeType = ShapeType.PENCIL; // Default shape type
        fillShape = false; // Default to not fill shapes
        addMouseListener(new Press_Listnser());
        addMouseMotionListener(new Drag_Listner());
    }
    
    public void setCurrentShapeType(ShapeType shapeType) {
        this.currentShapeType = shapeType;
    }

    public void setCurrentColor(Color color) {
        this.currentColor = color;
    }

    public void setFillShape(boolean fill) {
        this.fillShape = fill;
    } 
    
    public Color getCurrentColor(){return currentColor;}
    
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw all previously created shapes
        for (Shape_Properties shape : shapes) {
            g2d.setColor(shape.color);
            if (shape.fill) 
                g2d.fill(shape.shape);
            else 
                g2d.draw(shape.shape);
            
        }
        
        if(currentColor == getBackground() && currentShapeType != ShapeType.ERASER)
            currentColor = shapes.get(shapes.size()-2).color;
            
            
        // Draw the current shape if any
        if (currentShape != null && currentShapeType != ShapeType.PENCIL) {
            
            g2d.setColor(currentColor);
            if (fillShape) 
                g2d.fill(currentShape);
            else 
                g2d.draw(currentShape);
            
        }
        
        // Draw the current pencil path if any
        if (currentPencilPath != null) {
            
            g2d.setColor(currentColor);
            g2d.draw(currentPencilPath);
        }
    }
    
    
    class Press_Listnser implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
            
            if (currentShapeType == ShapeType.PENCIL) {
                currentPencilPath = new Path2D.Double();
                currentPencilPath.moveTo(x1, y1);
            } 
            
            else if (currentShapeType == ShapeType.ERASER) {
                currentPencilPath = new Path2D.Double();
                currentPencilPath.moveTo(x1, y1);
                currentColor = getBackground();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (currentShapeType == ShapeType.PENCIL || currentShapeType == ShapeType.ERASER) {
                if (currentPencilPath != null) {
                    currentPencilPath.lineTo(e.getX(), e.getY());
                    shapes.add(new Shape_Properties(currentPencilPath, currentColor, false));
                    currentPencilPath = null;
                }
            } 
            else{
                createShape(e.getX(), e.getY());
                if (currentShape != null) 
                    shapes.add(new Shape_Properties(currentShape, currentColor, fillShape));
                
                currentShape = null;
            }
            
            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    
    class Drag_Listner implements MouseMotionListener{

        @Override
        public void mouseDragged(MouseEvent e) {
            if (currentShapeType == ShapeType.PENCIL || currentShapeType == ShapeType.ERASER) {
                if (currentPencilPath != null) 
                    currentPencilPath.lineTo(e.getX(), e.getY());
                
            }
            else 
                createShape(e.getX(), e.getY());
            
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
    
    private void createShape(int x, int y) {
        x2 = x;
        y2= y;
        
        if(currentShapeType == ShapeType.RECTANGLE)
            currentShape = new Rectangle(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
              
        else if(currentShapeType == ShapeType.LINE)
            currentShape = new Line2D.Float(x1, y1, x2, y2);
        
        else if(currentShapeType == ShapeType.OVAL)   
             currentShape = new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
              
        
    }
    
    public void undo(){
        if(!shapes.isEmpty()){
            shapes.remove(shapes.size()-1);
            repaint();
        }
    }
    
    public void clear() {
        shapes.clear();
        
        repaint();
    }
}

