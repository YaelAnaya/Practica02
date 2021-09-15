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
public class TestGraphics extends JPanel{
    private Stack<Figure> figures = new Stack<>();
    private Stack<Figure> invertedFigures = new Stack<>();
 
    /**Con este método lo que hacemos es solucionar un bug que resulataba al momento de dibujar las lineas
     * en el panel principial, simplemente dibujamos lineas en el panel en tiempo real.
     */
    public void drawLines(int x1, int y1, int x2, int y2){
        Graphics g = getGraphics();
        g.drawLine(x1, y1, x2, y2);
    }
    /**
     Con estos metodos lo que hacemos es agregas las figuras al arrayList de Figuras, siempre y cuando los valores introducidos
     * sean mayores a 0.
     */
    public void addTriangle(int xPosition, int yPosition, int size, Color color){
        if(xPosition > 0 && yPosition > 0 && size > 0)
            figures.push(new Triangle(xPosition, yPosition, size, color));
    }
    
    public void addCircle(int xPosition, int yPosition, int size, Color color){
        if(xPosition > 0 && yPosition > 0 && size > 0)
            figures.push(new Circle(xPosition, yPosition, size, color));
    }
    
    public void addSquare(int xPosition, int yPosition, int size, Color color){
        if(xPosition > 0 && yPosition > 0 && size > 0)
            figures.push(new Square(xPosition, yPosition, size, color));
    }
    
    public void addSpiral(int xPosition, int yPosition, int size, int increment, int initialRadium, Color color){
         if(xPosition > 0 && yPosition > 0 && size > 0 && increment > 0 && initialRadium > 0)
             figures.push(new Spiral(xPosition, yPosition, size, increment, initialRadium, color));
    }
    
    public void addIrregularPolygon(ArrayList<Integer> xPosition, ArrayList<Integer> yPosition, Color color){
        figures.push(new IrregularPolygon(xPosition, yPosition, color));
    }
    
    /** Con este metodo vaciamos el arrayList de figuras
     */
    public void clear(){
        figures.clear();
    }
    
    /**
     Con este metodo dibujamos las figuras que agregamos en el arrayList
     */
    public void drawFigures(boolean isInvertedStack){
        Graphics g = getGraphics();
        Figure figure;
        //Dibujamos el Stack original y lo guardamos de forma invertida.
        if(isInvertedStack){
            while(!figures.empty()){
                figure = invertedFigures.push(figures.pop());
                figure.drawFigure(g);
                waitAMoment(350);
            }
        //Dibujamos el Stack invertido y lo guardamos de nuevo en su forma original.
        } else{
            while(!invertedFigures.empty()){
                figure = figures.push(invertedFigures.pop());
                figure.drawFigure(g);
                waitAMoment(350);
            }
        }
    }
    
    private void waitAMoment(long ms){
        try{
            TimeUnit.MILLISECONDS.sleep(ms);
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
 