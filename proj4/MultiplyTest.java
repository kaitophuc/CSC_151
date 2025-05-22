package proj4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Multiply class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 */

public class MultiplyTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    private Multiply multiply;
    private Stack<Token> stack;
    
    @Before
    public void setUp() throws Exception 
    {
        multiply = new Multiply();
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception 
    {
        multiply = null;
        stack = null;
    }

    @Test
    public void testCompute() 
    {
        Operand op1 = new Operand(5);
        Operand op2 = new Operand(3);
        Operand result = multiply.compute(op1, op2);
        assertEquals("Expected multiplication result", 15, Integer.parseInt(result.toString()));
    }

    @Test
    public void testHandle() 
    {
        stack.push(new Operand(5));
        stack.push(new Multiply());
        stack.push(new Operand(3));
        multiply.handle(stack);
        assertEquals("Expected stack size after handling multiply", 1, stack.size());
        assertEquals("Expected top of stack to be the result of multiplication", new Operand(15), stack.peek());
    }

    @Test
    public void testHandleWithEmptyStack() 
    {
        multiply.handle(stack);
        assertEquals("Expected stack size after handling empty stack", 0, stack.size());
    }

    @Test
    public void testHandleWithInsufficientTokens() 
    {
        stack.push(new Operand(5));
        multiply.handle(stack);
        assertEquals("Expected stack size after handling insufficient tokens", 1, stack.size());
    }
}
