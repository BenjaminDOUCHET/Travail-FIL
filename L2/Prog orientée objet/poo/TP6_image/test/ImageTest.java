import image.util.*;
import image.*;
import image.color.*;
import org.junit.*;
import static org.junit.Assert.*;


public class ImageTest {

    @Test
    public void testImageCreation(){
        Image someImage = new Image(20,30);
        assertNotNull(someImage);
        assertEquals(20,someImage.getWidth());
        assertEquals(30,someImage.getHeight());
    }

    @Test
    public void successToGetaPixel(){
        Image someImage = new Image(20,30);
        assertEquals(255,someImage.getPixel(5,10).getColor().getGrayLevel());
    }

    @Test(expected= UnknownPixelException.class)
    public void tryToGetPixelOutOfImageWidth(){
        Image someImage = new Image(20,30);
        someImage.getPixel(someImage.getWidth()+1,someImage.getHeight()/2);   
    }

    @Test(expected= UnknownPixelException.class)
    public void tryToGetPixelOutOfImageHeight(){
        Image someImage = new Image(20,30);
        someImage.getPixel(someImage.getWidth()/2,someImage.getHeight()+1);   
    }


    @Test
    public void sucessChangeColorOfaPixel(){
        Image someImage = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.changeColorPixel(10,15,someGray);
        assertEquals(100,someImage.getPixel(10,15).getColor().getGrayLevel());
    }

    @Test(expected= UnknownPixelException.class)
    public void tryToChangePixelOutOfImage(){
        Image someImage = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.changeColorPixel(someImage.getWidth()+1,0,someGray);
    }

    @Test
    public void rectangleIsCreated(){
        Image someImage = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.fillRectangle(1,1,5,5,someGray);
        boolean res = true ;
        for(int i=1;i<6;i++){
            for(int j=1 ; j<6;j++){
                if(someImage.getPixel(i,j).getColor().getGrayLevel() != 100){
                    res = false;
                }
            }
        }
        assertTrue(res == true);
    }


    @Test(expected =UnknownPixelException.class)
    public void rectangleOutOfImageByPlacment(){
        Image someImage = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.fillRectangle(someImage.getWidth()+1,someImage.getHeight()+1,4,4,someGray); 
    }

    @Test(expected = UnknownPixelException.class)
    public void rectangleOutOfImageByRectangleTooBig(){
        Image someImage = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.fillRectangle(0,0,someImage.getWidth()*2,someImage.getHeight()*2,someGray); 
    }
    
    @Test
    public void equalsMethod(){
        Image someImage = new Image(20,30);
        Image someImage2 = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.fillRectangle(1,1,6,6,someGray);
        someImage2.fillRectangle(1,1,6,6,someGray);
        assertTrue(someImage.equals(someImage2));
    }

    @Test 
    public void notEqualsBecauseNotSameDimesion(){
        Image someImage = new Image(20,30);
        Image someImage2 = new Image(40,60);
        assertFalse(someImage.equals(someImage2));
    }

    @Test
    public void notEqualsBecauseNotSameContent(){
        Image someImage = new Image(20,30);
        Image someImage2 = new Image(20,30);
        GrayColor someGray = new GrayColor(100);
        someImage.fillRectangle(1,1,6,6,someGray);
        assertFalse(someImage.equals(someImage2));
    }

    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ImageTest.class);
}


}
