package ueb03;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Tests of class Waypoint. Published with Assignment.
 * @author GeritKaleck
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WaypointTest {
    
//<editor-fold defaultstate="collapsed" desc="Helpers to create waypoint and compare doubles">
    /**
     * Precision of comparison of doubles
     */
    private static final double EPSILON = 0.001;

    /**
     * Creates a waypoint at the given coordinates.
     * @param x x-coordinate
     * @param y y-coordinate
     * @return waypoint at the given coordinates
     */
    private Waypoint createWaypoint(int x, int y) {
        Waypoint wp = new Waypoint();
        wp.setXY(x, y);
        return wp;
    }   
//</editor-fold>  
    
    /**
     * Test of setXY method, of class Waypoint.
     */
    @Test
    public void testGetAndSetXY() {
      Waypoint wp = new Waypoint();
      assertEquals(0, wp.getX());
      assertEquals(0, wp.getY());
      
      wp.setXY(1, 2);
      assertEquals(1, wp.getX());
      assertEquals(2, wp.getY());
    }

    /**
     * Test of calcDistance method, of class Waypoint.
     */
    @Test
    public void testCalcDistance() {
        Waypoint wp = createWaypoint(0, 0);
        Waypoint wp2 = createWaypoint(3, 4);
        assertEquals(5, wp.calcDistance(wp2), EPSILON);
    }
    
    @Test
    public void testCalcDistance_Diagonal() {
        Waypoint wp = createWaypoint(4, 4);
        Waypoint wp2 = createWaypoint(3, 3);
        assertEquals(1.414d, wp.calcDistance(wp2), EPSILON);
    }

    /**
     * Test of isEqual method, of class Waypoint.
     */
    @Test
    public void testIsEqual() {
        Waypoint wp = createWaypoint(1, 2);
        Waypoint wp2 = createWaypoint(1, 2);
        assertTrue(wp.isEqual(wp2));
    }
    
    @Test
    public void testIsEqual_Same() {
        Waypoint wp = createWaypoint(1, 2);
        assertTrue(wp.isEqual(wp));
    }
    
    @Test
    public void testIsEqual_Not() {
        Waypoint wp = createWaypoint(1, 2);
        Waypoint wp2 = createWaypoint(2, 1);
        assertFalse(wp.isEqual(wp2));
    }
    
    @Test
    public void testIsEqual_Null() {
        Waypoint wp = createWaypoint(1, 2);
        assertFalse(wp.isEqual(null));
    }

    /**
     * Test of toArray method, of class Waypoint.
     */
    @Test
    public void testToArray() {
        Waypoint wp = new Waypoint();
        assertArrayEquals(new int[] {0, 0}, wp.toArray());
        
        wp = createWaypoint(1, 2);
        assertArrayEquals(new int[] {1, 2}, wp.toArray());
    }

    /**
     * Test of toString method, of class Waypoint.
     */
    @Test
    public void testToString() {
        Waypoint wp = createWaypoint(1, 2);
        assertEquals("(1/2)", wp.toString());
    }
    
}
