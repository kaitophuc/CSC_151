package proj4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the Operand class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 */

public class OperandTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    
    private Operand operand;
    private Stack<Token> stack;

    @Before
    public void setUp() throws Exception 
    {
        operand = new Operand(5);
        stack = new Stack<Token>();
    }

    @After
    public void tearDown() throws Exception 
    {
        operand = null;
        stack = null;
    }

    @Test
    public void testHandle() 
    {
        operand.handle(stack);
        assertEquals("Expected stack size after handling operand", 1, stack.size());
        assertEquals("Expected top of stack to be the operand", operand, stack.peek());
    }

    @Test
    public void testToString() 
    {
        assertEquals("Expected string representation of operand", "5", operand.toString());
    }

    @Test
    public void testNonDefaultConstructorWithInt() 
    {
        Operand operand3 = new Operand(15);
        assertEquals("Expected string representation of operand", "15", operand3.toString());
    }

    @Test
    public void testNonDefaultConstructorWithString() 
    {
        Operand operand4 = new Operand("20");
        assertEquals("Expected string representation of operand", "20", operand4.toString());
    }
}
