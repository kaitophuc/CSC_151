package proj4;

import java.util.Deque;

/**
 * This class implements a stack of generic objects.  
 * The stack is a last-in-first-out (LIFO) data structure.
 * 
 * @author Kaito Nguyen
 * @version May 21st 2025, Spring 2025
 * I confirm that I have read the course academic integrity policy and that I am not in violation.
 */
public class Stack<T>
{
    /**
     * The stack is implemented using a Deque.  
     */
    private Deque<T> stack;
    /**
     * Constructor for objects of class Stack
     * @return a new stack
     */
    public Stack() 
    {
       stack = new java.util.ArrayDeque<T>();
    }

    /**
     * Returns true if the stack is empty, false otherwise.
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() 
    {
        return stack.isEmpty();
    }

    /**
     * Pushes a value onto the stack.
     * @param value
     */
    public void push(T value) 
    {
        stack.push(value);
    }

    /**
     * Pops a value off the stack.
     * @return the value popped off the stack
     */
    public T pop() 
    {
        return stack.pop();
    }

    /**
     * Peeks at the top value of the stack.
     * Looks at the value at the top of the stack without removing it.
     * @return the value at the top of the stack
     */
    public T peek() 
    {
        return stack.peek();
    }

    /**
     * Returns the number of elements in the stack.
     * @return the number of elements in the stack
     */
    public int size() 
    {
        return stack.size();
    }

    /**
     * return stack as a printable string
     * @return string in the form {>A, B, C} where > denotes the stack top
     */
    public String toString() 
    {
    	String ans = "{>";
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (i == stack.size() - 1) 
            {
                ans += stack.getFirst();
            } 
            
            else 
            {
                ans += ", " + stack.getFirst();
            }
            stack.addLast(stack.removeFirst());
        }
        ans += "}";
        return ans;
    }
    
} 
   

