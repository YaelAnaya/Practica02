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
    public IrregularPolygon(ArrayList<Integer> xPoints, ArrayList<Integer> yPoints, Color color) {
        super(0, 0, 0, color);
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
        int[] arrayAuxiliar = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arrayAuxiliar[i] = list.get(i);
        }
        return arrayAuxiliar;
    }

    @Override
    public void drawFigure(Graphics g) {
        g.setColor(color);
        int[] arrayXPoints = convertToArray(xPoints);
        int[] arrayYPoints = convertToArray(yPoints);
        
        for (int i = 0; i < xPoints.size() - 1; i++) {
            g.drawLine(xPoints.get(i), yPoints.get(i), xPoints.get(i + 1), yPoints.get(i + 1));
        }

        g.fillPolygon(arrayXPoints, arrayYPoints, xPoints.size());
        

    }

}
