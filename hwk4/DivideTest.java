package hwk4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Divide class.
 * 
 * @author Kaito Nguyen 
 * @version May 29th 2025, Spring 2025
 */

public class DivideTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);

    BinarySearchTree tree;
    @Before
    public void setUp() throws Exception 
    {
        tree = new BinarySearchTree();
        tree.recursiveInsert("D");
        tree.recursiveInsert("B");
        tree.recursiveInsert("F");
        tree.recursiveInsert("A");
        tree.recursiveInsert("C");
        tree.recursiveInsert("E");
        tree.recursiveInsert("G");
    }
    @After
    public void tearDown() throws Exception 
    {
        tree = null;
    }

    @Test
    public void testrecursiveInsert() 
    {
        // Test inserting a new node
        tree.recursiveInsert("H");
        assertTrue(tree.search("H"));   
    }

    @Test
    public void testSearch() 
    {
        // Test searching for existing nodes
        assertTrue(tree.search("A"));
        assertTrue(tree.search("B"));
        assertTrue(tree.search("C"));
        assertTrue(tree.search("D"));
        assertTrue(tree.search("E"));
        assertTrue(tree.search("F"));
        assertTrue(tree.search("G"));

        // Test searching for a non-existing node
        assertFalse(tree.search("X"));
    }

    @Test
    public void testPrint() 
    {
        // Test printing the tree structure
        String expectedOutput = "((A)B(C))D((E)F(G(H)))";
        assertEquals(expectedOutput, tree.print());
    }
    
    @Test
    public void testInsert() 
    {
        // Test inserting a new node
        tree.insert("I");
        assertTrue(tree.search("I"));
    }

    @Test
    public void testToString() 
    {
        // Test the toString method
        String expectedOutput = "((A)B(C))D((E)F(G(H(I))))";
        assertEquals(expectedOutput, tree.toString());
    }

    @Test
    public void testSize()
    {
        assertEquals(9, tree.size());

        // Test size after inserting a new node
        tree.insert("Z");
        assertEquals(10, tree.size());
    }
}
