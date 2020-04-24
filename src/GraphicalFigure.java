/**
 * This class contains getters and setters for the graphical components of the figures
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */

public class GraphicalFigure implements GraphicalFigureADT {

	/**
	 * Declaration of class instance variables
	 */
	private int id;
	private int width;
	private int height;
	private String type;
	private Location pos;
	private BinarySearchTree tree;
	
	/**
	 * Class constructor that creates an empty BinarySearchTree where the pixels of the figure will be stored
	 */
	public GraphicalFigure(int id, int width, int height, String type, Location pos) {
		tree = new BinarySearchTree();
		this.id = id;
		this.width = width;
		this.height = height;
		this.type = type;
		this.pos = pos;
	}
	
	/**
	 * Returns the width of this figure
	 * @return
	 * 		width of the figure
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns the height of this figure
	 * @return
	 * 		height of the figure
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Returns the type of this figure
	 * @return
	 * 		type of the figure
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Returns the ID of this figure
	 * @return
	 * 		ID of the figure
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Returns the offset or position of this figure
	 * @return
	 * 		offset or position of this figure
	 */
	public Location getOffset() {
		return this.pos;
	}

	/**
	 * Changes the offset of this figure to the specified value.
	 * @param value
	 * 		the new value we want to change the offset to
	 */
	public void setOffset(Location value) {
		this.pos = value;
		
	}

	/**
	 * Change the type of this figure to the specified value.
	 * @param t
	 * 		  the type we want to set this figure to
	 */
	public void setType(String t) {
		this.type = t;
		
	}

	/**
	 * Adds the given Pixel object into the binary search tree associated with
	 * this figure. A DuplicatedKeyException is thrown if the figure already has
	 * a Pixel with the same key as pix.
	 * @param pix
	 * 		  the pixel we want to add into the binary search tree
	 * @throws	
	 * 		  a DuplicatedKeyException if the figure already has a pixel with the same key as the pix
	 */
	public void addPixel(Pixel pix) throws DuplicatedKeyException {
		tree.put(tree.getRoot(), pix);
		
	}
	

	/**
	 * Helper method that returns the pixel at a given location
	 * @param p
	 * 		 the location of pixel to be returned
	 * @return false
	 * 		 if the pixel is not in the tree
	 * @return true
	 * 		 if the pixel is in the tree
	 */
	private boolean findPixel(Location p){
		Pixel found = tree.get(tree.getRoot(), p);
		if(found == null){
			return false;
		}
		return true;
	}


	/**
	 * Returns true if this figure intersects the one specified in the
	 * parameter; it returns false otherwise.
	 * @param fig
	 * 		  the figure that we want to check to see if this figure intersects it
	 * @return true
	 * 		  if the figure intersects it
	 * @return false
	 * 		  if the figure doesn't intersect it
	 */
	public boolean intersects(GraphicalFigure fig) {
		
		//For each data item stored in the binary search tree storing the pixels do:
		for(Pixel current = tree.smallest(tree.getRoot()); current!= null; current=tree.successor(tree.getRoot(), current.getLocation())) {
			
			//Coordinates of this figure
			int x = getOffset().xCoord();
			int y = getOffset().yCoord();
			
			//Coordinates of figure given as parameter
			int figX = fig.getOffset().xCoord();
			int figY = fig.getOffset().yCoord();
			
			//If in the tree storing the pixels of the figure given in the parameter there is a data item that intersects return true
			if (fig.findPixel(new Location((current.getLocation().xCoord()+x-figX), (current.getLocation().yCoord()+y-figY)))) {
				return true;
			}
		}
		//Otherwise return false
		return false;	
	}
	
}
