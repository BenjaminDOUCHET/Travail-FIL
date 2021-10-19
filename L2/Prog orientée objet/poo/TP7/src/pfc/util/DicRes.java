package pfc.util;

/**
 * Class made to make a data structure able to mix Shape and int in a same variable to 
 * make the Game.java more comfortable to use
 *  
 * @author DOUCHET Benjamin
 */


public class DicRes {

    /**
     * a DicRes is made to get the data from the result of a round of Rock Paper Scissors between 2 players.
     * as you can see it contain 2 attributes for the last Shape played and 2 for the result of the round played
     */
    private Shape coupJ1 ;
    private Shape coupJ2 ;
    private int scoreMancheJ1;
    private int scoreMancheJ2;


    /**
     * Constructor of the class 
     * @param coup1 the Shape played by Player 1
     * @param coup2 the Shape played by Player 2
     * @param Score1 the score scored by Player 1
     * @param Score2    the score scored by Player 2
     */

    public DicRes(Shape coup1 , Shape coup2 , int Score1 , int Score2){
        this.coupJ1 = coup1 ; 
        this.coupJ2 = coup2 ; 
        this.scoreMancheJ1 = Score1 ; 
        this.scoreMancheJ2 = Score2 ;

    }
    /**
     * a constructor to initialize an empty DicRes
     */
    public DicRes(){
        this.coupJ1 = null ; 
        this.coupJ2 = null; 
        this.scoreMancheJ1 = 0; 
        this.scoreMancheJ2 = 0 ;
    }


    /**
     * setter of coup1 attribute
     * @param coup1 Shape played by Player 1
     */
    public void setCoupJ1(Shape coup1){
        this.coupJ1 = coup1 ;
    }
    /**
     * setter of coup2 attribute
     * @param coup2 Shape played by Player 2
     */
    public void setCoupJ2(Shape coup2){
        this.coupJ2 = coup2 ;
    }
    /**
     * setter of score1 attribute
     * @param i the int to set 
     */
    public void setScoreJ1(int i){
        this.scoreMancheJ1=i;
    }
    /**
     * setter of score1 attribute
     * @param i the int to set
     */
    public void setScoreJ2(int i){
        this.scoreMancheJ2 = i ;
    }

    /**
     * getter of coup1 attribute 
     * @return Shape of coup1
     */
    public Shape getCoupJ1(){
        return this.coupJ1;
    }

    /**
     * getter of coup2 attribute 
     * @return Shape of coup2
     */
    public Shape getCoupJ2(){
        return this.coupJ2;
    }
    
    /**
     * getter of score1 attribute
     * @return int the score1
     */
    public int getScoreJ1(){
        return this.scoreMancheJ1;
    }

    /**
     * getter of score2 attribute
     * @return int the score2
     */
    public int getScoreJ2(){
        return this.scoreMancheJ2;
    }

    public boolean equals(Object o){
        if(o instanceof DicRes){
           DicRes other = (DicRes) o;
           return this.getCoupJ1() == other.getCoupJ1() && this.getCoupJ2() == other.getCoupJ2()
            && this.getScoreJ1() == other.getScoreJ1() && this.getScoreJ2() == this.getScoreJ2();
        }
        else{
            return false;
        }
    }
}
