/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

import java.awt.*;

/**
 * Con esta clase lo que buscamos es modelar una espiral, para poderla dibujar
 * en el canvas en un futuro.
 *
 * @author yaelanaya
 */
public class Spiral extends Figure {

    private int increment;
    private int initialRadium;

    public Spiral(int xPosition, int yPosition, int size, int increment, int initialRadium, Color color) {
        super(xPosition, yPosition, size, color);
        this.increment = increment;
        this.initialRadium = initialRadium;
    }

    //Métodos Getters de los atributos
    public int getIncrement() {
        return increment;
    }

    public int getInitialRadium() {
        return initialRadium;
    }

    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        initialRadium = 0;
        for (int i = 0; i < size; i++) {
            g.drawArc(xPosition - initialRadium, yPosition - initialRadium, 2 * initialRadium, 2 * initialRadium, 0, 180);
            initialRadium += increment;
            g.drawArc(xPosition - initialRadium, yPosition - initialRadium, 2 * initialRadium - increment, 2 * initialRadium, 180, 180);
        }
    }

    @Override
    public boolean isOutOfBounds(int xLimit, int yLimit) {
        int totalRadium, edgeX, edgeX2, edgeY, edgeY2;

        totalRadium = initialRadium + (size * increment) - increment;

        edgeX = xPosition + totalRadium;
        edgeX2 = xPosition - totalRadium;
        edgeY = yPosition + totalRadium + increment;
        edgeY2 = yPosition - totalRadium + increment;

        return edgeX > xLimit || edgeX2 < 0 || edgeY > yLimit || edgeY2 < 0;

    }

}
