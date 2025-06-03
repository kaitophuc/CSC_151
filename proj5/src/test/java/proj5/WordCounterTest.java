package proj5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {
    private final WordCounter wordCounter = new WordCounter();
    String currentDir = System.getProperty("user.dir");

    @Test
    void findFrequenciesAndFrequency() {
        String filePath = currentDir + "/src/main/java/proj5/apartment.txt";
        wordCounter.findFrequencies(filePath);
        assertEquals(5, wordCounter.getFrequency("grungy"));
        assertEquals(7, wordCounter.getFrequency("was"));
        assertNotEquals(3, wordCounter.getFrequency("grungy,"));
        assertEquals(0, wordCounter.getFrequency(""));
        assertEquals(0, wordCounter.getFrequency("$#%^&*("));
    }

    @Test
    void testToString() {
        String filePath = currentDir + "/src/main/java/proj5/apartment.txt";
        wordCounter.findFrequencies(filePath);
        String ans = "--: 1\n" +
                "all: 1\n" +
                "and: 1\n" +
                "apartment: 1\n" +
                "been: 1\n" +
                "could: 2\n" +
                "even: 1\n" +
                "floor: 1\n" +
                "fridge: 1\n" +
                "grass: 1\n" +
                "grungy: 5\n" +
                "have: 1\n" +
                "how: 1\n" +
                "i: 3\n" +
                "insane: 3\n" +
                "is: 1\n" +
                "it: 1\n" +
                "live: 1\n" +
                "outside: 1\n" +
                "so: 1\n" +
                "sofa: 1\n" +
                "that: 2\n" +
                "the: 5\n" +
                "think: 2\n" +
                "this: 1\n" +
                "totally: 1\n" +
                "was: 7\n" +
                "when: 1\n" +
                "where: 1\n" +
                "would: 1\n" +
                "year: 1\n";
        assertEquals(ans, wordCounter.toString());
    }
}