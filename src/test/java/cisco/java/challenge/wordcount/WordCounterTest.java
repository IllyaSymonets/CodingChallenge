package cisco.java.challenge.wordcount;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class WordCounterTest {

    WordCounter wordCounter = new WordCounter();

    @Test
    public void countWords() throws IOException {
        Map<String, Integer> result =
                wordCounter.showResult(wordCounter.countWords(
                        "src/test/resources/textExample.txt"));

        Assert.assertTrue((result.entrySet().size() == 7)
                && (result.get("far") == 3) && (result.get("the") == 2)
                && (result.get("behind") == 1) && (result.get("away") == 1)
                && (result.get("word") == 1) && (result.get("from") == 1)
                && (result.get("mountains") == 1));

    }
}