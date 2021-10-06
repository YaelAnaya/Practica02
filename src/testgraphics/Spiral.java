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
public class Spiral extends Figure {

    private final int INCREMENT;
    private int initialRadius;

    public Spiral(int xPosition, int yPosition, int size, int increment, int initialRadius, Color color) {
        super(xPosition, yPosition, size, color);
        this.INCREMENT = increment;
        this.initialRadius = initialRadius;
    }

    // Sobreescribimos los métodos para poder dibujar las figuras y
    // validar si están fuera de los límites.
    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        initialRadius = 0;
        for (int i = 0; i < size; i++) {
            g.drawArc(xPosition - initialRadius, yPosition - initialRadius, 2 * initialRadius, 2 * initialRadius, 0, 180);
            initialRadius += INCREMENT;
            g.drawArc(xPosition - initialRadius, yPosition - initialRadius, 2 * initialRadius - INCREMENT, 2 * initialRadius, 180, 180);
        }
    }

    @Override
    public boolean isOutOfBounds(int xLimit, int yLimit) {
        int totalRadius, edgeX, edgeX2, edgeY, edgeY2;

        totalRadius = initialRadius + (size * INCREMENT) - INCREMENT;

        edgeX = xPosition + totalRadius;
        edgeX2 = xPosition - totalRadius;
        edgeY = yPosition + totalRadius + INCREMENT;
        edgeY2 = yPosition - totalRadius + INCREMENT;

        return edgeX > xLimit || edgeX2 < 0 || edgeY > yLimit || edgeY2 < 0;

    }

}
