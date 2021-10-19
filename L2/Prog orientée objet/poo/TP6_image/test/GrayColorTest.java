import image.util.*;
import image.*;
import image.color.*;
import org.junit.*;
import static org.junit.Assert.*;



public class GrayColorTest {
    

@Test
public void grayColorCreated(){
    GrayColor someGray = new GrayColor(50);
    assertNotNull(someGray);
}

@Test
public void equalsMethodOk(){
    GrayColor someGray = new GrayColor(50);
    GrayColor someGray2 = new GrayColor(50);
    assertTrue(someGray.equals(someGray2));
}

@Test
public void equalsMethodNotOkNotSameGrayLevel(){
    GrayColor someGray = new GrayColor(150);
    GrayColor someGray2 = new GrayColor(50);
    assertFalse(someGray.equals(someGray2));
}




// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(ImageTest.class);
}


}
