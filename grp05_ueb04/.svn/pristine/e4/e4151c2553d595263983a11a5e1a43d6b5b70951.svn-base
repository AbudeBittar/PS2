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
public class TourElementTest4 {
    
//<editor-fold defaultstate="collapsed" desc="Test of Mrs. Kaleck">
    
    /**
     * Creates a ElementList with the given waypoints.
     * @param waypoints array of waypoints to use, the coordinates of the waypoints are also in an array
     * @return List of elements with the given waypoints
     * @pre at least one waypoint has to be in array
     */
    private TourElement createElementList(int[][] waypoints){
        assert waypoints.length > 0;
        int         lastIndex = waypoints.length-1;
        Waypoint    wp        = new Waypoint(waypoints[lastIndex][0], waypoints[lastIndex][1]);
        TourElement elem      = new TourElement(wp);
        for (int i = lastIndex-1; i >= 0 ; i--) {
            wp = new Waypoint(waypoints[i][0], waypoints[i][1]);
            elem = elem.addStart(wp);
        }
        return elem;
    }    
    
    /**
     * Test of constructors, of class TourElement.
     */
    @Test
    public void testTourElement() {
        //the constructor is expected to exist
        TourElement element = new TourElement();
        assertNull(element.getWaypoint());
    }
    
    @Test
    public void testTourElement_Waypoint() {
        //the constructor is expected to exist
        TourElement element = new TourElement(new Waypoint(1, 2));
        assertTrue(new Waypoint(1, 2).isEqual(element.getWaypoint()));
        assertNull(element.getNext());
    }
    
    @Test
    public void testTourElement_Waypoint_TourElement() {
        //the constructor is expected to exist
        TourElement next = new TourElement();
        TourElement element = new TourElement(new Waypoint(1, 2), next);
        assertTrue(new Waypoint(1, 2).isEqual(element.getWaypoint()));
        assertSame(next, element.getNext());
    }
    
    /**
     * Test of isEqual method, of class TourElement.
     */
    @Test
    public void test0IsEqual_ThreeElements() {
        TourElement elemA = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        TourElement elemB = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertTrue(elemA.isEqual(elemB));
    }
    
    @Test
    public void test0IsEqual_OneElement() {
        TourElement elemA = createElementList(new int[][]{{1, 1}});
        TourElement elemB = createElementList(new int[][]{{1, 1}});
        assertTrue(elemA.isEqual(elemB));
    }
    
    @Test
    public void test0IsEqual_NotEqualOneElement() {
        TourElement elemA = createElementList(new int[][]{{1, 1}});
        TourElement elemB = createElementList(new int[][]{{2, 2}});
        assertFalse(elemA.isEqual(elemB));
    }
    
    @Test
    public void test0IsEqual_FirstShorter() {
        TourElement elemA = createElementList(new int[][]{{1, 1}, {2, 2}});
        TourElement elemB = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertFalse(elemA.isEqual(elemB));
    }
    
    @Test
    public void test0IsEqual_FirstLonger() {
        TourElement elemA = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        TourElement elemB = createElementList(new int[][]{{1, 1}, {2, 2}});
        assertFalse(elemA.isEqual(elemB));
    }  
    
    @Test
    public void test0IsEqual_FirstDiffers() {
        TourElement elemA = createElementList(new int[][]{{0, 0}, {2, 2}, {3, 3}});
        TourElement elemB = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertFalse(elemA.isEqual(elemB));
    }
    
    @Test
    public void test0IsEqual_LastDiffers() {
        TourElement elemA = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        TourElement elemB = createElementList(new int[][]{{1, 1}, {2, 2}, {9, 9}});
        assertFalse(elemA.isEqual(elemB));
    }  
    
    @Test
    public void test0IsEqual_Null() {
        TourElement elem = createElementList(new int[][]{{1, 1}, {2, 2}, {3, 3}});
        assertFalse(elem.isEqual(null));
    }  
    
