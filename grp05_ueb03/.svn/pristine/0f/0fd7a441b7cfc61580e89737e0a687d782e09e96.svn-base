package ueb03;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Test of class TourElement. Published with assignment.
 * @author GeritKaleck
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TourElementTest {
    
//<editor-fold defaultstate="collapsed" desc="Helpers to create waypoint and list">
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
    
    /**
     * Creates a ElementList with the given waypoints.
     * @param waypoints array of waypoints to use, the coordinates of the waypoints are also in an array
     * @return List of elements with the given waypoints
     * @pre at least one waypoint has to be in array
     */
    private TourElement createElementList(int[][] waypoints){
        assert waypoints.length > 0;
        TourElement elem = new TourElement();
        int lastIndex = waypoints.length-1;
        Waypoint wp = createWaypoint(waypoints[lastIndex][0], waypoints[lastIndex][1]);
        elem.setWaypoint(wp);
        for (int i = lastIndex-1; i >= 0 ; i--) {
            wp = createWaypoint(waypoints[i][0], waypoints[i][1]);
            elem = elem.addStart(wp);
        }
        return elem;
    }
//</editor-fold>

    /**
     * Test of setWaypoint method, of class TourElement.
     */
    @Test
    public void testSetWaypoint() {
        TourElement elem = new TourElement();
        assertNull(elem.getWaypoint());
        elem.setWaypoint(createWaypoint(1, 2));
        assertArrayEquals(new int[]{1, 2}, elem.getWaypoint().toArray());
    }

    /**
     * Test of addStart method, of class TourElement.
     * This test has to pass first 
     * because this method is used in <code>createElementList()</code> 
     * which is used in most other tests.
     */
    @Test
    public void test0AddStart() {
        TourElement elem = new TourElement();
        elem.setWaypoint(createWaypoint(2, 2));  
        
        elem = elem.addStart(createWaypoint(1, 1));
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext());
    }
     
    /**
     * Test of getWaypointAt method, of class TourElement.
     * This test has to pass first 
     * because this method is used of all tests that check the content of 
     * the list after changing elements.
     */
    @Test
    public void test0GetWaypointAt_First() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        Waypoint expected = createWaypoint(0, 0);
        assertArrayEquals(expected.toArray(), elem.getWaypointAt(0).toArray());
    }
    
    @Test
    public void test0GetWaypointAt_Snd() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        Waypoint expected = createWaypoint(1, 1);
        assertArrayEquals(expected.toArray(), elem.getWaypointAt(1).toArray());
    }
    
    @Test
    public void test0GetWaypointAt_Last() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        Waypoint expected = createWaypoint(2, 2);
        assertArrayEquals(expected.toArray(), elem.getWaypointAt(2).toArray());
    }
    
    @Test
    public void test0GetWaypointAt_IndexNegative() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        assertNull(elem.getWaypointAt(-1));
    }
    
    @Test
    public void test0GetWaypointAt_IndexTooBig() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        assertNull(elem.getWaypointAt(3));
    }
    
    @Test
    public void test0GetWaypointAt_NotChangingList() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        Waypoint unused = elem.getWaypointAt(2);
        assertArrayEquals(new int[] {0, 0}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {1, 1}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }

    /**
     * Test of getNoOfWaypoints method, of class TourElement.
     */
    @Test
    public void testGetNoOfWaypoints_NotChangingList() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        int unused = elem.getNoOfWaypoints();
        assertArrayEquals(new int[] {0, 0}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {1, 1}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }
    
    /**
     * Test of calcDistance method, of class TourElement.
     */
    @Test
    public void testCalcDistance_ThreeElementsOrthogonal() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {0, 3}, {4, 3}});
        assertEquals(7, elem.calcDistance(), EPSILON);
    }

    @Test
    public void testCalcDistance_NotChangingList() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {0, 3}, {4, 3}});
        double unused = elem.calcDistance();
        assertArrayEquals(new int[] {0, 0}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {0, 3}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {4, 3}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());        
    } 
    
    /**
     * Test of contains method, of class TourElement.
     */
    @Test
    public void testContains_Fst() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        assertTrue(elem.contains(createWaypoint(0, 0)));
    }
    
    @Test
    public void testContains_Snd() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        assertTrue(elem.contains(createWaypoint(1, 1)));
    }
    
    @Test
    public void testContains_Last() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        assertTrue(elem.contains(createWaypoint(2, 2)));
    }
    
    @Test
    public void testContains_Not() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        assertFalse(elem.contains(createWaypoint(3, 3)));
    }
    
    @Test
    public void testContains_NotChangingList() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}, {2, 2}});
        boolean unused = elem.contains(createWaypoint(1, 1));
        assertArrayEquals(new int[] {0, 0}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {1, 1}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }



    /**
     * Test of append method, of class TourElement.
     */
    @Test
    public void testAppend() {
        TourElement elem = createElementList(new int[][] {{2, 2}});
        elem = elem.append(createWaypoint(3, 3));
        assertArrayEquals(new int[] {2, 2}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {3, 3}, elem.getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext());
    }
    
    @Test
    public void testAppend_AfterTwo() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {2, 2}});
        elem = elem.append(createWaypoint(3, 3));
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {3, 3}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }
    
    @Test 
    public void testAppend_Null() {
        TourElement elem = createElementList(new int[][] {{2, 2}});
        elem = elem.append(null);
        assertArrayEquals(new int[] {2, 2}, elem.getWaypoint().toArray());
        assertNull(elem.getNext());
    }

    /**
     * Test of insertAt method, of class TourElement.
     */
    @Test
    public void testInsertAt_BeforeFirst() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {3, 3}});
        Waypoint wp = createWaypoint(0, 0);
        elem = elem.insertAt(0, wp);
        assertArrayEquals(new int[] {0, 0}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {1, 1}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {3, 3}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }
    
    @Test
    public void testInsertAt_Second() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {3, 3}});
        Waypoint wp = createWaypoint(2, 2);
        elem = elem.insertAt(1, wp);
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {3, 3}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }
    
    @Test
    public void testInsertAt_Last() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {3, 3}});
        Waypoint wp = createWaypoint(4, 4);
        elem = elem.insertAt(2, wp);
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {3, 3}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {4, 4}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }

    /**
     * Test of toString method, of class TourElement.
     */
    @Test
    public void testToString_OneElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}});
        assertEquals("(1/1)", elem.toString());
    }
    
    @Test
    public void testToString_MoreElements() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {2, 2}, {3, 3}});
        assertEquals("(1/1) -> (2/2) -> (3/3)", elem.toString());
    }
    
    // Eigene Tests von Jan R. Neumann & Abdulrahman Al Bittar
    
    /**
     * Test of hasNext method, of class TourElement.
     */
    
    @Test
    public void testHasNext_OneElement() {
        TourElement elem = createElementList(new int[][] {{0, 0}});
        assertFalse(elem.hasNext());
    }
    
    @Test
    public void testHasNext_TwoElements() {
        TourElement elem = createElementList(new int[][] {{0, 0}, {1, 1}});
        assertTrue(elem.hasNext());
    }
    
    /**
     * Test of getNoOfWaypoints method, of class TourElement.
     */
    
    @Test
    public void testgetNoOfWaypoints_OneElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}});
        assertEquals(1, elem.getNoOfWaypoints());
    }
    
    @Test
    public void testgetNoOfWaypoints_TwoElements() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {3, 3}});
        assertEquals(2, elem.getNoOfWaypoints());
    }
    
    /**
     * Test of calcDistance method, of class TourElement.
     */
    
    @Test
    public void testCalcDistance_OneElement() {
        TourElement elem = createElementList(new int[][] {{2, 2}});
        assertEquals(0, elem.calcDistance(), EPSILON);
    }
    
    @Test
    public void testCalcDistance_TwoElements() {
        TourElement elem = createElementList(new int[][] {{5, 0}, {5, 6}});
        assertEquals(6, elem.calcDistance(), EPSILON);
    }
    
    /**
     * Test of removeAt method, of class TourElement.
     */
    
    @Test
    public void testremoveAt_FstElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {2, 2}});
        elem = elem.removeAt(0);
        assertArrayEquals(new int[] {2, 2}, elem.getWaypoint().toArray());
        assertNull(elem.getNext());
    }
    
    @Test
    public void testremoveAt_LastElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {2, 2}, {3, 3}});
        elem = elem.removeAt(2);
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext());
    }
    
    @Test
    public void testremoveAt_OnlyElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}});
        elem = elem.removeAt(0);
        assertNull(elem);
    }
    
    @Test
    public void testremoveAt_InvalidElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {2, 2}});
        elem = elem.removeAt(-1);
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext());
    }
    
    //Tests nach der Abnahme hinzugefügt zum testen des to do's
    
    @Test
    public void testinsertAt_LastElement() {
        TourElement elem = createElementList(new int[][] {{1, 1}, {2, 2}});
        Waypoint wp = createWaypoint(3, 3);
        elem = elem.insertAt(2, wp);
        assertArrayEquals(new int[] {1, 1}, elem.getWaypoint().toArray());
        assertArrayEquals(new int[] {2, 2}, elem.getNext().getWaypoint().toArray());
        assertArrayEquals(new int[] {3, 3}, elem.getNext().getNext().getWaypoint().toArray());
        assertNull(elem.getNext().getNext().getNext());
    }
}
