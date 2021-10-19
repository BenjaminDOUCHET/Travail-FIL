package player;

import java.util.*;

import personage.Personage;
import utils.InsufficientStockException;
import utils.UnknowPersonageException;

/**
 * 
 * @author Douchet Benjamin 
 * model a player by his Name (String) Unique by player
 * got a Chest as attribute to stock in game resources.
 *
 */
public class Player {

	private Chest chest;
	private String name;

	private List<Personage> myCharacter;

	/**
	 * construct a player by giving his name
	 * 
	 * @param name of the player
	 */
	public Player(String name) {

		this.name = name;
		this.chest = new Chest();
		this.myCharacter = new ArrayList<Personage>();
	}

	/**
	 * getter of name attribute
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * getter of Chest attribute
	 * 
	 * @return the stock of the player
	 */

	public Chest getChest() {
		return this.chest;
	}

	/**
	 * getter of the player's List of Characters
	 * 
	 * @return the list of characters of a specified player 
	 */
	public ArrayList<Personage> getPersonages() {
		return (ArrayList<Personage>) this.myCharacter;
	}

	/**
	 * add a Personage to player's List
	 * 
	 * @param perso the new Personage to add
	 */
	public void addPersonage(Personage perso) {
		if (perso.getOwner() != null) {
			perso.changeOwner(this);
		} else {
			perso.setOwner(this);
		}
		this.myCharacter.add(perso);

	}

	/**
	 * Remove a Character of a Player's List
	 * 
	 * @param perso the Character to remove from player's List
	 * @return <code>true</code> if the Character has been successfully removed, <code>false</code> if not
	 * @throws UnknowPersonageException if the Personage does not exist in player's List
	 */
	public Personage removePersonage(Personage perso) throws UnknowPersonageException {
		if (!(this.getPersonages().contains(perso))) {

			throw new UnknowPersonageException("le Personage n'appartient pas à ce joueur");
		} else {
			Personage res = perso;
			perso.setOwner(null);
			this.myCharacter.remove(this.myCharacter.indexOf(perso));
			return res;
		}
	}

	/**
	 * add to the Chest the amount quantity of the nomRessource in the Chest
	 * 
	 * @param nomRessource the name of a resource to add
	 * @param Qte          the quantity of the resource to add
	 */
	public void addRessource(String nomRessource, int Qte) {
		if (this.chest.getStock().containsKey(nomRessource)) {
			int temp = this.chest.getStock().get(nomRessource);
			this.chest.getStock().put(nomRessource, temp + Qte);
		} else {
			this.chest.getStock().put(nomRessource, Qte);
		}
	}

	/**
	 * Check if the player has a given gold quantity in stock
	 * 
	 * @param goldQuantity the given gold quantity
	 * @return <code>true</code> iff the given gold quantity is available in stock, <code>false</code> else
	 */
	public boolean checkGoldQuantity(int goldQuantity) {
		return this.chest.getStock().get("gold") >= goldQuantity;
	}

	/**
	 * Remove resources from the player's chest
	 * 
	 * @param nomRessource the resource to be removed
	 * @param Qte          the quantity of resources to be removed from the stock
	 * @throws InsufficientStockException if there isn't enough resources to be removed from the stock
	 */
	public void removeRessource(String nomRessource, int Qte) throws InsufficientStockException {
		if (this.chest.getStock().containsKey(nomRessource) && this.chest.getStock().get(nomRessource) >= Qte) {
			int temp = this.chest.getStock().get(nomRessource);
			this.chest.getStock().put(nomRessource, temp - Qte);
		} else {
			throw new InsufficientStockException("la dépense ne peut être efectuées ,  Stock insufisant");
		}

	}

	/**
	 * return the current state of the player format : name , state of his resources
	 * need to be completed in a game class by the current state of Personage deployed
	 * 
	 * @return a string representing the current state of the player
	 */
	public String toString() {
		return this.name + " " + this.chest.toString() + " ";
	}

	/**
	 * compare two instances of PLayer , they are equals if they got the same name and the same List of Personage
	 * 
	 * @param o the other player to compare with
	 */
	public boolean equals(Object o) {
		if (!(o instanceof Player)) {
			return false;
		} else {
			Player other = (Player) o;
			return this.getName() == other.getName() && this.getPersonages().equals(other.getPersonages());
		}
	}

}
