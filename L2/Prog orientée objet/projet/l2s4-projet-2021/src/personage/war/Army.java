package personage.war;

import personage.Personage;
import tile.Tile;

/**
 * 
 * @author GUENNINECHE Amel
 * @version 1.0 (initial) 07/02/2021 this class is an extension of the abstract class Personage
 */
public class Army extends Personage {

	/**
	 * Create an Army with a given size and ID.
	 * 
	 * @param id   The ID of the army.
	 * @param size The army size.
	 */
	public Army(String id, int size) {
		super(id, checkSize(size));
	}

	/**
	 * get the Id of the Army
	 * 
	 * @return the Army's Id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * get the size of the Army
	 * 
	 * @return the Army's size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Check if the army size is not between 1 and 5.
	 * 
	 * @param size The army size.
	 * @return size the size of the army.
	 * @throws IllegalStateException if size is not between 1 and 5.
	 * 
	 */
	private static int checkSize(int size) {
		if (size < 1 || size > 5) {
			throw new IllegalStateException("Size should be between 1 and 5: " + size);
		}
		return size;
	}

	/**
	 * Add gold units to gold.
	 * 
	 * @param gold units.
	 */
	public void addGold(int gold) {
		this.gold += gold;
	}

	/**
	 * compare two Armies , they are equal if they have the same size and the same Id
	 * 
	 * @param o the other Army to compare with
 	 */
	public boolean equals(Object o) {
		if (!(o instanceof Army)) {
			return false;
		} else {
			Army other = (Army) o;
			return this.getSize() == other.getSize() && this.getId().equals(other.getId());
		}
	}

	/**
	 * get the current state of the Army format : id, size , amount of Gold he has
	 * 
	 * @return a string representing the Army
	 */
	public String toString() {
		return "The Army with id " + this.getId() + " and size " + this.getSize() + " has " + this.gold
				+ " piece of gold.";
	}

	/**
	 * Set the army on the given tile
	 * 
	 * @param tile the given tile to set the army on
	 */
	public void setArmyOnTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * get the tile were the army is on
	 * 
	 * @return tile were the army is on 
	 */
	public Tile getTile() {
		return this.tile;
	}
}
