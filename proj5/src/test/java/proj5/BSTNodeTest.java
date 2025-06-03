package proj5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTNodeTest {

    @Test
    void testGetElement() {
        BSTNode<String, String> newNode = new BSTNode<>("key", "value");
        assertEquals("key", newNode.toString());
    }

    @Test
    void testSetElement() {
        BSTNode<String, String> newNode = new BSTNode<>("key", "value");
        BSTNode<String, String> oldNode = new BSTNode<>("key", "valuue");
        assertEquals(newNode.toString(), oldNode.toString());
        assertNotEquals(oldNode.value, newNode.value);

    }
}