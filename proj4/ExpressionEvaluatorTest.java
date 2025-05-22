package proj4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * 
 * This class tests the ExpressionEvaluator class.
 * 
 * @author Kaito Nguyen 
 * @version May 21st 2025, Spring 2025
 */

public class ExpressionEvaluatorTest 
{
    @Rule
    public Timeout timeout = Timeout.millis(100);
    
    private ExpressionEvaluator evaluator;

    @Before
    public void setUp() throws Exception 
    {
        evaluator = new ExpressionEvaluator();
    }

    @After
    public void tearDown() throws Exception 
    {
        evaluator = null;
    }

    @Test
    public void testEvaluate() 
    {
        String expression = "((3+4)*2)";
        int result = Integer.parseInt(evaluator.evaluateString(expression));
        assertEquals("Expected evaluation result", 14, result);
    }

    @Test
    public void testEvaluateWithNegativeNumbers() 
    {
        String expression = "((-3+4)*2)";
        int result = Integer.parseInt(evaluator.evaluateString(expression));
        assertEquals("Expected evaluation result with negative numbers", 2, result);
    }

    @Test
    public void testEvaluateWithNestedExpressions() 
    {
        String expression = "((3+(4*2))-1)";
        int result = Integer.parseInt(evaluator.evaluateString(expression));
        assertEquals("Expected evaluation result with nested expressions", 10, result);
    }

    @Test
    public void testEvaluateWithDivision() 
    {
        String expression = "((8/4)+2)";
        int result = Integer.parseInt(evaluator.evaluateString(expression));
        assertEquals("Expected evaluation result with division", 4, result);
    }

    @Test
    public void testEvaluateWithExponentiation() 
    {
        String expression = "(2^3)";
        int result = Integer.parseInt(evaluator.evaluateString(expression));
        assertEquals("Expected evaluation result with exponentiation", 8, result);
    }

    @Test
    public void testEvaluateWithInvalidExpression() 
    {
        String expression = "(3+4*2";
        String result = evaluator.evaluateString(expression);
        assertEquals("Expected evaluation result with invalid expression", "", result);
    }

    @Test
    public void testEvaluateWithEmptyExpression() 
    {
        String expression = "";
        String result = evaluator.evaluateString(expression);
        assertEquals("Expected evaluation result with empty expression", "", result);
    }

    @Test
    public void testEvaluateWithSingleOperand() 
    {
        String expression = "5";
        int result = Integer.parseInt(evaluator.evaluateString(expression));
        assertEquals("Expected evaluation result with single operand", 5, result);
    }
}
