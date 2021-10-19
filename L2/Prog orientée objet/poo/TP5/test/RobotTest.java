import org.junit.*;
import static org.junit.Assert.*;

import factory.Robot;   
import factory.util.*;   

public class RobotTest {	


    @Test
    public void robotCarryNoBoxWhenCreated() {
	Robot robbie = new Robot();
	assertFalse(robbie.carryBox());
    }

    @Test
    public void robotCanTakeBoxIfNotCarrying(){
        Robot robbie = new Robot();
        assertFalse(robbie.carryBox());
        Box box1 = new Box(3);
        robbie.take(box1);
        assertTrue(robbie.carryBox());
    }

    @Test
    public void robotCannotTakeBoxIfAlreadyCarrying(){
        Robot robbie = new Robot();
        Box box1 = new Box(3);
        robbie.take(box1);
        Box box2 = new Box(10);
        robbie.take(box2);
        assertEquals(3,robbie.getCarriedBox().getWeight());
    }


    @Test
    public void robotDontCarryBoxWhenPut(){
        Robot robbie = new Robot();
        ConveyerBelt conv = new ConveyerBelt(30);
        assertFalse(robbie.putOn(conv));
    }

    @Test
    public void robotCarryBoxAndCanPut(){
        Robot robbie = new Robot();
        ConveyerBelt conv = new ConveyerBelt(30);
        Box box1 = new Box(3);
        robbie.take(box1);
        assertTrue(robbie.putOn(conv));
        assertFalse(robbie.carryBox());

    }

    @Test
    public void robotCarryBoxOverWeigthLimit(){
        Robot robbie = new Robot();
        ConveyerBelt conv = new ConveyerBelt(10);
        Box box1 = new Box(30);
        robbie.take(box1);
        assertFalse(robbie.putOn(conv));
        assertEquals(30,robbie.getCarriedBox().getWeight());
    }

    @Test
    public void robotCantPutConveyerIsFull(){
        Robot robbie = new Robot();
        ConveyerBelt conv = new ConveyerBelt(30);
        Box box1 = new Box(10);
        Box box2 = new Box(10);
        Box box3 = new Box(3);
        conv.receive(box1);
        conv.receive(box2);
        robbie.take(box3);
        assertFalse(robbie.putOn(conv));
        assertEquals(3,robbie.getCarriedBox().getWeight());
    }

  



    
    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(RobotTest.class);
    }

}
