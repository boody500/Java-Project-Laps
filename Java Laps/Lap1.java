/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;

/**
 *
 * @author Abdelrahman Elsayed_
 */
public class Lap1 extends javax.swing.JFrame {

    /** Creates new form NewJFrame */
    
    public Lap1() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    
    @Override
    public void paint(Graphics g) {

        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.fillOval(150,50, 150, 30);
        
        
        g.fillOval(160, 100, 50, 100);
        g.fillOval(230, 100, 50, 100);

        g.drawLine(150, 70, 120, 200);
        g.drawLine(300, 70, 320, 200);
        
        g.drawArc(120, 150, 200, 100, 0,-180 );
        g.drawLine(200, 250, 140, 280);
        g.drawLine(250, 250, 310, 280);
        g.drawRect(140, 280, 170, 10);

        
    }
    
    public static void main(String[] args){
        new Lap1().setVisible(true);
    }
            

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
