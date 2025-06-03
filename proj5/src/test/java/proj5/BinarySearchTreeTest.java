package proj5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<ThesaurusNode> tree;
    private BinarySearchTree<WordCounterNode> subtree;

    @Test
    void testSize() {
        tree = new BinarySearchTree<>();
        assertEquals(0, tree.size());
    }

    @Test
    void testInsert() {
        tree = new BinarySearchTree<>();
        String key = "key";
        String[] value = {"value", "value2", "value3", "value4", "value5"};
        ThesaurusNode thesaurusNode = new ThesaurusNode(key, value);
        tree.insert(thesaurusNode);
        assertEquals(1, tree.size());

        String key2 = "key2";
        String[] value2 = {"value2", "value3", "value4", "value5"};
        ThesaurusNode thesaurusNode2 = new ThesaurusNode(key2, value2);
        tree.insert(thesaurusNode2);
        assertEquals(2, tree.size());

        String[] value3 = {"value6", "value7", "value8", "value9", "value10"};
        ThesaurusNode thesaurusNode3 = new ThesaurusNode(key, value3);
        tree.insert(thesaurusNode3);
        assertNotEquals(3, tree.size());
        assertEquals(2, tree.size());
    }

    @Test
    void testSearch() {
        tree = new BinarySearchTree<>();
        String key = "key";
        String[] value = {"value", "value2", "value3", "value4", "value5"};
        ThesaurusNode thesaurusNode = new ThesaurusNode(key, value);
        tree.insert(thesaurusNode);
        BSTNode<ThesaurusNode> node = tree.search(thesaurusNode);
        assertNotNull(node);
        assertEquals(node.element.getSynonyms(), value);

        String key2 = "key2";
        String[] value2 = {"value2", "value3", "value4", "value5"};
        ThesaurusNode thesaurusNode2 = new ThesaurusNode(key2, value2);
        tree.insert(thesaurusNode2);
        String key3 = "key3";
        String[] value3 = {"value3", "value4", "value5"};
        String key4 = "key4";
        ThesaurusNode thesaurusNode3 = new ThesaurusNode(key4, value3);
        tree.insert(thesaurusNode3);
        BSTNode<ThesaurusNode> node2 = tree.search(thesaurusNode3);
        assertNotNull(node2);
    }

    @Test
    void testDelete() {
        tree = new BinarySearchTree<>();
        String key = "key";
        String[] value = {"value", "value2", "value3", "value4", "value5"};
        ThesaurusNode thesaurusNode = new ThesaurusNode(key, value);
        tree.insert(thesaurusNode);
        assertEquals(1, tree.size());

        String key2 = "key2";
        String[] value2 = {"value2", "value3", "value4", "value5"};
        ThesaurusNode thesaurusNode2 = new ThesaurusNode(key2, value2);
        tree.insert(thesaurusNode2);
        assertEquals(2, tree.size());

        tree.delete(thesaurusNode);
        assertEquals(1, tree.size());

        tree.delete(thesaurusNode);
        assertEquals(1, tree.size());

        tree.delete(thesaurusNode2);
        assertEquals(0, tree.size());
    }

    @Test
    void testToStringParen() {
        tree = new BinarySearchTree<>();
        ThesaurusNode b = new ThesaurusNode("b", new String[]{"value"});
        tree.insert(b);
        ThesaurusNode c = new ThesaurusNode("c", new String[]{"value2"});
        tree.insert(c);
        ThesaurusNode a = new ThesaurusNode("a", new String[]{"value3"});
        tree.insert(a);
        ThesaurusNode e = new ThesaurusNode("e", new String[]{"value4"});
        tree.insert(e);
        ThesaurusNode d = new ThesaurusNode("d", new String[]{"value5"});
        tree.insert(d);
        ThesaurusNode f = new ThesaurusNode("f", new String[]{"value6"});
        tree.insert(f);
        ThesaurusNode g = new ThesaurusNode("g", new String[]{"value7"});
        tree.insert(g);
        assertEquals("(( a ) b ( c (( d ) e ( f ( g )))))", tree.toStringParen());
    }

    @Test
    void testIsEmpty() {
        tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        ThesaurusNode thesaurusNode = new ThesaurusNode(null, null);
        tree.insert(thesaurusNode);
        assertFalse(tree.isEmpty());
    }
}