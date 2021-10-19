package game;

import java.util.*;

import game.war.WarGame;
import player.Player;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


public class WarTest {
	private WarGame game1; 
	private List<Player> players;

	@Before
	public void before() throws CloneNotSupportedException {
		this.players = new ArrayList<Player>();
		Player moon  =  new Player("Moon");
		Player chill = new Player ("Chill");
		Player ben = new Player("Ben");
		Player max = new Player("Max");
		
		this.players.add(moon);
		this.players.add(ben);
		this.players.add(chill);
		this.players.add(max);
		this.game1 = new WarGame(10 , 20 , 30, players);

	}
	@Test 
	public void testRightAmountOfRessourcesAtTheBegining() {
		for (int i = 0; i < players.size(); i++) {
			assertEquals(Integer.valueOf(35),this.players.get(i).getChest().getStock().get("warrior"));
			assertEquals(Integer.valueOf(10),this.players.get(i).getChest().getStock().get("food"));
			assertEquals(Integer.valueOf(0),this.players.get(i).getChest().getStock().get("gold"));

		}
	}
	
	@Test 
	public void testTheAmountOfWarriorsToDeploy() {	
		int stockBeforeDeploying = this.players.get(0).getChest().getStock().get("warrior");
		System.out.println(stockBeforeDeploying);
		this.game1.deployArmy(this.players.get(0), 1,0 );
		System.out.print(this.players.get(0).getChest().getStock().get("warrior"));
		assertTrue(1 == (stockBeforeDeploying -  this.players.get(0).getChest().getStock().get("warrior")));
				
	}
	/*
	@Test
	public void testTheArmyNeighbourOfTheArmyDeployedIsAnEnemy() {
		//this.game1.deployArmy(this.players.get(0), 2, 1);
		this.game1.deployArmy(this.players.get(1), 3, 0);
		this.game1.deployArmy(this.players.get(2), 4, 2);
		int stockPlayer_0 = this.game1.getBoard().getTile(0,0).getOccupant().getSize();
		this.game1.deployArmy(this.players.get(0), 2, 1);
		int stockPlayer_0_afterDeploying = this.game1.getBoard().getTile(0,0).getOccupant().getSize();
		assertEquals(stockPlayer_0, stockPlayer_0_afterDeploying * 2);
	}*/
}
