import pfc.util.*;
import pfc.Player;
import pfc.strategy.*;
import pfc.*;
import org.junit.*;

import jdk.jfr.Timestamp;

import static org.junit.Assert.*;

public class GameTest {

@Test
public void FeuilleWinVersusPierre() {
  Strategy s1 = new testAlwaysPaper();
  Strategy s2 = new testAlwaysRock();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 2);
  assertTrue(res.getScoreJ2() == 0);
}


@Test
public void PierreWinVersusCiseaux() {
  Strategy s1 = new testAlwaysRock();
  Strategy s2 = new testAlwaysScissors();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 2);
  assertTrue(res.getScoreJ2() == 0);
}
@Test
public void CiseauxWinVersusFeuille() {
  Strategy s1 = new testAlwaysScissors();
  Strategy s2 = new testAlwaysPaper();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 2);
  assertTrue(res.getScoreJ2() == 0);
} 

@Test
public void FeuilleLooseVersusCiseaux() {
  Strategy s1 = new testAlwaysPaper();
  Strategy s2 = new testAlwaysScissors();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 0);
  assertTrue(res.getScoreJ2() == 2);
}
@Test
public void CiseauxLooseVersusPierre() {
  Strategy s1 = new testAlwaysScissors();
  Strategy s2 = new testAlwaysRock();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 0);
  assertTrue(res.getScoreJ2() == 2);
}
@Test
public void PierreLooseVersusFeuille() {
  Strategy s1 = new testAlwaysRock();
  Strategy s2 = new testAlwaysPaper();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 0);
  assertTrue(res.getScoreJ2() == 2);
}
@Test
public void DrawWhenSameElementIsPlayed() {
  Strategy s1 = new testAlwaysRock();
  Strategy s2 = new testAlwaysRock();
  Player j1 = new Player("bidule" , s1);
  Player j2 = new Player("machin",s2);
  Game test = new Game(j1 , j2);
  DicRes res = test.playOneRound();
  assertTrue(res.getScoreJ1() == 1);
  assertTrue(res.getScoreJ2() == 1);
}


@Test
public void testToGetTheNameOfJ1() {
  Player j1 = new Player("benjamin");
  Player j2 = new Player("maxime");
  Game test = new Game(j1 , j2);
  assertTrue(test.getJ1() == j1 );
}
@Test
public void testToGetTheNameOfJ2() {
  Player j1 = new Player("benjamin");
  Player j2 = new Player("maxime");
  Game test = new Game(j1 , j2);
  assertTrue(test.getJ2() == j2 );
}
// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(GameTest.class);
}


}
