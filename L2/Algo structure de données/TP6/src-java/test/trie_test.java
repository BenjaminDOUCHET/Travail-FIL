import org.junit.*;
import static org.junit.Assert.*;
import tri.*;

public class TrieTest {	

    @Test
    public void testAddIci() {
        Trie t = new Trie();
        t.add("ici");
        t.add("citron");
        assserTrue(t.contains("ici"));
    }

    @Test
    public void testContainIci() {
        Trie t = new Trie();
        t.add("ici");
        t.add("citron");
        assserTrue(t.contains("ici"));
    }

    @Test
    public void testNotContainIci() {
        Trie t = new Trie();
        t.add("icitron");
        assserFalse(t.contains("ici"));
    }

    @Test
    public void testAddPomme() {
        Trie t = new Trie();
        t.add("pomme");
        t.add("citron");
        assserTrue(t.contains("pomme"));
    }

    @Test
    public void testContainPomme() {
        Trie t = new Trie();
        t.add("poire");
        t.add("pomme");
        assserTrue(t.contains("pomme"));
    }

    @Test
    public void testContainPommeAndPoire() {
        Trie t = new Trie();
        t.add("paco");
        t.add("patrick");
        t.add("pomme");
        t.add("poire");
        assserTrue(t.contains("poire") && t.contains("pomme"));
    }

    @Test
    public void testNotContainPomme() {
        Trie t = new Trie();
        t.add("pommier");
        assserFalse(t.contains("pomme"));
    }
    
}

