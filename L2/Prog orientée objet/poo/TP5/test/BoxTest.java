import org.junit.*;
import static org.junit.Assert.*;

import factory.util.Box; 

public class BoxTest {	

    @Test
    public void testBoxCreation() {
        Box someBox = new Box(10);
        assertNotNull(someBox);
        assertEquals(10,someBox.getWeight()); 
    }
    
    @Test
    public void testGetWeight() {
        Box someBox = new Box(10);
        assertEquals(10,someBox.getWeight());
        Box someBox2 = new Box(20);
        assertEquals(20,someBox2.getWeight()); 
    }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(BoxTest.class);
    }

}
