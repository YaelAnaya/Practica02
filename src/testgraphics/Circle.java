/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;
import java.awt.*;
/**
 *Con esta clase buscamos modelar un circulo, para posteriormente
 * dibujarlo en nuestro Canvas.
 * @author yaelanaya
 */
public class Circle extends Figure {

    public Circle(int xPosition, int yPosition, int diameter, Color color) {
        super(xPosition, yPosition, diameter, color);
    }

    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        g.fillOval(xPosition, yPosition, size, size);
    }

}
