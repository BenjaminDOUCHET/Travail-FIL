package competitionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import competition.Competition;
import competition.Tournament;
import competitor.Competitor;
import exception.NotaPowerOfTwoException;
import match.Match;

class TounamentTest extends CompetitionTest{

	@Test
	public void playOneRoundSplitNumberOfPlayerBy2() {
		try {
			Tournament tTest = createCompet();
			tTest.generateMatchs();
			
			int nbComp =tTest.getCurrentCompetitor().size();
			tTest.clearCurrent();
			tTest.playOneRound();
			
			int newNbComp = tTest.getCurrentCompetitor().size();
			assertTrue(newNbComp*2 == nbComp );
			
		} catch (NotaPowerOfTwoException e) {
			System.out.println("génération du tournois a échoué voir test sur la création");
		}
	}


	
	
	
	@Test
	public void raiseExceptionWhenCompArentPowerOf2(){
		Competitor[] competitors = new Competitor[3];
		Competitor c1 = new Competitor("j1");
		Competitor c2 = new Competitor("j2");
		Competitor c3 = new Competitor("j3");
		competitors[0] = c1;
		competitors[1] = c2;
		competitors[2] = c3;
		Match matchTest = new MockMatch();
		
		
		Assertions.assertThrows(NotaPowerOfTwoException.class , ()->{
			Tournament tournamentTest = new Tournament(competitors, matchTest);
		});
	}
	
	
	
	
	
	
	
	
	@Override
	public Tournament createCompet() throws NotaPowerOfTwoException {
		Competitor[] competitors = new Competitor[4];
		Competitor c1 = new Competitor("j1");
		Competitor c2 = new Competitor("j2");
		Competitor c3 = new Competitor("j3");
		Competitor c4 = new Competitor("j4");
		competitors[0] = c1;
		competitors[1] = c2;
		competitors[2] = c3;
		competitors[3] = c4;
		
		Match matchTest = new MockMatch();
		
		Tournament tournamentTest = new Tournament(competitors, matchTest);
			
		return tournamentTest;
	}

}
