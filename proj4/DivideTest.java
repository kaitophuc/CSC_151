package proj4;

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
 * @version May 21st 2025, Spring 2025
 */

public class DivideTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    
    private Divide divide;
    private Stack<Token> stack;

    @Before
    public void setUp() throws Exception 
    {
        divide = new Divide();
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception 
    {
        divide = null;
        stack = null;
    }

    @Test
    public void testCompute() 
    {
        Operand op1 = new Operand(10);
        Operand op2 = new Operand(2);
        Operand result = divide.compute(op1, op2);
        assertEquals("Expected division result", 5, Integer.parseInt(result.toString()));
    }

    @Test
    public void testHandle() 
    {
        stack.push(new Operand(10));
        stack.push(new Divide());
        stack.push(new Operand(2));
        divide.handle(stack);
        assertEquals("Expected stack size after handling divide", 1, stack.size());
        assertEquals("Expected top of stack to be the result of division", new Operand(5), stack.peek());
    }

    @Test
    public void testHandleWithEmptyStack() 
    {
        divide.handle(stack);
        assertEquals("Expected stack size after handling empty stack", 0, stack.size());
    }
}
