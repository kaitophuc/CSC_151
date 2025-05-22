package proj4;

/**
 * This class implements an operand token.
 * @author Kaito Nguyen
 * @version May 21st 2025, Spring 2025
 * I confirm that I have read the course academic integrity policy and that I am not in violation.
 */
public class Operand implements Token
{
    private String value;
    /**
     * non-default constructor
     *
     * @param value number that this Operand represents
     */
    public Operand(String value)
    {
        this.value = value;
    }

    /**
     * non-default constructor
     *
     * @param value number that this Operand represents
     */
    public Operand(int value)
    {
        this.value = Integer.toString(value);
    }

    /**
     * The handle method. Just add it to the stack.
     * @param s the Stack the token uses when processing itself.
     */
    public void handle(Stack<Token> s)
    {
        s.push(this);
    }

    /**
     * The toString method returns the string representation of the operand.
     * @return the string representation of the operand
     */
    public String toString()
    {
        return value;
    }
}
