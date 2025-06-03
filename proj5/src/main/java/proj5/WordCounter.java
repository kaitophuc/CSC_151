package proj5;
/**
 * WordCounter class allows adding word and checking the count of a word.
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class WordCounter {
    private final BinarySearchTree<WordCounterNode> wordCountTree; // Binary search tree to store word counts

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
            return word;
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
                if (word != null && !word.isEmpty()) {
                    WordCounterNode wordNode = new WordCounterNode(word);
                    BSTNode<WordCounterNode> node = wordCountTree.search(wordNode);
                    if (node != null) {
                        node.element.incrementCount();
                    } else {
                        wordCountTree.insert(wordNode);
                    }
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
            return 0;
        }
        WordCounterNode wordNode = new WordCounterNode(word);
        BSTNode<WordCounterNode> node = wordCountTree.search(wordNode);
        if (node != null) {
            return node.element.getCount();
        }
        return 0; 
    }

    /**
     * toString method to return a string representation of the word counter.
     */
    public String toString() {
        String ans = "";
        for (String word : wordCountTree.inOrderTraversal()) {
            ans += word + ": " + wordCountTree.search(new WordCounterNode(word)).element.getCount() + "\n";
        }
        return ans;
    }
}
