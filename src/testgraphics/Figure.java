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
public abstract class Figure {

    protected int xPosition; //Posición en X.
    protected int yPosition; //Posición en Y.
    protected int size; //Tamaño de la figura.
    protected Color color; //Color de la figura.

    public Figure(int xPosition, int yPosition, int size, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.size = size;
        this.color = color;
    }

    //Getters de los atributos de la clase Figures.
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    //Este método abstracto se utilizará para dibujar las diferentes figuras.
    public abstract void drawFigure(Graphics g);

    //Este método abstracto se utilizará validar si la figura está fuera de los límites.
    public abstract boolean isOutOfBounds(int xLimit, int yLimit);

}
