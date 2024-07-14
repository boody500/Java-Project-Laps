/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint_brush;

import java.awt.Color;
import java.awt.Shape;

/**
 *
 * @author Abdelrahman Elsayed_
 */
public class Shape_Properties {
    Shape shape;
    Color color;
    boolean fill;

    public Shape_Properties(java.awt.Shape shape, Color color, boolean fill) {
        this.shape = shape;
        this.color = color;
        this.fill = fill;
    }
}
