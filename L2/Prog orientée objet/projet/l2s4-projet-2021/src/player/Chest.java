package player;

import java.util.HashMap;
import java.util.Set;

/**
 * @author groupe1
 * Representation of the stock of players
 */
public class Chest {
	
	private HashMap<String,Integer> stock;
	
	/**
	 * Constructor of the class , an instance of Chest always Start Empty to be initialize by a Game Class
	 */
	public Chest() {
		this.stock = new HashMap<String,Integer>();
	}
	
	/**
	 * getter of Coffre's HashMap
	 * @return the stock of the player
	 */
	public HashMap<String,Integer> getStock() {
		
		return this.stock;
	}
	
	/**
	 * convert the current Stock to string format : 0 wood, 12 food, ...
	 * @return String the current state of the stock
	 */
	public String toString(){
		String res = "";
		
		Set<String> keys = this.stock.keySet();
		for(String key : keys){
			res+=Integer.toString(this.stock.get(key))+" "+key+"(s), ";
		}
		
		return res;
	}

	/**
	 * equals method , two instances of chest are equals if their HashMap are equals
	 * @param o the object to compare to
	 * @return <code>true</code> if the two instances of chest are equals, <code>false</code> if not
	 */
	public boolean equals(Object o) {
		if(! (o instanceof Chest)) {
			return false ;
		}
		
		else {
			Chest other = (Chest)o;
			return this.getStock().equals(other.getStock());
		}
	}
}
