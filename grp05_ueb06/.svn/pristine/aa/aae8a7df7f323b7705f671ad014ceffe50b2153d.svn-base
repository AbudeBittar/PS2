package ueb.list.functions;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class IsPalindromeTest {
    @Test
    public void testCall_IsPalindrome() {
        PredicateFunctionObject<String> p = new IsPalindrome();
        assertTrue(p.call("anna"));
        assertTrue(p.call("derfred"));
        assertTrue(p.call("reliefpfeiler"));
    }
    
    @Test
    public void testCall_IsNotPalindrome() {
        PredicateFunctionObject<String> p = new IsPalindrome();
        assertFalse(p.call("hallo"));
        assertFalse(p.call("keine"));
        assertFalse(p.call("palindrome"));
    }
    
    @Test
    public void testCall_ignoreCase() {
        PredicateFunctionObject<String> p = new IsPalindrome();
        assertFalse(p.call("HeLLo"));
        assertTrue(p.call("WoW"));
        assertTrue(p.call("aHahA"));
    }
}
