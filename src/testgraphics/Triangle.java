/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

/**
 *
 * @author yaelanaya
 */
public class Triangle extends Figures{
    
    /**
    * Estos atributos guardan los valores de los puntos X e Y
    * que necesitamos, para dibujar un poligono con la
    * funcion drawPolygon de la clase Grapichs.
    */
    private int[] xPoints;
    private int[] yPoints;
    
    /**
     * Este constrcutor es utilizado para crear al Triangulo.
     */
    public Triangle(int xPosition, int yPosition, int size) {
        super(xPosition, yPosition, size);
        
    }
    
    /**
    * Con este metodo calculamos los puntos de x, para poder dibujar
    * el Triangulo equilatero.
     * @return el vector con los valores de los puntos de X
    */  
    public int[] getXPointsTriangle() {
        xPoints = new int[3]; 
        //Guardamos el punto incial X.
        xPoints[0] = xPosition;
        //Recorremos el punto inicial la mitad del tamaño del lado a la derecha.
        xPoints[1] = xPosition + (size/2);
        //Recorremos el punto inicial la mitad del tamaño del lado a la izquierda.
        xPoints[2] = xPosition - (size/2);
        return xPoints;
    }
    
   /**
    * Con este metodo calculamos los puntos de x, para poder dibujar
    * el Triangulo equilatero.
    * @return el vector con los valores de los puntos de Y
    */  
    public int[] getYPointsTriangle() {
        yPoints = new int[3];
        //Guardamos el punto incial Y.
        yPoints[0] = yPosition; 
        //Calculamos la altura para los lados, gracias al teorema de pitagoras.
        yPoints[1] = (int)(yPosition + Math.sqrt(Math.pow(size, 2) - Math.pow(size/2, 2)));
        yPoints[2] = yPoints[1];
        return yPoints;
    }
    
}
