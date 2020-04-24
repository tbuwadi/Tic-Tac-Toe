/**
 * This class represents the data items to be stored in the binary search tree
 * Each data item consists of 2 parts: a Location and an int colour
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */
public class Pixel {
	
	/**
	 * Declaration of instance variables
	 */
	private Location p;
	private int color;
	
	/**
	 * A constructor which initializes the new Pixel with the specified coordinates and colour
	 * @param p
	 * 		the key for the pixel
	 * @param color
	 * 		the color for the pixel
	 */
	public Pixel(Location key, int color) {
		this.p = key;
		this.color = color;
	}
	
	/**
	 * Returns the Location of the pixel
	 * @return
	 * 		the location of the pixel
	 */
	public Location getLocation() {
		return this.p;
	}
	
	/**
	 * Returns the color of the pixel
	 * @return
	 * 		the color of the pixel 
	 */
	public int getColor() {
		return this.color;
	}
}
