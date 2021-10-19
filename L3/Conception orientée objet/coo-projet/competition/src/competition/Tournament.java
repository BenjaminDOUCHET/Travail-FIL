package competition;

import java.util.ArrayList;
import java.util.Arrays;


import competitor.Competitor;
import exception.NotaPowerOfTwoException;
import match.Match;
import util.NumberTester;
/**
 * 
 * @author douchet
 *
 * Touranment class modelize a direct elimination tournament,
 * have to be used with a power of 2 competitor in entry 
 *
 *
 */
public class Tournament extends Competition {

	public Tournament  (Competitor[] comps, Match match) throws NotaPowerOfTwoException {
		
		super(comps, match);
		
		//on vérifie que le nombre de compétiteurs est une puissance de 2
		int n = comps.length;
		if(!NumberTester.isPowerOf2(n)) {
				throw new NotaPowerOfTwoException("competitors aren't in number of power of 2");
			}
				
		
	}

	
	/**
	 * génère des match depuis la liste currentCompetitors.
	 */
	@Override
	public void generateMatchs() {
		this.clearPairing();
		for (int i = 0 ; i<this.currentCompetitors.size() ; i+=2) {
			Competitor[] paire = {this.currentCompetitors.get(i),this.currentCompetitors.get(i+1)};
			this.pairing.add(new ArrayList<Competitor>(Arrays.asList(paire)));
		}
		
	}
	


	/**
	 * déroule un tournois au complet
	 */
	@Override
	public void play() {
		
		while(this.currentCompetitors.size()>1) {
			this.generateMatchs();
			this.clearCurrent();
			this.playOneRound();
		
			
		}
		this.displayRank(this.ranking());
		
	}

	
	/**
	 * déroule un tour du tournois.
	 */
	public void playOneRound() {
		//on itére les appariement et on résout les matchs
				for(int i=0 ;i<this.getPairing().size();i++) {
					//on prépare la trace
					
					Competitor j1 = this.getPairing().get(i).get(0);
					Competitor j2 =this.getPairing().get(i).get(1);
					String track = Competition.DISPLAYER.prepareTrack(j1.getName(),j2.getName());
					
					//on détermine le vainqueur
					Competitor winner = this.getMatch().getWinner(j1,j2);
										
					//on affiche le résultat
					track = Competition.DISPLAYER.endTrack( winner.getName(),track);
					Competition.DISPLAYER.displayMsg(track);
					
					//on lui attribue un point
					winner.setPoints(winner.getPoints()+1);
					
					//on l'ajoute aux competiteurs pour la manche suivante
					this.currentCompetitors.add(winner);
					
				}
				
	}


	


	
}
