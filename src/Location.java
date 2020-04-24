/**
 * This class represents position (x,y) of a pixel
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */
public class Location {
	
	/**
	 *Declaration of instance variables
	 */
	private int x;
	private int y;
	
	/**
	 * A constructor that initializes this Location object with the specified coordinates
	 * @param x
	 * 		the x coordinate of the figure
	 * @param y
	 * 		the y coordinate of the figure
	 */
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the x coordinate of this location
	 * @return
	 * 		returns x coordinate
	 */
	public int xCoord() {
		return this.x; 
	}
	
	/**
	 * Returns the y coordinate of this location
	 * @return
	 * 		returns y coordinate
	 */
	public int yCoord() {
		return this.y;
	}
	
	/**
	 * Compares this Location with p using column order
	 * @param p
	 * 		other pixel we want to compare location to
	 * @return
	 * 		-1 if position is less than other pixel
	 * 		 0 if position is equal to the other pixel
	 * 		 1 if position is greater than other pixel
	 */
	public int compareTo(Location p) {
		//If this position is less than p
		if ((this.x < p.xCoord()) || (this.x == p.xCoord() && this.y < p.yCoord())) {
			return -1;
		}
		//If this position is equal to p
		else if (this.x==p.xCoord() && this.y==p.yCoord()) {
			return 0;
		}
		//If this position is greater than p
		else {
			return 1;
		}
	}

}

	

