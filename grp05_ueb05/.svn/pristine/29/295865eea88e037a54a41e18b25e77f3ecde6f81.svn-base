package ueb05;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static ueb05.Color.*;

/**
 *
 * @author klk
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ColorTest {
    /**
     * Test of getColor method, of class Color.
     */
    @Test
    public void testCreateColor_3args_ExistingColors() {
        Color color = Color.getColor(0, 0, 0);
        assertEquals(BLACK, color);
        
        color = Color.getColor(0, 0, 0xff);
        assertEquals(BLUE, color);  
    }
    
    @Test
    public void testCreateColor_3args_notExistingColors() {
        Color color = Color.getColor(1, 1, 1);
        assertNull(color);

        color = Color.getColor(0, 0, 1);
        assertNull(color);
    }
    
    /**
     * Test of getColor method, of class Color.
     */
    @Test
    public void testCreateColor_int_ExistingColor() {
        Color color = Color.getColor(0);
        assertEquals(BLACK, color);
        
        color = Color.getColor(0xff);
        assertEquals(BLUE, color);
        
        color = Color.getColor(0x00ffff);
        assertEquals(AQUA, color);
    }    
    
    /**
     * Test of toString method, of class Color. 
     */
    @Test
    public void testToString() {
        assertEquals("WHITE    #FFFFFF", WHITE.toString());
        assertEquals("BLUE     #0000FF", BLUE.toString());
    }    

    // ---------- Eigene Tests ------------------------------
    
    /**
     * Test of getColor method, of class Color.
     */
    @Test
    public void testCreateColor_int_notExistingColor() {
        Color color = Color.getColor(123456);
        assertNull(color);
        
        color = Color.getColor(0xABC);
        assertNull(color);
    }    
    
    @Test
    public void testCreateColor_intArray_ExistingColor() {
        int[] testarray = {0,0,0};
        Color color = Color.getColor(testarray);
        assertEquals(BLACK, color);
        
        testarray[0] = 0xFF;
        testarray[1] = 0xFF;
        testarray[2] = 0xFF;
        color = Color.getColor(testarray);
        assertEquals(WHITE, color);
    }
    
    @Test
    public void testCreateColor_intArray_notExistingColor() {
        Color color = Color.getColor(123456);
        assertNull(color);
        
        color = Color.getColor(0xABC);
        assertNull(color);
    }    
    
    @Test
    public void testCreateColor_String_ExistingColor() {
        Color color = Color.getColor("aqua");
        assertEquals(AQUA, color);
        
        color = Color.getColor("AQUA");
        assertEquals(AQUA, color);
        
        color = Color.getColor("aQuA");
        assertEquals(AQUA, color);
    }
    
    @Test
    public void testCreateColor_String_notExistingColor() {
        Color color = Color.getColor("");
        assertNull(color);
        
        color = Color.getColor("Beige");
        assertNull(color);
    }
    
    @Test
    public void testIsKnownColor_ExistingColor() {
        assertTrue(Color.isKnownColor("white"));
        int[] testarray = {0,0,0};
        assertTrue(Color.isKnownColor(testarray));
    }
    
    @Test
    public void testIsKnownColor_nonExistingColor() {
        assertFalse(Color.isKnownColor("lmao"));
        int[] testarray = {12,34,56};
        assertFalse(Color.isKnownColor(testarray));
    }
    
    @Test
    public void testGetRGB() {
        int[] testarray = {0,0,0};
        assertArrayEquals(testarray, Color.BLACK.getRGB());
        assertArrayEquals(testarray, Color.getRGB("black"));
    }
    
    @Test
    public void testGetPackagedRGB() {
        assertEquals(0, Color.BLACK.getPackedRGB());
        assertEquals(0xFFFFFF, Color.WHITE.getPackedRGB());
    }
    
    //Test für to do
    
    @Test
    public void testGetColor_intToBig() {
        assertNull(Color.getColor(0xfffffff));
        assertNull(Color.getColor(0xFF000000));
        assertNull(Color.getColor(0xFFFFFFFF));
        assertNull(Color.getColor(0x12345678));
    }
}
