/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_brush;

/**
 *
 * @author Abdelrahman Elsayed_
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Abdelrahman Elsayed_
 */
public class UI extends JFrame {

    
    
    
    private Paint_Panel mypanel;
    public UI() {
        
        setTitle("Paint Brush");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        mypanel = new Paint_Panel();
        
        add(mypanel, BorderLayout.CENTER);
        
        JPanel features_panel = new JPanel();
        
        JLabel Functions = new JLabel("Functions: ");
        
        JButton BtnClear = new JButton("Clear");
        JButton BtnUndo = new JButton("Undo");
        
        JLabel Paint_mode = new JLabel("Paint mode: ");
        JButton BtnRect = new JButton("Rectangle");
        JButton BtnLine = new JButton("Line");
        JButton BtnOval = new JButton("Oval");
        JButton BtnPencil = new JButton("Pencil");
        JButton BtnEraser = new JButton("Eraser");
        
        
        JCheckBox fill = new JCheckBox("Solid");
        JButton BtnColor = new JButton("Color");
        
        BtnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.clear();
            }
        });
        
        
        BtnUndo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.undo();
            }
        });
        
        BtnLine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.setCurrentShapeType(Paint_Panel.ShapeType.LINE);
            }
        });
        
        
        BtnRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.setCurrentShapeType(Paint_Panel.ShapeType.RECTANGLE);
            }
        });
        
        BtnOval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.setCurrentShapeType(Paint_Panel.ShapeType.OVAL);
            }
        });
        
        BtnPencil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.setCurrentShapeType(Paint_Panel.ShapeType.PENCIL);
            }
        });
        
        BtnEraser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mypanel.setCurrentShapeType(Paint_Panel.ShapeType.ERASER);
            }
        });
        
        
        fill.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                 mypanel.setFillShape(fill.isSelected());
            }
        });
        
        BtnColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(null, "Choose a Color", mypanel.getCurrentColor());
                if (selectedColor != null) {
                    mypanel.setCurrentColor(selectedColor);
                }
            }
        });
        
        features_panel.add(Functions);
        features_panel.add(BtnClear);
        features_panel.add(BtnUndo);

        features_panel.add(Paint_mode);
        features_panel.add(BtnLine);
        features_panel.add(BtnRect);
        features_panel.add(BtnOval);
        features_panel.add(BtnPencil);
        features_panel.add(BtnEraser);
        
        features_panel.add(fill);
      
        features_panel.add(BtnColor);
        
        add(features_panel,BorderLayout.NORTH);
    }
    
    
    
                    
}
