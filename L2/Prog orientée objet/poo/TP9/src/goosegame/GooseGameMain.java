package goosegame;
import goosegame.board.*;
import goosegame.util.*;
import java.util.*;

public class GooseGameMain {
    public static void main(String[] args) throws noPlayerRegisterException {
        Board gameBoard = new ClassicalBoard();
        GooseGame main = new GooseGame(gameBoard);
        if(args.length!=0){
        for(int i = 0 ; i<args.length ; i++){
            Player temp = new Player(args[i]);
            main.addPlayer(temp);
        }
        }
        else{
        Player bob = new Player("bob");
        Player patrick = new Player("Patrick");
        Player carlo = new Player("Carlos");
        main.addPlayer(bob);
        main.addPlayer(patrick);
        main.addPlayer(carlo);
        }
        
   
        main.play();





    }

}
