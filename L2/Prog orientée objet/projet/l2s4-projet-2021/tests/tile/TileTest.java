package tile;

import static org.junit.Assert.*;
import org.junit.Test;

public class TileTest {

@Test 
public void testCloneMethod() { 

		Tile tuile1 = new TileDesert();
		Tile tuile2 = (Tile) tuile1.clone(); 
		assertTrue(tuile1.equals(tuile2));   
 }
}
 