import pfc.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class DicResTest {
/*on a essentielmen des getters et setters pour cette classe , on se contente 
donc de vérifier la méthode equals*/
@Test
public void dicResAreEquals(){
    DicRes dic1 = new DicRes(Shape.CISEAUX , Shape.FEUILLE,1,2);
    DicRes dic2 = new DicRes(Shape.CISEAUX , Shape.FEUILLE,1,2);
    assertTrue(dic1.equals(dic2));
}
// ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(DicResTest.class);
}

}
