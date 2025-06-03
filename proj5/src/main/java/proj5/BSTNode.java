package proj5;
/**
 * The BSTNode class represents a node in a binary search tree (BST).
 * Each node contains an element, a link to its left child, and a link to its right child.
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class BSTNode<K extends Comparable<K>, V> implements Comparable<BSTNode<K, V>> {
    public K element;
    public V value; 
    public BSTNode<K, V> llink;
    public BSTNode<K, V> rlink; 

    /**
     * Default constructor that initializes the node with null links.
     */
    public BSTNode(K elem, V value) {
        this.element = elem;
        this.value = value;
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
    public int compareTo(BSTNode<K, V> other) {
        return this.element.compareTo(other.element);
    }
}
