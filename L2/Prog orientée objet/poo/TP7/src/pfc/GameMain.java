package pfc ;
import pfc.strategy.*;

/**
 * main class to test or play a game of Rock Paper Scissors vs the Computer 
 * @author Benjamin DOUCHET Maxime COLLES
 */


public class GameMain {
    
    public static void main(String[] args){
        Strategy stratj1 = new AskStrategy() ;
        Strategy stratj2 = new RandomStrat() ;
        Player j1 = new Player("Gaston", stratj1);
        Player j2 = new Player("Guy", stratj2) ;
        Game jeu = new Game(j1,j2);
        jeu.play(Integer.parseInt(args[0]));

    }





}
