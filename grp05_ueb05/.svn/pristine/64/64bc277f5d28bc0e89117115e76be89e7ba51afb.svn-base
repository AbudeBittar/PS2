package ueb05;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static ueb05.Color.*;

/**
 *
 * @author GeritKaleck
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FigureTest {
    
    /**
     * Test of equals method, of class Figure.
     */
    @Test
    public void testEquals_DiffAreasDiffFigures() {
        Circle    circle   = new Circle(WHITE, 3);         //A=28.27
        Square    square   = new Square(WHITE,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(WHITE, 2, 3);   //A=6
        Triangle  triangle = new Triangle(WHITE, 2, 3, 4); //A=2.9
        assertFalse(circle.equals(square));
        assertFalse(square.equals(rect));
        assertFalse(rect.equals(triangle));
    }
    
    @Test
    public void testEquals_DiffAreasSameFigures() {
        Square    square   = new Square(WHITE,  2.5);      //A=6.25
        Square    square2  = new Square(WHITE,  3);        //A=9
        assertFalse(square.equals(square2));
        assertFalse(square2.equals(square));
    }
    
    @Test
    public void testEquals_DiffColorsSameFigures() {
        Square    square  = new Square(BLACK,  3);        //A=9
        Square    square2  = new Square(WHITE,  3);        //A=9
        assertTrue(square.equals(square2));
        assertTrue(square2.equals(square));
    }
    
    @Test
    public void testEquals_DiffFiguresSameArea() {
        Square    square  = new Square(BLACK,  4);        //A=16
        Rectangle rect    = new Rectangle(BLACK,  2, 8);  //A=16
        assertTrue(square.equals(rect));
        assertTrue(rect.equals(square));
    }
    
    @Test
    public void testEquals_DiffObj() {
        Square    square  = new Square(BLACK,  4);        //A=16
        assertFalse(square.equals("Square"));
    }
    
    @Test
    public void testEquals_Null() {
        Square    square  = new Square(BLACK,  4);        //A=16
        assertFalse(square.equals(null));
    }

}
