package proj5;
/**
 * Thesaurus class allows adding synonyms and checking if a synonym exists in the thesaurus.
 * 
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class Thesaurus {
    private BinarySearchTree<String, String[]> synonyms; // Binary search tree to store synonyms

    /**
     * Default constructor that initializes an empty thesaurus.
     */
    public Thesaurus() {
        synonyms = new BinarySearchTree<>();
    }

    /**
     * Non default constructor
     */
    public Thesaurus (String fileName) {
        synonyms = new BinarySearchTree<>();
        loadThesaurus(fileName);
    }

    /**
     * Inserts a synonym into the thesaurus.
     * 
     * @param synonym the synonym to insert
     */
    public void insert(String key, String[] synonym)  {
        if (synonym == null || synonym.length == 0 || key == null || key.isEmpty()) {
            return;
        }
        BSTNode<String, String[]> existingNode = synonyms.search(key);
        if (existingNode != null) {
            String[] existingSynonyms = existingNode.value;
            String[] newSynonyms = new String[existingSynonyms.length + synonym.length];
            for (int i = 0; i < existingSynonyms.length; i++) {
                newSynonyms[i] = existingSynonyms[i];
            }
            for (int i = 0; i < synonym.length; i++) {
                newSynonyms[existingSynonyms.length + i] = synonym[i];
            }
            synonyms.insert(key, newSynonyms);
        }
        else {
            synonyms.insert(key, synonym);
        }
    }

    /**
     * Gets the synonyms for a given word.
     * @param word the word to find synonyms for
     * @return an array of synonyms for the word, or null if no synonyms are found
     */
    private String[] getSynonyms(String word) {
        BSTNode<String, String[]> node = synonyms.search(word);
        if (node != null) {
            return node.value;
        }
        return null; 
    }

    /**
     * Gets random synonym for a given word.
     * @param word the word to find a random synonym for
     * @return a random synonym for the word, or null if no synonyms are found
     */
    public String getSynonymFor(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }

        String[] synonymsArray = getSynonyms(word);
        if (synonymsArray != null && synonymsArray.length > 0) {
            int randomIndex = (int) (Math.random() * synonymsArray.length);
            return synonymsArray[randomIndex];
        }
        return ""; 
    }

    /**
     * Deletes a synonym from the thesaurus.
     * @param key the key of the synonym to delete
     */
    public void delete(String key) {
        if (key == null || key.isEmpty()) {
            return;
        }
        synonyms.delete(key);
    }

    /**
     * toString method to represent the thesaurus.
     * @return a string representation of the thesaurus
     */
    public String toString() {
        String ans = "";
        for (String key : synonyms.inOrderTraversal()) {
            String[] values = synonyms.search(key).value;
            ans += key + " - {";
            for (int i = 0; i < values.length; i++) {
                ans += values[i];
                if (i < values.length - 1) {
                    ans += ", ";
                }
            }
            ans += "}\n";
        }
        return ans;
    }

    /**
     * Checks if the thesaurus is empty.
     * @return true if the thesaurus is empty, false otherwise
     */
    public boolean isEmpty() {
        return synonyms.isEmpty();
    }

    /**
     * Load the thesaurus from a file.
     * @param filePath the path to the thesaurus file
     * @return true if the thesaurus was loaded successfully, false otherwise
     */
    public boolean loadThesaurus(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        LineReader lineReader = new LineReader(filePath, ",");
        
        String[] words;
        while ((words = lineReader.getNextLine()) != null) {
            if (words.length > 1) {
                String key = words[0];
                String[] synonymsArray = new String[words.length - 1];
                for (int i = 1; i < words.length; i++) {
                    synonymsArray[i - 1] = words[i];
                }
                insert(key, synonymsArray); 
            }
        }
        lineReader.close();
        return true; 
    }

    /**
     * Return size of the Thesaurus
     * @return int
     */
    public int size() {
        return synonyms.size();
    }
}