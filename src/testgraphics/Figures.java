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
public class Figures {
    protected int xPosition;
    protected int yPosition;
    protected int size;
   /**
    * Estos atributos guardan los valores de los puntos X e Y
    * que necesitamos, para dibujar un poligono con la
    * funcion drawPolygon de la clase Grapichs.
    */

    public Figures(int xPosition, int yPosition, int size) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.size = size;
    }

 
    /**Getters de los atributos de la clase Figures.
     */
    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int getSize() {
        return size;
    }

  
      
   
}
