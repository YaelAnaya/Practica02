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
 * Con la clase Polygon, lo que queremos es modelar los dos poligonos que se nos
 * piden, heredando los atributos necesarios de la clase Figures.
 *
 * @author yaelanaya
 */
public class IrregularPolygon extends Figure {

    private ArrayList<Integer> xPoints = new ArrayList<>();
    private ArrayList<Integer> yPoints = new ArrayList<>();

    /**
     * Este constructor es utilizado para crear al Poligono.
     */
    public IrregularPolygon(ArrayList<Integer> xPoints, ArrayList<Integer> yPoints, int size, Color color) {
        super(1, 1, size, color);
        this.xPoints = xPoints;
        this.yPoints = yPoints;

    }

    //Con estos getters lo que hacemos el pasar los valores las listas a Arrays de tipo primitivo
    public ArrayList<Integer> getxPoints() {
        return xPoints;
    }

    public ArrayList<Integer> getyPoints() {
        return yPoints;
    }

    public int[] convertToArray(ArrayList<Integer> list) {
        int[] arrayAuxiliar = new int[size];
        for (int i = 0; i < size; i++) {
            arrayAuxiliar[i] = list.get(i);
        }
        return arrayAuxiliar;
    }

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
