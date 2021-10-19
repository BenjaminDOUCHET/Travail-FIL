package rental;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuspiciousRentalAgencyTest {
    
    @Test
    public void YoungPeopleHaveHigherPriceThanOldPeople()  {
        Client maxime = new Client("Maxime",25);
        Client benjamin = new Client("Benjamin",50);
        Vehicle vroum = new Vehicle("Volkswagen","Polo",2010,74);
        RentalAgency susp = new SuspiciousRentalAgency();
        susp.addVehicle(vroum);
       
        try{
        assertFalse(susp.isRented(vroum));
        assertFalse(susp.hasRentedAVehicle(maxime));
        assertFalse(susp.hasRentedAVehicle(benjamin));
        float temp = susp.rentVehicle(maxime,vroum);
        susp.returnVehicle(maxime);
        float mem = susp.rentVehicle(benjamin,vroum);
        assertTrue(temp > mem);
        }
        catch(UnknownVehicleException e){
            
        }
    }

    // ---Pour permettre l'exécution des test----------------------
public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(SuspiciousRentalAgencyTest.class);
}
}
