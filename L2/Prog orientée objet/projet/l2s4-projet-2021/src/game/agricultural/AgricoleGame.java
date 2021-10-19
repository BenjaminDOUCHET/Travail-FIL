package game.agricultural;
import game.Game;
import player.Player;
import tile.*;
import utils.InsufficientStockException;
import utils.UnknowCoordinatesException;
import utils.UnknowPersonageException;

import java.util.*;
import personage.Personage;
import personage.agricultural.Worker;


/**
 * @author DOUCHET Benjamin & ATCHEDJI Churchill
 * class of AgricoleGame , it specifies rules for this type of game
 */
public class AgricoleGame extends Game{
	
	private int workerID = 0; // le nombre d'ouvriers ajoutes
	private List<int[]> otherTile;// la liste des coordonnees des tuiles
	private Map<Player,Integer> scoreMap;//la map des scores où les clés sont les joueurs et les valeurs leurs scores
	/**
	 * initialize the game with the board and two players
	 * @param nbRound the number of rounds in the game
	 * @param length the length of the board
	 * @param width the width of the board
	 * @param players the list of players
	 * @throws CloneNotSupportedException if the tile type can't be cloned 
	 */
	public AgricoleGame(int nbRound , int length , int width, List<Player> players) throws CloneNotSupportedException   {
		super(nbRound , length , width, players);
		for(int i=0 ; i < this.players.size() ; i++) {
			this.players.get(i).addRessource("gold",15);
		}
		this.otherTile = this.getBoard().getOtherTileCoord();// on recupere les coordonnees des autres tuiles non ocean
	}
	
	
	/**
	 * Play the game 
	 */
	public void play() {
		int i = this.nbRound;
		while (this.nbRound > 0) {
			System.out.println(" -- Round "+ (i - this.nbRound + 1) +" --\n");
			for(int index=0 ; index < this.players.size() ; index++) {
				this.playOneTurn(this.players.get(index));
			}
			this.nbRound--;
			System.out.println(" ");
		}
		System.out.println(this.countdown());
	}
	
	/**
	 * Count the total points of the players after the game
	 * @return the total points of the players after the game
	 */
	public String countdown() {
		//Tile[][] gird = this.board.getBoard();
		this.scoreMap = new HashMap<Player,Integer>();
		
		Iterator<Player> itP = this.players.iterator();
		
		while(itP.hasNext()) {
			this.scoreMap.put(itP.next(), 0);// on initialise la map avec 0 comme score de chaque joueur
		}
		
		for(int index = 0; index < this.players.size() ; index++) {
			int tmpScore = 0;
			Player p = this.players.get(index);//on récupère le joueur
			
			Iterator<Personage> it = p.getPersonages().iterator();//pour chaque joueur on met un itérateur sur la liste des ouvrirers
			while (it.hasNext()) {
				tmpScore = it.next().getGoldQuantity() + this.scoreMap.get(p);
				this.scoreMap.put(p,tmpScore);//on ajoute le cumul de la quantité d'or des ouvriers 
			}
			
			tmpScore = p.getChest().getStock().get("gold");
			this.scoreMap.put(p, tmpScore);//on ajoute la quantité d'or du joueur
			
		}
		
		
		// on determine le vainqueur
		int scoreMax = Collections.max(this.scoreMap.values());
		
		//on ajoute les joueurs ayant le scoreMax(pratique quand il y a égalité des scores)
		List<Player> winners =  new ArrayList<>();
		for(int index = 0; index < this.players.size() ; index++) {
			if(this.scoreMap.get(this.players.get(index)) == scoreMax) {
				winners.add(this.players.get(index));
			}
		}
		
		String description ="";
		
		for(int index = 0; index < this.players.size() ; index++) {
			description += this.players.get(index).getName() + " marque " + this.scoreMap.get(this.players.get(index)) + " points \n";
		}
		
		String res = "";
		
		if(winners.size()==1) {
			res = "Le Vainqueur est "+ winners.get(0).getName()  + " Bravo !\n";
		}
		else {
			res = "Egalite entre ";
			for(int index =0; index < winners.size()-1 ; index++) {
				res +=  winners.get(index).getName()+" et ";
			}
			res+= winners.get(winners.size()-1).getName() +" Bravo! \n";
		}
	
		return description+res;
	}//fin countdown
	
