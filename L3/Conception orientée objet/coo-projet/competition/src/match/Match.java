package match;
import competitor.*;

/**
 * 
 * @author douchet
 * interface for all sort of match linked to a competition
 */
public interface Match {

	public Competitor getWinner(Competitor c1 , Competitor c2);
}