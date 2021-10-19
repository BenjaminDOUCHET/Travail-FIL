


public Class RentalAgency{

    private Car[] allCars = new Car

    public List<Car> selectByBrand(String requireBrand){
    ArrayList<Car> res = new ArrayList<Car>();

    for(int i = 0 ; i< this.getAllCars().length ; i++){
        if (this.getAllCars[i].getBrand()== requireBrand){
            res.add(this.getallCars[i]);
        }
    }
    return res;
    }


    


}


public class MaxPriceFilter implements CarFilter{
    private int requirePrice;

    public MaxPriceFilter(int price){
        this.requirePrice = price ;
    }

    public boolean accept(Car c){
        return c.getPrice() < this.requirePrice;
    }
}

public class BrandFilter implements CarFilter{
    private String requireBrand;

    public BrandFilter(String brand){
        this.requireBrand  = brand;
    }

    public boolean accept(Car c){
        return c.getBrand().equals(this.requireBrand);
    }
}

/*Q8*/
public List<Car> select(CarFilter filter){
    ArrayList<Car> res = new ArrayList<Car>();
    
    for( int i = 0 ; this.getAllCars().size() ; i++){
        if(filter.accept(this.getAllCars().get(i))){
            res.add(this.getAllCars().get(i));
        }
    } 
    return res;
}

/*Q9*/

MaxPriceFilter price = new MaxPriceFilter(100);
agency.select(price);

/*Q10*/

public class AndFilter implements CarFilter{
    private CarFilter filtre1;
    private CarFilter filtre2;

    public AndFilter(CarFilter  filtre1 ,CarFilter  filtre2){
        this.filtre1=filtre1;
        this.filtre2 = filtre2;

        
    }

    public boolean accept(Car c){
        return this.filtre1.accept() && this.filtre2.accept();
    }



}

