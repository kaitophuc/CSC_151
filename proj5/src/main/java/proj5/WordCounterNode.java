package proj5;
/**
 * WordCounterNode class represents a node in a word counting system. 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class WordCounterNode implements Comparable<WordCounterNode> {
    private final String word; // The word being counted
    private int count; // The count of occurrences of the word

    /**
     * Default constructor that initializes the WordCounterNode with a word and a count of 1.
     * @param word the word to be counted
     */
    public WordCounterNode(String word) {
        this.word = word;
        this.count = 1;
    }

    /**
     * Returns the word associated with this WordCounterNode.
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the count of occurrences of the word.
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * Increments the count of occurrences of the word by 1.
     */
    public void incrementCount() {
        count++;
    }

    /**
     * Compares this WordCounterNode with another based on the word.
     * @param other the other WordCounterNode to compare with
     * @return a negative integer, zero, or a positive integer as this node is less than, equal to, or greater than the specified node
     */
    @Override
    public int compareTo(WordCounterNode other) {
        return this.word.compareTo(other.word);
    }

    /**
     * Returns a string representation of the WordCounterNode.
     * @return a string representation of the WordCounterNode
     */
    @Override
    public String toString() {
        return word;
    }
    
}