	/**
	 * Play one turn of the game for a given player
	 * @param currentP the current player
	 */
	public void playOneTurn(Player currentP) {
		System.out.println("---");
		System.out.println(currentP.getName()+", possede "+currentP.getPersonages().size() + " Ouvrier(s) et dispose en reserve de "+ currentP.getChest().getStock().get("gold")+" pieces d'or." );
		int decision[] = randomDecision() ;
		// le joueur realise une action parmi trois 
		this.executeAction(currentP,decision);

		//le joueur recolte les ressources des territoires occupes par ses ouvriers
		this.harvestResources(currentP);

		 //renumerer les ouvriers en fonction du territoire
		 // si le joueur ne dispose pas d'assez de pieces d'or pour renumerer ses ouvriers ceux ci est retire du jeu et le 
		 //joueur perd le territoire
		 this.payTheWorkers(currentP);
		 
		 System.out.println("---");
	}
	
	
	/**
	 * choose randomly a tile from the board and and action to apply from the player
	 * @return an array of size two, index 0 is the index of the played tile in otherTile , index 1 is an integer between 0 and 2 (inclued) referring to the action to execute .
	 */
	public int[] randomDecision() {
		Random rand = new Random();
		
		int res[] = new int[2];
		
		int tileIndex =  rand.nextInt(this.otherTile.size()); //on determine la tuile sur laquelle on jouera dans le cas où ...
		res[0] = tileIndex;
		
		int action = rand.nextInt(3);//on determine l'action à effectuer cf. execute action pour la correspondance.
		res[1] = action ;
		
		
		return res;
		
	}
	
		
	/**
	 * deploy a worker on a random available territory 
	 * @param currentP the current player
	 * @param tileIndex 
	 */
	public void deployWorker(Player currentP , int tileIndex) {
		this.workerID++; // un ouvrier en plus est cree
		Worker aWorker = new Worker(String.valueOf(this.workerID));//on cree un ouvrier 
		int x,y ;
		
		if (this.otherTile.size() > 0) { //il reste des tuiles a conquerir
			
			
			try {
				aWorker.setOwner(currentP);
				currentP.addPersonage(aWorker);
				
				x = this.otherTile.get(tileIndex)[0];
				y =  this.otherTile.get(tileIndex)[1];
				Tile choosedTile = super.getBoard().getTile(x,y);// on recupere la tuile correspondante
				choosedTile.setPersonage(aWorker);// on place l'ouvrier sur la tuile
				//on enleve la tuile des tuiles dispo
				aWorker.setWorkerOnTile(choosedTile);
				this.otherTile.remove(tileIndex);
				System.out.println("Joueur " + currentP.getName() + " deploie un ouvrier sur une tuile " + choosedTile.getTileType()+ "("+ x+","+y +")");
				}// fin try 
			catch (UnknowCoordinatesException e) {
				e.printStackTrace();
			}// fin catch
		}
		else {
			//en principe si il n'y a plus de tuiles dispo le jeu s'arrete immediatement et on ne fini pas le tour ;
			// pour le moment je fais appel a coutdown() pour marquer la fin du jeu puis a un exit
			System.out.println("Le jeu se termine car aucune tuile n'est plus a conquerir");
			System.out.println("Voici le score des Joueurs en l'etat actuel du jeu : ");
			System.out.println(this.countdown());
			System.exit(0);
		}
		
	}//fin deploWorker

	
	/**
	 * The player does nothing but earns gold coins according to the position of the workers on the board
	 * @param currentP the current player
	 */
	public void doNothing(Player currentP) {
		Worker aWorker;
		if (currentP.getPersonages().size() > 0) {
			Iterator<Personage> it = currentP.getPersonages().iterator();// on construit un iterateur sur la liste des ouvriers possedes par le joueur
			System.out.println("Joueur "+currentP.getName()+" ne fait rien et ");
			while (it.hasNext()) {// on parcours la liste des ouvriers
				Personage perso = it.next();
				aWorker = (Worker) perso;// on recupere l'ouvrier dans la liste en faisant un cast car a la base c'est un Personage dans la liste
				//System.out.println(aWorker);
				Tile occupiedTile = aWorker.getTheWorkerTile();// on recupere le tuile occupee par l'ouvrier
				String tileType = occupiedTile.getTileType();// on recupere ensuite le type de la tuile
				//System.out.println(tileType);
				//En fonction du type de la tuile, de l'or est ajoute au stock du joueur 
				//les tuiles de type Montagne ne donnent rien
				switch (tileType){
					case ("foret   ") :
						currentP.addRessource("gold",1);
						System.out.println(" reçoit une piece d'or sur chaque tuile de type foret occupée ");
						break;
					case ("plaine  ") : 
						currentP.addRessource("gold",1);
						System.out.println(" reçoit une piece d'or sur chaque tuile de type plaine occupée");
						break;
					case ("desert  ") : 
						currentP.addRessource("gold",2);
						System.out.println(" reçoit deux pieces d'or sur chaque tuile de type desert occupée");
						break;
				}//fin switch
			}// fin while
			System.out.println("");
		}//fin if
		else {
			System.out.println("Joueur "+currentP.getName()+" ne fait rien. ");
		}
		
		
	}// fin doNothing
	
	
	/**
	 * exchange the resources of the player for gold
	 * @param currentP the current player
	 * @param resourceName the resource to be exchanged
	 * @param quantity the quantity of the resource to be exchanged 
	 */
	public void exchangedResourceForGold(Player currentP,String resourceName,int quantity) throws InsufficientStockException {
		if (currentP.getChest().getStock().get(resourceName) >= quantity) {//si la ressource est disponible en stock
			switch(resourceName) {
				case ("roche") : 
					currentP.addRessource("gold", quantity*8); //une unite de roche rapporte 8 pieces d'or
					currentP.removeRessource(resourceName, quantity);// on enleve du coffre la quantite de roches echangees
					System.out.println("Joueur "+ currentP.getName() + " echange "+quantity+" quantite de " + resourceName + " contre " +  quantity*8 + " pieces d'or");
					break;
					
				case ("sable") : 
					currentP.addRessource("gold", quantity*5); //une unite de sable rapporte 5 pieces d'or
					currentP.removeRessource(resourceName, quantity);//on enleve du coffre la quantite de sables echanges
					System.out.println("Joueur "+ currentP.getName() + " echange "+quantity+" quantite de " + resourceName + " contre " +  quantity*5 + " pieces d'or");
					break;
					
				case ("bois") : 
					currentP.addRessource("gold", quantity*2); //une unite de bois rapporte 2 pieces d'or
					currentP.removeRessource(resourceName, quantity);//on enleve du coffre la quantite de bois echanges
					System.out.println("Joueur "+ currentP.getName() + " echange "+ quantity +" quantite de " + resourceName + " contre " +  quantity*2 + " pieces d'or");
					break;
					
				case ("ble") : 
					currentP.addRessource("gold", quantity*2); //une unite de ble rapporte 2 pieces d'or
					currentP.removeRessource(resourceName, quantity);//on enleve du coffre la quantite de bles echanges
					System.out.println("Joueur "+ currentP.getName() + " echange "+ quantity +" quantite de " + resourceName + " contre " +  quantity*2 + " pieces d'or");
					break;
					
				/*default:
					System.out.println("This resource doesn't exist in the chest!");*/
			}// fin switch
		}//fin if
	}// fin exchangeResourceForGold
	
	
	/**
	 * execute an action chosen randomly between three actions at each turn 
	 * @param currentP the current player
	 * @param decision a table of size 2, index 0 is the index of the played tile in otherTile , index 1 is an integer between 0 and 2 (inclued) to chose the action to execute .
	 * @param auto 1 or 0 , if 1 , the exchange of resources is in automatic mode (radomaziation) if 0 it will ask a human decision.
	 */
	public void executeAction(Player currentP ,int[] decision, int auto) {
		int action = decision[1];
		int tileIndex = decision[0];
		
		if(action <0 || action >= 3) {
			System.out.println("action inconnue");
			System.out.println("0: Déployer Ouvrier ; 1: Echanger ressources ; 2: Passer tour");
			 //<------- implémenter le renvois vers une fonction input utilisateur
		}
		
		if (action == 0){// on deploie un ouvrier sur une tuile disponible
			this.deployWorker(currentP,tileIndex);
		}
		
		else if (action == 1 && currentP.getChest().getStock().keySet().size() > 1) {// on echange des ressources contre de l'or
			if(auto == 1) {
				randomExchange(currentP);
			}
			else {
				askExchange(currentP);
			}
		}
		
		else {// rien n'est fait par le joueur a ce tour
			this.doNothing(currentP);
		}
			
	}//fin executeAction
	
