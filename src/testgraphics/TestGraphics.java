/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 *
 * @author jorgeeie
 */
public class TestGraphics extends JPanel {

    private Stack<Figure> figures = new Stack<>();
    private Stack<Figure> invertedFigures = new Stack<>();
    private boolean polygonVisibility = true,
                    spiralVisibility = true, 
                    circleVisibility = true,
                    triangleVisibility = true,
                    squareVisibility = true;

    /**
     * Con estos metodos lo que hacemos es agregas las figuras al arrayList de
     * Figuras, siempre y cuando los valores introducidos sean mayores a 0.
     */
    public void addTriangle(int xPosition, int yPosition, int size, Color color) {
        if (xPosition > 0 && yPosition > 0 && size > 0) {
            figures.push(new Triangle(xPosition, yPosition, size, color));
        }
    }

    public void addCircle(int xPosition, int yPosition, int size, Color color) {
        if (xPosition > 0 && yPosition > 0 && size > 0) {
            figures.push(new Circle(xPosition, yPosition, size, color));
        }
    }

    public void addSquare(int xPosition, int yPosition, int size, Color color) {
        if (xPosition > 0 && yPosition > 0 && size > 0) {
            figures.push(new Square(xPosition, yPosition, size, color));
        }
    }

    public void addSpiral(int xPosition, int yPosition, int size, int increment, int initialRadium, Color color) {
        if (xPosition > 0 && yPosition > 0 && size > 0 && increment > 0 && initialRadium > 0) {
            figures.push(new Spiral(xPosition, yPosition, size, increment, initialRadium, color));
        }
    }

    public void addIrregularPolygon(ArrayList<Integer> xPosition, ArrayList<Integer> yPosition, int size, Color color) {
        figures.push(new IrregularPolygon(xPosition, yPosition, size, color));
    }

    public void setPolygonVisibility(boolean polygonVisibility) {
        this.polygonVisibility = polygonVisibility;
    }

    public void setSpiralVisibility(boolean spiralVisibility) {
        this.spiralVisibility = spiralVisibility;
    }

    public void setCircleVisibility(boolean circleVisibility) {
        this.circleVisibility = circleVisibility;
    }

    public void setTriangleVisibility(boolean triangleVisibility) {
        this.triangleVisibility = triangleVisibility;
    }

    public void setSquareVisibility(boolean squareVisibility) {
        this.squareVisibility = squareVisibility;
    }


    /**
     * Con este metodo vaciamos el arrayList de figuras
     */
    public void clear() {
        figures.clear();
        invertedFigures.clear();
    }

    /**
     * Con este metodo dibujamos las figuras que agregamos en el arrayList
     */
    public void isFigureVisibleToDraw(Figure figure) {

        Class classType = figure.getClass();

        if (classType.equals(Triangle.class) && triangleVisibility
           || classType.equals(Circle.class) && circleVisibility
           || classType.equals(Square.class) && squareVisibility
           || classType.equals(Spiral.class) && spiralVisibility
           || classType.equals(IrregularPolygon.class) && polygonVisibility) 
            
            figure.drawFigure(this.getGraphics());
    }

    public void drawFigures(boolean isInvertedStack) {
        
        this.revalidate();
        this.update(this.getGraphics());

        //Dibuja la pila invertida
        if (isInvertedStack) {
            while (!figures.empty()) {
                Figure figure;
                figure = figures.pop();
                isFigureVisibleToDraw(figure);
                waitAMoment(200);
                invertedFigures.push(figure);
            }
            while (!invertedFigures.empty()) {
                figures.push(invertedFigures.pop());
            }

            //Dibuja la pila en su estado original
        } else if (!isInvertedStack) {
            while (!figures.empty()) {
                invertedFigures.push(figures.pop());
            }
            while (!invertedFigures.empty()) {
                Figure figure;
                figure = invertedFigures.pop();
                isFigureVisibleToDraw(figure);
                waitAMoment(200);
                figures.push(figure);
            }
        }
    }

    public void drawinBounds(boolean isInvertedStack) {

        this.revalidate();
        this.update(this.getGraphics());

        //Dibuja la pila invertida
        if (isInvertedStack) {
            while (!figures.empty()) {
                Figure figure;
                figure = figures.pop();
                if (!figure.isOutOfBounds((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight())) {
                    isFigureVisibleToDraw(figure);
                    waitAMoment(200);
                }

                invertedFigures.push(figure);
            }
            while (!invertedFigures.empty()) {
                figures.push(invertedFigures.pop());
            }

            //Dibuja la pila en su estado original
        } else if (!isInvertedStack) {
            while (!figures.empty()) {
                invertedFigures.push(figures.pop());
            }
            while (!invertedFigures.empty()) {
                Figure figure;
                figure = invertedFigures.pop();
                if (!figure.isOutOfBounds((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight())) {
                    isFigureVisibleToDraw(figure);
                    waitAMoment(200);
                }
                figures.push(figure);
            }
        }
    }

    private void waitAMoment(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public boolean figureonPeek() {
        return figures.peek().isOutOfBounds((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
    }
}
