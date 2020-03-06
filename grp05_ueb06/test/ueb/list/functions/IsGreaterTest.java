package ueb.list.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marcus Riemer (mri)
 */
public class IsGreaterTest {
    @Test
    public void testCall_negative() {
        PredicateFunctionObject<Integer> p = new IsGreater(-10);
        assertFalse(p.call(-11));
        assertFalse(p.call(-10));
        assertTrue(p.call(-9));
    }
    
    @Test
    public void testCall_zero() {
        PredicateFunctionObject<Integer> p = new IsGreater(0);
        assertFalse(p.call(-1));
        assertFalse(p.call(0));
        assertTrue(p.call(1));
    }
    
    @Test
    public void testCall_positive() {
        PredicateFunctionObject<Integer> p = new IsGreater(10);
        assertFalse(p.call(9));
        assertFalse(p.call(10));
        assertTrue(p.call(11));
    }
    
    @Test
    public void testCall_upperLimits() {
        PredicateFunctionObject<Integer> p = new IsGreater(Integer.MAX_VALUE);
        assertFalse(p.call(Integer.MAX_VALUE));
        assertFalse(p.call(Integer.MAX_VALUE + 1));
    }
    
    @Test
    public void testCall_lowerLimits() {
        PredicateFunctionObject<Integer> p = new IsGreater(Integer.MIN_VALUE);
        assertFalse(p.call(Integer.MIN_VALUE));
        assertTrue(p.call(Integer.MIN_VALUE + 1));
        assertTrue(p.call(Integer.MAX_VALUE));
    }
}
