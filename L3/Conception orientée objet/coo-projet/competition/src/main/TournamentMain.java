package main;

import competition.Competition;
import competition.Tournament;
import competitor.Competitor;
import exception.NotaPowerOfTwoException;
import match.Match;
import match.RandomMatch;

public class TournamentMain {

	public static void main(String[] args) throws NotaPowerOfTwoException {
		Competitor[] comps;
		Match match = new RandomMatch();
		Competition tournament;
				
		comps = new Competitor[8];
		for(int j = 0 ; j<8 ; j++) {
			comps[j] = new Competitor("joueur"+" "+Integer.toString(j));
		}
		
		
		tournament = new Tournament(comps, match);
		tournament.play();

	}

}
