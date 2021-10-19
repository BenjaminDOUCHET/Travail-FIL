package pfc;
import pfc.util.*;
import pfc.strategy.*;

/**
 * classe du jeux pierre papier ciseaux
 *
 * @author colle maxime douchet benjamin
 */
public class Player{
    private String name; /*name of the player */
    private int point;  /* total score of the player */
    private Strategy strat; /* current strategy */


/**
 * Constructor of the class, 
 * @param name , the name of the player 
 * @param strat , the desire strategy
 * 
 */
    public Player(String name , Strategy strat){
        this.name=name;
        this.point = 0;
        this.strat= strat;

    }
 
/**
 * low cost constructor utility use.
 * @param name name of the player
 */ 


    public Player(String name){
        this.name=name;
        this.point = 0;
        this.strat= null;

    }




/**
 * getter of name attribute 
 * @return the name of the player
 */

    public String getName(){
        return this.name;
    }

/**
 * method to add some points at the total score of the player
 * @param p the number of points to add 
 */

    public void addPoints(int p) {
		this.point = this.point + p;
    }
    
/**
 * getter of the current total score of the player
 * @return int the score
 */
    public int getScore() {
		return this.point;
	}

/**
 * setter of the point attribute 
 * @param p the number of point to set
 */

    public void setPoints(int p){
        this.point = p;
    }

/**
 * linked method to call the play() methode from Strategy to play() of Game
 * @return Shape played by the strategy
 */
    public Shape play(){
        return strat.play();
    }

    public boolean equals(Object o){
        if(o instanceof Player){
           Player other = (Player) o;
           return this.getName() == other.getName() && this.getScore() == other.getScore();
        }
        else{
            return false;
        }
    }

}