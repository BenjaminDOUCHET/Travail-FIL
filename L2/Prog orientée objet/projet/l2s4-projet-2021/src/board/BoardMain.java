package board;

import utils.UnknowCoordinatesException;
import utils.UnknowPersonageException;

public class BoardMain {

	public static void main(String[] args) throws UnknowPersonageException {

		try {
			Board testBoard = new Board(5, 5);
			String toutelesautres = "";
			for (int k = 0; k < testBoard.getOtherTileCoord().size(); k++) {
				toutelesautres += "[" + Integer.toString(testBoard.getOtherTileCoord().get(k)[0]) + ","
						+ Integer.toString(testBoard.getOtherTileCoord().get(k)[1]) + "]";
			}
			System.out.println(toutelesautres);
			for (int i = 0; i < testBoard.getBoardLength(); i++) {
				String line = "";
				for (int j = 0; j < testBoard.getBoardWidth(); j++) {
					line = line + " | " + testBoard.getTile(i, j).getTileType();
				}
				System.out.println(line + "|");
			}

		} catch (UnknowCoordinatesException e) {
			System.out.println(e.getMessage());
		}
	}
}
