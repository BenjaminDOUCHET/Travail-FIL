package goosegame.cell;
import goosegame.*;
public class WaitCell extends Cell{
    
    private int waitVal;
    private int compt ;
    private Player current ;

    public WaitCell (int i , int compt){
        super(i);
        this.waitVal = compt+1;
        Player token =new Player("qa2é@=+}Ab08*");
        this.current=token;
    }


    public void resetCell(Player p){
        this.current = p;
        this.compt = this.waitVal;
        this.canBeLeft = false;
    }


    public int applyEffect(Player p){
        
        if(!this.current.equals(p)){
            
            this.resetCell(p);
           
            System.out.println(p.toString()+"is trapped and have to wait "+ Integer.toString(this.compt)+" turn");
        }
        else{
            this.compt--;
            if (this.compt == 0){
                System.out.println(this.getPlayer().toString()+" have finished to wait he/she can leave at  next turn");
                this.canBeLeft = true;
                Player token =new Player("qa2é@=+}Ab08*");
                this.current = token ;
            }
            else{
                System.out.println(this.getPlayer().toString()+"is still trapped and have to wait "+ Integer.toString(this.compt)+" turn"); 
            }
        }
        return this.getPos();
    }
    
}
