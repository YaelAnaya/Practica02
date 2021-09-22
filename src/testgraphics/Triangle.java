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
public class Triangle extends Figure {

    private int[] xPoints = new int[3];
    private int[] yPoints = new int[3];

     // Llamamos en el constructor los metodos que calculan los puntos en X e Y que se necesitan
     // para poder dibujar las figuras.
     
    public Triangle(int xPosition, int yPosition, int size, Color color) {
        super(xPosition, yPosition, size, color);
        getXPointsTriangle();
        getYPointsTriangle();
    }

    //Con este metodo calculamos los puntos de X, para poder dibujar el
    //Triangulo equilatero.
    public void getXPointsTriangle() {
        //Guardamos el punto incial X.
        xPoints[0] = xPosition;
        //Recorremos el punto inicial la mitad del tamaño del lado a la derecha.
        xPoints[1] = xPosition + (size / 2);
        //Recorremos el punto inicial la mitad del tamaño del lado a la izquierda.
        xPoints[2] = xPosition - (size / 2);
    }

    //Con este metodo calculamos los puntos de Y, para poder dibujar el
    //Triangulo equilatero.
    public void getYPointsTriangle() {
        //Guardamos el punto incial Y.
        yPoints[0] = yPosition;
        //Calculamos la altura para los lados, gracias al teorema de pitagoras.
        yPoints[1] = (int) (yPosition + Math.sqrt(Math.pow(size, 2) - Math.pow(size / 2, 2)));
        yPoints[2] = yPoints[1];
    }

    // Sobreescribimos los métodos para poder dibujar las figuras y
    // validar si están fuera de los límites.
    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public boolean isOutOfBounds(int xLimit, int yLimit) {
        int edgeX, edgeY, edgeX2;

        edgeX = xPoints[1];
        edgeX2 = xPoints[2];
        edgeY = yPoints[1];

        return edgeX > xLimit || edgeY > yLimit || edgeX2 < 0;
    }

}
