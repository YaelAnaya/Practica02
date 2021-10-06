/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

import java.awt.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

/**
 * @author yaelanaya
 */
public class TestGraphics extends JPanel {

    private Stack<Figure> figures = new Stack<>();
    private Stack<Figure> invertedFigures = new Stack<>();
    /**
     * Con estas banderas booleanas verificamos si la casilla de la figura está
     * seleccionada para poder dibujarla.
     */
    private boolean polygonVisibility = true,
            spiralVisibility = true,
            circleVisibility = true,
            triangleVisibility = true,
            squareVisibility = true;

    /**
     * Con estos métodos lo que hacemos es agregar las figuras al Stack. 
     */
    public void addTriangle(Triangle triangle) {
            figures.push(triangle);
    }

    public void addCircle(Circle circle) {
            figures.push(circle);
    }

    public void addSquare(Square square) {
        figures.push(square);
    }

    public void addSpiral(Spiral spiral) {
        figures.push(spiral);
    }

    public void addIrregularPolygon(IrregularPolygon polygon) {
        figures.push(polygon);
    }

    /**
     * Con estos Setters lo que se hace es cambiar el estado de la bandera booleana,
     * la cual indica si esta visible la figura (True) o no lo está (False).
     */
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

    //Con este método eliminamos todo lo que esté dentro de los Stacks.
    public void clear() {
        figures.clear();
        invertedFigures.clear();
    }

    /**
     * Este método se encarga de dibujar las figuras dentro del Stack, 
     * verificando que la figura esté seleccionada en el checkbox, esto gracias 
     * a las banderas boolenas que indican la visibilidad de la figura.
     */
    public void isFigureVisibleToDraw(Figure figure) {

        Class classType = figure.getClass();

        if (classType.equals(Triangle.class) && triangleVisibility
                || classType.equals(Circle.class) && circleVisibility
                || classType.equals(Square.class) && squareVisibility
                || classType.equals(Spiral.class) && spiralVisibility
                || classType.equals(IrregularPolygon.class) && polygonVisibility) {
            figure.drawFigure(this.getGraphics());
        }
    }

    /**
     * Este método dibuja los elementos del tope, el orden de dibujo se decide con el estado
     * de la bandera del parametro, si es True, se diburajarán de manera invertida los elementos, 
     * si es False, se dibujarán de la manera normal, estos elementos se dibujan, siempre y cuando
     * estén seleccionados en los checkbox.
     * 
     * @param isInvertedStack bandera booleana que nos indica si está invertido
     * el Stack.
     */
    public void drawFigures(boolean isInvertedStack) {
        //Actualizamos el panel
        this.revalidate();
        this.update(this.getGraphics());
        Figure figure;
        //Dibuja la pila invertida
        if (isInvertedStack) {
            while (!figures.empty()) {
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
                figure = invertedFigures.pop();
                isFigureVisibleToDraw(figure);
                waitAMoment(200);
                figures.push(figure);
            }
        }
    }

    /**
     * Este método dibuja los elementos del tope, el orden de dibujo se decide con el estado
     * de la bandera del parametro, si es True, se diburajarán de manera invertida los elementos, 
     * si es False, se dibujarán de la manera normal, estos elementos se dibujan, siempre y cuando
     * estén seleccionados en los checkbox y no esten fuera de los límites de la pizarra de dibujo.
     *
     * @param isInvertedStack bandera booleana que nos indica si está invertido
     * el Stack.
     */
    public void drawinBounds(boolean isInvertedStack) {

        this.revalidate();
        this.update(this.getGraphics());
        Figure figure;
        //Dibuja la pila invertida
        if (isInvertedStack) {
            while (!figures.empty()) {
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
                figure = invertedFigures.pop();
                if (!figure.isOutOfBounds((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight())) {
                    isFigureVisibleToDraw(figure);
                    waitAMoment(200);
                }
                figures.push(figure);
            }
        }
    }

    //Con este metodo hacemos que se espere "X" ms entre el dibujo de cada figura.
    private void waitAMoment(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    //Con metodo verificamos si el tope del Stack está fuera de los limities,
    //llamando al metodo abstracto de la figura que verifica los limites.
    public boolean isPeekOutOfBounds() {
        return figures.peek().isOutOfBounds((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
    }
}
