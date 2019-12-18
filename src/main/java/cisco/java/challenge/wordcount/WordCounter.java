package cisco.java.challenge.wordcount;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCounter {

    private Map<String, Integer> wordsCounted = new HashMap<String, Integer>();

    public Map<String, Integer> countWords(String pathOfFile) {
        String text = readFromFile(pathOfFile);
        ArrayList<String> vocabulary = getAllWords(text);
        int index = 0;
        while (!vocabulary.isEmpty()) {
            int beforeDeleting = vocabulary.size();
            final String word = vocabulary.get(index);
            vocabulary.removeIf(a -> (a.equalsIgnoreCase(word)));
            int afterDeleting = vocabulary.size();
            wordsCounted.put(word.toLowerCase(), beforeDeleting - afterDeleting);
        }
        return wordsCounted;
    }

    private String readFromFile(String pathOffile) {
        String textOfFile = new String("");
        try {
            textOfFile = String.valueOf(Files.readAllLines(Paths.get(pathOffile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textOfFile;
    }

    private ArrayList<String> getAllWords(String text) {
        ArrayList<String> words = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public Map<String, Integer> showResult(Map<String, Integer> result) {
        Map<String, Integer> sortedResult = sortResult(result);
        for (String word : sortedResult.keySet()) {
            System.out.println(word + " " + sortedResult.get(word));
        }
        return sortedResult;
    }

    private Map<String, Integer> sortResult(Map<String, Integer> result) {
        return result.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));
    }
}
