package game.war;

import java.util.*;

import game.Game;
import personage.Personage;
import personage.war.Army;
import player.Player;
import tile.*;
import utils.InsufficientStockException;
import utils.UnknowPersonageException;

/**
 * @author Douchet Benjamin, Colle Maxime 
 * class of WarGame , it specifies the rules of warGame
 */
public class WarGame extends Game {

	private int armyID = 0; // le nombre d'ouvriers ajoutes
	private List<int[]> otherTile;// la liste des coordonnees des tuiles
	private int x;
	private int y;
	private Map<Player, Integer> scoreMap;// la map des scores où les clés sont les joueurs et les valeurs leurs scores respectifs
	private Map<Player, Integer> nbTileMap;// la map associant à chaque joueur le nombre de tuiles qu'il occupe

	/**
	 * initialize the game with the board and two players
	 * 
	 * @param nbRound the numbers of rounds in the game
	 * @param length  the length of the board
	 * @param width   the width of the board
	 * @param players the list of players
	 * @throws CloneNotSupportedException if the tile type can't be cloned
	 */
	public WarGame(int nbRound, int length, int width, List<Player> players) throws CloneNotSupportedException {
		super(nbRound, length, width, players);
		this.otherTile = this.getBoard().getOtherTileCoord();// on recupere les coordonnees des autres tuiles non ocean

		for (int index = 0; index < this.players.size(); index++) {
			this.players.get(index).addRessource("gold", 0);
			this.players.get(index).addRessource("warrior", 35);
			this.players.get(index).addRessource("food", 10);
		}
	}

	/**
	 * initialize an entire game of WarGame
	 */
	public void play() {
		int i = this.nbRound;
		while (this.nbRound > 0) {
			System.out.println(" -- Tour n° " + (i - this.nbRound + 1) + " --\n");
			/*
			 * debug paragraph, keep in comment unless u need it String autres =""; for(int
			 * k=0;k<this.getBoard().getOtherTileCoord().size();k++) { autres
			 * +="["+Integer.toString(this.getBoard().getOtherTileCoord().get(k)[0])+","+
			 * Integer.toString(this.getBoard().getOtherTileCoord().get(k)[1])+"]"; }
			 * System.out.println(autres);
			 */
			for (int index = 0; index < this.players.size(); index++) {
				this.playOneTurn(this.players.get(index));
				System.out.println(" ");
			}
			this.nbRound--;
			System.out.println(" ");
		}
		System.out.println(this.countdown());
	}

