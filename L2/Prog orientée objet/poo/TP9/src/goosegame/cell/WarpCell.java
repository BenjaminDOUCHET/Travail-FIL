package goosegame.cell;

import goosegame.Player;

public class WarpCell extends Cell{
    private int linkedCell ;

    public WarpCell(int i , int link){
        super(i);
        this.linkedCell = link ; 
    }


    public int applyEffect(Player p){
        System.out.println(p.toString()+"is Warped to the Cell "+Integer.toString(this.linkedCell));
        return this.linkedCell;
    }
}
