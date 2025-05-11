package proj3;  // Gradescope needs this.
/**
 * The doubly linked list class gives you access to the beginning and end of a linked
 * list through instance variables firstNode and lastNode.  This class
 * should contain all the methods for general manipulation of linked lists:
 * traversal, insertion, deletion, searching, etc.
 * 
 * @author
 * @version
 */
public class DoublyLinkedList
{
    private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node
    private ListNode lastNode;   // pointer to last node

    /**
     * Default constructor
     */
    public DoublyLinkedList() {
        length = 0;
        firstNode = null;
        lastNode = null;
    }

    /**
     * Returns the number of nodes 
     * @return the number of nodes
     */
    public int size() {
        return length;
    }

    /**
     * Returns true if the list is empty, false otherwise.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Returns the first node in the list.
     * @return the first node in the list
     */
    public ListNode getFirstNode() {
        return firstNode;
    }

    /**
     * Returns the last node in the list.
     * @return the last node in the list
     */
    public ListNode getLastNode() {
        return lastNode;
    }

    /**
     * Adds a new node to the front of the list.
     * @param newData the data to be added
     */
    public void addFirst(String newData) {
        ListNode newNode = new ListNode(newData);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            newNode.next = firstNode;
            firstNode.prev = newNode;
            firstNode = newNode;
        }
        length++;
    }

    /**
     * Adds a new node to the end of the list.
     * @param newData the data to be added
     */
    public void addLast(String newData) {
        ListNode newNode = new ListNode(newData);
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            lastNode.next = newNode;
            newNode.prev = lastNode;
            lastNode = newNode;
        }
        length++;
    }

    /**
     * Removes the first node from the list.
     * @return the data of the removed node
     */
    public String removeFirst() {
        if (isEmpty()) {
            return null;
        }
        String data = firstNode.data;
        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.next;
            firstNode.prev = null;
        }
        length--;
        return data;
    }

    /**
     * Removes the last node from the list.
     * @return the data of the removed node
     */
    public String removeLast() {
        if (isEmpty()) {
            return null;
        }
        String data = lastNode.data;
        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            lastNode = lastNode.prev;
            lastNode.next = null;
        }
        length--;
        return data;
    }

    /**
     * Returns a string of the list.
     * @return a string of the list
     */
    public String toString() {
        String result = "[";
        ListNode currentNode = firstNode;
        while (currentNode != null) {
            result += currentNode.data;
            currentNode = currentNode.next;
            if (currentNode != null) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }
}