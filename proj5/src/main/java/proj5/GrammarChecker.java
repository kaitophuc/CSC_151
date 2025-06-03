package proj5;

/**
 * The GrammarChecker class provides functionality to improve grammar
 * @author Kaito Nguyen
 * @version May 31st 2025, Spring 2025
 */

public class GrammarChecker {
    private final int threshold;
    private final Thesaurus thesaurus;

    /**
     * Default constructor that initializes the GrammarChecker with an empty thesaurus.
     */
    public GrammarChecker(String thesaurusFile, int threshold) {
        if (thesaurusFile == null || thesaurusFile.isEmpty()) {
            throw new IllegalArgumentException("Thesaurus file cannot be null or empty");
        }
        thesaurus = new Thesaurus(thesaurusFile);
        this.threshold = threshold;
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
        String originalWord = word;
        word = word.toLowerCase();
        word = word.trim();
        word = word.replaceAll("[^a-zA-Z]", "");
        if (word.isEmpty()) {
            return originalWord;
        }
        return word; 
    }

    /**
     * Format the first word to be the same as the second word.
     * @param word the word to format
     * @param formattedWord the formatted word to compare against
     * @return the formatted word if it matches the second word
     */
    private String formatWord(String word, String formattedWord) {
        if (word == null || word.isEmpty() || formattedWord == null || formattedWord.isEmpty()) {
            return word;
        }
        String formatted = word.toLowerCase();
        if (Character.isUpperCase(formattedWord.charAt(0))) {
            formatted = Character.toUpperCase(formatted.charAt(0)) + formatted.substring(1);
        }
        String punctuation = formattedWord.replaceAll("[a-zA-Z]", "");
        if (!punctuation.isEmpty()) {
            formatted += punctuation;
        }
        return formatted;
    }

    /**
     * Improves the grammar of the input file by checking for synonyms and word frequencies.
     * * @param textfile the file containing the text to improve
     * 
     */
    public void improveGrammar(String textfile) {
        if (textfile == null || textfile.isEmpty()) {
            throw new IllegalArgumentException("Text file cannot be null or empty");
        }
        WordCounter wordCounter = new WordCounter();
        wordCounter.findFrequencies(textfile);
        LineReader lineReader = new LineReader(textfile, " ");
        String ans = "";
        String[] words;
        while ((words = lineReader.getNextLine()) != null) {
            for (String word : words) {
                String formattedWord = formatWord(word);
                if (formattedWord.isEmpty()) {
                    ans += word + " ";
                    continue;
                }
                if (wordCounter.getFrequency(formattedWord) > threshold) {
                    String synonym = thesaurus.getSynonymFor(formattedWord);
                    if (synonym != "") {
                        ans += formatWord(synonym, word) + " ";
                    } else {
                        ans += word + " ";
                    }
                } else {
                    ans += word + " ";
                }
            }
            ans += "\n";
        }
        ans = ans.trim();
        System.out.println(ans);
        lineReader.close();
    }
}
