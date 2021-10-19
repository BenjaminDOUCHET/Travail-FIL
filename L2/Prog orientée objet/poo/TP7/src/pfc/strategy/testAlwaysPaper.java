package pfc.strategy;
import pfc.util.*;
/**
 * Class for test , always return Rock
 * @author Benjamin DOUCHET , Maxime COLLE
 */
public class testAlwaysPaper implements Strategy  {
   

/**
 * @return the Shape to play defined by the method
 */
    public Shape play(){
    return Shape.valueOf("FEUILLE");
    }

}