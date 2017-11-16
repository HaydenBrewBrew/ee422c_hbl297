/**
 * EE422C Quiz 9 submission by
 * <Hayden Lydick, hbl297>
 * <R. Alan Cooper, rac4355>
 *
 */

package quiz10.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * In this quiz, you are asked to implement Binary Search Tree using iteration
 * and recursion.
 * </p>
 * <p>
 * Replacing TODO with your implementation. Don't change any other things,
 * including package, class, or method declaration. Your submission should not
 * have any generic warnings.
 * </p>
 * <p>
 * Only submit your BSearchTree.java file.
 * </p>
 */
public class BSearchTree<E extends Comparable<E>> {

	private BSTNode<E> root;

	public BSearchTree() {
		this.root = null;
	}

	public BSearchTree(E[] arr) {
		for (E v : arr)
			add(v);
	}

	/**
	 * BST insert method
	 *
	 * @param root
	 *            BST root node
	 * @param value
	 *            the inserted value, allow duplicate values.
	 */
	public void add(E value) {
		if(root == null) {
			BSTNode<E> baby = new BSTNode<E>(value, null, null);
			root = baby;
		} else {
			addHelper(value, root);
		}
		return;
	}

	private void addHelper(E value, BSTNode<E> root2) {
		int result = root2.getData().compareTo(value);
		if(result == 0) {
			if(root2.hasLeftChild()) {
				root2 = root2.getLeft();
				while(root2.getRight() != null) {
					root2 = root2.getRight();
				}
				BSTNode<E> baby = new BSTNode<E>(value, null, null);
				root2.setRight(baby);
			} else {
				BSTNode<E> baby = new BSTNode<E>(value, null, null);
				root2.setLeft(baby);
			}
		} else if (result > 0) {
			if(root2.hasLeftChild()) {
				addHelper(value,root2.getLeft());
			} else {
				BSTNode<E> baby = new BSTNode<E>(value, null, null);
				root2.setLeft(baby);
			}
		} else {
			if(root2.getRight() != null) {
				addHelper(value,root2.getRight());
			} else {
				BSTNode<E> baby = new BSTNode<E>(value, null, null);
				root2.setRight(baby);
			}
		}
		return;
	}

	/**
	 * Find method in BST
	 *
	 * @param root
	 *            BST root
	 * @param value
	 *            searched value
	 * @return true if the value is found in the BST
	 */
	public boolean find(E value) {
		return(findHelper(value, root));
	}

	private boolean findHelper(E value, BSTNode<E> root2) {
		int result = root2.getData().compareTo(value);
		if(result == 0) {
			return true;
		} else if(result > 0) {
			if(root2.hasLeftChild()) {
				return(findHelper(value, root2.getLeft()));
			}
		} else {
			if(root2.getRight() != null){
				return(findHelper(value, root2.getRight()));
			}
		}

		return false;
	}

	/**
	 * BST remove method
	 *
	 * @param root
	 *            BST root node
	 * @param value
	 * @return tree root
	 */
	public BSTNode<E> remove(E value) {
		if(root == null){
			return root;
		} else {
			removeHelper(value, root, 0, null);
		}
		return root;
	}

	private void removeHelper(E value, BSTNode<E> root2, int dir, BSTNode<E> parent) {
		// dir = which way in the tree you last went.
		// =0: starting from top
		// >0: went left
		// <0: went right
		if(root2 == null){
			return;
		} else {
			int result = root2.getData().compareTo(value);
			if(result == 0) {
				// Remove

				// 0 Children
				if(root2.isLeaf()){
					if(dir > 0){
						parent.setLeft(null);
					} else if(dir < 0){
						parent.setRight(null);
					} else {
						// delete overall root
						root2 = null;
					}

				// 1 Children
				} else if(root2.getLeft() == null || root2.getRight() == null) {
					if(dir > 0 && root2.getLeft() != null){
						parent.setLeft(root2.getLeft());
					} else if(dir > 0 && root2.getRight() != null){
						parent.setLeft(root2.getRight());
					} else if(dir < 0 && root2.getLeft() != null){
						parent.setRight(root2.getLeft());
					} else if(dir < 0 && root2.getRight() != null){
						parent.setRight(root2.getRight());
					} else {
						// delete overall root
						if(root2.getLeft() != null){
							root = root2.getLeft();
						}
						if(root2.getRight() != null){
							root = root2.getRight();
						}
					}

				// 2 Children
				} else {
					BSTNode<E> parent2 = root2;
					BSTNode<E> rep = root2.getRight();
					boolean left = rep.hasLeftChild();
					while(rep.hasLeftChild()){
						parent2 = rep;
						rep = parent2.getLeft();
					}
					root2.setData(rep.getData());
					if(parent2 != null){
						if(left){
							parent2.setLeft(null);
						} else {
							parent2.setRight(null);
						}
					}
				}

			} else if(result > 0) {
				if(root2.hasLeftChild()) {
					removeHelper(value, root2.getLeft(), result, root2);
				}
			} else {
				if(root2.getRight() != null){
					removeHelper(value, root2.getRight(), result, root2);
				}
			}
		}


	}


	public BSTNode<E> remove2(E value) {
		// TODO implement this method using iteration
		if(!find(value)) {
			return root;
		}
		BSTNode<E> n = root;
		removeHelp(value, n);
		return root;
	}

	private void removeHelp(E value, BSTNode<E> n) {
		if(value.compareTo(n.getData()) < 0) {
			removeHelp(value, n.getLeft());
		}

		else if(value.compareTo(n.getData()) > 0) {
			removeHelp(value, n.getRight());
		}

		else if(value.compareTo(n.getData()) == 0) {
			if(n.hasLeftChild() && n.getRight() != null) {
				// two children case
				BSTNode<E> pred = n.getLeft();
				while(pred.getRight() != null) {
					pred = pred.getRight();
				}
				n.setData(pred.getData());
				removeHelp(pred.getData(), n.getLeft());
			}
			else if (n.hasLeftChild()) {
				BSTNode<E> trash = n;
				n = n.getLeft();
				trash = null;
			}
			else if (n.getRight() != null) {
				BSTNode<E> trash = n;
				n = n.getRight();
				trash = null;
			}
			else if (n.isLeaf()) {
				n = null;
			}
		}
	}


	public BSTNode<E> getRoot() {
		return root;
	}

	// DO NOT CHANGE THIS METHOD
	public String toString() {
		if (root == null)
			return "";
		String str = "";
		Queue<BSTNode<E>> q = new LinkedList<BSTNode<E>>();
		q.add(root);
		while (!q.isEmpty()) {
			BSTNode<E> n = q.poll();
			str += n.toString() + " ";
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
		return str;
	}
}
