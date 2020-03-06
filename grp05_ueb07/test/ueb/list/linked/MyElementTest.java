//package ueb.list.linked;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.FixMethodOrder;
//import org.junit.runners.MethodSorters;
//
///**
// *
// * @author klk
// */
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class MyElementTest {
//    
//    /**
//     * Test of getPayload method, of class MyElement.
//     */
//    @Test (expected = AssertionError.class)
//    public void testGetPayload() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        myElem.getPayload();
//    }
//
//    /**
//     * Test of getNext method, of class MyElement.
//     */
//    @Test (expected = AssertionError.class)
//    public void testGetNext() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        myElem.getNext();
//    }
//
//    /**
//     * Test of getValueAt method, of class MyElement.
//     */
//    @Test 
//    public void testGetValueAt() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        assertNull(myElem.getValueAt(0));
//    }
//
//    /**
//     * Test of isEmpty method, of class MyElement.
//     */
//    @Test
//    public void testIsEmpty() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        assertTrue(myElem.isEmpty());
//    }
//
//    /**
//     * Test of length method, of class MyElement.
//     */
//    @Test
//    public void testLength() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        assertEquals(0, myElem.length());
//    }
//
//    /**
//     * Test of insertAtFront method, of class MyElement.
//     */
//    @Test
//    public void testInsertAtFront() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        MyEmptyElement<Integer> result = myElem.insertAtFront(99);
//        assertEquals(Integer.valueOf(99), result.getPayload());
//        assertNotNull(result.getNext());
//        assertEquals(1, result.length());
//        assertEquals(MyFilledElement.class, result.getClass());
//        assertEquals(MyEmptyElement.class, result.getNext().getClass());
//    }
//
//    /**
//     * Test of insertAt method, of class MyElement.
//     */
//    @Test
//    public void testInsertAt_First() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        MyEmptyElement<Integer> result = myElem.insertAt(0, 99);
//        assertEquals(Integer.valueOf(99), result.getPayload());
//        assertNotNull(result.getNext());
//        assertEquals(1, result.length());
//        assertEquals(MyFilledElement.class, result.getClass());
//        assertEquals(MyEmptyElement.class, result.getNext().getClass());        
//    }
//    
//    @Test
//    public void testInsertAt_InvalidIndex() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        MyEmptyElement<Integer> result = myElem.insertAt(1, 99);
//        assertSame(myElem, result);
//    }
//
//    /**
//     * Test of removeAt method, of class MyElement.
//     */
//    @Test
//    public void testRemoveAtIndex() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        MyEmptyElement<Integer> result = myElem.removeAt(0);
//        assertSame(myElem, result);
//    }
//
//    /**
//     * Test of append method, of class MyElement.
//     */
//    @Test
//    public void testAppend() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        MyEmptyElement<Integer> result = myElem.append(99);
//        assertEquals(Integer.valueOf(99), result.getPayload());
//        assertNotNull(result.getNext());
//        assertEquals(1, result.length());
//        assertEquals(MyFilledElement.class, result.getClass());
//        assertEquals(MyEmptyElement.class, result.getNext().getClass());
//    }
//
//    /**
//     * Test of equals method, of class MyElement.
//     */
//    @Test
//    public void testEquals() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        assertTrue(myElem.equals(new MyEmptyElement<>()));
//        assertTrue(new MyEmptyElement<>().equals(myElem));
//        assertFalse(myElem.equals(null));
//        assertFalse(myElem.equals(0));
//    }
//
//    /**
//     * Test of toString method, of class MyElement.
//     */
//    @Test
//    public void testToString() {
//        MyEmptyElement<Integer> myElem = new MyEmptyElement<>();
//        assertEquals("", myElem.toString());
//    }
//
//    
//}
