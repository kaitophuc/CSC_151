package proj3;
/**
 * JUnit test class.  Use these tests as models for your own.
 */

import java.util.concurrent.TimeUnit;

import junit5.documentation.src.test.java.example.FastTest;

import java.beans.Transient;


public class DequeJavaTest {
    @Rule // a test will fail if it takes longer than 1/10 of a second to run
 	public Timeout timeout = Timeout.millis(100); 

    // Test the constructor
    // The constructor should create an empty deque with a default capacity of 10
    @Test
    public void testAddNull() {
        Deque d = new Deque();
        d.addLeft(null);
        assertEquals(0, d.size());
        assertEquals("{} (capacity = 10)", d.toString());
        d.addRight(null);
        assertEquals(0, d.size());
        assertEquals("{} (capacity = 10)", d.toString());
    }

    // Test removeLeft and removeRight
    // The removeLeft and removeRight methods should return null when the deque is empty
    // and should return the correct element when the deque is not empty
    @Test 
    public void testRemoveLeftOnEmptyRepeatedly() {
        Deque d = new Deque();
        assertNull(d.removeLeft());
        assertEquals(0, d.size());
        assertNull(d.removeLeft());
        assertEquals(0, d.size());
    }

    @Test
    public void testRemoveRightOnEmptyRepeatedly() {
        Deque d = new Deque();
        assertNull(d.removeRight());
        assertEquals(0, d.size());
        assertNull(d.removeRight());
        assertEquals(0, d.size());
    }

    // Test the ensureCapacity method
    // The ensureCapacity method should not change the size of the deque
    // and should not change the capacity of the deque if the new capacity is less than the current capacity
    @Test
    public void testEnsureCapacity() {
        Deque d = new Deque(5);
        d.addRight("a");
        assertEquals(5, d.getCapacity());
        d.ensureCapacity(3);
        assertEquals(5, d.getCapacity());
    }

    // Test trimToSize
    // The trimToSize method should not change the size of the deque
    // and cuts the capacity of the deque to the current size
    @Test
    public void testTrimToSize() {
        Deque d = new Deque(8);
        d.trimToSize();
        assertEquals(8, d.getCapacity());
        Deque d2 = new Deque(10);
        d2.addLeft("a");
        assertEquals(8, d2.getCapacity());
    }

    // Test the toString method
    // The toString method should return a string representation of the deque
    @Test
    public void testToStringAddLeft() {
        Deque d = new Deque();
        d.addLeft("a");
        assertEquals("{a} (capacity = 10)", d.toString());
        d.addLeft("b");
        assertEquals("{b, a} (capacity = 10)", d.toString());
    }

    @Test
    public void testToStringAddRight() {
        Deque d = new Deque();
        d.addRight("a");
        assertEquals("{a} (capacity = 10)", d.toString());
        d.addRight("b");
        assertEquals("{a, b} (capacity = 10)", d.toString());
    }
    
    // Test clone
    // The clone method should return a copy of the deque
    // and the copy should be independent of the original deque
    @Test 
    public void testCloneIndependence() {
        Deque orin = new Deque();
        orin.addLeft("a");
        Deque clone = (Deque)orin.clone();
        assertEquals(orin.size(), clone.size());
        clone.addLeft("b");
        assertNotEquals(orin.size(), clone.size());
        assertEquals(orin.size(), 1);
        assertEquals(clone.size(), 2);
    }

    // Test the addAll method
    // It should add all elements from the given collection to the deque
    // and should not change the size of the deque if the collection is empty
    @Test
    public void testAddAllNullArgument() {
        Deque d = new Deque();
        d.addAll(null);
        assertEquals(0, d.size());
        assertEquals("{} (capacity = 10)", d.toString());
    }

    // Test clear
    // The clear method should remove all elements from the deque
    @Test
    public void testClear() {
        Deque d = new Deque(5);
        d.addLeft("a");
        assertEquals(1, d.size());
        d.clear();
        assertEquals(0, d.size());
        assertEquals("{} (capacity = 5)", d.toString());
    }

    // Test equals
    // The equals method should return true if the two deques are equal
    @Test 
    public void testEquals() {
        Deque d1 = new Deque();
        d1.addLeft("a");
        d1.addRight("b");
        Deque d2 = new Deque();
        d2.addLeft("a");
        d2.addRight("b");
        assertTrue(d1.equals(d2));
        assertFalse(d1.equals(null));
        assertFalse(d1.equals(new Object()));
    }

    // Test the size method
    // The size method should return the number of elements in the deque
    @Test
    public void testSize() {
        Deque d = new Deque();
        assertEquals(0, d.size());
        d.addLeft("a");
        assertEquals(1, d.size());
        d.addRight("b");
        assertEquals(2, d.size());
        d.removeLeft();
        assertEquals(1, d.size());
        d.removeRight();
        assertEquals(0, d.size());
    }

    // Test the isEmpty method
    // The isEmpty method should return true if the deque is empty
    // and false otherwise
    @Test
    public void testIsEmpty() {
        Deque d = new Deque();
        assertTrue(d.isEmpty());
        d.addLeft("a");
        assertFalse(d.isEmpty());
        d.removeLeft();
        assertTrue(d.isEmpty());
    }

    // Test the addLeft method
    // The addLeft method should add an element to the left end of the deque
    @Test
    public void testAddLeft() {
        Deque d = new Deque();
        d.addLeft("a");
        assertEquals(1, d.size());
        assertEquals("{a} (capacity = 10)", d.toString());
        d.addLeft("b");
        assertEquals(2, d.size());
        assertEquals("{b, a} (capacity = 10)", d.toString());
    }

    // Test the addRight method
    // The addRight method should add an element to the right end of the deque
    @Test
    public void testAddRight() {
        Deque d = new Deque();
        d.addRight("a");
        assertEquals(1, d.size());
        assertEquals("{a} (capacity = 10)", d.toString());
        d.addRight("b");
        assertEquals(2, d.size());
        assertEquals("{a, b} (capacity = 10)", d.toString());
    }

    // Test the removeLeft method
    // The removeLeft method should remove and return the leftmost element of the deque
    @Test
    public void testRemoveLeft() {
        Deque d = new Deque();
        d.addLeft("a");
        d.addLeft("b");
        assertEquals("b", d.removeLeft());
        assertEquals(1, d.size());
        assertEquals("{a} (capacity = 10)", d.toString());
        assertEquals("a", d.removeLeft());
        assertEquals(0, d.size());
        assertEquals("{} (capacity = 10)", d.toString());
    }
}
