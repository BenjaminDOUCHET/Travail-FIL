package game;

import java.util.ArrayList;
import java.util.List;
import game.war.WarGame;
import player.Player;
import utils.UnknowCoordinatesException;
import utils.UnknowPersonageException;

public class WarMain {
	public static void main(String[] args) throws UnknowPersonageException {

		try {
			List<Player> players = new ArrayList<Player>();

			if (args.length < 1) {
				// throw new IllegalArgumentException("The Players should be more than 1");
				System.out.println(
						"Usage : dans un terminal, placez-vous dans le répertoire bin du projet et exécuter la commande :");
				System.out.println("java  game.WarMain NomJoueur1 NomJoueur2 NomJoueur3");
				System.out.println(" NB : Plusieurs joueurs peuvent être passés en paramètre.");
				System.exit(0);
			} else {
				// on récupère les noms des joueurs passés en argument pour construire la liste
				// des joueurs
				for (int index = 0; index < args.length; index++) {
					Player p = new Player(args[index]);
					players.add(p);
				}
			}

			WarGame wGame = new WarGame(10, 25, 20, players);
			/*
			 * String autres =""; ###### debug paragraph keep it comment unless you need it
			 * ###### for(int k=0;k<wGame.getBoard().getOtherTileCoord().size();k++) {
			 * autres
			 * +="["+Integer.toString(wGame.getBoard().getOtherTileCoord().get(k)[0])+","+
			 * Integer.toString(wGame.getBoard().getOtherTileCoord().get(k)[1])+"]"; }
			 * System.out.println(autres);
			 */
			wGame.play();
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		} catch (UnknowCoordinatesException e) {
			System.out.println(e.getMessage());
		}
	}

}
