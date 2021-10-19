package game;

import java.util.ArrayList;
import java.util.List;

import game.agricultural.AgricoleGame;
import player.Player;
import utils.UnknowCoordinatesException;

public class AgricoleMain {

	public static void main(String[] args) {
		
				try {
					List <Player> players = new ArrayList<Player>();
					
					if(args.length <1) {
						players.add(new Player("Jules"));
						players.add(new Player("Mount"));
					}
					else {
						//on récupère les noms des joueurs passés en argument pour construire la liste des joueurs
						for(int index  = 0 ; index < args.length ; index++) {
							Player p  =  new Player(args[index]);
							players.add(p);
						}
					}
					
					//String ligne = "";
					AgricoleGame aGame =  new AgricoleGame(10,25,20,players);
					//System.out.println(aGame.getBoard().getBoard());
					/*for (int i=0 ; i < aGame.getBoard().getBoardLength();i++) {
						
						for (int j=0 ; j < aGame.getBoard().getBoardWidth();j++) {
							ligne += "|"  + aGame.getBoard().getTile(i, j).getTileType();
						}
						//System.out.println(ligne);
					}*/
					aGame.play();
				}
				catch( CloneNotSupportedException e) {
					System.out.println(e.getMessage());
				}
				catch(UnknowCoordinatesException e) {
					System.out.println(e.getMessage());
				}
			}
		

	}

