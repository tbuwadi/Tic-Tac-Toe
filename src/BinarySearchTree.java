/**
 * This class implements an ordered dictionary using a binary search tree. 
 * Each node of the tree will store a Pixel object; the attribute Location of the Pixel will be its key.
 * Only the internal nodes will store information. 
 * The leaves are nodes (leaves are not null) that do not store any data
 * 
 * @author Tala Buwadi, tbuwadi
 *
 */

public class BinarySearchTree implements BinarySearchTreeADT {

	/**
	 * Declaration of instance variables
	 */
	private BinaryNode root;
	
	/**
	 * A constructor that creates a tree whose root is a leaf node
	 */
	public BinarySearchTree() {
		this.root = new BinaryNode();
	}
	
	
	/**
	 * Returns the Pixel object storing the given key, if the key is stored in
	 * the tree. Returns null otherwise.
	 * 
	 * @param r
	 * 			the root of the tree
	 * @param key
	 * 			the key we want to return the corresponding pixel of
	 * 
	 * @return
	 * 			the pixel object storing the given key if in tree
	 * 			null otherwise
	 */
	public Pixel get(BinaryNode r, Location key) {
		
		//If r is a leaf return null
		if(r.isLeaf()) {
				return null;
		}
		else {
			//If the key we want is the key stored in r, return the pixel
			if (r.getData().getLocation().compareTo(key) == 0) {
				return r.getData();
			}
			//If k is less than the key stored in r then return the left most key
			else if(r.getData().getLocation().compareTo(key)>0) {
				return get(r.getLeft(), key);
			}
			//If k is larger than the key stored in r then return the right most key
			else {
				return get(r.getRight(), key);
			} 
		}
	}

	/**
	 * Returns the node storing the given key, if the key is stored in
	 * the tree. Returns null otherwise.
	 * 
	 * @param r
	 * 			the root of the tree
	 * @param key
	 * 			the key we want to return the corresponding node of
	 * 
	 * @return
	 * 			the node storing the given key if in tree
	 * 			null otherwise
	 */
	private BinaryNode getNode(BinaryNode r, Location key) {

		//If r is a leaf return r
		if(r.isLeaf()) {
			return r;
		}
		else {
			//If the key we want is the key stored in r, return the node
			if (r.getData().getLocation().compareTo(key) == 0) {
				return r;
			}
			//If k is less than the key stored in r then return the left most node
			else if(r.getData().getLocation().compareTo(key)>0) {
				return getNode(r.getLeft(), key);
			}
			//If k is larger than the key stored in r then return the right most node
			else {
				return getNode(r.getRight(), key);
			}
		}
	}

	/**
	 * Inserts the given data in the tree if no data item with the same key is
	 * already there. If a node already stores the same key, the algorithm
	 * throws a DuplicatedKeyException.
	 * 
	 * @param r
	 * 		the root of the tree
	 * @param data
	 * 		the pixel we want to add
	 * 
	 * @throws	
	 * 		DuplicatedKeyException if a node already stores the same key
	 * 
	 */
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException{
		
		//Get the current node
		BinaryNode currentNode = getNode(r, data.getLocation());
		
		//If the node is an internal node then the information is duplicated, return exception
		if(!currentNode.isLeaf()) {
			throw new DuplicatedKeyException();
		}
		//Otherwise, the node is a leaf which means it is null, so store the information into it
		else {
			//Set data of current
			currentNode.setData(data);
			
			//Set empty left and right children 
			BinaryNode left = new BinaryNode();
			BinaryNode right = new BinaryNode();
			currentNode.setLeft(left);
			currentNode.setRight(right);
			
			//Set parents of children to node
			left.setParent(currentNode);
			right.setParent(currentNode);
		}
	}

	/**
	 * Removes the data item with the given key, if the key is stored in the
	 * tree. Throws an InexistentKeyException otherwise.
	 * 
	 * @param r
	 * 		the root of the tree containing the data item
	 * @param key
	 * 		the key of the data item we want to remove
	 * 
	 * @throws 
	 * 		InexistentKeyException if the key isn't in the tree
	 * 		
	 */
	public void remove(BinaryNode r, Location key) throws InexistentKeyException {
		
		//Get the current node
		BinaryNode currentNode = getNode(r, key);
		BinaryNode otherChild = new BinaryNode();
		BinaryNode parent = currentNode.getParent();
		
		//If p is a leaf then return an exception (leafs don't store data, so this means there's nothing to remove)
		if(currentNode.isLeaf()) {
			throw new InexistentKeyException();
		}
		else {
			//If p has a child c that is a leaf then
			if(currentNode.getLeft().isLeaf() || currentNode.getRight().isLeaf()) {
				if (currentNode.getLeft().isLeaf())
					//if the left is the leaf then the right is the child
					otherChild = currentNode.getRight();
				else if(currentNode.getRight().isLeaf()) {
					//if the right is the leaf then the left is the child
					otherChild = currentNode.getLeft();
				}
				//If the parent is the root then make the other child the new root
				if (parent==null) {
					this.root = otherChild;
					otherChild.setParent(null);
				}
				//Otherwise make the otherChild the child of the parent instead of the current node
				else {
					
					//if the current node is the right, make otherChild the right
					if(parent.getRight().equals(currentNode)) {
						parent.setRight(otherChild);
						otherChild.setParent(parent);
					}
					//if the current node is the left, make otherChild the left
					else {
						parent.setLeft(otherChild);
						otherChild.setParent(parent);
					}
				}
			}
			
			//Case where the node to be removed is an internal node
			else {
				BinaryNode smallest = new BinaryNode();
				smallest = smallestNode(currentNode.getRight());
				currentNode.setData(smallest.getData());
				remove(smallest, smallest.getData().getLocation());
			}
		}
	}

