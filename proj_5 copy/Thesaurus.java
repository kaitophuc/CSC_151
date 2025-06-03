package proj5;
/**
 * Thesaurus class allows adding synonyms and checking if a synonym exists in the thesaurus.
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class Thesaurus {
    /**
     * Default constructor that initializes an empty thesaurus.
     */
    public Thesaurus() {
    }

    public Thesaurus(java.lang.String file) {
    }

    /**
     * Inserts a synonym into the thesaurus.
     * 
     * @param synonym the synonym to insert
     */
    public void insert(java.lang.String entry,
                   java.lang.String[] syns)  {
    }

    /**
     * Deletes a synonym from the thesaurus.
     * @param key the key of the synonym to delete
     */
    public void delete(java.lang.String entry) {
    }
    
    /**
     * Gets random synonym for a given word.
     * @param word the word to find a random synonym for
     * @return a random synonym for the word, or null if no synonyms are found
     */
    public java.lang.String getSynonymFor(java.lang.String keyword) {
        return ""; 
    }

    /**
     * toString method to represent the thesaurus.
     * @return a string representation of the thesaurus
     */
    @Override
    public java.lang.String toString() {
        return "";
    }
}