	/**
	 * overload of excuteAction to put a default comportment.
	 * @param currentP current player 
	 * @param decision an int[2] index 0 is the index of the played tile in otherTile , index 1 is an int between 0 and 2 (inclued) referring to the action to execute .
	 */
	public void executeAction(Player currentP ,int[] decision) {
		executeAction(currentP ,decision , 1);
	}
	
	
	
	
	/**
	 * give the permission to the user to chose a resource to exchange
	 * @param currentP the current player
	 */
	
	public void askExchange(Player currentP) {
		    Scanner scan = new Scanner(System.in);
		    String resource = null;
		    int qty = 0 ;
		    List<String> allType = new ArrayList<String>();
		    allType.add("roche");
		    allType.add("sable");
		    allType.add("bois");
		    allType.add("ble");
		    
		    boolean ok = false;
		    
		    // Enter resource name and press Enter
		    while(!ok) {
			    while(!ok) {
			    	System.out.println("Enter ressource: roche , sable , bois , ble  ou exit"); 
				    resource = scan.nextLine();
				    if(resource =="exit") {
				    	return;//on sort de la méthode.
				    }
					if(allType.contains(resource)) {
				    	ok = true ;
				    }
			    } // fin boucle type ressource
		    	System.out.println("Ressource selectionnée : " + resource);
		    // on vas chercher la quantité disponible :
		    int currentQty = 0 ;
		    if (currentP.getChest().getStock().containsKey(resource)) {
		    	currentQty = currentP.getChest().getStock().get(resource);
		    }
		    else {
		    	System.out.println("Vous ne disosez pas de  " + resource + " pour le moment");
		    	ok=false ;
		    }
		    
		    if(ok) {
			    ok = false;
			    while(!ok) {
				    System.out.println(" Vous disposez de "+Integer.toString(currentQty)+ " unite de "+resource);
				    System.out.println("Combien voulez-vous en échanger ?");
				    qty = scan.nextInt();
				    if(qty>=0 && qty<= currentP.getChest().getStock().get(resource)) {
				    	ok = true;
				    	scan.close();
					    }
				    else {
				    	System.out.println("Stock insuffisant");
				    }
				    
			    } // fin boucle qty 
		    }
		
		}//fin boucle principale
		
		try {
			this.exchangedResourceForGold(currentP, resource, qty );
		}catch (InsufficientStockException e) {
			// normalement no a tout vérifié donc on ne devrais pas lever cette exception
			e.printStackTrace();
		}
		
	}

