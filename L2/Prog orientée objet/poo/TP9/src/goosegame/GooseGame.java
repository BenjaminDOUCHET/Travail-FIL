package goosegame;
import goosegame.board.*;
import goosegame.cell.*;
import goosegame.util.*;
import java.util.*;



public class GooseGame {
    private ArrayList<Player> thePlayers;
    private Board board ; 

    public GooseGame(Board board){
        this.board = board ;
        this.thePlayers = new ArrayList<Player>();
    }

    public void addPlayer(Player p){
        this.thePlayers.add(p);
    }

    public void play() throws noPlayerRegisterException {
        if(this.thePlayers.size()==0){
            throw new noPlayerRegisterException();
        }
        else{
            for(int i=0; i<this.thePlayers.size();i++){
                this.thePlayers.get(i).setCell(this.board.getCell(0));
            }
        }


        int tour = 0;
        boolean won = false ;
        Player currentPlayer ;

        while(!won){

            currentPlayer = this.thePlayers.get(tour); // on recup le joueur dont c'est le tour 
            
            System.out.println("-------it is  "+currentPlayer.toString()+ "'s turn :");
            System.out.println(currentPlayer.toString() + " is in cell " + Integer.toString(currentPlayer.getCell().getPos()));
            
            
            // on traite les cases non quitables
            if(!currentPlayer.getCell().canBeLeft()){
                int temp = this.board.getCell(currentPlayer.getCell().getPos()).applyEffect(currentPlayer);
                currentPlayer.setCell(this.board.getCell(temp));
            }
            // on traite les autres cases 
            else{
                currentPlayer.twoDiceThrow();               // on lui fais lancer les dés
                System.out.println(currentPlayer.toString()+ " throws a " + Integer.toString(currentPlayer.getResDice()));
                //on calcule la case d'arrivée
                int nextCell = currentPlayer.getCell().getPos()+currentPlayer.getResDice();
                
                
                //on vérifie d'abord que le joueur n'ai pas gagné
                if(nextCell != this.board.getNbOfCells()){
                
                
                    // on vérifie qu'il ne dépasse pas l'arrivée et on traite le cas si ça arrive 
                    if(nextCell > this.board.getNbOfCells()-1){
                        nextCell = 2*(this.board.getNbOfCells()-1)-nextCell;
                        System.out.println("too far ! go back to :" +  Integer.toString(nextCell) );
                    }
                    System.out.println(" and reach cell "+ Integer.toString(nextCell));
                    //si personne dans la case d'arrivée
                    if(this.board.getCell(nextCell).getPlayer()==null){
                        
                        // on nettoie la case de départ 
                        this.board.getCell(currentPlayer.getCell().getPos()).setPlayer(null);
                        
                        // on  applique un eventuel effet.
                        nextCell = this.board.getCell(nextCell).applyEffect(currentPlayer);
                        if(nextCell > this.board.getNbOfCells()-1){
                            nextCell = 2*(this.board.getNbOfCells()-1)-nextCell;
                            System.out.println("bounced too far ! go back to :" +  Integer.toString(nextCell) );
                        }
                        
                        // on mets le currentPlayer dans la case d'arrivée
                        this.board.getCell(nextCell).setPlayer(currentPlayer);
                        currentPlayer.setCell(this.board.getCell(nextCell));
                        
                    }


                    else{
                        //on récupère le joueur sur la case d'arrivée 
                        
                        Player other = this.board.getCell(nextCell).getPlayer();
                        System.out.println("Cell is busy by "+other.toString()+" they change theire places");
                        //on échange les places
                        this.board.getCell(currentPlayer.getCell().getPos()).setPlayer(other);
                        other.setCell(currentPlayer.getCell());
                        this.board.getCell(nextCell).setPlayer(currentPlayer);
                        currentPlayer.setCell(this.board.getCell(nextCell));

                        this.board.getCell(nextCell).applyEffect(currentPlayer); 
                    }
                }

                
                //le joueur a gagné
                else{
                    won = true;
                    this.board.getCell(this.board.getNbOfCells()-1).setPlayer(currentPlayer);
                }

                

            }

            //on mets une sécurité pour detecter si tous les joueurs sont en prison.
            boolean stucked = true; 
            for(int k =0 ; k<this.thePlayers.size();k++){
                if(!(this.thePlayers.get(k).getCell() instanceof TrapCell)){
                    stucked = false;
                }
            }
            
            if(stucked){
                System.out.println("All Players are in Jail; this game is draw");
                System.exit(0);
            }

            // on initilalise le prochain tour
            tour = (tour+1)%thePlayers.size();
        }

        System.out.println("congratulation to "+ this.board.getCell(this.board.getNbOfCells()-1).getPlayer().toString() + " you have won the game !");

    }
}
