package proj5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ThesaurusTest {
    private final Thesaurus thesaurus = new Thesaurus();
    String currentDir = System.getProperty("user.dir");

    @Test
    void testInsert() {
        String[] synonym = {"b", "c", "d"};
        String[] add = {"e", "f", "g"};
        thesaurus.insert("a", synonym);
        assertEquals("a - {b, c, d}\n", thesaurus.toString());
        thesaurus.insert("a", add);
        assertEquals("a - {b, c, d, e, f, g}\n", thesaurus.toString());
        thesaurus.insert("b", add);
        String expected = "a - {b, c, d, e, f, g}\nb - {e, f, g}\n";
        assertEquals(expected, thesaurus.toString());
        thesaurus.insert("", add);
        assertEquals(expected, thesaurus.toString());
    }

    @Test
    void testGetSynonymFor() {
        String[] synonym = {"b", "c", "d"};
        thesaurus.insert("a", synonym);
        String getSynonym = thesaurus.getSynonymFor("a");
        assertTrue(Arrays.asList(synonym).contains(getSynonym));
        String getSynonym2 = thesaurus.getSynonymFor("b");
        assertFalse(Arrays.asList(synonym).contains(getSynonym2));
        String getSynonym3 = thesaurus.getSynonymFor("c");
        assertEquals("", getSynonym3);
    }

    @Test
    void delete() {
        String[] synonym = {"b", "c", "d"};
        thesaurus.insert("a", synonym);
        thesaurus.insert("b", synonym);
        thesaurus.insert("c", synonym);
        thesaurus.insert("d", synonym);
        thesaurus.delete("a");
        String deleteSynonym = "b - {b, c, d}\nc - {b, c, d}\nd - {b, c, d}\n";
        assertEquals(deleteSynonym, thesaurus.toString());
        thesaurus.delete("b");
        thesaurus.delete("c");
        assertEquals("d - {b, c, d}\n", thesaurus.toString());
        thesaurus.delete("c");
        assertEquals("d - {b, c, d}\n", thesaurus.toString());
        thesaurus.delete("");
        assertEquals("d - {b, c, d}\n", thesaurus.toString());
        thesaurus.delete("d");
        assertEquals("", thesaurus.toString());
    }

    @Test
    void testToString() {
        String[] synonym = {"b", "c", "d"};
        thesaurus.insert("a", synonym);
        assertEquals("a - {b, c, d}\n", thesaurus.toString());
    }

    @Test
    void testIsEmpty() {
        String[] synonym = {"b", "c", "d"};
        thesaurus.insert("a", synonym);
        assertFalse(thesaurus.isEmpty());
        thesaurus.delete("a");
        assertTrue(thesaurus.isEmpty());
    }

    @Test
    void testLoadSmallThesaurus() {
        String dir = currentDir + "/src/main/java/proj5/smallThesaurus.txt";
        assertTrue(thesaurus.loadThesaurus(dir));
        assertEquals(11, thesaurus.size());
        thesaurus.delete("terrific");
        assertEquals(10, thesaurus.size());
        thesaurus.delete("ajhsfhidsa");
        assertEquals(10, thesaurus.size());
        thesaurus.delete("grungy");
        assertEquals(9, thesaurus.size());
        thesaurus.delete("grungy");
        assertEquals(9, thesaurus.size());
    }

    @Test
    void testLoadBigThesaurus() {
        String dir = currentDir + "/src/main/java/proj5/bigThesaurus.txt";
        assertTrue(thesaurus.loadThesaurus(dir));
        assertEquals(5006, thesaurus.size());
        thesaurus.delete("terrific");
        assertEquals(5005, thesaurus.size());
        thesaurus.delete("ajhsfhidsa");
        assertEquals(5005, thesaurus.size());
        thesaurus.delete("grungy");
        assertEquals(5004, thesaurus.size());
        thesaurus.delete("fraud");
        String synonym = thesaurus.getSynonymFor("fraud");
        assertEquals(5003, thesaurus.size());
        assertEquals("", synonym);
    }
}