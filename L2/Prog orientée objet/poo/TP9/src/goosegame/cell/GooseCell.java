package goosegame.cell;

import goosegame.Player;

public class GooseCell extends Cell {
    
    public GooseCell(int i){
        super(i);
    }
    
    
    public int applyEffect(Player p){
        System.out.println(p.toString()+" found a goose and bounce to the cell : "+Integer.toString(this.getPos()+p.getResDice()));
        return this.getPos()+p.getResDice();
    }

    
}
