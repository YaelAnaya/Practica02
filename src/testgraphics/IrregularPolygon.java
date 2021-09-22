/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

/**
 * @author yaelanaya
 */
public class IrregularPolygon extends Figure {

    private ArrayList<Integer> xPoints = new ArrayList<>();
    private ArrayList<Integer> yPoints = new ArrayList<>();

    public IrregularPolygon(ArrayList<Integer> xPoints, ArrayList<Integer> yPoints, int size, Color color) {
        super(1, 1, size, color);
        this.xPoints = xPoints;
        this.yPoints = yPoints;

    }

    /**
     * Con este método lo que se hace es convertir el ArrayList de Integers a
     * Arrays de tipo primitivo int.
     *
     * @param list La lista que convertieramos a Array de tipo primitivo.
     * @return El Array de tipo primitivo.
     */
    public int[] convertToArray(ArrayList<Integer> list) {
        int[] arrayAuxiliar = new int[size];
        for (int i = 0; i < size; i++) {
            arrayAuxiliar[i] = list.get(i);
        }
        return arrayAuxiliar;
    }

    // Sobreescribimos los métodos para poder dibujar las figuras y
    // validar si están fuera de los límites.
    @Override
    public void drawFigure(Graphics g) {
        int[] arrayXPoints = convertToArray(xPoints);
        int[] arrayYPoints = convertToArray(yPoints);

        g.setColor(color);
        g.fillPolygon(arrayXPoints, arrayYPoints, size);
    }

    @Override
    public boolean isOutOfBounds(int xLimit, int yLimit) {
        for (int i = 0; i < size; i++) {
            if (xPoints.get(i) > xLimit || yPoints.get(i) > yLimit) {
                return true;
            }
        }
        return false;
    }

}
