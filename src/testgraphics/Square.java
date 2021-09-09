/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;
import java.awt.Graphics;

/**
 *Con esta clase buscamos modelar un cuadrado para posteriormente
 * dibujarlo en nuestro Canvas.
 * @author yaelanaya
 */
public class Square extends Figures {
    /**
     * Heredamos los atributos de la clase padre Figures.
     */
    public Square(int xPosition, int yPosition, int side) {
        super(xPosition, yPosition, side);
    }
    
}
