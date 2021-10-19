package util;

public class NumberTester {
	
	/**
	 * verify if param is a power of 2
	 * @param nb
	 * @return
	 */
	public static Boolean isPowerOf2(int nb) {
		return ((int)(Math.ceil((Math.log(nb) / Math.log(2)))) == (int)(Math.floor(((Math.log(nb) / Math.log(2))))));
		
	}
	
	
	public static Boolean isDivisibleBy4(int nb) {
		return nb%4 == 0;
	}
	
}
