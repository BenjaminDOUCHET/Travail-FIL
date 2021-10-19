public class BikeStation {

    /** array of slots for bikes in the station */
    private Bike[] bikes;
    /** name of the station */
    private String name;

    /**
     * Constructeur de la classe BikeStation
	 * @param String nom de la station 
	 * @param int capacité d'accueil de la sation
     */
	public BikeStation(String name, int capacity) {
		this.bikes = new Bike[capacity] ;
		this.name = name;
	}

	public BikeStation( int capacity) {
		this.bikes = new Bike[capacity] ;
		this.name = "nom_defaut";
	}

	public BikeStation( String name) {
		this.bikes = new Bike[1] ;
		this.name = name;
	}

	public BikeStation() {
		this.bikes = new Bike[1] ;
		this.name = "nom_defaut";
	}




    /**
     * renvoie le nom de la station
	 * @return String le nom de la station
     */
	public String getName() {
	    return this.name;
	}

    /**
     * renvoie la capacité d'acceuil de la station
	 * @return la longueur du tableau des slots  de vélo
     */
	public int getCapacity() {
	    return this.bikes.length;
	}

    /**
     * renvoie le nombre de velo stockés dans la station
	 * @return int le nombre de vélo en stock dans la station
     */
	public int getNumberOfBikes() {
		int comp = 0;
		for(int i=0;i<this.getCapacity();i++){
			if(this.bikes[i]!=null){
				comp++;
			}
		}
		return comp;
	}

    
    /**
     * renvoie le premier slot disponible
	 * @return int l'indice du premier slot disponible , -1 si le stock est complet
     */
	public int firstFreeSlot() {
		
		for(int i=0;i<this.getCapacity();i++){
			if(this.bikes[i]==null){
				return  i ;
			}
		}
	    return -1;
	}
	
    /**
     * entre les données du vélo en param au premier slot disponible
	 * @param Bike le vélo à stocker
	 * @return boolean true si le vélo a été stocké , false sinon
     */
	public boolean dropBike(Bike bike) {
		int recherche = this.firstFreeSlot();
		if(recherche != -1){
			this.bikes[recherche] = bike;
			return true;
		}
		else{
			return false;
		}
	  
	}
	
	
	
    /**
     * retire le velo à l'emplacement d'indice en param 
	 * @param int l'indice du slot dans lequel retirer le vélo
	 * @return Bike le vélo qui était dans l'emplacement , null si il n'y avais rien
     */
	public Bike takeBike(int i) {
		Bike res;
		if(i>-1 && i<this.bikes.length){
			if(this.bikes[i] != null){
				res = this.bikes[i];
				this.bikes[i]=null;
				return res;
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
		
	    
	}
	
}
