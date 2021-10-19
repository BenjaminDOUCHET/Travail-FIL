package competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import competitor.Competitor;
import match.Match;
import util.Displayer;
import util.MapUtil;
import util.StdDisplayer;

public abstract class Competition {

	private Match match;
	private final Competitor[] competitors;
	protected ArrayList<Competitor> currentCompetitors;
	protected ArrayList<ArrayList<Competitor>> pairing;
	public static final Displayer DISPLAYER = new StdDisplayer();
	
	public Competition(Competitor[] comps , Match match) {
		this.competitors = comps;
		this.match = match;
		
		//on prépare la première génération de match de façon aléatoire
		this.currentCompetitors = new ArrayList<Competitor>(Arrays.asList(this.getCompetitors()));
		Collections.shuffle(this.currentCompetitors);
		
	}
	
	
	public Match getMatch() {
		return match;
	}
	public void setMatch(Match match) {
		this.match = match;
	}


	public Competitor[] getCompetitors() {
		return competitors;
	}


	public List<ArrayList<Competitor>> getPairing() {
		return pairing;
	}
	
	
	public List<Competitor> getCurrentCompetitor(){
		return this.currentCompetitors;
	}
	
	public void clearCurrent() {
		this.currentCompetitors = new ArrayList<Competitor>();
	}
	/**
	 * generate match between competitors and stock them in pairing attribute
	 */
	public abstract void generateMatchs();
	
	
	/**
	 * method to play a whole tournament
	 */
	public abstract void play();
	
	
	/**
	 * reset the pairing attribute
	 */
	protected void clearPairing() {
		this.pairing = new ArrayList<ArrayList<Competitor>>();
	}
	
	
	/**
	 * method to simulate a match player and affect the score to the winner
	 * @param score the score to add
	 * @param c1 1st competitor
	 * @param C2 2nd competitor
	 */
	public void playMatch(Competitor c1 , Competitor C2, int score) { //faut peut etre généraliser ici
		Competitor winner = this.match.getWinner(c1, C2);		
		winner.setPoints(winner.getPoints()+score);
	}
	
	
	/**
	 * create an Hashmap from the actual points of Competitors
	 * 
	 * not a good complexity version need a V2.0
	 * @return HashMap<
	 */
	public Map<Competitor,Integer>ranking() {
		Map<Competitor,Integer> rank = new HashMap<Competitor,Integer>();
		
		
		int total = this.competitors.length;
	
		int joueurRentre = 0;
		int rang = this.getCompetitors().length;
		int nbMaxPoints = this.bestScore() ;
		
		//tant qu'on a pas entré tous les joueurs.
		while(joueurRentre<=total &&  nbMaxPoints>=0) {
			
			//on recherche les joueurs à entrer.
			for(int i = 0 ; i<total ;i++) {
				
				///on regarde si le joueur est deja entré.
				Integer val = rank.get(this.competitors[i]);
				
				if (val == null) {//dans ce cas on a pas encore rentré le joueur
					
					if(this.competitors[i].getPoints()== nbMaxPoints) { // on regarde si il a le nb de point
						rank.put(this.competitors[i], rang);
						joueurRentre ++;
						
					}//fin si  competiteur a le nb de point
					rang--;//on incrémente le rang
				}//fin si le compétiteur n'est pas rentré
				
			
					
		}///fin for
		nbMaxPoints --;	// on descends le score à évaluer 
		}///fin while
		
		return MapUtil.sortByDescendingValue(rank);
	}

	/**
	 * display the rank of the competition 
	 * can handle Map Structures
	 * @param rank the Map format
	 */
	public void displayRank(Map<Competitor,Integer> rank) {
		Competition.DISPLAYER.displayMsg("*** Ranking ***");
		
		Set<Competitor> keys = rank.keySet();
		
		for(Competitor key : keys) {
			String displayRank = Competition.DISPLAYER.prepareRank(key.getName(),key.getPoints());
			Competition.DISPLAYER.displayMsg(displayRank);
		}
	}
	
	/**
	 * intern method to look for the best score to evaluate the ranking
	 * @return int the best score in all Competitor's one
	 */
	private int bestScore() {
		int res = 0;
		for(int i = 0 ; i<this.competitors.length;i++) {
			if(this.competitors[i].getPoints()>res) {
				res = this.competitors[i].getPoints();
			}
		}
		return res;
	}
	
	
	
	
}
