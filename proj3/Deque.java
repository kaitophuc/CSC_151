package proj3;   // Gradescope needs this
/**
 *  Class description, name, honor code go here.
 * This class implements a deque using a doubly linked list.
 * It provides methods to add and remove elements from both ends,
 * check the size, and ensure capacity. It also includes methods
 * to clone the deque, check equality, and trim capacity.
 * @author Kaito Nguyen
 * @version May 11, 2025, CSC 151, Spring 2025
 * I confirm that I follow the Honor Code.
 */

public class Deque {
    public int DEFAULT_CAPACITY = 10;
    /**
     * Data is stored in a doubly linked list.
     * The capacity of the deque is the number of elements that can be stored in the deque. 
     * The size of the deque is the number of elements currently in the deque.
     */
    private DoublyLinkedList data; // the data in the deque                      //
    private int capacity;         // the current capacity of the deque          //
    private int size;            // the number of elements in the deque        //

    
    /**
     * Creates a new deque with initial capacity 10.
     */
    public Deque()
    {
        data = new DoublyLinkedList();
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }
    
    /**
     * Creates a new deque.
     * @param initialCapacity the initial capacity of the deque.
     */
    public Deque(int initialCapacity)
    {
        if (initialCapacity < 0) {
            System.out.println("Invalid capacity");
            return;
        }
        data = new DoublyLinkedList();
        capacity = initialCapacity;
        size = 0;
    }
    
    /**
     * inserts a string on the left of the deque.
     *
     * If the deque's capacity has been reached, the deque will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addLeft(String value)
    {
        if (value == null) {
            System.out.println("Invalid value");
            return;
        }
        if (size == capacity) {
            ensureCapacity(2 * capacity + 1);
        }
        data.addFirst(value);
        size = data.size();
    }

    /**
     * inserts a string on the right of the deque.
     *
     * If the deque's capacity has been reached, the deque will
     * expand to twice its current capacity plus 1.
     *
     * @param value the string to add.
     */
    public void addRight(String value)
    {
        if (value == null) {
            System.out.println("Invalid value");
            return;
        }
        if (size == capacity) {
            ensureCapacity(2 * capacity + 1);
        }
        data.addLast(value);
        size = data.size();
    }

    /**
     * Remove and return the left item from the deque.  Return
     * null if the deque is empty.
     */
    public String removeLeft()
    {
        if(data.isEmpty()) {
            return null;
        }
        String value = data.removeFirst();
        size = data.size();
        return value;
    }

    /**
     * Remove and return the right item from the deque.  Return
     * null if the deque is empty.
     */
    public String removeRight()
    {
        if(data.isEmpty()) {
            return null;
        }
        String value = data.removeLast();
        size = data.size();
        return value;
    }

    /**
     * Places the contents of another deque in order at the right
     * end of this deque.  For example, if this deque is {A,B} and
     * the other deque is {B,C,D}, addAll will change this deque
     * to be {A,B,B,C,D}.
     *
     * If adding all elements of the other deque would exceed the
     * capacity of this deque, the capacity is changed to make
     * exactly enough room for all the elements to be added.
     * 
     * Postcondition: NO SIDE EFFECTS!  the other deque should be left
     * unchanged.
     *
     * @param otherDeque the deque whose contents should be added.
     */
    public void addAll(Deque otherDeque)
    {
        if (otherDeque == null) {
            System.out.println("Invalid deque");
            return;
        }
        if (otherDeque.size() == 0) {
            return;
        }
        if (size + otherDeque.size() > capacity) {
            ensureCapacity(size + otherDeque.size());
        }
        ListNode otherCurrent = otherDeque.data.getFirstNode();
        while (otherCurrent != null) {
            data.addLast(otherCurrent.data);
            otherCurrent = otherCurrent.next;
        }
        size = data.size();
    }

    /**
     * Make a copy of this deque.  Changes to the copy
     * do not affect the current deque, and vice versa.
     * 
     * Postcondition: NO SIDE EFFECTS!  This deque's leftmost
     * and rightmost elements should remain unchanged.
     * 
     * @return the copy of this deque.
     */
    public Deque clone()
    {
        Deque copy = new Deque(capacity);
        ListNode current = data.getFirstNode();
        while (current != null) {
            copy.addRight(current.data);
            current = current.next;
        }
        return copy;
    }

    /**
     * Change the current capacity of this sequence.  The sequence's
     * capacity will be changed to be at least minCapacity.  Does 
     * nothing if current capacity is already >= minCapacity.
     *
     * @param minCapacity the minimum capacity that the sequence
     * should now have.
     */
    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity > capacity) {
            capacity = minCapacity;
        }
    }

    /**
     * @return the capacity of the sequence.
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * @return the leftmost element in the deque, or
     * null if deque is empty
     */
    public String leftMost()
    {
        if(data.isEmpty()) {
            return null;
        }
        return data.getFirstNode().data;
    }

    /**
     * @return the rightmost element in the deque, or
     * null if deque is empty
     */
    public String rightMost()
    {
        if(data.isEmpty()) {
            return null;
        }
        return data.getLastNode().data;
    }


    /**
     * @return the number of elements stored in the sequence.
     */
    public int size()
    {
        return size;
    }


    /**
     * Reduce the current capacity to its actual size, so that it has
     * capacity to store only the elements currently stored.
     */
    public void trimToSize()
    {
        if (size < capacity) {
            capacity = size;
        }
    }
    
    /**
     * Produce a left-to-right string representation of this deque.
     * For example, a deque of capacity 5 with "A" as its leftmost elmt,
     * "C" as its rightmost elmt, and "B" in the middle would print as:
     * 
     *    {A, B, C} (capacity = 5)
     * 
     * The string you create should be formatted like the above example,
     * with a comma and space following each element, no comma following the
     * last element, and all on a single line. An empty deque
     * should give back "{}" followed by its capacity.
     * 
     * @return a string representation of this deque.
     */
    public String toString()
    {
        String result = "{";
        ListNode current = data.getFirstNode();
        while (current != null) {
            result += current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "} (capacity = " + capacity + ")";
        return result;
    }
    
    /**
     * Checks whether another deque is equal to this one.  To be
     * considered equal, both deques must have exactly the same
     * elements in the same order.  The capacity can differ.
     *
     * NO SIDE EFFECTS!  Both this deque and the other deque
     * must be the same at the end of this method as they were
     * at the start of this method.
     * 
     * @param other the other Deque with which to compare
     * @return true iff the other Deque is equal to this one.
     */
    public boolean equals(Deque other)
    {
        if (other == null) {
            return false;
        }
        if (size != other.size()) {
            return false;
        }
        ListNode current = data.getFirstNode();
        ListNode otherCurrent = other.data.getFirstNode();
        while (current != null && otherCurrent != null) {
            if (!current.data.equals(otherCurrent.data)) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return true;
    }
    
    /**
     * 
     * @return true if deque empty, else false
     */
    public boolean isEmpty()
    {
        return data.isEmpty();
    }
    
    /**
     *  empty the deque
     */
    public void clear()
    {
        data = new DoublyLinkedList();
        size = 0;
    }


}