	/**
	 * Returns the Pixel with the smallest key larger than the given one (note
	 * that the tree does not need to store a node with the given key). Returns
	 * null if the given key has no successor.
	 * 
	 * @param r
	 * 		the root of the tree
	 * @param key
	 * 		the key of the node
	 * 
	 * @returns
	 * 		Pixel with the smallest key larger than the given one
	 * 		Null if no successor
	 */
	public Pixel successor(BinaryNode r, Location key) {
		BinaryNode currentNode = getNode(r, key);
		BinaryNode parent = currentNode.getParent();
		
		//If tree is empty or at the end return null
		if(r.isLeaf()) {
			return null;
		}
		
		//Otherwise 
		else {
			
			//if the current node is an internal node and the right child of the current node is internal
			if(!currentNode.isLeaf() && !currentNode.getRight().isLeaf()) {
				//return smallest right child of the node
				return smallest(currentNode.getRight());
			}
			else {
				
				//while the current node isnt the root and the current node is the right child of the parent of the node
				while((!currentNode.equals(r)) && (parent.getRight().equals(currentNode))) {
					currentNode = parent;
					parent = currentNode.getParent();
				}
				
				//if the node is the root then
				if(currentNode.equals(r)) {
					return null;
				}
				else {
					return parent.getData();
				}
			}
		}
	}

	/**
	 * Returns the Pixel with the largest key smaller than the given one (note
	 * that the tree does not need to store a node with the given key). Returns
	 * null if the given key has no predecessor.
	 * 
	 * @param r
	 * 		the root of the tree
	 * @param key
	 * 		the key of the node
	 * 
	 * @returns
	 * 		Pixel with the largest key larger than the given one
	 * 		Null if no predecessor
	 */
	public Pixel predecessor(BinaryNode r, Location key) {
		BinaryNode currentNode = new BinaryNode();
		BinaryNode parent = new BinaryNode();
		
		if(r.isLeaf()) {
			return null;
		}
		else {
			currentNode = getNode(r, key);
			
			//if the current node is an internal node and the left child of the current node is internal
			if(!currentNode.isLeaf() && !currentNode.getLeft().isLeaf()) {
				//return largest left child of node
				return largest(currentNode.getLeft());
			}
			else {
				parent = currentNode.getParent();
				
				//while the current node isnt the root and the current node is the left child of the parent of the node
				while((!currentNode.equals(r)) && (parent.getLeft().equals(currentNode))) {
					currentNode = parent;
					parent = currentNode.getParent();
				}
				//if the node is the root then
				if(currentNode.equals(r)) {
					return null;
				}
				else {
					return parent.getData();
				}
			}
		}
	}
	
	/**
	 * Returns the node with the smallest key. Throws an EmptyTreeException if
	 * the tree is empty.
	 * 
	 * @param r
	 * 		  the root of the tree
	 * 
	 * @returns 
	 * 		  The node with the smallest key
	 * 
	 * @throws
	 * 		  EmptyTreeException if the tree is empty
	 */
	private BinaryNode smallestNode(BinaryNode r) throws EmptyTreeException{
		
		BinaryNode currentNode = new BinaryNode();
		
		//If the tree is empty throw an exception
		if(r.isLeaf()) {
			throw new EmptyTreeException();
		}
		
		//Otherwise return the smallest node
		else {
			currentNode = r;
			while(!currentNode.isLeaf()) {
				currentNode = currentNode.getLeft();
			}
			return currentNode.getParent();
		}
	}
	
	/**
	 * Returns the node with the largest key. Throws an EmptyTreeException if
	 * the tree is empty.
	 * 
	 * @param r
	 * 		  the root of the tree
	 * 
	 * @returns 
	 * 		  The node with the largest key
	 * 
	 * @throws
	 * 		  EmptyTreeException if the tree is empty
	 */
	private BinaryNode largestNode(BinaryNode r) throws EmptyTreeException{
		
		BinaryNode currentNode = new BinaryNode();
		
		//If tree is empty throw an exception
		if(r.isLeaf()) {
			throw new EmptyTreeException();
		}
		
		//Otherwise return the largest node by traversing the tree
		else {
			currentNode = r;
			while(!currentNode.isLeaf()) {
				currentNode = currentNode.getRight();
			}
			return currentNode.getParent();
		}
	}
	
	/**
	 * Returns the Pixel with the smallest key. Throws an EmptyTreeException if
	 * the tree is empty.
	 * 
	 * @param r
	 * 		  the root of the tree
	 * 
	 * @returns 
	 * 		  The Pixel with the smallest key
	 * 
	 * @throws
	 * 		  EmptyTreeException if the tree is empty
	 */
	public Pixel smallest(BinaryNode r) throws EmptyTreeException{
		
		//return the pixel value of the node found in smallestNode
		return smallestNode(r).getData();
	}

	/**
	 * Returns the Pixel with the largest key. Throws an EmptyTreeException if
	 * the tree is empty.
	 * 
	 * @param r
	 * 		  the root of the tree
	 * 
	 * @returns 
	 * 		  The Pixel with the largest key
	 * 
	 * @throws
	 * 		  EmptyTreeException if the tree is empty
	 */
	public Pixel largest(BinaryNode r) throws EmptyTreeException{
		
		//return the pixel value of the node found in largestNode
		return largestNode(r).getData();
	}
	
	/**
	 * Returns the root of the binary search tree
	 * @return
	 * 		the root of the binary search tree
	 */
	public BinaryNode getRoot() {
		return root;
	}

}

