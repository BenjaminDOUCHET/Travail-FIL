package utilTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import competition.Tournament;
import exception.NotaPowerOfTwoException;
import util.NumberTester;

class NumberTesterTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void isPowerOf2sayTrueWhenGood() throws NotaPowerOfTwoException {
		assertTrue(NumberTester.isPowerOf2(16));
	}
	
	@Test
	public void isPowerOf2sayFalseWhenNotGood() throws NotaPowerOfTwoException {
		assertFalse(NumberTester.isPowerOf2(15));
	}
	
}
