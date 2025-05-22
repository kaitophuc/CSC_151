package proj4;

/**
 * This class implements a right parenthesis token.
 * 
 * @author Kaito Nguyen
 * @version May 21st 2025, Spring 2025
 * I confirm that I have read the course academic integrity policy and that I am not in violation.
 */
public class RightParen implements Token
{
    /**
     * The constructor for the right parenthesis token.
     */
    public RightParen() 
    {
        // No initialization needed for this token
    }

    /**
     * Processes the current token.
     * @param s the Stack the token uses when processing itself.
     */
    public void handle(Stack<Token> s) 
    {
        // Pop the last 3 tokens from the stack. Check for size first
        if (s.isEmpty() || s.size() < 3) 
        {
            System.out.println("Error: Not enough tokens to process.");
            System.out.println("Stack: " + s);
            return;
        }
        Token first = s.pop();
        Token second = s.pop();
        Token third = s.pop();
        
        // Check if the popped tokens are valid
        boolean firstIsOperand = first instanceof Operand;
        boolean secondIsOperator = !(second instanceof Operand);
        boolean thirdIsOperand = third instanceof Operand;
        
        
        // Push the tokens back to the stack
        s.push(third);
        s.push(second);
        s.push(first);

        if (firstIsOperand && secondIsOperator && thirdIsOperand) 
        {
            second.handle(s);
            System.out.println("Processed: " + third + " " + second + " " + first);
            System.out.println("Stack: " + s);
        } 
        
        else 
        {
            System.out.println("Error: Invalid tokens for processing.");
            System.out.println("Stack: " + s);
            return;
        }
    }

    /**
     * Returns the token as a printable String
     * 
     * @return the String version of the token.  For example, ")"
     * for a right parenthesis.
     */
    public String toString() 
    {
        return ")";
    }
}
