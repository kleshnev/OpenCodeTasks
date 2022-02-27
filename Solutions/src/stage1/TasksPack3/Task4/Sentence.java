package stage1.TasksPack3.Task4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sentence {
    private Word[] words;

    public Sentence(String[] words) {
        this.words = Arrays
                .stream(words)
                .map(Word::new)
                .toArray(Word[]::new);
    }


    public int getWordsCount() {
        return words.length;
    }

    public String getOriginalSentence() {
        return Arrays.stream(words)
                .map(Word::getOriginalWord)
                .collect(Collectors.joining(" "));

    }

    public Word getWordByPosition(int pos) {
        return words[pos];
    }
}
