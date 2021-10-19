package pfc;
import pfc.util.*;

/**
 * Classe du jeu pierre feuille ciseaux
 *
 * @author COllE MAXIME DOUCHET BENJAMIN
 * @version v1
 */
public class Game{
    private Player j1;
    private Player j2;

    /**
     * construceur de la class Game
     * 
     * @param j1 le joueur 1
     * @param j2 le joueur 2
     */
    public Game( Player j1 , Player j2){
        this.j1 = j1;
        this.j2 = j2;

    }

    /**
     * getter of j1 param
     * @return Player j1
     */
    public Player getJ1(){
        return this.j1;
    }

    /**
     * getter of j2 param
     * @return Player j2
     */
    public Player getJ2(){
        return this.j2;
    }

    /**
     * setter of j1 param
     * @param j Player to set
     */
    public void setJ1(Player j){
        this.j1= j;
    }

    /**
     * setter of j2 param
     * @param j Player to set
     */
    public void setJ2(Player j){
        this.j2= j;
    }


    /**
     * play to play a round of Rock Paper Scissors
     *
     * 
     * @return DicRes the result of this round 
     */

    public DicRes playOneRound(){

        DicRes res = new DicRes();
        Shape coupj1 = this.j1.play();
        Shape coupj2 = this.j2.play();
        res.setCoupJ1(coupj1);
        res.setCoupJ2(coupj2);

        if(coupj1 == coupj2){
            res.setScoreJ1(1);
            res.setScoreJ2(1) ;
        }
        else if (coupj1==Shape.PIERRE){
            if ( coupj2 == Shape.CISEAUX){
                res.setScoreJ1(2);
                res.setScoreJ2(0) ;
            }
            else {
                res.setScoreJ1(0);
                res.setScoreJ2(2);
            }
        }
        else if ( coupj1 == Shape.FEUILLE ) {
            if ( coupj2 == Shape.PIERRE){
                res.setScoreJ1(2);
                res.setScoreJ2(0) ;
            }
            else {
                res.setScoreJ1(0);
                res.setScoreJ2(2);
            }
        }
        else {
            if ( coupj2 == Shape.FEUILLE){
                res.setScoreJ1(2);
                res.setScoreJ2(0);
            }
            else {
                res.setScoreJ1(0);
                res.setScoreJ2(2);
            }
        }
    return res;
    }





/**
 * methode permettant de faire jouer nbRounds round aux joueurs
 * @param nbRounds int le nombre de round 
 * @return Player le joueur ayant gagné le plus de points 
 */
public Player play(int nbRounds){
    int i =0 ; /**compteur des paries jouées */
    DicRes res; /**Création  de la variable qui contiendra les resultats d'un round joué  */
    Player winner = new Player("Match Nul"); /* Joueur factice servant en cas d'égalité */
    while(i<nbRounds){
        
        res = this.playOneRound(); 
        System.out.println(this.j1.getName()+" a joué "+ res.getCoupJ1().name() +". "+this.j2.getName()+" a joué "+res.getCoupJ2().name());
        if(res.getScoreJ1()>res.getScoreJ2()){
            System.out.println(this.j1.getName()+" l'emporte et marque 2 points");
            this.j1.addPoints(2);
        }
        else if(res.getScoreJ1()<res.getScoreJ2()){
            System.out.println(this.j2.getName()+" l'emporte et marque 2 points");
            this.j2.addPoints(2);
        }
        else{
            System.out.println("il y a égalité chaque joueur marque 1 point");
            this.j1.addPoints(1);
            this.j2.addPoints(1);
        }
        System.out.println("Le Score est maintenant : " + this.j1.getName()+" = "+ Integer.toString(this.j1.getScore()) +" point(s) - " + this.j2.getName()+" = "+ Integer.toString(this.j2.getScore()) +" point(s)");
        i++;
    }


    if(this.j1.getScore()>this.j2.getScore()){
        winner = this.j1;
    }
    if(this.j1.getScore()<this.j2.getScore()){
        winner = this.j2;  
    }
    
    System.out.println("Joueur Gagnant : "+winner.getName());
    return winner;
}

}