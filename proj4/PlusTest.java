package proj4;
/**
 * JUnit test class.  Use these tests as models for your own.
 */

import java.util.concurrent.TimeUnit;

import junit5.documentation.src.test.java.example.FastTest;

import java.beans.Transient;

public class PlusTest 
{
    @Rule // a test will fail if it takes longer than 1/10 of a second to run
  	public Timeout timeout = Timeout.millis(100);

    //Test compute method
    // The compute method should return the sum of two operands
    @Test
    public void testCompute() 
    {
        Plus plus = new Plus();
        Operand op1 = new Operand(5);
        Operand op2 = new Operand(10);
        Operand result = plus.compute(op1, op2);
        assertEquals(15, Integer.parseInt(result.toString()));
    }

    //Test handle method
    // The handle method should pop three tokens from the stack, compute the sum of the first and third tokens,
    // and push the result back onto the stack
    @Test
    public void testHandle() 
    {
        Stack<Token> stack = new Stack<Token>();
        Operand op1 = new Operand(5);
        Operand op2 = new Operand(10);
        Operand op3 = new Operand(15);
        stack.push(op1);
        stack.push(op2);
        stack.push(op3);
        
        Plus plus = new Plus();
        plus.handle(stack);
        
        assertEquals(25, Integer.parseInt(stack.pop().toString()));
        Operand result = (Operand) stack.pop();
        assertEquals(25, Integer.parseInt(result.toString()));
        assertEquals(0, stack.size());
    }
}
