package proj5;
/**
 * WordCounter class allows adding word and checking the count of a word.
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class WordCounter {
    private BinarySearchTree<String, Integer> wordCountTree; // Binary search tree to store word counts

    /**
     * Default constructor that initializes an empty word counter.
     */
    public WordCounter() {
        wordCountTree = new BinarySearchTree<>();
    }

    /**
     * Formats a word by converting it to lowercase, trimming whitespace, deleting punctuation, etc.
     * @param word the word to format
     * @return the formatted word
     */
    private String formatWord(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        String originalWord = word; // Store the original word for error messages
        word = word.toLowerCase();
        word = word.trim();
        word = word.replaceAll("[^a-zA-Z]", "");
        if (word.isEmpty()) {
            return originalWord;
        }
        return word; 
    }

    /**
     * Inserts a word into the word counter or increments its count if it already exists.
     * 
     * @param word the word to insert or increment
     */
    private void findFrequencies(String word, int count) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        BSTNode<String, Integer> node = wordCountTree.search(word);
        if (node != null) {
            node.value++;
        } else {
            wordCountTree.insert(word, count);
        }
    }

    /**
     * Adds words from file to the word counter.
     * 
     * @param word the word to add
     */
    public void findFrequencies(String fileString) {
        LineReader lineReader = new LineReader(fileString, " ");
        String[] words;
        while ((words = lineReader.getNextLine()) != null) {
            for (String word : words) {
                word = formatWord(word); 
                // Check if the 
                if (word != null && !word.isEmpty()) {
                    findFrequencies(word, 1);
                }
            }
        }
        lineReader.close();
    }

    /**
     * Gets the count of a specific word.
     * 
     * @param word the word to get the count for
     * @return the count of the word, or 0 if the word does not exist
     */
    public int getFrequency(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        BSTNode<String, Integer> node = wordCountTree.search(word);
        if (node != null) {
            return node.value; 
        }
        return 0; 
    }

    /**
     * toString method to return a string representation of the word counter.
     */
    public String toString() {
        String ans = "";
        for (String word : wordCountTree.inOrderTraversal()) {
            int count = getFrequency(word);
            ans += word + ": " + count + "\n"; 
        }
        return ans;
    }
}
