package proj4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Exponent class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 */

public class ExponentTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    
    private Exponent exponent;
    private Stack<Token> stack;

    @Before
    public void setUp() throws Exception 
    {
        exponent = new Exponent();
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception 
    {
        exponent = null;
        stack = null;
    }

    @Test
    public void testCompute() 
    {
        Operand op1 = new Operand(2);
        Operand op2 = new Operand(3);
        Operand result = exponent.compute(op1, op2);
        assertEquals("Expected exponentiation result", 8, Integer.parseInt(result.toString()));
    }

    @Test
    public void testHandle() 
    {
        stack.push(new Operand(2));
        stack.push(new Exponent());
        stack.push(new Operand(3));
        exponent.handle(stack);
        assertEquals("Expected stack size after handling exponent", 1, stack.size());
        assertEquals("Expected top of stack to be the result of exponentiation", new Operand(8), stack.peek());
    }

    @Test
    public void testHandleWithEmptyStack() 
    {
        exponent.handle(stack);
        assertEquals("Expected stack size after handling empty stack", 0, stack.size());
    }
    
}
