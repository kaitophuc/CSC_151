package proj5;

public class ThesaurusNode implements Comparable<ThesaurusNode> {
    private String word; // The word for which synonyms are stored
    private String[] synonyms; // Array of synonyms for the word

    /**
     * Default constructor that initializes the ThesaurusNode with a word and its synonyms.
     * @param word the word for which synonyms are stored
     * @param synonyms the array of synonyms for the word
     */
    public ThesaurusNode(String word, String[] synonyms) {
        this.word = word;
        this.synonyms = synonyms;
    }

    /**
     * Returns the word associated with this ThesaurusNode.
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * Returns the array of synonyms associated with this ThesaurusNode.
     * @return the array of synonyms
     */
    public String[] getSynonyms() {
        return synonyms;
    }

    /**
     * Compares this ThesaurusNode with another based on the word.
     * @param other the other ThesaurusNode to compare with
     * @return a negative integer, zero, or a positive integer as this node is less than, equal to, or greater than the specified node
     */
    public int compareTo(ThesaurusNode other) {
        return this.word.compareTo(other.word);
    }

    /**
     * Returns a string representation of the ThesaurusNode.
     * @return a string representation of the ThesaurusNode
     */
    public String toString() {
        return word;
    }
}
