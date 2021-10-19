package rental;
/**
 * class to debug the RentalAgency class
 * 
 */

public class MainAgency {
    
    public static void main(String[] args) throws UnknownVehicleException {
        Vehicle v1 = new Vehicle("brand1", "model5", 1999, 20);
        Vehicle v2 = new Vehicle("brand4", "model2", 2001, 30);
        Vehicle v3 = new Vehicle("brand4", "model1", 2018, 150);
        Vehicle v4 = new Vehicle("brand1", "model3", 2015, 100);
        Vehicle v5 = new Vehicle("brand3", "model1", 2015, 100);
        Vehicle v6 = new Vehicle("brand3", "model2", 1999, 20);
        Vehicle v7 = new Vehicle("brand1", "model1", 2015, 70);
        Vehicle v8 = new Vehicle("brand1", "model2", 2015, 100);
        Vehicle v9 = new Vehicle("brand2", "model1", 2015, 140);
        Vehicle v10 = new Vehicle("brand2", "model8", 2015, 30);
        Client c1 = new Client("raymond", 18);
        Client c2 = new Client("Guy", 35);
        Client c3 = new Client("J-C", 50);
        Client c4 = new Client("Clem", 33);
        Client c5 = new Client("yassinth", 22);
        RentalAgency agency = new RentalAgency();
        agency.addVehicle(v1);
        agency.addVehicle(v2);
        agency.addVehicle(v3);
        agency.addVehicle(v4);
        agency.addVehicle(v5);
        agency.addVehicle(v6);
        agency.addVehicle(v7);
        agency.addVehicle(v8);
        agency.addVehicle(v9);
        agency.addVehicle(v10);
        AndFilter andFilter = new AndFilter();
        MaxPriceFilter maxFilter = new MaxPriceFilter(130);
        BrandFilter brandFilter = new BrandFilter("brand3");
        agency.displaySelection(andFilter);
        andFilter.addFilter(maxFilter);
        andFilter.addFilter(brandFilter);
        if(andFilter.accept(v5)){
            System.out.println("for a search of vehicle brand3 max price 130 v5 is accepted");
        }
        if(brandFilter.accept(v6)){
            System.out.println("Vehicle(\"brand3\", \"model2\", 1999, 20) is accepted");
        }
        agency.removeVehicle(v10);
        agency.rentVehicle(c1,v6);
        agency.rentVehicle(c2,v2);
        agency.rentVehicle(c3,v3);
        agency.rentVehicle(c4, v4);
        agency.rentVehicle(c5, v5);
        System.out.println(agency.isRented(v5));
        agency.returnVehicle(c5);
        agency.rentVehicle(c5, v7);
        System.out.println(agency.allRentedVehicles());
        Vehicle car1 = new Car(4, "Volvo", "model1", 2018, 150);
        Vehicle mot1 = new Motorbike(150,"brand4", "model1", 2018, 150);
        
        agency.addVehicle(car1);
        
        agency.addVehicle(mot1);
        agency.returnVehicle(c2);
        agency.returnVehicle(c1);
        System.out.println(agency.allRentedVehicles());
        System.out.println(agency.isRented(car1));
        System.out.println(agency.hasRentedAVehicle(c2));
        agency.rentVehicle(c2, car1);
        RentalAgency fraude = new SuspiciousRentalAgency();
        fraude.addVehicle(mot1);
        System.out.println(fraude.allRentedVehicles());
        System.out.println(fraude.getAllVehicles());
        System.out.println("prix pour la moto pour cleint 18 ans dans agence arnaque " + Float.toString(fraude.rentVehicle(c1, mot1)));
        fraude.returnVehicle(c1);
        System.out.println("prix pour la moto pour cleint 50 ans dans agence aranque " + Float.toString(fraude.rentVehicle(c3, mot1)));
        




    }


}
