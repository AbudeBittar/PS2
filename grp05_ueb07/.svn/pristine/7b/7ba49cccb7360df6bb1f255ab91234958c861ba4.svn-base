package ueb.list.linked;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import ueb.Waypoint;
import ueb.list.MyList;
import ueb.list.MyListTestBase;

/**
 *
 * @author Marcus Riemer (mri), klk
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyNaiveLinkedListTest extends MyListTestBase {

    @Override
    public MyList<String> createStringList(String... values) {
        MyList<String> list = new MyNaiveLinkedList<>();
        for(int i = 0; i < values.length; i++) {
        list.insertAt(i, values[i]);
        }
        return list;
    }
    
    @Override
    public MyList<Integer> createIntegerList(Integer... values) {
        MyList<Integer> list = new MyNaiveLinkedList<>();
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
    
    /**
     * Test of using Raw-types
     */
    @Test
    public void testDidntUseRawTypes() {
        MyList<String> strL = new MyNaiveLinkedList("B", "C");
        /* if you used raw-types in your listdefinition, 
           l.getValueAt() will return an object and 
           toLowerCase() won´t work with it */
        assertEquals("b", strL.getValueAt(0).toLowerCase()); 
        
        MyList<Waypoint> wpL = new MyNaiveLinkedList(new Waypoint(1,1), new Waypoint(1,2));
        /* if you used raw-types in your listdefinition, 
           l.getValueAt() will return an object and 
           calcDistance() won´t work with it */
        assertEquals(1, wpL.getValueAt(0).calcDistance(wpL.getValueAt(1)), 0.00001);
    }
    
    //TODO DONE folgende Testfälle sollen nicht hier auftauchen, sondern in MyListTestBase
}
