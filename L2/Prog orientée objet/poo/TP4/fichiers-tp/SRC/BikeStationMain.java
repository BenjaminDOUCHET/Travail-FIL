public class BikeStationMain {
    
    /* emplacement du premier vélo */
    private int empla;

    /* contructeurs */
    public BikeStationMain(int empla){
        
        this.empla = empla;
    }
    public BikeStationMain(){
        
        this.empla = 1;
    }

    /*getters */
    
    public int getEmpla(){
        return this.empla;
    }

    public static void main(String[] args){
        if(args.length>0){
            for(int i=0 ; i<args.length ;i++){
                BikeStationMain station = new BikeStationMain(Integer.parseInt(args[i]));
                BikeStation tim = new BikeStation("Timoleon",10);
                Bike b001 = new Bike("b001", BikeModel.CLASSICAL);
                Bike b002 = new Bike("b002", BikeModel.ELECTRIC) ;
                tim.dropBike(b001);
                tim.dropBike(b002);
                Bike tempBike = tim.takeBike(station.getEmpla());
        
                if(tempBike != null){
                    System.out.println(tempBike.getId()+"; coût loc.: 3€/heure");
                }
                else{
                    System.out.println("il n'y a pas de vélo à cet emplacement");
                }
            }
        }
        else{
            BikeStationMain station = new BikeStationMain(1);
            BikeStation tim = new BikeStation("Timoleon",10);
            Bike b001 = new Bike("b001", BikeModel.CLASSICAL);
            Bike b002 = new Bike("b002", BikeModel.ELECTRIC) ;
            tim.dropBike(b001);
            tim.dropBike(b002);
            Bike tempBike = tim.takeBike(station.getEmpla());
        
            if(tempBike != null){
                System.out.println(tempBike.getId()+"; coût loc.: 3€/heure");
            }
            else{
                System.out.println("il n'y a pas de vélo à cet emplacement");
            }

        }
    
    }










}
