/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

import java.awt.*;

/**
 * Con esta clase buscamos modelar un cuadrado para posteriormente dibujarlo en
 * nuestro Canvas.
 *
 * @author yaelanaya
 */
public class Square extends Figure {

    /**
     * Heredamos los atributos de la clase padre Figures.
     */
    public Square(int xPosition, int yPosition, int side, Color color) {
        super(xPosition, yPosition, side, color);
    }

    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        g.fillRect(xPosition, yPosition, size, size);
    }

    @Override
    public boolean isOutOfBounds(int xLimit, int yLimit) {
        int edgeX, edgeY;
        edgeX = xPosition + size;
        edgeY = yPosition + size;
        return edgeX > xLimit || edgeY > yLimit;

    }

}
