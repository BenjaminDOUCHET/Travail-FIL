package goosegame.cell;
import goosegame.*;

public class TrapCell extends Cell{
    
    public TrapCell(int i){
        super(i);
        this.canBeLeft = false;
    }
    
    public int applyEffect(Player p){
        p.setCell(this);
        System.out.println(p.toString() + " is trapped in Cell "+Integer.toString(this.getPos()) + " and have to pass his/her turn");
        return this.getPos();
    }
    
}
