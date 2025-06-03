package proj_5;

public class TestThesaurus {
    private Thesaurus thesaurus;
    public TestThesaurus() {
        thesaurus = new Thesaurus();
    }
    public void testInsert() {
        String[] synonyms = {"siuuu", "joyful", "cheerful"};
        thesaurus.insert("happy", synonyms);
        String synonym = thesaurus.getSynonymFor("happy");
        if (synonym != null) {
            System.out.println("Synonym for 'happy': " + synonym);
        } else {
            System.out.println("No synonym found for 'happy'");
        }
    }
    public void testDelete() {
        String[] synonyms = {"sad", "depressed"};
        thesaurus.insert("unhappy", synonyms);
        System.out.println("Inserted synonyms for 'unhappy'");
        System.out.println(thesaurus.toString());
        System.out.println("==========================");
        String[] synonym2 = {"joyful", "cheerful"};
        thesaurus.insert("happy", synonym2);
        System.out.println("Inserted synonyms for 'happy'");
        System.out.println(thesaurus.toString());
        System.out.println("==========================");
        thesaurus.delete("unhappy");
        System.out.println("Deleted synonyms for 'unhappy'");
        System.out.println(thesaurus.toString());
        System.out.println("==========================");
        thesaurus.delete("happy");
        System.out.println("Deleted synonyms for 'happy'");
        System.out.println(thesaurus.toString());
        System.out.println("==========================");
        thesaurus.delete("nonexistent");
        System.out.println("Tried to delete 'nonexistent' (should not change anything)");
        System.out.println(thesaurus.toString());   
    }

    public void testGetSynonymFor() {
        String[] synonyms = {"joyful", "cheerful"};
        thesaurus.insert("happy", synonyms);
        String synonym = thesaurus.getSynonymFor("happy");
        System.out.println("Random synonym for 'happy': " + synonym);
    }

    public void testLoadThesaurus() {
        thesaurus.loadThesaurus("proj_5/smallThesaurus.txt");
        if (thesaurus.isEmpty()) {
            System.out.println("Thesaurus is empty after loading.");
            return;
        }
        System.out.println("Thesaurus loaded from file.");
        String synonym = thesaurus.getSynonymFor("grungy");
        System.out.println("Random synonym for 'grungy': " + synonym);
    }

    public static void main(String[] args) {
        TestThesaurus test = new TestThesaurus();
        test.testDelete();
    }
}