	/**
	 * chose randomly resources to exchange
	 * @param currentP the player currently playing
	 */
	private void randomExchange(Player currentP) {
		Random rand = new Random();
		List<String> resourcesAvalaible = new ArrayList<String> ();// on dispose de 4 ressources au total(bois,sable,roche,ble)
		// a chaque echange on verifie les ressources disponibles en stock (quantite > 0)
		// et on les enregistre dans un tableau 
		// cela permet de connaitre les ressources qu'on peut toujours echanger
		for (String resource : currentP.getChest().getStock().keySet()) {
			if (!resource.equals("gold")) {// l'or n'est pas a ajouter car elle ne constitue pas une ressource produite par une tuile
				if (currentP.getChest().getStock().get(resource) > 0) {
					resourcesAvalaible.add( resource);
				}
			}
		}
		if (resourcesAvalaible.size() > 0 ) {// si des ressources en quantite non nulles ont ete ajoutees au tableau on procede a l'echange
			int alResource = rand.nextInt(resourcesAvalaible.size());//la ressource a echanger est choisie aleatoirement parmi les ressources disponible
			int totalResourceQuantity = currentP.getChest().getStock().get(resourcesAvalaible.get(alResource));// on recupere la quantite de cette ressource en stock
			int quantity = 1+rand.nextInt(totalResourceQuantity);//on choisi aleatoirement la quantite a echanger(compris entre 1 et la quantite totale de la ressource en stock)
			
			try {
				this.exchangedResourceForGold(currentP, resourcesAvalaible.get(alResource), quantity );// on procede a l'echange contre de l'or
			}
			catch(InsufficientStockException e){
				System.out.println("");//si la quantite de ressource est nulle, on traite l'exception qui sera levee
				//en effet on ne viendra jamais dans ce cas car le tableau resourcesAvalaible ne contient que des resources en quantite non nulles
			}
		}
		else {
			System.out.println(currentP.getName()+" ne dispose pas d'assez de ressources pour proceder a un echange");
		}
		
	}


	//NB : La methode produce n'a pas ete utilisee ici car elle produisait les ressources pour tous les joueurs a chaque tour m�me si ce n'est 
	//pas leur tour.
	
