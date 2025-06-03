package proj5;

public class GrammarCheckerTest {
    /**
     * The name of the thesaurus file used for testing.
     */
    public static final String currentDir = System.getProperty("user.dir");
    public static final String THESAURUS_FILE = currentDir + "/proj5/src/main/java/proj5/bigThesaurus.txt";
    public static final String TEST_FILE = currentDir + "/proj5/src/main/java/proj5/apartment.txt";
    public static final int THRESHOLD = 2;
    
    public static void main(String[] args) {
        GrammarChecker grammarChecker = new GrammarChecker(THESAURUS_FILE, THRESHOLD);
        grammarChecker.improveGrammar(TEST_FILE);
    }
}
