package goosegame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void OneDiceThrowValuesIsBetween1and6() {
        int des = oneDieThrow();
        assertTrue( des<7 && des>0);
    }

    @Test 
    public void TwoDiceThrowValuesIsBetween2and12() {
        int des = twoDiceThrow();
        assertTrue( des<13 && des>1);
    }

    // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(goosegame.PlayerTest.class);
    }

}