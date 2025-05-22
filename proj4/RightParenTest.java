package proj4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the RightParen class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 */

public class RightParenTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    
    private Stack<Token> stack;
    private RightParen rightParen;

    @Before
    public void setUp() throws Exception 
    {
        stack = new Stack<Token>();
        rightParen = new RightParen();
    }

    @After
    public void tearDown() throws Exception 
    {
        stack = null;
        rightParen = null;
    }

    @Test
    public void testHandleWithValidTokens() 
    {
        stack.push(new Operand(5));
        stack.push(new Exponent());
        stack.push(new Operand(2));
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling valid tokens", 1, stack.size());
    }

    @Test
    public void testHandleWithInvalidTokens() 
    {
        stack.push(new Operand(5));
        stack.push(new Operand(2));
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling invalid tokens", 3, stack.size());
    }

    @Test
    public void testHandleWithEmptyStack() 
    {
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling empty stack", 0, stack.size());
    }

    @Test
    public void testHandleWithInsufficientTokens() 
    {
        stack.push(new Operand(5));
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling insufficient tokens", 1, stack.size());
    }

    @Test
    public void testHandleWithNonOperatorToken() 
    {
        stack.push(new Operand(5));
        stack.push(new Operand(2));
        stack.push(new Operand(3));
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling non-operator token", 3, stack.size());
    }

    @Test
    public void testHandleWithInvalidTokenOrder() 
    {
        stack.push(new Operand(5));
        stack.push(new Operand(2));
        stack.push(new Exponent());
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling invalid token order", 3, stack.size());
    }

    @Test
    public void testHandleWithValidTokenOrder() 
    {
        stack.push(new Operand(5));
        stack.push(new Exponent());
        stack.push(new Operand(2));
        rightParen.handle(stack);
        assertEquals("Expected stack size after handling valid token order", 1, stack.size());
    }
}
