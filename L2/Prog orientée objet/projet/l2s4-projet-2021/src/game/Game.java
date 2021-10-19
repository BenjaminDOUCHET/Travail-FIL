package game;

import board.*;
import player.*;
import tile.*;
import utils.UnknowPersonageException;
import java.util.*;

/**
 * class Game 
 * @author groupe1
 *
 */
public abstract class Game {
	protected Board board;
	protected int nbRound;
	protected List<Player> players;

	/**
	 * initialize the game with the board and two players
	 * 
	 * @param nbRound the number of rounds in the game
	 * @param length  the length of the board
	 * @param width   the width of the board
	 * @param players the list of players
	 * @throws CloneNotSupportedException if the tile type can't be cloned
	 */
	public Game(int nbRound, int length, int width, List<Player> players) throws CloneNotSupportedException {
		this.board = new Board(length, width);
		this.nbRound = nbRound;
		this.players = players;
	}

	/**
	 * Play one turn of the game for a given player
	 * 
	 * @param currentP the current player
	 * @throws UnknowPersonageException
	 */
	public abstract void playOneTurn(Player currentP) throws UnknowPersonageException;

	/**
	 * Play the game 
	 */
	public abstract void play();

	/**
	 * Provide the board of the game
	 * 
	 * @return the board of the game
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * proceed to the final score of the game
	 */
	public abstract String countdown();

	/**
	 * method to give resources to player
	 */
	public void produce() {
		Tile[][] gird = this.board.getBoard();
		for (int i = 0; i < gird.length; i++) {
			for (int j = 0; j < gird[0].length; j++) {
				if (gird[i][j].getOccupant() != null) {
					gird[i][j].getOccupant().getOwner().addRessource(gird[i][j].getRessourceType(), 1); // ------ pour
																										// l'instant on
																										// recolte 1
																										// ressource par
																										// tour.
				}
			}
		}
	}

}
