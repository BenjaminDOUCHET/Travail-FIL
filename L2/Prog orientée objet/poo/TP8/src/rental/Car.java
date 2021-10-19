package rental;

public class Car extends Vehicle{

    private int passager;

    /**
	 * creates a vehivle with given informations
	 * 
	 * @param brand
	 *            the vehicle's brand
	 * @param model
	 *            the vehicle's model int Passager
	 * @param productionYear
	 *            the vehicle's production year
	 * @param dailyRentalPrice
	 *            the daily rental price
     * @param passager
     *            the number of place
	 */
    public Car(int passager,String brand, String model, int productionYear, float dailyRentalPrice) {
        super(brand, model, productionYear, dailyRentalPrice);
        this.passager = passager;
    }
    
    /**
     * Describe the vehicle with his informations.
     * @return the informations about the vehicule.
     */
    public String toString() {
        return super.toString() + "pasagers number : " + Integer.toString(this.passager); 
    }



}
