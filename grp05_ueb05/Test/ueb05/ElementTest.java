package ueb05;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static ueb05.Color.*;

/**
 *
 * @author klk
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ElementTest {
    
    /**
     * Erstellt eine Liste mit den übergebenen Figuren in der angegebenen Reihenfolge.<br>
     * Es kann so eine unsortierte Liste erzeugt werden!
     * @param figures mehrere Figuren, die zuzufügen sind
     * @return Liste mit übergebenen Figuren
     */
    private Element createList(Figure... figures) {
        Element head = null;
        if (figures.length > 0) {
            head = new Element(figures[figures.length-1]);
            for (int i = figures.length-2; i >= 0; i--) {
                head = new Element(figures[i], head);
            }
        }
        return head;
    }
    
    /**
     * Test of constructors, of class Element.
     */
    @Test
    public void test0Element_Figure(){
        //the constructor has to exist
        Element elem = new Element(new Figure(BLACK));
    }
    
    @Test
    public void test0Element_FigureNext(){
        //the constructor has to exist
        Element elem = new Element(new Figure(BLACK), null);
    }
    
        
    /**
     * Test of size() method, of class Element.
     */
    @Test
    public void testSize() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Triangle  triangle = new Triangle(RED, 2, 3, 4); //A=2.9
        
        Element list = createList(circle, square, rect, triangle);
        assertEquals(4, list.size());
    }
    
    @Test
    public void testSize_OneElement() {
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Element list = new Element(rect);
        assertEquals(1, list.size());
    }
    
    /**
     * Test of getValues() method, of class Element.
     */
    
    @Test
    public void testGetValues() {
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Triangle  triangle = new Triangle(RED, 2, 3, 4); //A=2.9
        
        Element list = createList(circle, square, rect, triangle);
        assertArrayEquals(new Figure[] {circle, square, rect, triangle}, list.getValues());  
        assertArrayEquals("getValues() darf die Liste nicht verändern", 
		                  new Figure[] {circle, square, rect, triangle}, list.getValues());           
    }
    /**
     * Test of equals() method, of class Element.
     */
    
    @Test
    public void testEquals() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Triangle  triangle = new Triangle(RED, 2, 3, 4); //A=2.9
        
        Element list  = createList(circle, square, rect, triangle);
        Element other = createList(circle, square, rect, triangle);
        assertTrue(list.equals(other));
    }
        
    @Test
    public void testEquals_FirstShorter() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Triangle  triangle = new Triangle(RED, 2, 3, 4); //A=2.9
        
        Element list  = createList(circle, square, rect);
        Element other = createList(circle, square, rect, triangle);
        assertFalse(list.equals(other));
    }
    
    @Test
    public void testEquals_SecondShorter() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Triangle  triangle = new Triangle(RED, 2, 3, 4); //A=2.9
        
        Element list  = createList(circle, square, rect, triangle);
        Element other = createList(circle, square, rect);
        assertFalse(list.equals(other));
    }
    
    @Test
    public void testEquals_DiffOrder() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        Triangle  triangle = new Triangle(RED, 2, 3, 4); //A=2.9
        
        Element list  = createList(circle, square, rect, triangle);
        Element other = createList(circle, square, triangle, rect);
        assertFalse(list.equals(other));
    }
    
    @Test
    public void testEquals_DiffFiguresSameArea() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  4);        //A=16
        Rectangle rect     = new Rectangle(RED, 2, 8);   //A=16
        
        Element list  = createList(circle, square);
        Element other = createList(circle, rect);
        assertTrue(list.equals(other));
    }
    
    @Test
    public void testEquals_SameFiguresDiffArea() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Rectangle rect     = new Rectangle(RED, 2, 8);   //A=16
        Rectangle rect2    = new Rectangle(RED, 3, 9);   //A=27
        
        Element list  = createList(circle, rect2);
        Element other = createList(circle, rect);
        assertFalse(list.equals(other));
    }
    
    @Test
    public void testEquals_SameLengthDiffFigures() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        Rectangle rect     = new Rectangle(RED, 2, 3);   //A=6
        
        Element list  = createList(circle, square);
        Element other = createList(circle, rect);
        assertFalse(list.equals(other));
    }
    
    @Test
    public void testEquals_DiffObj() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Element list  = createList(circle);
        
        assertFalse(list.equals("list"));
        assertFalse(list.equals(circle));
    }
    
    @Test
    public void testEquals_null() {
        Circle    circle   = new Circle(RED, 3);         //A=28.27
        Square    square   = new Square(RED,  2.5);      //A=6.25
        
        Element list  = createList(circle, square);
        assertFalse(list.equals(null));
    }

    
}
