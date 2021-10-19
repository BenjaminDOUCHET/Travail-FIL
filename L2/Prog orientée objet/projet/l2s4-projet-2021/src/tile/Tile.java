package tile;

import personage.Personage;

/**
 * 
 * @author GUENNINECHE Amel
 * @version 1.0 (initial) 07/02/2021
 */
public abstract class Tile implements Cloneable {

	protected Personage occupant;
	protected String ressourceType;
	protected String tileType;

	/**
	 * the constructor of the class
	 * 
	 * @param tileType      the field type of the tile
	 * @param ressourceType the resource type of the tile
	 */
	public Tile(String tileType, String ressourceType) {
		this.ressourceType = ressourceType;
		this.tileType = tileType;
		this.occupant = null;
	}

	/**
	 * clone an instance of tile.
	 * 
	 * @return the instance of tile after being cloned
	 */
	public Tile clone() {
		Tile res = null;
		try {
			res = (Tile) super.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("this Tile cannot be clone");
		}

		return res;
	}

	/**
	 * @return the personage occupying the tile
	 */
	public Personage getOccupant() {
		return occupant;
	}

	/**
	 * @return the ressourceType of the tile
	 */
	public String getRessourceType() {
		return ressourceType;
	}

	/**
	 * @param ressourceType the ressourceType to set
	 */
	public void setRessourceType(String ressourceType) {
		this.ressourceType = ressourceType;
	}

	/**
	 * @return the type of the tile
	 */
	public String getTileType() {
		return tileType;
	}

	/**
	 * delete a personage 
	 */
	public void deleteOccupant() {
		this.occupant = null;
	}

	/**
	 * set a personage on tile
	 * 
	 * @param occupant the personage occupying the tile
	 */
	public void setPersonage(Personage occupant) {
		this.occupant = occupant;
	}

	/**
	 * compare two tiles, they are equal if they have the same type and the same resource
	 * @param O the tile to compare to
	 * @return <code>true</code> if the tiles are equal, <code>false</code> if not
	 */
	public boolean equals(Object O) {
		if (!(O instanceof Tile)) {
			return false;
		} else {
			Tile other = (Tile) O;
			return this.getTileType() == other.getTileType() && this.getRessourceType() == other.getRessourceType();
		}
	}
}
