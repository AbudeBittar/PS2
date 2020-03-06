package ueb04;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author GeritKaleck
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TourTest4 {


//<editor-fold defaultstate="collapsed" desc="Test of Mrs. Kaleck">
    
    /**
     * Test of constructors, of class Tour.
     */
    @Test
    public void test0Tour() {
        Tour tour = new Tour();
        assertTrue(tour.isEmpty());
    }
    
    @Test
    public void test0Tour_intArr_Empty() {
        Tour tour = new Tour(new int[][]{});
        assertTrue(tour.isEmpty());
    }
    
    @Test
    public void test0Tour_intArr_OneElement() {
        Tour tour = new Tour(new int[][]{{0, 0}});
        assertTrue(new Waypoint(0,0).isEqual(tour.getWaypointAt(0)));
        assertNull(tour.getWaypointAt(1));
    }
    
    @Test
    public void test0Tour_intArr_ThreeElements() {
        Tour tour = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        assertTrue(new Waypoint(0,0).isEqual(tour.getWaypointAt(0)));
        assertTrue(new Waypoint(1,1).isEqual(tour.getWaypointAt(1)));
        assertTrue(new Waypoint(2,2).isEqual(tour.getWaypointAt(2)));
        assertNull(tour.getWaypointAt(3));
    }

    /**
     * Test of isEqual method, of class Tour.
     */
    @Test
    public void test0IsEqual_ThreeElements() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        assertTrue(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_FirstLonger() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}});
        assertFalse(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_FirstShorter() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        assertFalse(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_FirstDiffers() {
        Tour tourA = new Tour(new int[][]{{9, 9}, {1, 1}, {2, 2}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        assertFalse(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_LastDiffers() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}, {9, 9}});
        assertFalse(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_FirstEmpty() {
        Tour tourA = new Tour();
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        assertFalse(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_SndEmpty() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}});
        Tour tourB = new Tour();
        assertFalse(tourA.isEqual(tourB));
    }
    @Test
    public void test0IsEqual_BothEmpty() {
        Tour tourA = new Tour();
        Tour tourB = new Tour();
        assertTrue(tourA.isEqual(tourB));
    }

    /**
     * Test of createConcatenatedTour method, of class Tour.
     */
    @Test
    public void testCreateConcatenatedTour_TwoPlusOne() {
        Tour tourA    = new Tour(new int[][]{{0, 0}, {1, 1}});
        Tour tourB    = new Tour(new int[][]{{2, 2}});
        Tour expected = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}}); 
        Tour result   = tourA.createConcatenatedTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));
    }
   
    /**
     * Test of createTourWithOrder method, of class Tour.
     */
    @Test
    public void testCreateTourWithOrder_SameOrder() {
        Tour tour     = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour expected = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour result = tour.createTourWithOrder(new int[]{0, 1, 2, 3});
        assertTrue(result.toString(), expected.isEqual(result));
    }

    /**
     * Test of createPopularTour method, of class Tour.
     */
    @Test
    public void testCreatePopularTour_sameTours() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour expected = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour result = tourA.createPopularTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));    
    }

    /**
     * Test of createShortestTour method, of class Tour.
     */
    @Test
    public void testCreateShortestTour() {
        Tour tour = new Tour(new int[][]{{10, 10}, {1, 1}, {22, 22}, {3, 3}});
        Tour result = tour.createShortestTour(1);
        Tour expected = new Tour(new int[][]{{1, 1}, {3, 3}, {10, 10}, {22, 22}});
        assertTrue(result.toString(), expected.isEqual(result));
    }

    /**
     * Test of createTourWithoutDuplicates method, of class Tour.
     */
    @Test
    public void testCreateTourWithoutDuplicates_DupAtEnd() {
        Tour tour = new Tour(new int[][]{{1, 1}, {2, 2}, {1, 1}});
        Tour result = tour.createTourWithoutDuplicates();
        Tour expected = new Tour(new int[][]{{1, 1}, {2, 2}});
        assertTrue(result.toString(), expected.isEqual(result));
    }

    /**
     * Test of createUnion method, of class Tour.
     */
    @Test
    public void testCreateUnion_OneAndOne() {
        Tour tourA = new Tour(new int[][]{{1, 1}});
        Tour tourB = new Tour(new int[][]{{12, 12}});
        Tour result = tourA.createUnion(tourB);
        Tour expected = new Tour(new int[][]{{1, 1}, {12, 12}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    //</editor-fold>
    
    //Eigene Tests von Jan R. Neumann & Abdulrahman Al Bittar.
    

    /**
     * Test of copy method, of class Tour.
     */
    @Test
    public void testCopy_ThreeWaypoints() {
        Tour tour = new Tour(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        Tour result = tour.copy();
        Tour expected = new Tour(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCopy_ThreeWaypointsNotChanged() {
        Tour tour = new Tour(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        Tour unused = tour.copy();
        Tour expected = new Tour(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertTrue(tour.toString(), expected.isEqual(tour));
    }
    
    @Test
    public void testCopy_ThreeWaypointsNotSameReference() {
        Tour tour = new Tour(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        Tour result = tour.copy();
        assertNotEquals(result, tour);
    }
    
    /**
     * Test of createConcatenatedTour method, of class Tour.
     */
    @Test
    public void testCreateConcatenatedTour_EmptyPlusOne() {
        Tour tourA    = new Tour(new int[][]{});
        Tour tourB    = new Tour(new int[][]{{2, 2}});
        Tour expected = new Tour(new int[][]{{2, 2}}); 
        Tour result   = tourA.createConcatenatedTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateConcatenatedTour_EmptyPlusOne_notSame() {
        Tour tourA    = new Tour(new int[][]{});
        Tour tourB    = new Tour(new int[][]{{2, 2}});
        Tour expected = new Tour(new int[][]{{2, 2}}); 
        Tour result   = tourA.createConcatenatedTour(tourB);
        assertNotEquals(result, tourB);
    }
    
    @Test
    public void testCreateConcatenatedTour_OnePlusEmpty() {
        Tour tourA    = new Tour(new int[][]{{2, 2}});
        Tour tourB    = new Tour(new int[][]{});
        Tour expected = new Tour(new int[][]{{2, 2}}); 
        Tour result   = tourA.createConcatenatedTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateConcatenatedTour_thisNotChanged() {
        Tour tourA    = new Tour(new int[][]{{2, 2}, {3, 4}});
        Tour tourB    = new Tour(new int[][]{{4, 5}, {5, 6}, {6, 7}});
        Tour expected = new Tour(new int[][]{{2, 2}, {3, 4}}); 
        Tour unused   = tourA.createConcatenatedTour(tourB);
        assertTrue(tourA.toString(), expected.isEqual(tourA));
    }
    
    @Test
    public void testCreateConcatenatedTour_otherNotChanged() {
        Tour tourA    = new Tour(new int[][]{{2, 2}, {3, 4}});
        Tour tourB    = new Tour(new int[][]{{4, 5}, {5, 6}, {6, 7}});
        Tour expected = new Tour(new int[][]{{4, 5}, {5, 6}, {6, 7}}); 
        Tour unused   = tourA.createConcatenatedTour(tourB);
        assertTrue(tourB.toString(), expected.isEqual(tourB));
    }
    
    /**
     * Test of createTourWithOrder method, of class Tour.
     */
    @Test
    public void testCreateTourWithOrder_ReversedOrder() {
        Tour tour     = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour expected = new Tour(new int[][]{{3, 3}, {2, 2}, {1, 1}, {0, 0}});
        Tour result = tour.createTourWithOrder(new int[]{3, 2, 1, 0});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateTourWithOrder_EveryScndElement() {
        Tour tour     = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour expected = new Tour(new int[][]{{1, 1}, {3, 3}});
        Tour result = tour.createTourWithOrder(new int[]{1, 3});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateTourWithOrder_IndicesLongerThanTour() {
        Tour tour     = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour expected = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour result = tour.createTourWithOrder(new int[]{0, 1, 2, 3, 4, 5});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateTourWithOrder_NotSame() {
        Tour tour     = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour result = tour.createTourWithOrder(new int[]{0, 1, 2, 3, 4, 5});
        assertNotEquals(result, tour);
    }
    
    /**
     * Test of createPopularTour method, of class Tour.
     */
    @Test
    public void testCreatePopularTour_EveryScndWaypointFromFirst() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour tourB = new Tour(new int[][]{{0, 0}, {2, 2}});
        Tour expected = new Tour(new int[][]{{0, 0}, {2, 2}});
        Tour result = tourA.createPopularTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));    
    }
    
    @Test
    public void testCreatePopularTour_EveryScndWaypointFromScnd() {
        Tour tourA = new Tour(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}});
        Tour tourB = new Tour(new int[][]{{1, 1}, {3, 3}});
        Tour expected = new Tour(new int[][]{{1, 1}, {3, 3}});
        Tour result = tourA.createPopularTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));    
    }
    
    @Test
    public void testCreatePopularTour_variedWaypoints() {
        Tour tourA = new Tour(new int[][]{{1, 3}, {1, 1}, {2, 6}, {3, 3}});
        Tour tourB = new Tour(new int[][]{{2, 3}, {3, 3}, {7, 9}, {1, 1}});
        Tour expected = new Tour(new int[][]{{1, 1}, {3, 3}});
        Tour result = tourA.createPopularTour(tourB);
        assertTrue(result.toString(), expected.isEqual(result));    
    }
    
    /**
     * Test of createShortestTour method, of class Tour.
     */
    @Test
    public void testCreateShortestTour_DoubledWaypoint() {
        Tour tour = new Tour(new int[][]{{10, 10}, {1, 1}, {22, 22}, {3, 3}});
        Tour result = tour.createShortestTour(1);
        Tour expected = new Tour(new int[][]{{1, 1}, {3, 3}, {10, 10}, {22, 22}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateShortestTour_InvalidIndex() {
        Tour tour = new Tour(new int[][]{{10, 10}, {1, 1}, {22, 22}, {3, 3}});
        Tour result = tour.createShortestTour(9);
        Tour expected = new Tour();
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    /**
     * Test of createTourWithoutDuplicates method, of class Tour.
     */
    @Test
    public void testCreateTourWithoutDuplicates_MultipleDups() {
        Tour tour = new Tour(new int[][]{{1, 1}, {2, 2}, {1, 1}, {3, 3}, {1, 1}, {1, 1}});
        Tour result = tour.createTourWithoutDuplicates();
        Tour expected = new Tour(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateTourWithoutDuplicates_NotChanging() {
        Tour tour = new Tour(new int[][]{{1, 1}, {2, 2}, {1, 1}, {3, 3}, {1, 1}, {1, 1}});
        Tour unused = tour.createTourWithoutDuplicates();
        Tour expected = new Tour(new int[][]{{1, 1}, {2, 2}, {1, 1}, {3, 3}, {1, 1}, {1, 1}});
        assertTrue(tour.toString(), expected.isEqual(tour));
    }
    
    /**
     * Test of createUnion method, of class Tour.
     */
    @Test
    public void testCreateUnion_thisIsEmpty() {
        Tour tourA = new Tour();
        Tour tourB = new Tour(new int[][]{{12, 12}});
        Tour result = tourA.createUnion(tourB);
        Tour expected = new Tour(new int[][]{{12, 12}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateUnion_otherIsEmpty() {
        Tour tourA = new Tour(new int[][]{{12, 12}});
        Tour tourB = new Tour();
        Tour result = tourA.createUnion(tourB);
        Tour expected = new Tour(new int[][]{{12, 12}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateUnion_SameWaypoints() {
        Tour tourA = new Tour(new int[][]{{12, 12}, {1, 1}});
        Tour tourB = new Tour(new int[][]{{13, 13}, {1, 1}});
        Tour result = tourA.createUnion(tourB);
        Tour expected = new Tour(new int[][]{{12, 12}, {13, 13}, {1, 1}});
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testCreateUnion_NotChangingA() {
        Tour tourA = new Tour(new int[][]{{12, 12}, {1, 1}});
        Tour tourB = new Tour(new int[][]{{13, 13}, {1, 1}});
        Tour unused = tourA.createUnion(tourB);
        Tour expected = new Tour(new int[][]{{12, 12}, {1, 1}});
        assertTrue(tourA.toString(), expected.isEqual(tourA));
    }
    
    @Test
    public void testCreateUnion_NotChangingB() {
        Tour tourA = new Tour(new int[][]{{12, 12}, {1, 1}});
        Tour tourB = new Tour(new int[][]{{13, 13}, {1, 1}});
        Tour unused = tourA.createUnion(tourB);
        Tour expected = new Tour(new int[][]{{13, 13}, {1, 1}});
        assertTrue(tourB.toString(), expected.isEqual(tourB));
    }
    
    //Zum testen des to do's
    
    @Test
    public void testCreateShortestTour_EmptyTour() {
        Tour tour = new Tour();
        Tour result = tour.createShortestTour(0);
        assertTrue(result.toString(), result.isEmpty());
    }
    
    //Zum testen von Fix me 
    
    @Test
    public void testCreateShortestTour_idxSlightlyTooBig() {
        Tour tour = new Tour(new int[][]{{10, 10}, {1, 1}, {22, 22}, {3, 3}});
        Tour result = tour.createShortestTour(4);
        Tour expected = new Tour();
        assertTrue(result.toString(), expected.isEqual(result));
    }
}
