package match;

import competitor.Competitor;

/**
 * 
 * @author douchet
 * Basic class of match decide randomly who won the match
 */
public class RandomMatch implements Match {
	


	
	/**
	 * Method to choose who won the match; here its randomly decided
	 */
	@Override
	public Competitor getWinner(Competitor c1, Competitor c2) {
		double res = Math.random();
		Competitor winner;
		if(res>=0.5) {
			winner = c1;
		}
		else {
			winner = c2;
		}
		return winner;
		
	}
	
	public boolean equals(Object o) {
		return o instanceof RandomMatch;
	}


}
