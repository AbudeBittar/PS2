/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import ueb.list.functions.IsGreater;
import ueb.list.functions.IsHarshadNumber;
import ueb.list.functions.IsPalindrome;
import ueb.list.linked.MyLinkedList;

/**
 *
 * @author 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class MyListTestBase {
    
    public abstract MyList<String> createStringList(String...values);
    
    public abstract MyList<Integer> createIntegerList(Integer...values);
    
    /* TODO DONE Da für die Klassen unterschiedliche Konstruktoren gefordert sind, 
       sollten die Konstruktortests in den konkreten Testklassen auftauchen. 
    */
    
    /**
     * Test of using Raw-types
     */
//    @Test
//    public void testDidntUseRawTypes() {
//        MyLinkedList<String> strL = new MyLinkedList("B", "C");
//        /* if you used raw-types in your listdefinition, 
//           l.getValueAt() will return an object and 
//           toLowerCase() won´t work with it */
//        assertEquals("b", strL.getValueAt(0).toLowerCase()); 
//        
//        MyLinkedList<Waypoint> wpL = new MyLinkedList(new Waypoint(1,1), new Waypoint(1,2));
//        /* if you used raw-types in your listdefinition, 
//           l.getValueAt() will return an object and 
//           calcDistance() won´t work with it */
//        assertEquals(1, wpL.getValueAt(0).calcDistance(wpL.getValueAt(1)), 0.00001);
//    }
 
    /* TODO DONE Alle folgenden Tests sollen ihre Listen mit createList() 
    bzw. createStringList() oder createIntegerList() erzeugen (siehe Allgemeines Forum).
    Jede Methode von MyList sollte hier gründlich getestet werden.
    Durch die Vererbungsstruktur der Tests werden die Testmethoden dann für 
    alle Listen ausgeführt, also auch die Array-Listen sorgfältig getestet.
    */
    
    
    /**
     * Test of getValueAt method, of class MyLinkedList.
     */
    @Test
    public void testGetValueAt_Fst() {
        MyList<Integer> e = createIntegerList(1,2,3);
        assertEquals(Integer.valueOf(1), e.getValueAt(0));
    }
    @Test
    public void testGetValueAt_Snd() {
        MyList<Integer> e = createIntegerList(1,2,3);
        assertEquals(Integer.valueOf(1), e.getValueAt(0));
        assertEquals(Integer.valueOf(2), e.getValueAt(1));
    }
    @Test
    public void testGetValueAt_IndexOneTooBig() {
        MyList<Integer> e = createIntegerList(1,2,3);
        assertNull(e.getValueAt(3));
    }
    @Test
    public void testGetValueAt_IndexTooBig() {
        MyList<Integer> e = createIntegerList(1,2,3);
        assertNull(e.getValueAt(4));
    }

    /**
     * Test of isEmpty method, of class MyLinkedList.
     */
    @Test
    public void testIsEmpty() {
        MyList<Integer> e = createIntegerList();
        assertTrue(e.isEmpty());
        
        MyList<Integer> f = createIntegerList(99);
        assertFalse(f.isEmpty());
    }

    /**
     * Test of length method, of class MyLinkedList.
     */
    @Test
    public void testLength() {
        MyList<Integer> e = createIntegerList();
        assertEquals(0, e.length());
        
        MyList<Integer> l = createIntegerList(88,99);
        assertEquals(2, l.length());
    }
    
    /**
     * Test of append method, of class MyLinkedList.
     */
    @Test
    public void testAppend() {
        MyList<Integer> l = createIntegerList(11,22);
        l.append(33);
        MyList<Integer> expected = createIntegerList(11,22,33);
        assertEquals(3, l.length());
        assertEquals(expected, l); 
    }  
    
    @Test
    public void testAppend_AllStringValues() {
        MyList<String> l = createStringList();
        
        assertTrue(l.isEmpty());
        
        l.append("false");
        assertFalse(l.isEmpty());
        assertEquals("false", l.getValueAt(0));
        
        l.append("true");
        assertFalse(l.isEmpty());
        assertEquals("false", l.getValueAt(0));
        assertEquals("true", l.getValueAt(1));
        
        assertEquals("[false, true]", l.toString());
    }
    
    @Test
    public void testAppend_DigitValues() {
        MyList<Integer> l = createIntegerList();
        
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
        MyList<Integer> l = createIntegerList(22,33);
        l.insertAtFront(11);
        assertEquals(3, l.length());
        assertEquals("[11, 22, 33]", l.toString());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));
    }

    /**
     * Test of insertAt method, of class MyLinkedList.
     */
    @Test
    public void testInsertAt_First() {
        MyList<Integer> l = createIntegerList(22,33);
        l.insertAt(0, 11);
        assertEquals(3, l.length());
        assertEquals("[11, 22, 33]", l.toString());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));       
    }
    
    @Test
    public void testInsertAt_Snd() {
        MyList<Integer> l = createIntegerList(11,33);
        l.insertAt(1, 22);
        assertEquals(3, l.length());
        assertEquals("[11, 22, 33]", l.toString());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));       
    }
    
    @Test
    public void testInsertAt_Last() {
        MyList<Integer> l = createIntegerList(11,22);
        l.insertAt(2, 33);
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));       
    }
    
    @Test 
    public void testInsertAt_InvalidIndex() {
        MyList<Integer> l = createIntegerList(11,22);
        l.insertAt(3, 33);
        assertEquals(2, l.length());
    }

    /**
     * Test of removeAt method, of class MyLinkedList.
     */
    @Test
    public void testRemoveAt_First() {
        MyList<Integer> l = createIntegerList(11,33);
        l.removeAt(0);
        assertEquals(1, l.length());
        assertEquals(Integer.valueOf(33), l.getValueAt(0));
    }
    @Test
    public void testRemoveAt_Last() {
        MyList<Integer> l = createIntegerList(11,22);
        l.removeAt(1);
        assertEquals(1, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
    }
    @Test 
    public void testRemoveAt_InvalidIndex() {
        MyList<Integer> l = createIntegerList(11,22);
        l.removeAt(2);
        assertEquals(2, l.length());        
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
    }
    
    //TODO DONE mehrere Tests für replaceAt() implementieren (sorgfältig Randfälle überlegen)
    
    /**
     * Test für ReplaceAt Methode
     */
    @Test
    public void testReplaceAt_fst() {
        MyList<Integer> l = createIntegerList(11,22,33);
        l.replaceAt(0, 44);
        assertEquals(3, l.length());        
        assertEquals(Integer.valueOf(44), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));
    }
    
    @Test
    public void testReplaceAt_snd() {
        MyList<Integer> l = createIntegerList(11,22,33);
        l.replaceAt(1, 44);
        assertEquals(3, l.length());        
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(44), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));
    }
    
    @Test
    public void testReplaceAt_last() {
        MyList<Integer> l = createIntegerList(11,22,33);
        l.replaceAt(2, 44);
        assertEquals("[11, 22, 44]", l.toString());
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(44), l.getValueAt(2));
    }
    
    @Test
    public void testReplaceAt_InvalidIndex() {
        MyList<Integer> l = createIntegerList(11,22,33);
        l.replaceAt(3, 44);
        assertEquals("[11, 22, 33]", l.toString());
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(11), l.getValueAt(0));
        assertEquals(Integer.valueOf(22), l.getValueAt(1));
        assertEquals(Integer.valueOf(33), l.getValueAt(2));
    }
    
    @Test
    public void testReplaceAt_EmptyList() {
        MyList<Integer> l = createIntegerList();
        l.replaceAt(0, 44);
        assertEquals(0, l.length());
    }

    /**
     * Test of equals method, of class MyLinkedList.
     */
    @Test
    public void testEquals_ListOfTwo() {
        MyList<Integer> a = createIntegerList(11,22);
        MyList<Integer> b = createIntegerList(11,22);
        assertEquals(a, b);
    }
    @Test
    public void testEquals_DifferentElements() {
        MyList<Integer> e = createIntegerList(11,22);
        MyList<Integer> o = createIntegerList(22,11);
        assertNotEquals(e, o);
        assertNotEquals(o, e);
    }
    @Test
    public void testEquals_OneShorter() {
        MyList<Integer> e = createIntegerList(11,22);
        MyList<Integer> o = createIntegerList(11);
        assertNotEquals(e, o);
        assertNotEquals(o, e);
    }

    /**
     * Test of toString method, of class MyLinkedList.
     */
    @Test
    public void testToString() {
        MyList<Integer> l = createIntegerList(11,22);
        assertEquals("[11, 22]", l.toString());
    }
    @Test
    public void testToString_OneElement() {
        MyList<Integer> l = createIntegerList(11);
        assertEquals("[11]", l.toString());
    }
       

    /**
     * Test of filterThis method, of class MyLinkedList.
     */    
    @Test
    public void testFilterThis_IsGreater() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        
        l.filterThis(new IsGreater(0));
        
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(1), l.getValueAt(0));
        assertEquals(Integer.valueOf(2), l.getValueAt(1));
        assertEquals(Integer.valueOf(3), l.getValueAt(2));
    }
    
    /**
     * Test of find method, of class MyLinkedList.
     */     
    @Test
    public void testFind_IsGreater() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        
        assertEquals(Integer.valueOf(1), l.find(new IsGreater(0)));
        assertEquals(Integer.valueOf(2), l.find(new IsGreater(1)));
        assertEquals(Integer.valueOf(3), l.find(new IsGreater(2)));
    }
    
    @Test
    public void testFind_IsGreater_Not() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        
        assertNull(l.find(new IsGreater(3)));
    }
    
    /**
     * Test of exists method, of class MyLinkedList.
     */     
    @Test
    public void testExists_IsGreater() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        
        assertTrue(l.exists(new IsGreater(0)));
        assertTrue(l.exists(new IsGreater(1)));
        assertTrue(l.exists(new IsGreater(2)));
    }
    
    @Test
    public void testExists_IsGreater_Not() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        
        assertFalse(l.exists(new IsGreater(3)));
    }
    
    /**
     * Test of forAll method, of class MyLinkedList.
     */     
    @Test
    public void testforAll_IsGreater() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        assertTrue(l.forAll(new IsGreater(-1)));
        
        l = createIntegerList(5);
        assertTrue(l.forAll(new IsGreater(4)));
        
        l = createIntegerList();
        assertTrue(l.forAll(new IsGreater(4)));
    }
    
    @Test
    public void testforAll_IsGreater_Not() {
        MyList<Integer> l = createIntegerList(0,1,0,2,0,3);
        assertFalse(l.forAll(new IsGreater(1)));
        
        l = createIntegerList(10,11,9,22);
        assertFalse(l.forAll(new IsGreater(9)));
        
        l = createIntegerList(11,11,11,9);
        assertFalse(l.forAll(new IsGreater(10)));
    }
    
    // Weitere Tests für Nachabnahme
    
    // Tests für InsertAt Methode aus MyCapacityArrayList
    
    @Test
    public void testInsertAt_addToOneElemAtFront() {
        MyList<Integer> l = createIntegerList(2);
        l.insertAt(0, 1);
        assertEquals(2, l.length());
        assertEquals(Integer.valueOf(1), l.getValueAt(0));
        assertEquals(Integer.valueOf(2), l.getValueAt(1));
    }
    
    @Test
    public void testInsertAt_addToEmptyList() {
        MyList<Integer> l = createIntegerList();
        l.insertAt(0, 1);
        assertEquals(1, l.length());
        assertEquals(Integer.valueOf(1), l.getValueAt(0));
    }

    //Tests für verschiedene Funktionsobjekte aus alter MyLinkedListTest Klasse
    
    @Test
    public void testFilterThis_IsPalindrome() {
        MyList<String> l = createStringList("Anna", "Bert", "Cassie", "DerFred", "Eve");
        
        l.filterThis(new IsPalindrome());
        
        assertEquals(3, l.length());
        assertEquals("Anna", l.getValueAt(0));
        assertEquals("DerFred", l.getValueAt(1));
        assertEquals("Eve", l.getValueAt(2));
    }
    
    @Test
    public void testforAll_IsHarshadNumber() {
        MyList<Integer> l = createIntegerList(0, 1, 0, 2, 0, 3);
        assertFalse(l.forAll(new IsHarshadNumber()));
        
        l = new MyLinkedList<>(12, 3);
        assertTrue(l.forAll(new IsHarshadNumber()));
        
        l = new MyLinkedList<>();
        assertTrue(l.forAll(new IsHarshadNumber()));
    }
    
    //Tests für find Methode aus MyList
    
    @Test
    public void testFind_sndOfEightElem() {
        MyList<Integer> l = createIntegerList(1,3,1,1,1,1,1,1);
        assertEquals(Integer.valueOf(3), l.find(new IsGreater(2)));
        
        l = createIntegerList(1,3,2,3,4,5,6,7);
        assertEquals(Integer.valueOf(3), l.find(new IsGreater(2)));
    }
    
    @Test
    public void testFind_fstOfEightElem() {
        MyList<Integer> l = createIntegerList(3,1,1,1,1,1,1,1);
        assertEquals(Integer.valueOf(3), l.find(new IsGreater(2)));
        
        l = createIntegerList(3,1,2,3,4,5,6,7);
        assertEquals(Integer.valueOf(3), l.find(new IsGreater(2)));
    }
    
    //Tests für filterThis aus MyList
    
    @Test
    public void testFilterThis_fstAndSndElem() {
        MyList<Integer> l = createIntegerList(0,1,3,4,5);
        l.filterThis(new IsGreater(2));
        assertEquals("[3, 4, 5]", l.toString());
        assertEquals(3, l.length());
        assertEquals(Integer.valueOf(3), l.getValueAt(0));
        assertEquals(Integer.valueOf(4), l.getValueAt(1));
        assertEquals(Integer.valueOf(5), l.getValueAt(2));
    }
    
    @Test
    public void testFilterThis_everySndElem() {
        MyList<Integer> l = createIntegerList(3,1,3,1,4,1,5,1);
        l.filterThis(new IsGreater(2));
        assertEquals("[3, 3, 4, 5]", l.toString());
        assertEquals(4, l.length());
        assertEquals(Integer.valueOf(3), l.getValueAt(0));
        assertEquals(Integer.valueOf(3), l.getValueAt(1));
        assertEquals(Integer.valueOf(4), l.getValueAt(2));
        assertEquals(Integer.valueOf(5), l.getValueAt(3));
    }
    
    @Test
    public void testFilterThis_everyElem() {
        MyList<Integer> l = createIntegerList(1,1,1,1,1,1,1,1);
        l.filterThis(new IsGreater(2));
        assertEquals("[]", l.toString());
        assertEquals(0, l.length());
        assertNull(l.getValueAt(0));
    }
}
