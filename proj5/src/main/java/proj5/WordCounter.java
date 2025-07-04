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

    private BSTNode<WordCounterNode> search(String word) {
        WordCounterNode wordNode = new WordCounterNode(word);
        return wordCountTree.search(wordNode);
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
                    BSTNode<WordCounterNode> node = search(word);
                    if (node != null) {
                        node.element.incrementCount();
                    } else {
                        WordCounterNode wordCounterNode = new WordCounterNode(word);
                        wordCountTree.insert(wordCounterNode);
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
        BSTNode<WordCounterNode> node = search(word);
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
            ans += word + ": " + search(word).element.getCount() + "\n";
        }
        return ans;
    }
}
