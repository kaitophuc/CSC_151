package proj2;
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
        assertEquals(5, d.size());
        d.ensureCapacity(3);
        assertEquals(5, d.size());
    }

    // Test trimToSize
    // The trimToSize method should not change the size of the deque
    // and cuts the capacity of the deque to the current size
    @Test
    public void testTrimToSize() {
        Deque d = new Deque(8);
        d.trimToSize();
        assertEquals(0, d.size());
        Deque d2 = new Deque(10);
        d2.addLeft("a");
        assertEquals(1, d2.size());
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
}
