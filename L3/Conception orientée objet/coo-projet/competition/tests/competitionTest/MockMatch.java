package competitionTest;

import competitor.Competitor;
import match.Match;

public class MockMatch implements Match{

	@Override
	public Competitor getWinner(Competitor c1, Competitor c2) {
		return c1;
	}

}
