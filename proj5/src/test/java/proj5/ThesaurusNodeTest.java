package proj5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThesaurusNodeTest {

    @Test
    void testToString() {
        ThesaurusNode thesaurusNode = new ThesaurusNode("key", new String[]{"value"});
        BSTNode<ThesaurusNode> newNode = new BSTNode<>(thesaurusNode);
        assertEquals("key", newNode.toString());
    }

    @Test
    void testToString2() {
        ThesaurusNode thesaurusNode = new ThesaurusNode("key", new String[]{"value"});
        BSTNode<ThesaurusNode> newNode = new BSTNode<>(thesaurusNode);
        ThesaurusNode thesaurusNode2 = new ThesaurusNode("key", new String[]{"valuue"});
        BSTNode<ThesaurusNode> oldNode = new BSTNode<>(thesaurusNode2);
        assertEquals(newNode.toString(), oldNode.toString());
        assertEquals(oldNode.element.getWord(), newNode.element.getWord());
    }

    @Test
    void testCompareTo() {
        ThesaurusNode thesaurusNode = new ThesaurusNode("key", new String[]{"value"});
        BSTNode<ThesaurusNode> newNode = new BSTNode<>(thesaurusNode);
        ThesaurusNode thesaurusNode2 = new ThesaurusNode("key", new String[]{"valuue"});
        BSTNode<ThesaurusNode> oldNode = new BSTNode<>(thesaurusNode2);
        assertEquals(0, newNode.compareTo(oldNode));

        ThesaurusNode thesaurusNode3 = new ThesaurusNode("key2", new String[]{"value"});
        BSTNode<ThesaurusNode> newNode2 = new BSTNode<>(thesaurusNode3);
        assertEquals(1, newNode2.compareTo(oldNode));

        ThesaurusNode thesaurusNode4 = new ThesaurusNode("key", new String[]{"value2"});
        BSTNode<ThesaurusNode> newNode3 = new BSTNode<>(thesaurusNode4);
        assertEquals(0, newNode3.compareTo(oldNode));

        ThesaurusNode thesaurusNode5 = new ThesaurusNode("ke", new String[]{"value"});
        BSTNode<ThesaurusNode> newNode4 = new BSTNode<>(thesaurusNode5);
        assertEquals(-1, newNode4.compareTo(newNode));
    }
}