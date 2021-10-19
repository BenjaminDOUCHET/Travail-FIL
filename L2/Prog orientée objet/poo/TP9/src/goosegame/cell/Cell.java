package goosegame.cell;
import goosegame.*;
public abstract class Cell {
    protected boolean canBeLeft ;
    protected int bounce;
    private int pos;
    protected Player p ; 

    public Cell(int i){
        this.pos = i;
        this.canBeLeft =true ;
        this.bounce = 0 ;
        this.p = null;
    }

    public boolean canBeLeft(){
        return this.canBeLeft;
    }

    public int bounce(){
        return this.bounce;
    }

    public int getPos(){
        return this.pos;
    }

    public void setPlayer(Player p){
        this.p = p;
    }

    public Player getPlayer(){
        return this.p;
    }

    
    public abstract int applyEffect(Player p);
}