	/**
	 * This method play one turn of the game for one player with some random decision.
	 * 
	 * @throws UnknowPersonageException
	 */
	public void playOneTurn(Player currentP) {
		System.out.println(currentP.getName() + ", possede " + currentP.getPersonages().size()
				+ " Armée(s) et dispose en reserve de " + currentP.getChest().getStock().get("gold") + " pieces d'or.");
		double[] choices = this.randomDecision(currentP);
		// choix aéatoire entre deux decision : deployer une armée ou ne rien faire

		if (choices[0] < 0.5) {

			this.deployArmy(currentP, (int) choices[1], (int) choices[2]);

			this.harvestFoodRessources(currentP);
			// this.harvestGoldRessources(currentP); à priori le joueur ne rapatrie pas l'or
			// de ses armées
			try {
				this.feedArmy(currentP);
			} catch (UnknowPersonageException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println(currentP.getName() + " ne fait rien");
			this.harvestFoodRessources(currentP);
			this.harvestGoldRessources(currentP);
			try {
				this.feedArmy(currentP);
			} catch (UnknowPersonageException e) {

				e.printStackTrace();
			}

		}
	}

	/**
	 * Apply the rules of the game on the personage depending on whether he exists or not in the Tile
	 * 
	 * @param currentP the current player 
	 * @param currentArmy the current army 
	 */
	public void checkNeighboringTile(Player currentP, Army currentArmy) {

		// on check à gauche da l'armée courante:
		// si on est pas en bordure gauche et qu'il y a une armée à comparer.
		if (this.x > 0 && this.getBoard().getTile(this.x - 1, this.y).getOccupant() != null) {
			// System.out.println("######### On COmpare gauche ########"); <-- debug line
			// keep in comment if u dont need it
			compareArmy(currentArmy, this.getBoard().getTile(this.x - 1, this.y).getOccupant());
		}
		// on check à droite
		// si on est pas en bordure droite et qu'il y a une armée à comparer.
		if (this.x < this.getBoard().getBoardLength() - 1
				&& this.getBoard().getTile(this.x + 1, this.y).getOccupant() != null) {
			// System.out.println("######### On COmpare droite ########"); <-- debug line
			// keep in comment if u dont need it
			compareArmy(currentArmy, this.getBoard().getTile(this.x + 1, this.y).getOccupant());
		}
		// on check en bas
		// si on est pas en bordure basse et qu'il y a une armée à comparer.
		if (this.y < this.getBoard().getBoardWidth() - 1
				&& this.getBoard().getTile(this.x, this.y + 1).getOccupant() != null) {
			// System.out.println("######### On COmpare bas ########"); <-- debug line keep
			// in comment if u dont need it
			compareArmy(currentArmy, this.getBoard().getTile(this.x, this.y + 1).getOccupant());
		}
		// on check en haut
		// si on est pas en bordure haute et qu'il y a une armée à comparer.
		if (this.y > 0 && this.getBoard().getTile(this.x, this.y - 1).getOccupant() != null) {
			// System.out.println("######### On COmpare haut ########"); <-- debug line keep
			// in comment if u dont need it
			compareArmy(currentArmy, this.getBoard().getTile(this.x, this.y - 1).getOccupant());
		}
	}

	/**
	 * compare an army with its neighbors
	 *
	 * @param current the army played
	 * @param other   the army to be compared with.
	 */
	public void compareArmy(Personage current, Personage other) {
		// on commence par calculer la taille effective des armées à comparer:
		int seenCurrent = current.getSize();
		int seenOther = other.getSize();
		Army armyOther = (Army) other;
		Army armyCurrent = (Army) current;
		if (armyOther.getTile().getTileType() == "montagne") {
			seenOther = seenOther + 2;
		}
		if (armyCurrent.getTile().getTileType() == "montagne") {
			seenCurrent = seenCurrent + 2;
		}
		// si la comparée est inférieur à la courante
		if (seenOther < seenCurrent) {
			// si les propriétaires sont différents
			if (current.getOwner().equals(other.getOwner())) {
				if (other.getSize() == 1) {
					System.out.println(current.getOwner().getName() + " a capturé l'armée d'id : " + other.getId()
							+ " et l'armée d'id :" + current.getId() + " gagne 2 pièce d'or");
					other.changeOwner(current.getOwner());
					current.addGold(2);

				} else {
					other.setSize(other.getSize() / 2);
					if (other.getSize() == 1) {
						other.changeOwner(current.getOwner());
						current.addGold(2);
						System.out.println(current.getOwner().getName() + " a capturé l'armée d'id : " + other.getId()
								+ " et l'armée d'id :" + current.getId() + " gagne 2 pièce d'or");
					}
				}

			} else {
				if ((other.getSize() < 3 && armyOther.getTile().getTileType() == "montagne")
						|| (other.getSize() < 5 && armyOther.getTile().getTileType() != "montagne")) {
					other.setSize(other.getSize() + 1);
					System.out
							.println("L'armée d'id : " + current.getId() + " a renforcée l'armée d'id :" + other.getId()
									+ " qui possède maintenant " + Integer.toString(other.getSize()) + " Guerriers");
				}
			}
		}
		// sinon il ne se passe rien.

	}

	/**
	 * method to manage random decisions of players for the demonstration.
	 * 
	 * @param currentP the current player
	 * @return double[] the different informations need to be randomly picked : in
	 *         Order : [ the action , the number of soldier to deploy in the next
	 *         army , the index of the chosen tile in otherT]
	 */
	public double[] randomDecision(Player currentP) {
		Random rand = new Random();
		double[] res = new double[3];
		// action nb soldat à deployer |
		if (this.otherTile.size() <= 0) {
			return res;
		}
		int tileIndex = rand.nextInt(this.otherTile.size());// on choisi une tuile parmi les tuiles disponibles
		this.x = this.otherTile.get(tileIndex)[0];
		this.y = this.otherTile.get(tileIndex)[1];
		Tile choosedTile = super.getBoard().getTile(this.x, this.y);// on recupere la tuile correspondante

		int maxSize = 5;
		if (choosedTile.getTileType() == "desert  " || choosedTile.getTileType() == "montagne") { // on verifie que les
																									// tuiles sont de
																									// type desert ou
																									// montagne
			maxSize = 3;
		}
		int nbrSoldat = rand.nextInt(maxSize) + 1;
		if (nbrSoldat > currentP.getChest().getStock().get("warrior")) {
			nbrSoldat = currentP.getChest().getStock().get("warrior");
		}

		res[0] = Math.random();
		res[1] = nbrSoldat;

		res[2] = tileIndex;
		return res;
	}

	/**
	 * deploy an army on a random available territory
	 * 
	 * @param currentP   the current player
	 * @param nbrSoldat  the number of Warrior for the Army that will be created
	 * @param chosenTile the index of the played Tile in the otherTile Array.
	 */
	public void deployArmy(Player currentP, int nbrSoldat, int chosenTile) {
		if (this.otherTile.size() > 0) { // il reste des tuiles a conquerir

			Tile choosedTile = this.getBoard().getTile(this.x, this.y);// on recupere la tuile correspondante

			this.armyID++; // une armee en plus est cree

			if (nbrSoldat > 0) {

				Army soldat = new Army(String.valueOf(this.armyID), nbrSoldat);// on cree une armee

				soldat.setOwner(currentP); // on lui donne en proriétaire le joueur courant
				//currentP.getChest().getStock().put("warrior",
					//	currentP.getChest().getStock().get("warrior") - nbrSoldat); // on met à jour le stock de
																					// guerrier
				try {
					currentP.removeRessource("warrior", nbrSoldat);
					currentP.addPersonage(soldat); // on mets à jour la liste des personnages du joueur
					soldat.setArmyOnTile(choosedTile);// on lui attibue sa tuile
					this.getBoard().getTile(this.x, this.y).setPersonage(soldat);// on place l'armée sur la tuile
					this.otherTile.remove(chosenTile);// on enleve la tuile qu'on viens d'utiliser des tuiles
														// disponibles des tuiles dispo

					System.out.println(currentP.getName() + " deploie une armée d'identifiant: " + soldat.getId()
							+ " et de taille " + nbrSoldat + " sur la tuile " + choosedTile.getTileType() + "( "
							+ this.x + "," + this.y + " ) et " + " il lui reste : "
							+ currentP.getChest().getStock().get("warrior") + " guerriers");
					this.checkNeighboringTile(currentP, soldat);

				} catch (InsufficientStockException e) {
					System.out.println("stock insuffisant");

				}

			} else {
				System.out.println("Le joueur n'a plus de soldat pour le moment et passe son tour.");
			}
		} else {
			// en principe si il n'y a plus de tuiles dispo le jeu s'arr�te immediatement et
			// on ne fini pas le tour ;
			// pour le moment je fais appel a coutdown() pour marquer la fin du jeu puis a
			// un exit
			System.out.println("Le jeu se termine car aucune tuile n'est plus a conquerir");
			System.out.println("Voici le score des Joueurs en l'etat actuel du jeu : ");
			System.out.println(this.countdown());
			System.exit(0);

		}

	}

	// this method is never used , and was code to implement an eventual change in
	// the rules.
	/**
	 * harvest the gold resources of all the personages to the player
	 * 
	 * @param currentP the current player
	 */
	public void harvestGoldRessources(Player currentP) {
		Tile[][] gird = this.board.getBoard();
		for (int i = 0; i < gird.length; i++) {
			for (int j = 0; j < gird[0].length; j++) {
				if (gird[i][j].getOccupant() != null) {
					Player proprio = gird[i][j].getOccupant().getOwner();
					if (proprio != null && proprio.equals(currentP)) {
						currentP.addRessource("gold", gird[i][j].getOccupant().getGoldQuantity()); // Le joueur recolte
																									// l'or de ses
																									// arm�es
						gird[i][j].getOccupant().resetGold(); // on remet a 0 l'or des l'armées
					} // fin if
				} // fin if
			} // fin for
		} // fin for
	}

	/**
	 * harvest the resources of all the personages to the player into food
	 * 
	 * @param currentP the current player
	 */
	public void harvestFoodRessources(Player currentP) {
		Tile[][] gird = this.board.getBoard();
		for (int i = 0; i < gird.length; i++) {
			for (int j = 0; j < gird[0].length; j++) {
				if (gird[i][j].getOccupant() != null) {
					Player proprio = gird[i][j].getOccupant().getOwner();
					String tileType = gird[i][j].getTileType();
					if (proprio != null && proprio.equals(currentP)) {
						if (tileType == "plaine  ") { // si tuile type plaine on recolte 5 food
							currentP.addRessource("food", 5);
						} // fin if
						if (tileType == "foret   ") { // si tuile type foret on recolte 1 food
							currentP.addRessource("food", 1);
						} // fin if
					} // fin if
				} // fin if
			} // fin for
		} // fin for
	}

	/**
	 * feed all the armies if it is possible, if not, destroy the army and get 1 gold
	 * 
	 * @param currentP the current player
	 * @throws UnknowPersonageException
	 */
	public void feedArmy(Player currentP) throws UnknowPersonageException {
		System.out.println(currentP.toString() + "nourris ses armées");
		Tile[][] gird = this.board.getBoard();
		for (int i = 0; i < gird.length; i++) {
			for (int j = 0; j < gird[0].length; j++) { // je parcours le plateau
				if (gird[i][j].getOccupant() != null) { // si il y a quelqu'un sur la case :
					Player proprio = gird[i][j].getOccupant().getOwner(); // je determine son propriétaire
					String tileType = gird[i][j].getTileType(); // je determine le type de la tuile
					if (proprio != null && proprio.equals(currentP)) { // si le joueur courant et le propriétaire

						if (tileType == "desert  ") { // Tuile de types desert
							if (gird[i][j].getOccupant().getSize() * 2 < currentP.getChest().getStock().get("food")) { // Si
																														// il
																														// y
																														// a
																														// assez
																														// de
																														// nourriture
																														// en
																														// stock
																														// par
																														// rapport
																														// a
																														// une
																														// tuile
																														// desert
								int temp = currentP.getChest().getStock().get("food"); // valeurs actuel de food
								currentP.getChest().getStock().put("food",
										temp - 2 * gird[i][j].getOccupant().getSize());// nouvelle valeurs de food
							} // fin if
							else { // Mince, il n'y a pas assez de nourriture en stock!
								gird[i][j].getOccupant().getOwner().removePersonage(gird[i][j].getOccupant());// son
																												// arm�e
																												// est
																												// detruite
																												// et
								currentP.addRessource("gold", 1); // il recolte 1Po
							} // fin else
						} // fin if
						else { // Tuiles de types non desert
							if (gird[i][j].getOccupant().getSize() < currentP.getChest().getStock().get("food")) { // Si
																													// il
																													// y
																													// a
																													// assez
																													// de
																													// nourriture
																													// en
																													// stock
								int temp = currentP.getChest().getStock().get("food");// valeurs actuel de food
								currentP.getChest().getStock().put("food", temp - gird[i][j].getOccupant().getSize());// nouvelle
																														// valeurs
																														// de
																														// food
							} // fin if
							else { // Mince, il n'y a pas assez de nourriture en stock!
								System.out.println("L'armée d'identifiant " + gird[i][j].getOccupant().getId()
										+ " meurt car il ne reste plus que "
										+ Integer.toString(currentP.getChest().getStock().get("food"))
										+ " unité(s) de nouriture");

								gird[i][j].getOccupant().getOwner().removePersonage(gird[i][j].getOccupant());// son
																												// arm�e
																												// est
																												// detruite
																												// et
								currentP.addRessource("gold", 1); // il recolte 1Po
							} // fin else
						} // fin else

					} // fin if
				} // fin if
			} // fin for
		} // fin for
		System.out.println("Il lui reste : " + Integer.toString(currentP.getChest().getStock().get("food"))
				+ " unite(s) de nouriture");
	}

	/**
	 * return the final score of each player and the winner
	 * 
	 * @return a string representing the final score of each player and the winner.
	 */
	public String countdown() {
		Tile[][] gird = this.board.getBoard();

		this.scoreMap = new HashMap<Player, Integer>();
		this.nbTileMap = new HashMap<Player, Integer>();

		Iterator<Player> itP = this.players.iterator();

		while (itP.hasNext()) {
			Player p = itP.next();
			this.scoreMap.put(p, p.getChest().getStock().get("gold"));
			this.nbTileMap.put(p, 0);
		}

		for (int i = 0; i < gird.length; i++) {
			for (int j = 0; j < gird[0].length; j++) {
				if (gird[i][j].getOccupant() != null) {

					Player proprio = gird[i][j].getOccupant().getOwner(), pTmp;
					String tileType = gird[i][j].getTileType();
					int tmpScore, tmpNbTile;

					for (int index = 0; index < this.players.size(); index++) {

						if (proprio != null && proprio.equals(this.players.get(index))) {

							pTmp = this.players.get(index);
							tmpScore = gird[i][j].getOccupant().getGoldQuantity() + this.scoreMap.get(pTmp);
							tmpNbTile = 1 + this.nbTileMap.get(pTmp);

							if (tileType.equals("desert  ") || tileType.equals("montagne")) {
								tmpScore += 4;
							}
							if (tileType.equals("foret   ")) {
								tmpScore += 2;
							}
							if (tileType.equals("plaine  ")) {
								tmpScore += 1;
							}

							this.scoreMap.put(pTmp, tmpScore);
							this.nbTileMap.put(pTmp, tmpNbTile);
						} // fin if

					} // fin for

				} // fin if
			} // fin for
		} // fin for

		for (int index = 0; index < this.players.size(); index++) {
			if (this.nbTileMap.get(this.players.get(index)) >= 10) {
				int tmpScore = this.scoreMap.get(this.players.get(index)) + 5;
				this.scoreMap.put(this.players.get(index), tmpScore);
			}
		}

		/*
		 * if(nbTileJ1>=10) { scoreJ1+=5; }
		 */

		// on determine le vainqueur
		int scoreMax = Collections.max(this.scoreMap.values());

		// on ajoute les joueurs ayant le scoreMax(pratique quand il y a égalité des
		// scores)
		List<Player> winners = new ArrayList<>();
		for (int index = 0; index < this.players.size(); index++) {
			if (this.scoreMap.get(this.players.get(index)) == scoreMax) {
				winners.add(this.players.get(index));
			}
		}

		String description = "";

		for (int index = 0; index < this.players.size(); index++) {
			description += this.players.get(index).getName() + " marque " + this.scoreMap.get(this.players.get(index))
					+ " points \n";
		}

		String res = "";

		if (winners.size() == 1) {
			res = "Le Vainqueur est " + winners.get(0).getName() + " Bravo !\n";
		} else {
			res = "Egalite entre ";
			for (int index = 0; index < winners.size() - 1; index++) {
				res += winners.get(index).getName() + " et ";
			}
			res += winners.get(winners.size() - 1).getName() + " Bravo! \n";
		}

		return description + res;
	}// fin countdown

}
