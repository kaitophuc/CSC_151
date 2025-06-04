package proj5;
/**
 * The BSTNode class represents a node in a binary search tree (BST).
 * Each node contains an element, a link to its left child, and a link to its right child.
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

<<<<<<< HEAD
public class BSTNode<E extends Comparable<E>> {
    public E element;
    public BSTNode<E> llink;
    public BSTNode<E> rlink; 
=======
public class BSTNode<K extends Comparable<K>, V> implements Comparable<BSTNode<K, V>> {
    public K element;
    public V value; 
    public BSTNode<K, V> llink;
    public BSTNode<K, V> rlink; 
>>>>>>> 3083e9785baee6a2c9f8988aaef04a77dfb5751f

    /**
     * Default constructor that initializes the node with null links.
     */
    public BSTNode(E elem) {
        this.element = elem;
        this.llink = null;
        this.rlink = null;
    }

    /**
     * Returns a string representation of the element in this node.
     * @return a string representation of the element
     */
    public String toString() {
        return element.toString();
    }

    /**
     * Compares this node with another node based on the element.
     * 
     * @param other the other node to compare with
     * @return a negative integer, zero, or a positive integer as this node is less than, equal to, or greater than the specified node
     */
<<<<<<< HEAD
    public int compareTo(BSTNode<E> other) {
=======
    public int compareTo(BSTNode<K, V> other) {
>>>>>>> 3083e9785baee6a2c9f8988aaef04a77dfb5751f
        return this.element.compareTo(other.element);
    }
}
