package personage.agricultural;

import static org.junit.Assert.*;
 
import org.junit.Test;
 
 public class WorkerTest {
 
 @Test(expected = IllegalArgumentException.class) 
 public void testGetPaid() {
	 Worker worker = new Worker("ID"); assertEquals(0, worker.getGoldQuantity());
	 worker.getPaid(5); assertEquals(5, worker.getGoldQuantity());
	 worker.getPaid(-5); }
 
  }
 