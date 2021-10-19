package goosegame.board;
import goosegame.cell.*;
public abstract class Board{
    
    protected final int NB_OF_CELLS ;
    protected Cell[] theCells;
    
    public Board(int nbOfCells){
        this.NB_OF_CELLS = nbOfCells;
        this.theCells = new Cell[NB_OF_CELLS];
        initBoard();
    }
    
    public Cell getCell(int index){
        return this.theCells[index];
    }
    
    public int getNbOfCells(){
        return this.NB_OF_CELLS;
    }
    
    public abstract void initBoard();
  
}