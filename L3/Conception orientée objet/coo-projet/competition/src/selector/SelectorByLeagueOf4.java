package selector;

import java.util.ArrayList;
import java.util.Map;

import competition.League;
import competitor.Competitor;
import match.Match;
import match.RandomMatch;
import util.NumberTester;

public class SelectorByLeagueOf4 implements CompetitorSelector{

	private Competitor[] candidates;
	private Competitor[] selected;
	private Map<Competitor,Integer> intermediateRank ;
	
	
	public SelectorByLeagueOf4(Competitor[] competitors){
		this.candidates = competitors;	
	}
	
	@Override
	public Competitor[] select() {
		ArrayList<Competitor[]> poolList = this.generatePool();
		
		for(int i=0 ; i<poolList.size();i++) {
			// on fait jouer et on récupère la map triée de la pool.
			Map<Competitor,Integer> resPool = this.playPool(poolList.get(i));
			
		}
		
		
		
		
		return null;
	}
	
	
	
	
	
	private Map<Competitor,Integer> playPool(Competitor[] competitors) {
		Match randomM = new RandomMatch();
		League selectLeague = new League(competitors,randomM);
		// on fait jouer la pool et on en affiche le résultat
		selectLeague.play();	
		return selectLeague.ranking();
	}

	public ArrayList<Competitor[]> generatePool(){
		//on verifie que le nombre de compétiteur est divisible par 4
		// mais en principe puissance de 2 == divisible par 4
		assert NumberTester.isDivisibleBy4(this.candidates.length);
		
		// on crée la liste des pools
		ArrayList<Competitor[]>res = new ArrayList<Competitor[]>();
		
		//on crée les groupes de pool
		for(int i=0;i<(this.candidates.length-4);i+=4) {
			Competitor[] pool = new Competitor[4];
			for(int j=0 ; j<=pool.length;j++) {
				pool[j] = this.candidates[i+j];
			}
			// on ajoute les groupe de pool à la liste
			res.add(pool);
		}
		// on  renvois la liste des groupes des joueurs.
		return res;
	}

}
