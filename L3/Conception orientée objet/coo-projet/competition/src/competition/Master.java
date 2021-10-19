package competition;

import competitor.Competitor;
import exception.NotaPowerOfTwoException;
import match.Match;
import selector.CompetitorSelector;
import selector.SelectorByLeagueOf4;

public class Master extends Competition{

	private CompetitorSelector selector;

	public Master(Competitor[] comps, Match match, CompetitorSelector selector) {
		super(comps, match);
		this.selector = selector;
		
	}

	@Override
	public void generateMatchs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void play() {
		this.selector = new SelectorByLeagueOf4(this.getCompetitors());
		Competitor[] finalist = this.selector.select();
		this.playFinals(finalist);
		
		
		
	}

	
	public void playFinals(Competitor[] finalist) {
		try {
			
			Tournament finalTournament = new Tournament(finalist , this.getMatch());
			
			while(this.currentCompetitors.size()>1) {
				finalTournament.generateMatchs();
				finalTournament.clearCurrent();
				finalTournament.playOneRound();	
			}
			
			
		} catch (NotaPowerOfTwoException e) {
			e.printStackTrace();
		}
	}
}
