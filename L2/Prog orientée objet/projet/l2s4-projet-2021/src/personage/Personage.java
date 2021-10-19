package personage;

import player.*;
import tile.Tile;
import utils.UnknowPersonageException;

/**
 * class of Personage
 * @author Groupe1
 */
public abstract class Personage {
	protected String id;
	protected int gold;
	protected int size;
	protected Player owner;
	protected Tile tile;

	/**
	 * Construct a Personage with a given id and size.
	 * 
	 * @param size the size of the army.
	 * @param id   the id of the personage.
	 */
	public Personage(String id, int size) {
		this.id = id;
		this.gold = 0;
		this.size = size;
	}

	/**
	 * Class Constructor with initial size of 1 and 0 unit of gold.
	 * 
	 * @param id the id of personage
	 */
	public Personage(String id) {
		this.id = id;
		this.gold = 0;
		this.size = 1;
	}

	/**
	 * Set the owner of the personage (didn't add him in the owner's list)
	 * 
	 * @param name the player who gets the personage.
	 */
	public void setOwner(Player name) {
		this.owner = name;
	}

	/**
	 * Get the owner of the Personage
	 * 
	 * @return the player that has the personage in his list.
	 */
	public Player getOwner() {
		return this.owner;
	}

	/**
	 * Get the size of the Army
	 * 
	 * @return the Army's size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * Set the size of the Personage
	 * 
	 * @param size the size of the army
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Get the worker id
	 * 
	 * @return the worker id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * get the gold quantity of the worker 
	 * 
	 * @return the worker gold's quantity
	 */
	public int getGoldQuantity() {
		return this.gold;
	}

	/**
	 * Add gold units to gold.
	 * 
	 * @param gold the gold units.
	 */
	public void addGold(int gold) {
		this.gold += gold;
	}

	/**
	 * Reset the gold of the personage
	 */
	public void resetGold() {
		this.gold = 0;
	}

	/**
	 * Remove a Personage from the owner's list and add him into another player's list.
	 * 
	 * @param name the player who gets the personage.
	 */
	public void changeOwner(Player name) {
		try {

			this.owner.removePersonage(this);
			name.addPersonage(this);
			this.setOwner(name);
		} catch (UnknowPersonageException e) {
			// TODO process exception or re-throw it
		}
	}

}
