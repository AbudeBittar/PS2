package ueb.list.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class IsHarshadNumberTest {
    @Test
    public void testCall_negative() {
        PredicateFunctionObject<Integer> p = new IsHarshadNumber();
        assertFalse(p.call(-11));
        assertFalse(p.call(-10));
        assertFalse(p.call(-9));
    }
    
    @Test
    public void testCall_zero() {
        PredicateFunctionObject<Integer> p = new IsHarshadNumber();
        assertFalse(p.call(-1));
        assertFalse(p.call(0));
        assertTrue(p.call(1));
    }
    
    @Test
    public void testCall_positive() {
        PredicateFunctionObject<Integer> p = new IsHarshadNumber();
        assertFalse(p.call(43));
        assertTrue(p.call(10));
        assertTrue(p.call(12));
    }
}
