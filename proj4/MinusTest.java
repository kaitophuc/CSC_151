package proj4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Minus class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 */

public class MinusTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    
    private Minus minus;
    private Stack<Token> stack;
    
    @Before
    public void setUp() throws Exception 
    {
        minus = new Minus();
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception 
    {
        minus = null;
        stack = null;
    }

    @Test
    public void testCompute() 
    {
        Operand op1 = new Operand(5);
        Operand op2 = new Operand(3);
        Operand result = minus.compute(op1, op2);
        assertEquals("Expected subtraction result", 2, Integer.parseInt(result.toString()));
    }

    @Test
    public void testHandle() 
    {
        stack.push(new Operand(5));
        stack.push(new Minus());
        stack.push(new Operand(3));
        minus.handle(stack);
        assertEquals("Expected stack size after handling minus", 1, stack.size());
        assertEquals("Expected top of stack to be the result of subtraction", new Operand(2), stack.peek());
    }

    @Test
    public void testHandleWithEmptyStack() 
    {
        minus.handle(stack);
        assertEquals("Expected stack size after handling empty stack", 0, stack.size());
    }

    @Test
    public void testHandleWithInsufficientTokens() 
    {
        stack.push(new Operand(5));
        minus.handle(stack);
        assertEquals("Expected stack size after handling insufficient tokens", 1, stack.size());
    }
    
}
