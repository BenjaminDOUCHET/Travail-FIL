/* patern copié de https://www.codegrepper.com/code-examples/java/how+to+generate+random+name+in+java */

package ex3;
import java.util.*;
/**
 * class copied from basic patern to generate randoms names.
 */
public class RandomNameGenerator {
    private static final int LEN = 6;

    public static String generate(){
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(LEN);
		for (int i = 0; i < LEN; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    
    }