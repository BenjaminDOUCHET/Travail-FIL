import pfc.*;
import pfc.util.*;
import pfc.strategy.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PlayerTest {

@Test
public void testAdd2Points(){
    Player j1 = new Player("Ricardo");
    j1.addPoints(2);
    assertTrue(j1.getScore() == 2);
}

@Test
public void testEqualsMethod(){
    Player j1 = new Player("Ricky");
    Player j2 = new Player("Ricky");
    assertTrue(j1.equals(j2));
}
@Test
public void getNameMethodeReturnTheNameOfThePlayer() {
    Player j1 = new Player("benjamin");
    assertTrue(j1.getName() =="benjamin" );
}
@Test
public void getScoreMethodeReturnTheScoreOfThePlayer() {
    Player j1 = new Player("benjamin");
    j1.addPoints(1);
    assertTrue(  1 == j1.getScore() );
}
@Test
public void setScoreMethodeReturnTheScoreEnter() {
    Player j1 = new Player("benjamin");
    j1.addPoints(1);
    j1.setPoints(2);
    assertTrue(j1.getScore() == 2 );
}
@Test 
public void testThePlayMethode() {
    Strategy s1 = new testAlwaysRock();
    Player j1 = new Player("maxime",s1);
    assertTrue(j1.play() == Shape.PIERRE);
}
// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(PlayerTest.class);
}


}
