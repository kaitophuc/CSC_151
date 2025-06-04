package proj5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrammarCheckerTest {
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String TEST_THESAURUS_FILE = currentDirectory + "/src/main/java/proj5/test_thesaurus.txt";
    private static final String TEST_INPUT_FILE = currentDirectory + "/src/main/java/proj5/test_input.txt";
    private static final String TEST_EMPTY_FILE = currentDirectory + "/src/main/java/proj5/test_empty.txt";
    private static final String TEST_THESAURUS_NO_MATCH = currentDirectory + "/src/main/java/proj5/test_thesaurus_nomatch.txt";
    private static final String TEST_INPUT_PUNCT_CASE = currentDirectory + "/src/main/java/proj5/test_punct_case.txt";

    @Test
    void coreReplacementLogic() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_FILE, 1);
        String output = checker.improveGrammarFile(TEST_INPUT_FILE);
        String[] lines = output.split("\n");

        assertEquals(2, lines.length);

        // Line 1: "This is a very very good test."
        String[] line1Words = lines[0].split(" ");
        assertEquals("This", line1Words[0]);
        assertNotEquals("very", line1Words[3].replaceAll("[^a-zA-Z]", ""));
        assertNotEquals("very", line1Words[4].replaceAll("[^a-zA-Z]", ""));
        assertEquals("good", line1Words[5].replaceAll("[^a-zA-Z]", ""));
        assertTrue(line1Words[6].startsWith("test"));

        // Line 2: "A little little lamb."
        String[] line2Words = lines[1].split(" ");
        assertEquals("A", line2Words[0]);
        assertNotEquals("little", line2Words[1].replaceAll("[^a-zA-Z]", ""));
        assertNotEquals("little", line2Words[2].replaceAll("[^a-zA-Z]", ""));
        assertTrue(line2Words[3].startsWith("lamb"));
    }

    @Test
    void noReplacementsIfThresholdNotMet() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_FILE, 2); 
        String output = checker.improveGrammarFile(TEST_INPUT_FILE);
        String expected = "This is a very very good test. \nA little little lamb.";
        assertEquals(expected, output);
    }

    @Test
    void noReplacementsIfSynonymsNotInThesaurus() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_NO_MATCH, 1);
        String output = checker.improveGrammarFile(TEST_INPUT_FILE);
        String expected = "This is a very very good test. \nA little little lamb.";
        assertEquals(expected, output);
    }

    @Test
    void emptyInputFileResultsInEmptyOutput() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_FILE, 1);
        String output = checker.improveGrammarFile(TEST_EMPTY_FILE);
        assertEquals("", output);
    }

    @Test
    void punctuationAndCasePreservation() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_FILE, 1);
        String output = checker.improveGrammarFile(TEST_INPUT_PUNCT_CASE);
        String[] words = output.split(" "); 

        // Original: "Very, very nice. Little little cat."
        // words[0] was "Very,"
        assertNotEquals("Very,", words[0]);
        assertTrue(Character.isUpperCase(words[0].charAt(0)), "Should retain initial capital for 'Very,'");
        assertTrue(words[0].endsWith(","), "Should retain comma for 'Very,'");

        // words[1] was "very"
        assertNotEquals("very", words[1].replaceAll("[^a-zA-Z]", ""));

        assertEquals("nice.", words[2]); 

        // words[3] was "Little"
        assertNotEquals("Little", words[3].replaceAll("[^a-zA-Z]", ""));
        assertTrue(Character.isUpperCase(words[3].charAt(0)), "Should retain initial capital for 'Little'");
        assertFalse(words[3].endsWith("."), "Should not have period if original 'Little' didn't");


        // words[4] was "little"
        assertNotEquals("little", words[4].replaceAll("[^a-zA-Z]", ""));
        
        assertEquals("cat.", words[5]); 
    }

    @Test
    void constructor_NullThesaurusFile_ThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new GrammarChecker(null, 1));
        assertEquals("Thesaurus file cannot be null or empty", e.getMessage());
    }

    @Test
    void constructor_EmptyThesaurusFile_ThrowsException() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> new GrammarChecker("", 1));
        assertEquals("Thesaurus file cannot be null or empty", e.getMessage());
    }

    @Test
    void improveGrammarFile_NullTextFile_ThrowsException() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_FILE, 1);
        Exception e = assertThrows(IllegalArgumentException.class, () -> checker.improveGrammarFile(null));
        assertEquals("Text file cannot be null or empty", e.getMessage());
    }

    @Test
    void improveGrammarFile_EmptyTextFile_ThrowsException() {
        GrammarChecker checker = new GrammarChecker(TEST_THESAURUS_FILE, 1);
        Exception e = assertThrows(IllegalArgumentException.class, () -> checker.improveGrammarFile(""));
        assertEquals("Text file cannot be null or empty", e.getMessage());
    }
}