    /**
     * Test of concat method, of class TourElement.
     */
    
    @Test
    public void testConcat_TwoListsOfOneElement() {
        TourElement elemA = createElementList(new int[][]{{0, 1}});
        TourElement elemB = createElementList(new int[][]{{2, 3}});
        TourElement expected = createElementList(new int[][]{{0, 1}, {2, 3}});
        TourElement result = elemA.concat(elemB);
        assertTrue(result.toString(), expected.isEqual(result));
    }

    /**
     * Test of getIdxOfClosestWaypoint method, of class TourElement.
     */
    
    @Test
    public void testGetIdxOfClosestWaypoint_FirstSame() {
        TourElement elem = createElementList(new int[][]{{1, 1}, {10, 10}, {100, 100}, {1000, 1000}});
        Waypoint closeWp = new Waypoint(1, 1);
        assertEquals(0, elem.getIdxOfClosestWaypoint(closeWp));
    }
    
    //</editor-fold>
    
    // Eigene Tests von Jan R. Neumann & Abdulrahman Al Bittar 
    
    /**
     * Test of concat method, of class TourElement.
     */
    @Test
    public void testConcat_AddOneElementListOntoThreeElementList() {
        TourElement elemA = createElementList(new int[][]{{0, 1}, {2, 3}, {4, 5}});
        TourElement elemB = createElementList(new int[][]{{6, 7}});
        TourElement expected = createElementList(new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}});
        TourElement result = elemA.concat(elemB);
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    @Test
    public void testConcat_AddTwoElementListOntoThreeElementList() {
        TourElement elemA = createElementList(new int[][]{{0, 1}, {2, 3}, {4, 5}});
        TourElement elemB = createElementList(new int[][]{{6, 7}, {8, 9}});
        TourElement expected = createElementList(new int[][]{{0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}});
        TourElement result = elemA.concat(elemB);
        assertTrue(result.toString(), expected.isEqual(result));
    }
    
    /**
     * Test of getIdxOfClosestWaypoint method, of class TourElement.
     */
    
    @Test
    public void testGetIdxOfClosestWaypoint_FirstClose() {
        TourElement elem = createElementList(new int[][]{{2, 2}, {10, 10}, {100, 100}, {1000, 1000}});
        Waypoint closeWp = new Waypoint(1, 1);
        assertEquals(0, elem.getIdxOfClosestWaypoint(closeWp));
    }
  
    @Test
    public void testGetIdxOfClosestWaypoint_SecondSame() {
        TourElement elem = createElementList(new int[][]{{2, 2}, {10, 10}, {100, 100}, {1000, 1000}});
        Waypoint closeWp = new Waypoint(10, 10);
        assertEquals(1, elem.getIdxOfClosestWaypoint(closeWp));
    }
    
    @Test
    public void testGetIdxOfClosestWaypoint_LastSame() {
        TourElement elem = createElementList(new int[][]{{2, 2}, {10, 10}, {100, 100}, {1000, 1000}});
        Waypoint closeWp = new Waypoint(1000, 1000);
        assertEquals(3, elem.getIdxOfClosestWaypoint(closeWp));
    }
    
    @Test
    public void testGetIdxOfClosestWaypoint_MultipleSame() {
        TourElement elem = createElementList(new int[][]{{2, 2}, {10, 10}, {100, 100}, {10, 10}});
        Waypoint closeWp = new Waypoint(10, 10);
        assertEquals(1, elem.getIdxOfClosestWaypoint(closeWp));
    }
    
    //Zum testen des to do's
    @Test
    public void testGetIdxOfClosestWaypoint_SameDistanceBetweenTwo() {
        TourElement elem = createElementList(new int[][]{{0, 0}, {10, 10}});
        Waypoint closeWp = new Waypoint(5, 5);
        assertEquals(0, elem.getIdxOfClosestWaypoint(closeWp));
    }
}
