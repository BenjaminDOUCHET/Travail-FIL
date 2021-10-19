package board;

import tile.*;
import java.util.*;
import utils.UnknowCoordinatesException;

/**
 * The board on which the game will take place
 * @author groupe1
 */
public class Board {
	private Tile[][] gird;
	private int length;
	private int width;
	private List<int[]> otherTile;

	/**
	 * construct a board with a given length and width
	 * 
	 * @param i length of the board
	 * @param j width of the board
	 */
	public Board(int i, int j) {
		this.gird = new Tile[i][j];
		this.length = i;
		this.width = j;
		this.otherTile = new ArrayList<int[]>();
		try {
			this.generate();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * return the coordinate of all tiles except ocean
	 * 
	 * @return the list of tab containing coordinates of tiles
	 */
	public List<int[]> getOtherTileCoord() {
		return this.otherTile;
	}

	/**
	 * getter of the gird Parameter
	 * 
	 * @return the gird
	 */
	public Tile[][] getBoard() {
		return this.gird;
	}

	/**
	 * getter of the tile of the board
	 * 
	 * @param x the abscissa of the tile
	 * @param y the ordinate of the tile
	 * @return the tile corresponding to the coordinates passed in parameter
	 * @throws UnknowCoordinatesException if the given coordinates are not correct
	 */
	public Tile getTile(int x, int y) {
		if (x >= this.length || x < 0 || y >= this.width || y < 0) {
			throw new UnknowCoordinatesException("The coordinates are not correct");
		} else {
			return this.gird[x][y];
		}
	}

	/**
	 * getter of the board width
	 * 
	 * @return the board width
	 */
	public int getBoardWidth() {
		return this.width;
	}

	/**
	 * getter of the board length
	 * 
	 * @return the board length
	 */
	public int getBoardLength() {
		return this.length;
	}

	/**
	 * remove the tile at a given index
	 * 
	 * @param ind the index where to remove the tile
	 */
	public void removeAvaible(int ind) {
		this.otherTile.remove(ind);
	}

	/**
	 * generate a standard Board
	 * 
	 * @throws CloneNotSupportedException if the Tile can't be cloned
	 */
	public void generate() throws CloneNotSupportedException {
		// on calcule la taille totale du plateau

		int taille = this.gird.length * this.gird[0].length;
		Random rand = new Random();
		// on determine le nombre de cases ocean
		// avec un min de 2 cases non ocean

		int complementOcean = rand.nextInt(taille / 3 - 2);
		// on défini le nombre de case ocean et des autres
		int tailleOcean = taille / 3 * 2 + complementOcean;
		int tailleAutre = taille - tailleOcean;

		// on crée une "bibliothèque" des tuiles du jeu
		Tile[] ref = new Tile[4];
		ref[0] = new TileMontain();
		ref[1] = new TileForest();
		ref[2] = new TilePlain();
		ref[3] = new TileDesert();

		// on parcours maintenant la plateau pour y disposer les tuiles.
		int ocean = 0; // indice de parcours des tuiles oceans
		int autre = 0; // indice de parcours de autres tuiles

		for (int i = 0; i < this.getBoardLength(); i++) {
			for (int j = 0; j < this.getBoardWidth(); j++) {
				int flip = rand.nextInt(2);
				// si on a pas encore rempli la case
				if (this.getBoard()[i][j] == null) {
					// si on a tiré une case ocean et qu'il nous en reste ou qu'on a plus de tuile
					// autre
					if ((flip == 0 && ocean < tailleOcean) || autre >= tailleAutre) {
						this.getBoard()[i][j] = new TileOcean();
						ocean++;
					}
					// on a pas tiré une tuile ocean ET il nous reste des tuiles autre
					else {
						int type = rand.nextInt(4);
						this.getBoard()[i][j] = ref[type].clone();
						autre++;
						int[] coord = new int[2];
						coord[0] = i;
						coord[1] = j;
						this.otherTile.add(coord);

						// on regarde les cases adjacentes deja remplies
						boolean aUnVoisinAutre = false;

						if ((i > 1 && !(this.getBoard()[i - 1][j] instanceof TileOcean))
								|| (j > 1 && !(this.getBoard()[i][j - 1] instanceof TileOcean))) {
							aUnVoisinAutre = true;
						}
						// on a pas de tuile autre deja adjacente ou il ne nous en restera qu'une
						if (!aUnVoisinAutre || autre == tailleAutre - 2) {
							type = rand.nextInt(4);
							if (i < this.getBoardLength() - 2) {
								this.getBoard()[i + 1][j] = ref[type].clone();
								int[] coord2 = new int[2];
								coord2[1] = coord[1];
								coord2[0] = i + 1;
								this.otherTile.add(coord2);
								autre++;
								;

							} else if (j < this.getBoardWidth() - 2) {
								this.getBoard()[i][j + 1] = ref[type].clone();
								int[] coord3 = new int[2];
								coord3[1] = j + 1;
								coord3[0] = coord[0];
								this.otherTile.add(coord);
								autre++;
							} else {
								this.getBoard()[i - 1][j] = ref[type].clone();
								int[] coord3 = new int[2];
								coord3[1] = j + 1;
								coord3[0] = coord[0];
								this.otherTile.add(coord);
								autre++;

							}

						}

					} // fin else
				} // fin if case est vide
			} // fin premier for
		} // fin second for
	}// fin generate

	/**
	 * equals method of Board Class , 2 boards are equal if there tiles in the gird
	 * have the same type at the same place
	 * 
	 * @param o the object to evaluate with
	 * @return <code>true</code> if equals , <code>false</code> if not
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Board)) {
			return false;
		} else {
			Board other = (Board) o;
			Tile[][] gird1 = this.getBoard();
			Tile[][] gird2 = other.getBoard();
			boolean same = true;
			for (int i = 0; i < gird1.length; i++) {
				for (int j = 0; j < gird1[0].length; j++) {
					if (!(gird1[i][j].equals(gird2[i][j]))) {
						same = false;
					}
				}
			}
			return same;
		}
	}
}
