package personage.agricultural;

import personage.Personage;
import tile.*;

/**
 * 
 * @author ATCHEDJI Churchill
 * @version 1.0 (initial) 07/02/2021 this class is an extension of the abstract class Personage
 */
public class Worker extends Personage {

	/**
	 * Create a worker with his id (initially size is 1)
	 * 
	 * @param id the id of the worker
	 */
	public Worker(String id) {
		super(id, 1);
	}

	/**
	 * Pay the worker with a gold quantity
	 * 
	 * @param gold the gold quantity to add to the worker
	 */
	public void getPaid(int gold) {
		if (gold <= 0) {
			throw new IllegalArgumentException("Gold must be positive");
		}
		this.gold += gold;
	}

	/**
	 * two workers are equals if they have the same id and the same owner
	 * 
	 * @return true iff the the two worker have the same id and the same owner
	 */
	public boolean equals(Object o) {
		try {
			Worker other = (Worker) o;
			return this.id.equals(other.getId());
		} catch (ClassCastException e) {
			return false;
		}
	}

	/**
	 * Provides the string representation of a worker
	 * 
	 * @return the string representation of a worker
	 */
	public String toString() {
		return "Worker n°" + this.id;
	}

	/**
	 * Set the worker on the given tile
	 * 
	 * @param tile the given tile to set the worker on
	 */
	public void setWorkerOnTile(Tile tile) {
		this.tile = tile;
	}

	/**
	 * Provides the current tile of the worker
	 * 
	 * @return the current tile of the worker
	 */
	public Tile getTheWorkerTile() {
		return this.tile;
	}

}
