package competition;

import java.util.ArrayList;
import java.util.Arrays;

import competitor.Competitor;
import match.Match;

public class League extends Competition{

	public League(Competitor[] comps, Match match) {
		super(comps, match);
		
	}

	@Override
	public void generateMatchs() {
		this.clearPairing();
		//on génère toutes les permutations de match  possibles une fois.
		for(int i = 0 ; i<this.getCompetitors().length-1;i++) {
			for(int j = i+1;j<this.getCompetitors().length;j++) {
				Competitor[] paire = {this.currentCompetitors.get(i),this.currentCompetitors.get(j)};
				this.pairing.add(new ArrayList<Competitor>(Arrays.asList(paire)));
			}
		}
	}
	
	

	@Override
	public void play() {
		
		this.generateMatchs();
		this.playAllMatchs();
		this.displayRank(this.ranking());
		
		
	}
	
	private void playAllMatchs() {
		for(int i=0 ;i<this.getPairing().size();i++) {
			for(int j= 0 ; j<2 ;j++){
				
			Competitor j1 = this.getPairing().get(i).get(0);
			Competitor j2 = this.getPairing().get(i).get(1);
				
				
			String track = Competition.DISPLAYER.prepareTrack(j1.getName(),j2.getName());
			
			Competitor winner = this.getMatch().getWinner(j1,j2);
			
			//on lui attribue un point
			winner.setPoints(winner.getPoints()+1);
			
			track = Competition.DISPLAYER.endTrack(winner.getName(),track );
			//on affiche le résultat
			Competition.DISPLAYER.displayMsg(track);
			}			
			
		}

}
}



