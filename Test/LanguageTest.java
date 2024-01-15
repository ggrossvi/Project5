import Language.Language;
import org.junit.Assert;
import org.junit.Test;
import Language.Type;

public class LanguageTest {
    @Test
    public void TestFindShortestKwdLength(){
        String [] keywords = {"if", "do", "while"};
        Language language1 = new Language("name","c.txt", Type.COMPILED);
        language1.setKeywords(keywords);
        language1.findShortestKwdLength();
        Assert.assertEquals( language1.findShortestKwdLength(),Integer.valueOf(2));
    }

    @Test
    public void TestFindLongestKwdLength(){
        String [] keywords = {"if", "do", "while"};
        Language language1 = new Language("name","c.txt", Type.COMPILED);
        language1.setKeywords(keywords);
        Assert.assertEquals( language1.findLongestKwdLength(),Integer.valueOf(5));
    }

    @Test
    public void sortKwds(){
        String [] keywords = {"if", "do", "while"};
        String [] srtedKeywords = {"do", "if", "while"};
        Language language1 = new Language("name","c.txt", Type.COMPILED);
        language1.setKeywords(keywords);
        language1.sortKwds();
        Assert.assertArrayEquals(language1.getKeywords(),srtedKeywords);
    }
}
