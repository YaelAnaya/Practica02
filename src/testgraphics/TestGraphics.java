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
    //Con estas bandelas booleanas verificamos si la casilla de
    //la figura está seleccionada para poder dibujarla
    private boolean polygonVisibility = true,
            spiralVisibility = true,
            circleVisibility = true,
            triangleVisibility = true,
            squareVisibility = true;

    /**
     * Con estos metodos lo que hacemos es agregas las figuras al Stack de
     * Figuras, siempre y cuando los valores introducidos sean mayores a 0.
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
     * Con estos Setters lo que se hace es cambiar la bandera booleana de
     * visibilidad de las figuras.
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

    //Con este método limpiamos los Stacks.
    public void clear() {
        figures.clear();
        invertedFigures.clear();
    }

    /**
     * Con este metodo se verifica si la figura está seleccionada en el checkbox
     * si es así se dibujará la figura correspondiente a la clase.
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
     * Este método dibuja las figuras del Stack en su forma normal o invertida,
     * dependiendo el estado de la bandera, primero se actualiza el panel,
     * despues dibuja las figuras del Stack dependiendo si están visibles o no,
     * agregando un metodo que hace esperar 200ms entre figura.
     *
     * @param isInvertedStack bandera booleana que nos indica si está invertido
     * el Stack.
     */
    public void drawFigures(boolean isInvertedStack) {
        //Actualizamos el panel
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

    /**
     * Este método dibuja las figuras del Stack en su forma normal o invertida,
     * dependiendo el estado de la bandera, primero se actualiza el panel,
     * despues dibuja las figuras del Stack dependiendo si están visibles y si
     * estan dentro de los limites de dibujos, agregando un metodo que hace
     * esperar 200ms entre figura.
     *
     * @param isInvertedStack bandera booleana que nos indica si está invertido
     * el Stack.
     */
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

    //Con este metodo hacemos que se espere x ms entre el dibujo de cada figura.
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
