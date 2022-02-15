package stage1.TasksPack2.Task5;

import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
    private final Word[] words;

    public Sentence(String[] words) {

        ArrayList<Word> list = new ArrayList<>();
        for (String word : words)
            list.add(new Word(word));
        this.words = list.toArray(new Word[words.length]);
    }

    public int getWordsCount() {
        return words.length;
    }

    public String getOriginalSentence() {
        return Arrays.toString(words);
    }

    public Word getWordByPosition(int pos) {
        return words[pos];
    }
}
