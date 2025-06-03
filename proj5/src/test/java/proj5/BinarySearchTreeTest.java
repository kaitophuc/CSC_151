package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<String, String[]> tree;
    private BinarySearchTree<String,String> subtree;

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
        tree.insert(key, value);
        assertEquals(1, tree.size());

        String key2 = "key2";
        String[] value2 = {"value2", "value3", "value4", "value5"};
        tree.insert(key2, value2);
        assertEquals(2, tree.size());

        String[] value3 = {"value6", "value7", "value8", "value9", "value10"};
        tree.insert(key, value3);
        assertNotEquals(3, tree.size());
        assertEquals(2, tree.size());
    }

    @Test
    void testSearch() {
        tree = new BinarySearchTree<>();
        String key = "key";
        String[] value = {"value", "value2", "value3", "value4", "value5"};
        tree.insert(key, value);
        BSTNode<String, String[]> node = tree.search(key);
        assertNotNull(node);
        assertEquals(node.value, value);

        String key2 = "key2";
        String[] value2 = {"value2", "value3", "value4", "value5"};
        tree.insert(key2, value2);
        String key3 = "key3";
        String[] value3 = {"value3", "value4", "value5"};
        String key4 = "key4";
        tree.insert(key4, value3);
        BSTNode<String, String[]> node2 = tree.search(key4);
        assertNotNull(node2);
        assertEquals(key4, node2.toString());
    }

    @Test
    void testDelete() {
        tree = new BinarySearchTree<>();
        String key = "key";
        String[] value = {"value", "value2", "value3", "value4", "value5"};
        tree.insert(key, value);
        assertEquals(1, tree.size());

        String key2 = "key2";
        String[] value2 = {"value2", "value3", "value4", "value5"};
        tree.insert(key2, value2);
        assertEquals(2, tree.size());

        tree.delete(key);
        assertEquals(1, tree.size());

        tree.delete(key);
        assertEquals(1, tree.size());

        tree.delete(key2);
        assertEquals(0, tree.size());
    }

    @Test
    void testToStringParen() {
        subtree = new BinarySearchTree<>();
        subtree.insert("b", "");
        subtree.insert("c", "");
        subtree.insert("a", "");
        subtree.insert("e", "");
        subtree.insert("d", "");
        subtree.insert("f", "");
        subtree.insert("g", "");
        assertEquals("(( a ) b ( c (( d ) e ( f ( g )))))", subtree.toStringParen());
    }

    @Test
    void testIsEmpty() {
        tree = new BinarySearchTree<>();
        assertTrue(tree.isEmpty());
        tree.insert(null, null);
        assertFalse(tree.isEmpty());
    }
}