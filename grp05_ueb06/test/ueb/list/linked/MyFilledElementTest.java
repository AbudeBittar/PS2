package ueb.list.linked;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 * Testcases to ensure that linked lists are properly implemented.
 * 
 * @author Marcus Riemer (mri)
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyFilledElementTest {
    
    @Test
    public void testConstruct_singleIntegerElement() {
        MyFilledElement<Integer> e = new MyFilledElement<>(0, new MyElement<>());
        assertEquals(Integer.valueOf(0), e.getPayload());
        assertNotNull(e.getNext());
    }
    
    @Test
    public void testConstruct_singleIntegerElementsdf() {
        MyFilledElement<Integer> e = new MyFilledElement<>(0, new MyElement<>());
        assertEquals(Integer.valueOf(0), e.getPayload());
        assertNotNull(e.getNext());
    }
    
    @Test
    public void testConstruct_singleBooleanElement() {
        final MyElement<Boolean> EMPTY = new MyElement<>();        
        MyFilledElement<Boolean> f = new MyFilledElement<>(false, EMPTY);
        assertEquals(false, f.getPayload());
        assertSame(EMPTY, f.getNext());
        
        MyFilledElement<Boolean> t = new MyFilledElement<>(true, EMPTY);
        assertEquals(true, t.getPayload());
        assertSame(EMPTY, t.getNext());
    }
    
    /**
     * Test of getPayload method, of class MyElement.
     */
    @Test 
    public void testGetPayload() {
        MyFilledElement<Integer> e = new MyFilledElement<>(99, new MyElement<>());
        assertEquals(Integer.valueOf(99), e.getPayload());
    }

    /**
     * Test of getNext method, of class MyElement.
     */
    @Test
    public void testGetNext() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(99, EMPTY);
        assertSame(EMPTY, e.getNext());
    }

    /**
     * Test of getValueAt method, of class MyElement.
     */
    @Test
    public void testGetValueAt_Fst() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(99, EMPTY);
        assertEquals(Integer.valueOf(99), e.getValueAt(0));
    }
    @Test
    public void testGetValueAt_Snd() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertEquals(Integer.valueOf(11), e.getValueAt(0));
        assertEquals(Integer.valueOf(22), e.getValueAt(1));
    }
    @Test
    public void testGetValueAt_IndexOneTooBig() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertNull(e.getValueAt(2));
    }
    @Test
    public void testGetValueAt_IndexTooBig() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertNull(e.getValueAt(3));
    }

    /**
     * Test of isEmpty method, of class MyElement.
     */
    @Test
    public void testIsEmpty() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11, EMPTY);
        assertFalse(e.isEmpty());
        
        MyFilledElement<Integer> f = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertFalse(f.isEmpty());
    }

    /**
     * Test of length method, of class MyElement.
     */
    @Test
    public void testLength() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertEquals(2, e.length());
    }

    /**
     * Test of insertAtFront method, of class MyElement.
     */
    @Test
    public void testInsertAtFront() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(22,  new MyFilledElement<>(33, EMPTY));
        MyElement<Integer> result = e.insertAtFront(11);
        assertEquals(3, result.length());
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
        assertEquals(Integer.valueOf(22), result.getValueAt(1));
        assertEquals(Integer.valueOf(33), result.getValueAt(2));
    }

    /**
     * Test of insertAt method, of class MyElement.
     */
    @Test
    public void testInsertAt_First() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(22,  new MyFilledElement<>(33, EMPTY));
        MyElement<Integer> result = e.insertAt(0, 11);
        assertEquals(3, result.length());
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
        assertEquals(Integer.valueOf(22), result.getValueAt(1));
        assertEquals(Integer.valueOf(33), result.getValueAt(2));       
    }
    
    @Test
    public void testInsertAt_Snd() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(33, EMPTY));
        MyElement<Integer> result = e.insertAt(1, 22);
        assertEquals(3, result.length());
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
        assertEquals(Integer.valueOf(22), result.getValueAt(1));
        assertEquals(Integer.valueOf(33), result.getValueAt(2));       
    }
    
    @Test
    public void testInsertAt_Last() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyElement<Integer> result = e.insertAt(2, 33);
        assertEquals(3, result.length());
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
        assertEquals(Integer.valueOf(22), result.getValueAt(1));
        assertEquals(Integer.valueOf(33), result.getValueAt(2));       
    }
    
    @Test 
    public void testInsertAt_InvalidIndex() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyElement<Integer> result = e.insertAt(3, 33);
        assertEquals(2, result.length());
    }

    /**
     * Test of removeAt method, of class MyElement.
     */
    @Test
    public void testRemoveAt_First() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyElement<Integer> result = e.removeAt(0);
        assertEquals(1, result.length());
        assertEquals(Integer.valueOf(22), result.getValueAt(0));
    }
    @Test
    public void testRemoveAt_Last() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyElement<Integer> result = e.removeAt(1);
        assertEquals(1, result.length());
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
    }
    @Test 
    public void testRemoveAt_InvalidIndex() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyElement<Integer> result = e.removeAt(2);
        assertEquals(2, result.length());        
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
        assertEquals(Integer.valueOf(22), result.getValueAt(1));
    }

    /**
     * Test of append method, of class MyElement.
     */
    @Test
    public void testAppend() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyElement<Integer> result = e.append(33);
        assertEquals(3, result.length());
        assertEquals(Integer.valueOf(11), result.getValueAt(0));
        assertEquals(Integer.valueOf(22), result.getValueAt(1));
        assertEquals(Integer.valueOf(33), result.getValueAt(2)); 
    }

    /**
     * Test of equals method, of class MyElement.
     */
    @Test
    public void testEquals_ListOfTwo() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyFilledElement<Integer> o = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertEquals(e, o);
    }
    @Test
    public void testEquals_DifferentElements() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyFilledElement<Integer> o = new MyFilledElement<>(22,  new MyFilledElement<>(11, EMPTY));
        assertNotEquals(e, o);
        assertNotEquals(o, e);
    }
    @Test
    public void testEquals_OneShorter() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        MyFilledElement<Integer> o = new MyFilledElement<>(11,  EMPTY);
        assertNotEquals(e, o);
        assertNotEquals(o, e);
    }

    /**
     * Test of toString method, of class MyElement.
     */
    @Test
    public void testToString() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  new MyFilledElement<>(22, EMPTY));
        assertEquals("11, 22", e.toString());
    }
    @Test
    public void testToString_OneElement() {
        final MyElement<Integer> EMPTY = new MyElement<>();  
        MyFilledElement<Integer> e = new MyFilledElement<>(11,  EMPTY);
        assertEquals("11", e.toString());
    }
       
    
}
