/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testgraphics;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author jorgeeie
 */
public class TestGraphics extends JPanel{
    private ArrayList<Figures> figures = new ArrayList<>();
    
     /**
     * Con este método dibujamos el triangulo
     * Recibe como parametros los arrays de los puntos en x e y
     */
    public void drawTriangle(int[] xPoints, int[] yPoints){
        Graphics g= getGraphics();
        g.drawPolygon(xPoints, yPoints, 3);
    }
   
    /**
     * Con este método dibujamos al Cuadrado en el ambiente gráfico.
     */
    public void drawSquare(int xPosition, int yPosition, int size){
       Graphics g= getGraphics();
       g.drawRect(xPosition, yPosition, size, size);
    }
    
   /**
     * Este método, nos ayuda a dibujar el circulo en el Canvas
     * Recibe como parametros l ambiente grafico en el que 
     * lo dibujaremos.
     */
    public void drawCircle(int xPosition, int yPosition, int diameter){
        Graphics g= getGraphics();
        g.drawOval(xPosition, yPosition, diameter, diameter);
    }
    
    /**
     * Este método, nos ayuda a dibujar el Espiral en el Canvas
     * Recibe como parametros el ambiente grafico en el que se dibujará 
     * ,los parametros de posicion, incremento y radio inicial.
     */
    public void drawSpiral(int xPosition, int yPosition, int size, int increment, int initialRadium){
        Graphics g= getGraphics();
        for(int i = 0; i < size; i++){
            g.drawArc(xPosition - initialRadium, yPosition - initialRadium, 2 * initialRadium, 2 * initialRadium, 0, 180);
            initialRadium += increment;
            g.drawArc(xPosition - initialRadium, yPosition - initialRadium, 2 * initialRadium - increment, 2 * initialRadium, 180, 180);
        }
    }
    
    public void drawIrregularPolygon(ArrayList<Integer> xPoints, ArrayList<Integer> yPoints){
        Graphics g = getGraphics();
        for (int i = 0; i < xPoints.size() - 1; i++) {
            g.drawLine(xPoints.get(i), yPoints.get(i), xPoints.get(i + 1), yPoints.get(i + 1));
        }
    }
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
    public void addTriangle(int xPosition, int yPosition, int size){
        if(xPosition > 0 && yPosition > 0 && size > 0)
            figures.add(new Triangle(xPosition, yPosition, size));
    }
    
    public void addCircle(int xPosition, int yPosition, int size){
        if(xPosition > 0 && yPosition > 0 && size > 0)
            figures.add(new Circle(xPosition, yPosition, size));
    }
    
    public void addSquare(int xPosition, int yPosition, int size){
        if(xPosition > 0 && yPosition > 0 && size > 0)
            figures.add(new Square(xPosition, yPosition, size));
    }
    
    public void addSpiral(int xPosition, int yPosition, int size, int increment, int initialRadium){
         if(xPosition > 0 && yPosition > 0 && size > 0 && increment > 0 && initialRadium > 0)
             figures.add(new Spiral(xPosition, yPosition, size, increment, initialRadium));
    }
    
    public void addIrregularPolygon(ArrayList<Integer> xPosition, ArrayList<Integer> yPosition){
        figures.add(new IrregularPolygon(xPosition, yPosition));
    }
    
    /** Con este metodo vaciamos el arrayList de figuras
     */
    public void clear(){
        figures.clear();
    }
    
    /**
     Con este metodo dibujamos las figuras que agregamos en el arrayList
     */
    public void drawFigures(){
        Graphics g = getGraphics();
        //Recorremos el ArrayList
        for(Figures figure : figures){
            /**
             Lo que hacemos ahora es verificar que las clases sean hijas de la clase Figure
             * Una vez que la condicion sea verdadera, casteamos el objeto figura para obtener los atributos y metodos de la clase
             * Y con los atributos obtenidos, dibujamos la respectiva figura.
             */
            Class classType = figure.getClass();
            if(classType.equals(Triangle.class)){
                Triangle triangle = (Triangle)figure;
                drawTriangle(triangle.getXPointsTriangle(), triangle.getYPointsTriangle());
            }
            else if(classType.equals(Circle.class)){
                Circle circle = (Circle)figure;
                drawCircle(circle.xPosition, circle.yPosition, circle.size);
            }
            else if(classType.equals(Square.class)){
                Square square = (Square)figure;
                drawSquare(square.xPosition, square.yPosition, square.size);
            }
            else if(classType.equals(Spiral.class)){
                Spiral spiral = (Spiral)figure;
                drawSpiral(spiral.xPosition, spiral.yPosition, spiral.size, spiral.getIncrement(), spiral.getInitialRadium());
            }
         
        }
    
    }
    
}
 