package main;

import competition.Competition;
import competition.League;
import competitor.Competitor;
import match.Match;
import match.RandomMatch;

public class LeagueMain {
	
	
	
	public static void main(String[] args) {
		Competitor[] comps;
		Match match = new RandomMatch();
		Competition league;
		
		
		
		
		comps = new Competitor[5];
		for(int j = 0 ; j<5 ; j++) {
			comps[j] = new Competitor("joueur"+" "+Integer.toString(j));
		}
		
		
		league = new League(comps, match);
		league.play();
	}

}
