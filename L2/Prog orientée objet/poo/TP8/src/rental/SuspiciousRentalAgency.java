package rental;
import java.util.*;
public class SuspiciousRentalAgency extends RentalAgency{
     // vehicles of this agency
    private List<Vehicle> theVehicles;

     // maps client to rented vehicle (at most one vehicle by client) 
    private Map<Client,Vehicle> rentedVehicles;

    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
    	if(client.getAge()<=25){
            float fakeprice = super.rentVehicle(client, v);
            return fakeprice + (fakeprice*10)/100;
        }
        else{
            return super.rentVehicle(client, v);
        }
    }
}
