package proj4;

/**
 * This class implements a multiply token.
 * 
 * @author Kaito Nguyen
 * @version May 21st 2025, Spring 2025
 * I confirm that I have read the course academic integrity policy and that I am not in violation.
 */
public class Multiply implements Token 
{
    /**
     * The constructor for the multiply token.
     */
    public Multiply() {
        // No initialization needed for this token
    }

    /**
     * Compute the sum of two operands.
     * @param op1
     * @param op2
     * @return the sum of the two operands
     */
    public Operand compute(Operand op1, Operand op2)
    {
        int num1 = Integer.parseInt(op1.toString());
        int num2 = Integer.parseInt(op2.toString());
        return new Operand(num1 * num2);
    }

    /**
     * The handle method. Just add it to the stack.
     * @param s the Stack the token uses when processing itself.
     */
    public void handle(Stack<Token> s)
    {
        Token third = s.pop();
        Token second = s.pop();
        Token first = s.pop();
        Token result = compute((Operand) first, (Operand) third);
        s.push(result);
    }
    
    /**
     * The toString method returns the string representation of the multiply token.
     * @return the string representation of the multiply token
     */
    public String toString()
    {
        return "*";
    }
}
