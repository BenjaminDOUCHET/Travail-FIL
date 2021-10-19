import image.util.*;
import image.*;
import image.color.*;
import org.junit.*;
import static org.junit.Assert.*;



public class PixelTest {
  
@Test
public void pixelIsCreated(){
    GrayColor someGray = new GrayColor(100);
    Pixel somePixel = new Pixel(someGray);
    assertNotNull(somePixel);
}

@Test
public void setColorWorked(){
    GrayColor someGray = new GrayColor(100);
    GrayColor someGray2 = new GrayColor(55);
    Pixel somePixel = new Pixel(someGray);
    somePixel.setColor(someGray2);
    assertEquals(55,somePixel.getColor().getGrayLevel());
}

@Test
public void equalsMethodOk(){
    GrayColor someGray = new GrayColor(100);
    Pixel somePixel = new Pixel(someGray);
    Pixel somePixel2 = new Pixel(someGray);
    assertTrue(somePixel.equals(somePixel2));
}

@Test
public void pixelNotEqualsBecauseNotSameColor(){
    GrayColor someGray = new GrayColor(100);
    GrayColor someGray2 = new GrayColor(50);
    Pixel somePixel = new Pixel(someGray);
    Pixel somePixel2 = new Pixel(someGray2);
    assertFalse(somePixel.equals(somePixel2));
}





// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(ImageTest.class);
}

}
