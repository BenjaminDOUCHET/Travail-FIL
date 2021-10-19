package goosegame.board;
import goosegame.cell.*;

public class ClassicalBoard extends Board{
    
    public ClassicalBoard(){
        super(64);    
    }
   
    public void initBoard(){
     
        // Cellulle de départ
        theCells[0]= new DepartCell(0);
        
        // Toutes les autres
        for (int i = 1; i < NB_OF_CELLS ; i++) {
			theCells[i] = new RegularCell(i);
		}
        
        // goose cells
		for (int i = 9; i < NB_OF_CELLS; i = i + 9) {
			theCells[i] = new GooseCell(i);
		}

        
        // jump cells
		theCells[58] = new WarpCell(58,1);
		theCells[42] = new WarpCell(42,30);
		theCells[6] = new WarpCell(6,12);
        // wait cell
		theCells[19] = new WaitCell(19,2);
        // trap cells
		theCells[52] = new TrapCell(52);
		theCells[31] = new TrapCell(31);
		
	
        
    }
}