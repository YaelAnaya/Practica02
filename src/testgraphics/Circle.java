/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

import java.awt.*;

/**
 * @author yaelanaya
 */
public class Circle extends Figure {

    public Circle(int xPosition, int yPosition, int diameter, Color color) {
        super(xPosition, yPosition, diameter, color);
    }

    // Sobreescribimos los métodos para poder dibujar las figuras y
    // validar si están fuera de los límites.
    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        g.fillOval(xPosition, yPosition, size, size);
    }

    @Override
    public boolean isOutOfBounds(int xLimit, int yLimit) {
        int edgeX, edgeY;
        edgeX = xPosition + size;
        edgeY = yPosition + size;
        return edgeX > xLimit || edgeY > yLimit;
    }

}
