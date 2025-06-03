package proj5;
/**
 * The BinarySearchTree class represents a binary search tree (BST).
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class BinarySearchTree<K extends Comparable<K>,V>
{
    private BSTNode<K, V> root; // root of the binary search tree
    private int size; // number of elements in the tree
    /**
     * Default constructor that initializes an empty binary search tree.
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * Returns the number of elements in this tree.
     * 
     * @return the size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Inserts an element into the binary search tree.
     * @param subroot
     * @param elem the element to insert
     * @param value the value associated with the element
     * @return the new root of the subtree after insertion
     */
    private BSTNode<K, V> insert(BSTNode<K, V> subroot, K elem, V value) {
        if (subroot == null) { 
            size++;
            return new BSTNode<>(elem, value);
        } 
        else if (elem.compareTo(subroot.element) < 0) { 
            subroot.llink = insert(subroot.llink, elem, value);
        } 
        else if (elem.compareTo(subroot.element) > 0) { 
            subroot.rlink = insert(subroot.rlink, elem, value);
        } 
        else { 
            subroot.value = value;
        }
        return subroot; 
    }
    
    /**
     * Inserts an element into the binary search tree.
     * 
     * @param elem the element to insert
     * @param value the value associated with the element
     */
    public void insert(K elem, V value) {
        root = insert(root, elem, value);
    }
	
    /**
     * Searches for an element in the binary search tree.
     * @param subroot
     * @param elem the element to search for
     * @return the node containing the element if found, null otherwise
     */
    private BSTNode<K, V> search(BSTNode<K, V> subroot, K elem) {
        if (subroot == null)
            return null;
        else if (elem.compareTo(subroot.element) < 0) 
            return search(subroot.llink, elem);
        else if (elem.compareTo(subroot.element) > 0) 
            return search(subroot.rlink, elem);
        else 
            return subroot;
    }
    
    /**
     * Searches for an element in the binary search tree.
     * 
     * @param elem the element to search for
     * @return the node containing the element if found, null otherwise
     */
    public BSTNode<K, V> search(K elem) {
        return search(root, elem);
    }

    /**
     * Finds the minimum element in a subtree rooted at subroot.
     * @param subroot
     * @return the node containing the minimum element
     */
    private BSTNode<K, V> findMin(BSTNode<K, V> subroot) {
        if (subroot == null) 
            return null;
        else if (subroot.llink == null) 
            return subroot;
        else 
            return findMin(subroot.llink);
    }

    /**
     * Deletes an element from the binary search tree.
     * @param subroot
     * @param elem the element to delete
     * @return the new root of the subtree after deletion
     */
    private BSTNode<K, V> delete(BSTNode<K, V> subroot, K elem) {
        if (subroot == null) 
            return null;
        else if (elem.compareTo(subroot.element) < 0) 
            subroot.llink = delete(subroot.llink, elem);
        else if (elem.compareTo(subroot.element) > 0) 
            subroot.rlink = delete(subroot.rlink, elem);
        else {
            if (subroot.llink == null)  {
                size--;
                return subroot.rlink;
            }
            else if (subroot.rlink == null) {
                size--;
                return subroot.llink;
            }
            else { 
                BSTNode<K, V> minNode = findMin(subroot.rlink);
                subroot.element = minNode.element; 
                subroot.value = minNode.value;
                subroot.rlink = delete(subroot.rlink, minNode.element); 
            }
        }
        return subroot; 
    }
    /**
     * Deletes an element from the binary search tree.
     * 
     * @param elem the element to delete
     */
    public void delete(K elem) {
        root = delete(root, elem);
    }

    /** recursive helper for toStringParen
     * 
     * @param subroot root of subtree to start at
     * @return inorder string of elements in this subtree
     */
    private String toStringParen(BSTNode<K, V> subroot) {
  	  if (subroot == null) // base case
  		  return "";
  	  else
  		  return "(" + toStringParen(subroot.llink) + " " +
                  subroot.toString() + " " + toStringParen(subroot.rlink) + ")";
    }
    
    /**
     * returns string showing tree structure using parentheses, as shown in class
     */
    public String toStringParen() {
  	  return toStringParen(root);
    }

    /**
     * Checks if the tree is empty.
     * 
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * recursive helper for inOrderTraversal
     * @param subroot root of subtree to start at
     * @return string array of elements in this subtree in inorder
     */
    private String[] inOrderTraversal(BSTNode<K, V> subroot) {
        if (subroot == null) {
            return new String[0];
        }
        String[] left = inOrderTraversal(subroot.llink);
        String[] right = inOrderTraversal(subroot.rlink);
        String[] result = new String[left.length + 1 + right.length];
        for (int i = 0; i < left.length; i++) {
            result[i] = left[i];
        }
        result[left.length] = subroot.toString();
        for (int i = 0; i < right.length; i++) {
            result[left.length + 1 + i] = right[i];
        }
        return result;
    }

    /**
     * inorder traversal of the tree
     * @return string showing elements in inorder
     */
    public String[] inOrderTraversal() {
        return inOrderTraversal(root);
    }
}