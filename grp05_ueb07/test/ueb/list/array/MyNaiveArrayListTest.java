/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ueb.list.array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import ueb.list.MyList;
import ueb.list.MyListTestBase;

/**
 *
 * @author 
 */
public class MyNaiveArrayListTest extends MyListTestBase {

    @Override
    public MyList<String> createStringList(String... values) {
        MyList<String> list = new MyNaiveArrayList<>();
        for(int i = 0; i < values.length; i++) {
        list.insertAt(i, values[i]);
        }
        return list;
    }

    @Override
    public MyList<Integer> createIntegerList(Integer... values) {
        MyList<Integer> list = new MyNaiveArrayList<>();
        for(int i = 0; i < values.length; i++) {
        list.insertAt(i, values[i]);
        }
        return list;
    }
    
    @Test
    public void testConstruct_EmptyIntegerList() {
        MyList<Integer> l = createIntegerList();
        
        assertTrue(l.isEmpty());
        assertEquals("[]", l.toString());
    }
    
    @Test
    public void testConstruct_SingleIntegerElement() {
        MyList<Integer> l = createIntegerList(0);
        
        assertFalse(l.isEmpty());
        assertEquals(Integer.valueOf(0), l.getValueAt(0));
        assertEquals("[0]", l.toString());
    }
    
    @Test
    public void testConstruct_SingleStringElement() {
        MyList<String> l = createStringList("0");
        
        assertFalse(l.isEmpty());
        assertEquals("0", l.getValueAt(0));
        assertEquals("[0]", l.toString());
    }
    
    @Test
    public void testConstruct_multipleElements() {
        MyList<Integer> l = createIntegerList(1,3,5);
        
        assertFalse(l.isEmpty());
        assertEquals(Integer.valueOf(1), l.getValueAt(0));
        assertEquals(Integer.valueOf(3), l.getValueAt(1));
        assertEquals(Integer.valueOf(5), l.getValueAt(2));
        assertEquals("[1, 3, 5]", l.toString());
    }
    
}
