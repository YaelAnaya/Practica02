/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;
import java.awt.Graphics;
/**
 *Con esta clase lo que buscamos es modelar una espiral, para
 * poderla dibujar en el canvas en un futuro.
 * @author yaelanaya
 */
public class Spiral extends Figures {
    
    private int increment;
    private int initialRadium;
    
    public Spiral(int xPosition, int yPosition, int size, int increment, int initialRadium) {
        super(xPosition, yPosition, size);
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
  
}
