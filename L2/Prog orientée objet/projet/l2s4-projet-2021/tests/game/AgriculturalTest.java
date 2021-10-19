package game;

import java.util.*;

import game.agricultural.AgricoleGame;
import player.Player;
import utils.InsufficientStockException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class AgriculturalTest {
	private AgricoleGame game1;
	private List<Player> players;

	@Before
	public void before() throws CloneNotSupportedException {
		this.players = new ArrayList<Player>();
		Player moon = new Player("Moon");
		Player chill = new Player("Chill");
		Player ben = new Player("Ben");
		Player max = new Player("Max");

		this.players.add(moon);
		this.players.add(ben);
		this.players.add(chill);
		this.players.add(max);
		this.game1 = new AgricoleGame(10, 20, 30, players);
	}

	@Test
	public void testRightAmountOfRessourcesAtTheBegining() {
		for (int i = 0; i < players.size(); i++) {
			assertEquals(Integer.valueOf(15), this.players.get(i).getChest().getStock().get("gold"));

		}
	}

	@Test
	public void testIfRocheExchangedOneRessourceFor8Gold()
			throws CloneNotSupportedException, InsufficientStockException {
		Player max = new Player("Max");
		this.players.add(max);
		this.game1 = new AgricoleGame(10, 20, 30, players);
		max.addRessource("roche", 1);
		game1.exchangedResourceForGold(max, "roche", 1);
		assertTrue(23 == max.getChest().getStock().get("gold"));
	}

	@Test
	public void testIfSableExchangedOneRessourceFor5Gold()
			throws CloneNotSupportedException, InsufficientStockException {
		Player max = new Player("Max");
		this.players.add(max);
		this.game1 = new AgricoleGame(10, 20, 30, players);
		max.addRessource("sable", 1);
		game1.exchangedResourceForGold(max, "sable", 1);
		assertTrue(20 == max.getChest().getStock().get("gold"));
	}

	@Test
	public void testIfBoisExchangedOneRessourceFor2Gold()
			throws CloneNotSupportedException, InsufficientStockException {
		Player max = new Player("Max");
		this.players.add(max);
		this.game1 = new AgricoleGame(10, 20, 30, players);
		max.addRessource("bois", 1);
		game1.exchangedResourceForGold(max, "bois", 1);
		assertTrue(17 == max.getChest().getStock().get("gold"));
	}

	@Test
	public void testIfBleExchangedOneRessourceFor2Gold() throws CloneNotSupportedException, InsufficientStockException {
		Player max = new Player("Max");
		this.players.add(max);
		this.game1 = new AgricoleGame(10, 20, 30, players);
		max.addRessource("ble", 1);
		game1.exchangedResourceForGold(max, "ble", 1);
		assertTrue(17 == max.getChest().getStock().get("gold"));
	}
}
