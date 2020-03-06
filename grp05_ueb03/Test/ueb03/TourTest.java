package ueb03;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Test of class Tour. Published with assignment.
 * @author GeritKaleck
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TourTest {
    
//<editor-fold defaultstate="collapsed" desc="Helpers to create waypoint and tour">
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
     * Creates a tour with the given waypoints.
     * @param waypoints array of waypoints to use, the coordinates of the waypoints are also in an array
     * @return tour with the given waypoints
     */
    private Tour createTour(int[][] waypoints){
        Tour tour = new Tour();
        for (int i = waypoints.length-1; i >= 0 ; i--) {
            Waypoint wp = createWaypoint(waypoints[i][0], waypoints[i][1]);
            tour.addStart(wp);
        }
        return tour;
    }
//</editor-fold>
    

    /**
     * Test of addStart method, of class Tour.
     * This test has to pass first 
     * because this method is used in createTour() 
     * which is used in most other tests. 
     */
    @Test
    public void test0AddStart_ToEmptyTour() {
        Tour tour = new Tour();
        tour.addStart(createWaypoint(1, 1));
        assertArrayEquals(new int[]{1, 1}, tour.getWaypointAt(0).toArray());       
        assertNull(tour.getWaypointAt(1));
    }
    
    @Test
    public void test0AddStart() {
        Tour tour = new Tour();
        tour.addStart(createWaypoint(2, 2));
        tour.addStart(createWaypoint(1, 1));
        assertArrayEquals(new int[]{1, 1}, tour.getWaypointAt(0).toArray());
        assertArrayEquals(new int[]{2, 2}, tour.getWaypointAt(1).toArray());
        assertNull(tour.getWaypointAt(2));
    }

    /**
     * Test of getWaypointAt method, of class Tour.
     * This test has to pass first 
     * because this method is used of all tests that check the content of 
     * the tour after changing elements.
     */
    @Test
    public void test0GetWaypointAt_First() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        assertArrayEquals(new int[] {0, 0}, tour.getWaypointAt(0).toArray());
    }
    
    @Test
    public void test0GetWaypointAt_Snd() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        assertArrayEquals(new int[] {1, 1}, tour.getWaypointAt(1).toArray());
    }
    
    @Test
    public void test0GetWaypointAt_Last() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        assertArrayEquals(new int[] {3, 3}, tour.getWaypointAt(3).toArray());
    }
    
    @Test
    public void test0GetWaypointAt_NegativeIndex() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        assertNull(tour.getWaypointAt(-1));
    }
    
    @Test
    public void test0GetWaypointAt_IndexTooBig() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        assertNull(tour.getWaypointAt(4));
    }
    
    @Test
    public void test0GetWaypointAt_EmptyTour() {
        Tour tour = new Tour();
        assertNull(tour.getWaypointAt(0));
    }
    
    @Test
    public void test0GetWaypointAt_NotChangingList() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Waypoint unused = tour.getWaypointAt(2);
        assertArrayEquals(new int[]{0, 0}, tour.getWaypointAt(0).toArray());
        assertArrayEquals(new int[]{1, 1}, tour.getWaypointAt(1).toArray());
        assertArrayEquals(new int[]{2, 2}, tour.getWaypointAt(2).toArray());
        assertArrayEquals(new int[]{3, 3}, tour.getWaypointAt(3).toArray());
        assertNull(tour.getWaypointAt(4));
    }


    /**
     * Test of toString method, of class Tour.
     */
    @Test
    public void testToString() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        assertEquals("[(0/0) -> (1/1) -> (2/2)]", tour.toString());
    }
    
    @Test
    public void testToString_EmptyTour() {
        Tour tour = new Tour();
        assertEquals("[]", tour.toString());
    }
    
    //Eigene Tests von Jan R. Neumann & Abdulrahman Al Bittar
    
    /**
     * Test of getStartPoint method, of class Tour.
     */
    
    @Test
    public void testgetStartPoint_OneWaypoint() {
        Tour tour = createTour(new int[][]{{0, 0}});
        assertArrayEquals(new int[] {0, 0}, tour.getStartPoint().toArray());
    }
    
    @Test
    public void testgetStartPoint_TwoWaypoints() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}});
        assertArrayEquals(new int[] {0, 0}, tour.getStartPoint().toArray());
    }
    
    @Test
    public void testgetStartPoint_EmptyTour() {
        Tour tour = new Tour();
        assertNull(tour.getStartPoint());
    }
    
    /**
     * Test of getNoOfWaypoints method, of class Tour.
     */
    
    @Test
    public void testGetNoOfWaypoints_NoElements() {
        Tour tour = new Tour();
        assertEquals(0, tour.getNoOfWaypoints());
    }
    
    @Test
    public void testGetNoOfWaypoints_FourElements() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        assertEquals(4, tour.getNoOfWaypoints());
    }
    
    @Test
    public void testGetNoOfWaypoints_NotChangingList() {
        Tour tour = createTour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        int unused = tour.getNoOfWaypoints();
        assertArrayEquals(new int[]{0, 0}, tour.getWaypointAt(0).toArray());
        assertArrayEquals(new int[]{1, 1}, tour.getWaypointAt(1).toArray());
        assertArrayEquals(new int[]{2, 2}, tour.getWaypointAt(2).toArray());
        assertArrayEquals(new int[]{3, 3}, tour.getWaypointAt(3).toArray());
        assertNull(tour.getWaypointAt(4));
    }
    
    /**
     * Test of calcDistance method, of class Tour.
     */
    
    @Test
    public void testCalcDistance_NoElement() {
        Tour tour = new Tour();
        assertEquals(0, tour.calcDistance(), EPSILON);
    }
    
    @Test
    public void testCalcDistance_OneElement() {
        Tour tour = createTour(new int[][] {{2, 2}});
        assertEquals(0, tour.calcDistance(), EPSILON);
    }
    
    @Test
    public void testCalcDistance_HorizontalAndPerpendicularElement() {
        Tour tour = createTour(new int[][] {{3, 3}, {3, 7}, {7, 7}});
        assertEquals(8, tour.calcDistance(), EPSILON);
    }
    
    //Tests nach Abnahme zum testen des to do's hinzugefügt
    
    @Test
    public void testappend_EmptyList() {
        Tour tour = new Tour();
        Waypoint wp = createWaypoint(1, 1);
        tour.append(wp);
        assertArrayEquals(new int[]{1, 1}, tour.getWaypointAt(0).toArray());
        assertNull(tour.getWaypointAt(1));
    }
    
    //FIXME DONE -> testfall zum Überprüfen  
    @Test
    public void testinsertAt_zeroIndex() {
        Tour tour = new Tour();
        Waypoint wp = createWaypoint(1, 1);
        tour.insertAt(0, wp);
        assertArrayEquals(new int[]{1, 1}, tour.getWaypointAt(0).toArray());
        assertNull(tour.getWaypointAt(1));
    }
 
}
