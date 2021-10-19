package rental;
import static org.junit.Assert.*;

import org.junit.Test;

public class AndFilterTest {
    
@Test
public void testAccept(){
    BrandFilter criterion = new BrandFilter("brand1");
    MaxPriceFilter criterion2 = new MaxPriceFilter(150);
    AndFilter test = new AndFilter();
    test.addFilter(criterion);
    test.addFilter(criterion2);
    Vehicle v1 = new Vehicle("brand1", "model1", 2015, 100);
    Vehicle v2 = new Vehicle("brand2", "model2", 2000, 200);
    assertTrue(test.accept(v1));
    assertFalse(test.accept(v2));
}
 // ---Pour permettre l'execution des tests ----------------------
 public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(rental.MaxPriceFilterTest.class);
 }
}
