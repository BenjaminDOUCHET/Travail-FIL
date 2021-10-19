package rental;

public class Motorbike extends Vehicle{

    private int cylindre;
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
     * @param cylindre
     *            the volume of the cylinder(in cm^3)
	 */
    public Motorbike(int cylindre, String brand, String model, int productionYear, float dailyRentalPrice) {
        super(brand, model, productionYear, dailyRentalPrice);
        this.cylindre = cylindre;
    }

    /**
     * Describe the vehicle with his informations.
     * @return the informations about the vehicule.
     */
    public String toString() {
        return super.toString() + "cylinder(cm^3) :" + Integer.toString(this.cylindre); 
    }

}
