import com.swabunga.spell.engine.SpellDictionary;
import com.swabunga.spell.engine.SpellDictionaryHashMap;
import com.swabunga.spell.event.SpellChecker;
import com.swabunga.spell.event.StringWordTokenizer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class GenerateWord {
    private static List<String> checkedWord = new ArrayList<>();

    private static void generateString(String input, String result) throws IOException {
        if (input.isEmpty()) {
//           out.println(result);
            checkSpell(result);
           return;
        }
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            String res = left + right;
            generateString(res, result + c);
        }
    }

    /**
     * Check spelling word English
     * @param word Word
     * @throws IOException IOException
     */
    private static void checkSpell(String word) throws IOException {
        SpellChecker spellCheck;
        SpellDictionary dictionary = new SpellDictionaryHashMap(new File("src/main/java/english.0"), null);
        spellCheck = new SpellChecker(dictionary);
        if (spellCheck.checkSpelling(new StringWordTokenizer(word.toLowerCase())) == -1) {
            if (!checkedWord.contains(word)) {
                checkedWord.add(word);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String test = "GLORY";
        String result = "";
        generateString(test, result);
        out.println(checkedWord.toString());
    }
}

