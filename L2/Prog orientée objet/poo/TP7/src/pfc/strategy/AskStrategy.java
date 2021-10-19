package pfc.strategy;
import pfc.util.io.*;
import pfc.util.*;

/**
 * Class with Strategy inteface to define a strategy to adpot at Rock Paper Scisors's game
 * @author Benjamin DOUCHET , Maxime COLLE
 */

public class AskStrategy implements Strategy {
    private Shape shape;

/**
 * @return the Shape to play defined by the method
 */
    public Shape play(){
        boolean ok = false ;
        while( ok == false){
        System.out.print("coup à jouer  : PIERRE,FEUILLE ou CISEAUX ? ");
        String choice = Input.readString();


        try{
            this.shape = Shape.valueOf(choice);
            ok = true;
        }
        catch(java.lang.IllegalArgumentException e){
            System.out.println("valeur incorrect , veuillez entrer : PIERRE,FEUILLE ou CISEAUX");
        }
        
        }
    return this.shape;
    }







}
