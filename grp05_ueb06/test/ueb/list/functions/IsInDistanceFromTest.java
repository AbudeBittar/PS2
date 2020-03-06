package ueb.list.functions;

import org.junit.Test;
import static org.junit.Assert.*;
import ueb.Waypoint;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class IsInDistanceFromTest {
    @Test
    public void testCall_IsInDistance() {
        PredicateFunctionObject<Waypoint> p = new IsInDistanceFrom(new Waypoint(5, 0), 5);
        assertTrue(p.call(new Waypoint(5, 0)));
        assertTrue(p.call(new Waypoint(1, 0)));
        assertTrue(p.call(new Waypoint(6, 1)));
    }
    
    @Test
    public void testCall_IsNotInDistance() {
        PredicateFunctionObject<Waypoint> p = new IsInDistanceFrom(new Waypoint(5, 0), 5);
        assertFalse(p.call(new Waypoint(0, 5)));
        assertFalse(p.call(new Waypoint(-1, 0)));
        assertFalse(p.call(new Waypoint(11, 0)));
    }
}