	/**
	 * The player harvest the resources on the territory occupied by his workers
	 * @param currentP the current Player
	 */
	public void harvestResources(Player currentP) {
		Worker aWorker;
		Iterator<Personage> it = currentP.getPersonages().iterator();// on construit un iterateur sur la liste des ouvriers possedes par le joueur
		while (it.hasNext()) {// on parcours la liste des ouvriers
			Personage perso = it.next();
			aWorker = (Worker) perso;// on recupere l'ouvrier dans la liste en faisant un cast car a la base c'est un Personage dans la liste
			Tile occupiedTile = aWorker.getTheWorkerTile();// on recupere le tuile occupee par l'ouvrier
			currentP.addRessource(occupiedTile.getRessourceType(), 1);// on ajoute une unite de ressource au stock
		}// fin while
		System.out.println("Joueur "+currentP.getName() + " recolte des ressources. ");
	}//fin harvestResources
	
	
	/**
	 * Pay the workers based on their territory
	 * @param currentP the current player
	 */
	public void payTheWorkers(Player currentP) {
		
		if(currentP.getPersonages().size() > 0) {
			ArrayList<Personage> listPerso = new ArrayList<Personage> ( currentP.getPersonages());
			
			Worker aWorker;
			
			Iterator<Personage> it = listPerso.iterator();// on construit un iterateur sur la liste des ouvriers possedes par le joueur
	
			System.out.println("Joueur "+ currentP.getName() + " renumere les ouvriers en fonction du territoire occupe " );
			
			while(it.hasNext()) {
				Personage perso = it.next();
				aWorker =  (Worker) perso;// on recupere l'ouvrier dans la liste en faisant un cast car a la base c'est un Personage dans la liste
				Tile occupiedTile = aWorker.getTheWorkerTile();// on recupere le tuile occupee par l'ouvrier
				String tileType = occupiedTile.getTileType();// on recupere ensuite le type de la tuile
				
				//En fonction du type de la tuile qu'il occupe, l'ouvrier est ensuite paye
				//les tuiles de type Montagne ne donnent rien
				
				switch (tileType){
				
					case ("foret   ") : 
						try {
							currentP.removeRessource("gold",1);// on retire d'abord l'or necessaire pour le payement au joueur (cela l�vera l'exception InsufficientStockException  si l'or n'est pas suffisant) 
							aWorker.getPaid(1);// on paye ensuite l'ouvrier avec la quantite d'or retiree
						}//fin try 1
						
						catch(InsufficientStockException e1) {
							System.out.println("Joueur " + currentP.getName() + " ne dispose pas d'assez de pieces d'or pour payer un ouvrier. (sur une tuile foret)");
							System.out.println("Il perd donc cet ouvrier qui est retire du jeu.");
							//aWorker.setOwner(new Player(" "));//on change le proprio de l'ouvrier
							try {
								currentP.removePersonage(aWorker);
							} catch (UnknowPersonageException e) {
								e.printStackTrace();
							}
							occupiedTile.deleteOccupant();
						}// fin catch 1
						break;
						
					case ("plaine  ") : 
						
						try {
							currentP.removeRessource("gold",1);
							aWorker.getPaid(1);
						}//fin try 1
						
						catch(InsufficientStockException e1) {
							
							System.out.println("Joueur " + currentP.getName() + " ne dispose pas d'assez de pieces d'or pour payer un ouvrier (sur une tuile plaine).");
							System.out.println("Il perd donc cet ouvrier qui est retiré du jeu.");
							//aWorker.setOwner(new Player(" "));
							try {
								currentP.removePersonage(aWorker);
							} catch (UnknowPersonageException e) {
								e.printStackTrace();
							}
							occupiedTile.deleteOccupant();
						}// fin catch 1
						
						break;
						
					case ("desert  ") : 
						try {
							currentP.removeRessource("gold",3);
							aWorker.getPaid(3);
						}//fin try 1
						catch(InsufficientStockException e1) {
							
							System.out.println("Joueur " + currentP.getName() + " ne dispose pas d'assez de pieces d'or pour payer un ouvrier sur une tuile desert.");
							System.out.println("Il perd donc cet ouvrier qui est retiré du jeu.");
							
							try {
								currentP.removePersonage(aWorker);
							} catch (UnknowPersonageException e) {
								e.printStackTrace();
							}
							occupiedTile.deleteOccupant();
							
						}// fin catch 1
						break;
						
					case ("montagne") : 
						try {
							currentP.removeRessource("gold",5);
							aWorker.getPaid(5);
						}//fin try 1
						
						catch(InsufficientStockException e1) {
							
							System.out.println("Joueur : " + currentP.getName() + " ne dispose pas d'assez de pieces d'or pour payer un ouvrier (sur une tuile montagne).");
							System.out.println("Il perd donc cet ouvrier qui est retiré du jeu.");
							//aWorker.setOwner(new Player(" "));
							try {
								currentP.removePersonage(aWorker);
							} catch (UnknowPersonageException e) {
								e.printStackTrace();
							}
							occupiedTile.deleteOccupant();
						}// fin catch 1
						break;
						
				}//fin switch
		}//fin for
		}// fin if
		else {
			System.out.println("Joueur "+ currentP.getName() + " ne dispose pas d'ouvriers et donc n'effectue pas de  renumeration !" );
		}
		
	}// fin payTheWorkers
	
}//fin AgricoleGame



