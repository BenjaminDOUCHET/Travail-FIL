package utils;

/**
 * @author atche This class is an exception that is thrown when the coordinates
 *         of a tile are not correct.
 */
public class UnknowCoordinatesException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknowCoordinatesException(String message) {
		super(message);
	}

	public UnknowCoordinatesException() {
		super();
	}
}
