/**
 * This class represents the nodes of the binary search tree. 
 * Each node will store an object of the class Pixel and it will 
 * have references to its left child, its right child, and its parent.
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */
public class BinaryNode {
	
	/**
	 * Declaration of instance variables
	 */
	private Pixel value; 
	private BinaryNode left;
	private BinaryNode right; 
	private BinaryNode parent;
	
	/**
	 * A constructor for the class
	 * Stores the pixel in the node and sets the left child, right child, and parent to the specified values
	 * @param value
	 * 		  the pixel value to store in the node
	 * @param left
	 * 		  the left child of the node
	 * @param right
	 * 		  the right child of the node
	 * @param parent
	 * 		  the parent of the node
	 */
	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {
		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	/**
	 * A constructor for the class
	 * Initializes a leaf node
	 */
	public BinaryNode() {
		this.value = null;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
	
	/**
	 * Returns the parent of the node
	 * @return
	 * 		returns this node's parent
	 */
	public BinaryNode getParent() {
		return this.parent;
	}
	
	/**
	 * Sets the parent of this node to be the specified value
	 * @param parent
	 * 			the parent of the node
	 */
	public void setParent(BinaryNode parent) {
		this.parent = parent;
	}
	
	/**
	 * Sets the left child of this node to the specified value
	 * @param p
	 * 		  the value we want the left child to be
	 */
	public void setLeft(BinaryNode p) {
		this.left = p;
	}
	
	/**
	 * Sets the right child of this node to the specified value
	 * @param p
	 * 	      the value we want the right child to be
	 */
	public void setRight(BinaryNode p) {
		this.right = p;
	}
	
	/**
	 * Stores the given pixel in this node
	 * @param value
	 * 		  the value of the pixel
	 */
	public void setData(Pixel value) {
		this.value = value;
	}
	
	/**
	 * Returns true if this node is leaf, returns false otherwise
	 * @return
	 *		true if node is leaf
	 *		false otherwise
	 */
	public boolean isLeaf() {
		if (this.left==null && this.right == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the pixel object stored in this node
	 * @return
	 *		pixel object
	 */
	public Pixel getData() {
		return this.value;
	}
	
	/**
	 * Returns the left child of this node
	 * @return
	 *		left child of this node
	 */
	public BinaryNode getLeft() {
		return this.left;
	}
	
	/**
	 * Returns the right child of this node
	 * @return
	 *		right child of this node
	 */
	public BinaryNode getRight() {
		return this.right;
	}
}
