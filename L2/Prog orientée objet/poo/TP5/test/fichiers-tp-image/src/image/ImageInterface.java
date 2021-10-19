package image;


/**
 * Basic interface for images based on a rectangular area of pixels
 */
public interface ImageInterface {

	/** returns width of the image
	 * @return width of the image
	 */
	public int getWidth();

	/** returns height of the image
	 * @return height of the image
	 */
	public int getHeight();

	/** get the pixel at coord (x,y) of this image. (0,0) is top left corner pixel.
	 * @param x the horizontal coordinate
	 * @param y the vertical coordinate
	 * @return pixel at coord (x,y) of this image. (0,0) is top left corner pixel.
	 * @exception UnknownPixelException if coord (x,y) is not valid for this image
	 */
	public Pixel getPixel(int x, int y) throws UnknownPixelException;

}
