package proj5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterNodeTest {

    @Test
    void testToString() {
        WordCounterNode wordCounterNode = new WordCounterNode("key");
        for (int i = 0; i < 10; i++) {
            wordCounterNode.incrementCount();
        }
        BSTNode<WordCounterNode> newNode = new BSTNode<>(wordCounterNode);
        assertEquals("key", newNode.toString());
    }

    @Test
    void testCompareTo() {
        WordCounterNode wordCounterNode = new WordCounterNode("key");
        BSTNode<WordCounterNode> newNode = new BSTNode<>(wordCounterNode);

        WordCounterNode wordCounterNode2 = new WordCounterNode("key");
        BSTNode<WordCounterNode> oldNode = new BSTNode<>(wordCounterNode2);
        for (int i = 0; i < 10; i++) {
            wordCounterNode.incrementCount();
        }
        assertEquals(0, newNode.compareTo(oldNode));

        WordCounterNode wordCounterNode3 = new WordCounterNode("key2");
        BSTNode<WordCounterNode> newNode2 = new BSTNode<>(wordCounterNode3);
        assertEquals(1, newNode2.compareTo(oldNode));

        WordCounterNode wordCounterNode4 = new WordCounterNode("key");
        BSTNode<WordCounterNode> newNode3 = new BSTNode<>(wordCounterNode4);
        assertEquals(0, newNode3.compareTo(oldNode));
        
        WordCounterNode wordCounterNode5 = new WordCounterNode("ke");
        BSTNode<WordCounterNode> newNode4 = new BSTNode<>(wordCounterNode5);
        assertEquals(-1, newNode4.compareTo(newNode));
    }
}
