package proj4;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Stack class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 *
 */
public class StackTest 
{

	@Rule
    public Timeout timeout = Timeout.millis(100);
	
    private Stack<String> stack;
    
    @Before
    public void setUp() throws Exception 
    {
        stack = new Stack<String>();
    }

    @After
    public void tearDown() throws Exception 
    {
        stack = null;
    }

    @Test
    public void testStackConstructor_toString () 
    {
        assertEquals ("An empty stack. (> indicates the top of the stack)", "{>}", stack.toString());
    }
    
    @Test
    public void testStackPushOneOntoEmptyStack () 
    {
        stack.push("A");
        assertEquals ("Pushing A onto an empty stack.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushTwoOntoEmptyStack () 
    {
        stack.push("A");
        stack.push("B");
        assertEquals ("Pushing first A and then B onto an empty stack.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
    
    @Test
    public void testStackPushThreeOntoEmptyStack () 
    {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals ("Pushing first A, then B, then C onto an empty stack.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopOneOntoEmptyStack () 
    {
        stack.push("A");
        String popped = stack.pop();
        assertEquals ("Popping A from a stack with one element.", "A", popped);
        assertEquals ("Popping A from a stack with one element.", "{>}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopTwoOntoEmptyStack () 
    {
        stack.push("A");
        stack.push("B");
        String popped = stack.pop();
        assertEquals ("Popping B from a stack with two elements.", "B", popped);
        assertEquals ("Popping B from a stack with two elements.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopThreeOntoEmptyStack () 
    {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        String popped = stack.pop();
        assertEquals ("Popping C from a stack with three elements.", "C", popped);
        assertEquals ("Popping C from a stack with three elements.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPopEmptyStack () 
    {
        String popped = stack.pop();
        assertEquals ("Popping from an empty stack.", null, popped);
        assertEquals ("Popping from an empty stack.", "{>}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekOneOntoEmptyStack ()
    {
        stack.push("A");
        String peeked = stack.peek();
        assertEquals ("Peeking A from a stack with one element.", "A", peeked);
        assertEquals ("Peeking A from a stack with one element.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekTwoOntoEmptyStack () 
    {
        stack.push("A");
        stack.push("B");
        String peeked = stack.peek();
        assertEquals ("Peeking B from a stack with two elements.", "B", peeked);
        assertEquals ("Peeking B from a stack with two elements.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekThreeOntoEmptyStack () 
    {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        String peeked = stack.peek();
        assertEquals ("Peeking C from a stack with three elements.", "C", peeked);
        assertEquals ("Peeking C from a stack with three elements.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackPeekEmptyStack () 
    {
        String peeked = stack.peek();
        assertEquals ("Peeking from an empty stack.", null, peeked);
        assertEquals ("Peeking from an empty stack.", "{>}", stack.toString().replaceAll("[ ]+", ""));
    }

    @Test
    public void testStackIsEmpty () 
    {
        assertTrue ("Checking if an empty stack is empty.", stack.isEmpty());
        stack.push("A");
        assertFalse ("Checking if a non-empty stack is empty.", stack.isEmpty());
        stack.pop();
        assertTrue ("Checking if an empty stack is empty.", stack.isEmpty());
    }

    @Test
    public void testStackSize () 
    {
        assertEquals ("Checking the size of an empty stack.", 0, stack.size());
        stack.push("A");
        assertEquals ("Checking the size of a stack with one element.", 1, stack.size());
        stack.push("B");
        assertEquals ("Checking the size of a stack with two elements.", 2, stack.size());
        stack.push("C");
        assertEquals ("Checking the size of a stack with three elements.", 3, stack.size());
        stack.pop();
        assertEquals ("Checking the size of a stack with two elements.", 2, stack.size());
    }

    @Test
    public void testStackToString () 
    {
        assertEquals ("Checking the string representation of an empty stack.", "{>}", stack.toString().replaceAll("[ ]+", ""));
        stack.push("A");
        assertEquals ("Checking the string representation of a stack with one element.", "{>A}", stack.toString().replaceAll("[ ]+", ""));
        stack.push("B");
        assertEquals ("Checking the string representation of a stack with two elements.", "{>B,A}", stack.toString().replaceAll("[ ]+", ""));
        stack.push("C");
        assertEquals ("Checking the string representation of a stack with three elements.", "{>C,B,A}", stack.toString().replaceAll("[ ]+", ""));
    }
}