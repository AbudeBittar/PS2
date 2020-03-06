package ueb.list.linked;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import ueb.Waypoint;
import ueb.list.functions.IsGreater;
import ueb.list.functions.IsPalindrome;
import ueb.list.functions.IsHarshadNumber;
import ueb.list.functions.IsInDistanceFrom;

/**
 *
 * @author Marcus Riemer (mri), klk
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyLinkedListTest {
    
    @Test
    public void testConstruct_EmptyIntegerList() {
        MyLinkedList<Integer> l = new MyLinkedList<>();
        
        assertTrue(l.isEmpty());
        assertEquals("[]", l.toString());
    }
    
    @Test
    public void testConstruct_SingleIntegerElement() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0);
        
        assertFalse(l.isEmpty());
        assertEquals(Integer.valueOf(0), l.getValueAt(0));
        assertEquals("[0]", l.toString());
    }
    
    @Test
    public void testConstruct_SingleStringElement() {
        MyLinkedList<String> l = new MyLinkedList<>("0");
        
        assertFalse(l.isEmpty());
        assertEquals("0", l.getValueAt(0));
        assertEquals("[0]", l.toString());
    }
    
    @Test
    public void testConstruct_SingleBooleanElement() {
        MyLinkedList<Boolean> l = new MyLinkedList<>(false);
        
        assertFalse(l.isEmpty());
        assertEquals(false, l.getValueAt(0));
        assertEquals("[false]", l.toString());
    }
    
    /**
     * Test of using Raw-types
     */
    @Test
    public void testDidntUseRawTypes() {
        MyLinkedList<String> strL = new MyLinkedList("B", "C");
        /* if you used raw-types in your listdefinition, 
           l.getValueAt() will return an object and 
           toLowerCase() won´t work with it */
        assertEquals("b", strL.getValueAt(0).toLowerCase()); 
        
        MyLinkedList<Waypoint> wpL = new MyLinkedList(new Waypoint(1,1), new Waypoint(1,2));
        /* if you used raw-types in your listdefinition, 
           l.getValueAt() will return an object and 
           calcDistance() won´t work with it */
        assertEquals(1, wpL.getValueAt(0).calcDistance(wpL.getValueAt(1)), 0.00001);
    }
    
    
    /**
     * Test of getValueAt method, of class MyLinkedList.
     */
    @Test
    public void testGetValueAt_Fst() {
        MyLinkedList<Integer> e = new MyLinkedList<>(1, 2, 3);
        assertEquals(Integer.valueOf(1), e.getValueAt(0));
    }
    @Test
    public void testGetValueAt_Snd() {
        MyLinkedList<Integer> e = new MyLinkedList<>(1, 2, 3);
        assertEquals(Integer.valueOf(1), e.getValueAt(0));
        assertEquals(Integer.valueOf(2), e.getValueAt(1));
    }
    @Test
    public void testGetValueAt_IndexOneTooBig() {
        MyLinkedList<Integer> e = new MyLinkedList<>(1, 2, 3);
        assertNull(e.getValueAt(3));
    }
    @Test
    public void testGetValueAt_IndexTooBig() {
        MyLinkedList<Integer> e = new MyLinkedList<>(1, 2, 3);
        assertNull(e.getValueAt(4));
    }

    /**
     * Test of isEmpty method, of class MyLinkedList.
     */
    @Test
    public void testIsEmpty() {
        MyLinkedList<Integer> e = new MyLinkedList<>();
        assertTrue(e.isEmpty());
        
        MyLinkedList<Integer> f = new MyLinkedList<>(99);
        assertFalse(f.isEmpty());
    }

    /**
     * Test of length method, of class MyLinkedList.
     */
    @Test
    public void testLength() {
        MyLinkedList<Integer> e = new MyLinkedList<>();
        assertEquals(0, e.length());
        
        MyLinkedList<Integer> l = new MyLinkedList<>(88, 99);
        assertEquals(2, l.length());
    }
    
    /**
     * Test of append method, of class MyLinkedList.
     */
    @Test
    public void testAppend() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 22);
        l.append(33);
        MyLinkedList<Integer> expected = new MyLinkedList<>(11, 22, 33);
        assertEquals(3, l.length());
        assertEquals(expected, l); 
    }  
    
    @Test
    public void testAppend_AllBooleanValues() {
        MyLinkedList<Boolean> l = new MyLinkedList<>();
        
        assertTrue(l.isEmpty());
        
        l.append(false);
        assertFalse(l.isEmpty());
        assertEquals(false, l.getValueAt(0));
        
        l.append(true);
        assertFalse(l.isEmpty());
        assertEquals(false, l.getValueAt(0));
        assertEquals(true, l.getValueAt(1));
        
        assertEquals("[false, true]", l.toString());
    }
    
    @Test
    public void testAppend_DigitValues() {
        MyLinkedList<Integer> l = new MyLinkedList<>();
        
        assertTrue(l.isEmpty());
        
        l.append(0);
        assertFalse(l.isEmpty());
        assertEquals(Integer.valueOf(0), l.getValueAt(0));
        
        l.append(1);
        assertFalse(l.isEmpty());
        assertEquals(Integer.valueOf(0), l.getValueAt(0));
        assertEquals(Integer.valueOf(1), l.getValueAt(1));
        
        l.append(2);
        assertFalse(l.isEmpty());
        assertEquals(Integer.valueOf(0), l.getValueAt(0));
        assertEquals(Integer.valueOf(1), l.getValueAt(1));
        assertEquals(Integer.valueOf(2), l.getValueAt(2));
    }
    
    /**
     * Test of insertAtFront method, of class MyLinkedList.
     */
    @Test
    public void testInsertAtFront() {
        MyLinkedList<Integer> l = new MyLinkedList<>(22, 33);
        l.insertAtFront(11);
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));
    }

    /**
     * Test of insertAt method, of class MyLinkedList.
     */
    @Test
    public void testInsertAt_First() {
        MyLinkedList<Integer> l = new MyLinkedList<>(22, 33);
        l.insertAt(0, 11);
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));       
    }
    
    @Test
    public void testInsertAt_Snd() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 33);
        l.insertAt(1, 22);
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));       
    }
    
    @Test
    public void testInsertAt_Last() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 22);
        l.insertAt(2, 33);
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));       
    }
    
    @Test 
    public void testInsertAt_InvalidIndex() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 22);
        l.insertAt(3, 33);
        assertEquals(2, l.length());
    }

    /**
     * Test of removeAt method, of class MyLinkedList.
     */
    @Test
    public void testRemoveAt_First() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 33);
        l.removeAt(0);
        assertEquals(1, l.length());
        assertEquals(Integer.valueOf(33), l.getValueAt(0));
    }
    @Test
    public void testRemoveAt_Last() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 22);
        l.removeAt(1);
        assertEquals(1, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
    }
    @Test 
    public void testRemoveAt_InvalidIndex() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 22);
        l.removeAt(2);
        assertEquals(2, l.length());        
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
    }

    /**
     * Test of equals method, of class MyLinkedList.
     */
    @Test
    public void testEquals_ListOfTwo() {
        MyLinkedList<Integer> a = new MyLinkedList<>(11, 22);
        MyLinkedList<Integer> b = new MyLinkedList<>(11, 22);
        assertEquals(a, b);
    }
    @Test
    public void testEquals_DifferentElements() {
        MyLinkedList<Integer> e = new MyLinkedList<>(11, 22);
        MyLinkedList<Integer> o = new MyLinkedList<>(22, 11);
        assertNotEquals(e, o);
        assertNotEquals(o, e);
    }
    @Test
    public void testEquals_OneShorter() {
        MyLinkedList<Integer> e = new MyLinkedList<>(11, 22);
        MyLinkedList<Integer> o = new MyLinkedList<>(11);
        assertNotEquals(e, o);
        assertNotEquals(o, e);
    }

    /**
     * Test of toString method, of class MyLinkedList.
     */
    @Test
    public void testToString() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11, 22);
        assertEquals("[11, 22]", l.toString());
    }
    @Test
    public void testToString_OneElement() {
        MyLinkedList<Integer> l = new MyLinkedList<>(11);
        assertEquals("[11]", l.toString());
    }
       

    /**
     * Test of filterThis method, of class MyLinkedList.
     */    
    @Test
    public void testFilterThis_IsGreater() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        
        l.filterThis(new IsGreater(0));
        
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(1), l.getValueAt(0));
        assertEquals(Integer.valueOf(2), l.getValueAt(1));
        assertEquals(Integer.valueOf(3), l.getValueAt(2));
    }
    
    /**
     * Test of filter method, of class MyLinkedList.
     */     
    @Test
    public void testFilter_IsGreater() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        MyLinkedList<Integer> unChanged = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        
        MyLinkedList<Integer> result = l.filter(new IsGreater(0));
        
        assertEquals(3, result.length());
        assertEquals(Integer.valueOf(1), result.getValueAt(0));
        assertEquals(Integer.valueOf(2), result.getValueAt(1));
        assertEquals(Integer.valueOf(3), result.getValueAt(2));
        
        assertEquals(unChanged, l);
    }
    
    /**
     * Test of find method, of class MyLinkedList.
     */     
    @Test
    public void testFind_IsGreater() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        
        assertEquals(Integer.valueOf(1), l.find(new IsGreater(0)));
        assertEquals(Integer.valueOf(2), l.find(new IsGreater(1)));
        assertEquals(Integer.valueOf(3), l.find(new IsGreater(2)));
    }
    
    @Test
    public void testFind_IsGreater_Not() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        
        assertNull(l.find(new IsGreater(3)));
    }
    
    /**
     * Test of exists method, of class MyLinkedList.
     */     
    @Test
    public void testExists_IsGreater() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        
        assertTrue(l.exists(new IsGreater(0)));
        assertTrue(l.exists(new IsGreater(1)));
        assertTrue(l.exists(new IsGreater(2)));
    }
    
    @Test
    public void testExists_IsGreater_Not() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        
        assertFalse(l.exists(new IsGreater(3)));
    }
    
    /**
     * Test of forAll method, of class MyLinkedList.
     */     
    @Test
    public void testforAll_IsGreater() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        assertTrue(l.forAll(new IsGreater(-1)));
        
        l = new MyLinkedList<>(5);
        assertTrue(l.forAll(new IsGreater(4)));
        
        l = new MyLinkedList<>();
        assertTrue(l.forAll(new IsGreater(4)));
    }
    
    @Test
    public void testforAll_IsGreater_Not() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        assertFalse(l.forAll(new IsGreater(1)));
        
        l = new MyLinkedList<>(10, 11, 9, 22);
        assertFalse(l.forAll(new IsGreater(9)));
        
        l = new MyLinkedList<>(11, 11, 11, 9);
        assertFalse(l.forAll(new IsGreater(10)));
    }

    // Eigene tests von Jan R. Neumann & Abdulrajman Al Bittar
    
    @Test
    public void testConstruct_notSame() {
        MyLinkedList<Boolean> l = new MyLinkedList<>(false, true , false);
        MyLinkedList<Boolean> li = new MyLinkedList<>(l);
        assertFalse(li.isEmpty());
        assertNotSame(l, li);
        assertTrue(l.equals(li));
    }

    @Test
    public void testFilterThis_IsPalindrome() {
        MyLinkedList<String> l = new MyLinkedList<>("Anna", "Bert", "Cassie", "DerFred", "Eve");
        
        l.filterThis(new IsPalindrome());
        
        assertEquals(3, l.length());
        assertEquals("Anna", l.getValueAt(0));
        assertEquals("DerFred", l.getValueAt(1));
        assertEquals("Eve", l.getValueAt(2));
    }
    
    @Test
    public void testforAll_IsHarshadNumber() {
        MyLinkedList<Integer> l = new MyLinkedList<>(0, 1, 0, 2, 0, 3);
        assertFalse(l.forAll(new IsHarshadNumber()));
        
        l = new MyLinkedList<>(12, 3);
        assertTrue(l.forAll(new IsHarshadNumber()));
        
        l = new MyLinkedList<>();
        assertTrue(l.forAll(new IsHarshadNumber()));
    }
    
    @Test
    public void testFilter_IsInDistanceFrom() {
        Waypoint wp1 = new Waypoint(0, 1);
        Waypoint wp2 = new Waypoint(0, 5);
        Waypoint wp3 = new Waypoint(0, 12);
        MyLinkedList<Waypoint> l = new MyLinkedList<>(wp1, wp2, wp3);
        
        MyLinkedList<Waypoint> li = l.filter(new IsInDistanceFrom(new Waypoint(0, 5), 5));
        
        assertEquals(2, li.length());
        assertEquals(wp1, li.getValueAt(0));
        assertEquals(wp2, li.getValueAt(1));
        
        assertEquals(3, l.length());
        assertEquals(wp1, l.getValueAt(0));
        assertEquals(wp2, l.getValueAt(1));
        assertEquals(wp3, l.getValueAt(2));
    }
}
