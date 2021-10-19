package competitionTest;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Map;


import org.junit.jupiter.api.Test;

import competition.Competition;
import competitor.Competitor;
import exception.NotaPowerOfTwoException;

import java.util.Map.Entry;


abstract class CompetitionTest {

	@Test
	public void winnerWellIncrementedTest() throws NotaPowerOfTwoException {
		
		Competition testCompet = createCompet();
		Competitor c1 = testCompet.getCompetitors()[0];
		Competitor c2 = testCompet.getCompetitors()[1];
		int scoreJ1 = c1.getPoints();
		
		
		testCompet.playMatch(c1 ,c2,1);
		
		assertTrue(c1.getPoints() == scoreJ1+1);
		
	}

	@Test
	public void rankingRankWell() throws NotaPowerOfTwoException {
		Competition testCompet = createCompet();
		Competitor c1 = testCompet.getCompetitors()[0];
		Competitor c2 = testCompet.getCompetitors()[1];
		
		//je fais en sorte que C2 ai le plus de points
		c1.setPoints(1);
		c2.setPoints(3*c1.getPoints());
		
		//je crée mes rangs triés
		Map<Competitor, Integer> ranks = testCompet.ranking();
		
		//je récupère la première entrée qui corresponds à celui qui a le plus de points
		Entry<Competitor, Integer> firstComp = ranks.entrySet().iterator().next();
		
		//je vérifie qu'il s'agit bien de c2
		assertTrue(firstComp.getKey().equals(c2));
	}
	
	
	
	
	
	/**
	 * create a test Competition with 4 competitors inside
	 * @return
	 * @throws NotaPowerOfTwoException 
	 */
	public abstract Competition createCompet() throws NotaPowerOfTwoException;

}
