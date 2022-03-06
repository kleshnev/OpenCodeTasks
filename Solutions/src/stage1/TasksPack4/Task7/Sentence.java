package stage1.TasksPack4.Task7;

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

    public Word[] getWords(){
        return words;
    }
    public Word getWordByPosition(int pos) {
        return words[pos];
    }

}
