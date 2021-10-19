package pfc.strategy;
import pfc.util.* ;
import java.util.Random ;

/**
 * Class with Strategy inteface to define a strategy to adpot at Rock Paper Scisors's game
 * @author Benjamin DOUCHET , Maxime COLLE
 */


public class RandomStrat implements Strategy{

/**
 * @return the Shape to play defined by the method
 */
    public Shape play(){
        Random rand= new Random();
        return Shape.values()[rand.nextInt(Shape.values().length)];
	}    
}
