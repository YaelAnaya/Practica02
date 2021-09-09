/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;
import java.util.*;
/**
 *Con la clase Polygon, lo que queremos es modelar los dos poligonos que se
 * nos piden, heredando los atributos necesarios de la clase Figures.
 * @author yaelanaya
 */
public class IrregularPolygon extends Figures{
  
    private ArrayList <Integer> xPoints = new ArrayList<>();
    private ArrayList <Integer> yPoints = new ArrayList<>();
    
     /**
     * Este constructor es utilizado para crear al Poligono.
     */
    public IrregularPolygon(ArrayList<Integer> xPoints, ArrayList<Integer> yPoints){
        super(0, 0, 0);
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
    
   
}
