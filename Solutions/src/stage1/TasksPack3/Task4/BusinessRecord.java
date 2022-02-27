package stage1.TasksPack3.Task4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BusinessRecord extends Sentence {

    private ArrayList<Word> words = new ArrayList<>();
    private LocalDateTime executeDate;
    private final LocalDateTime createdWhen;

    public BusinessRecord(String[] words, LocalDateTime executeDate) {
        super(words);
        for (String str : words) {
            this.words.add(new Word(str));
        }
        this.executeDate = executeDate;
        this.createdWhen = LocalDateTime.now();
    }

    public String getWordsAsString() {
        return words.stream()
                .map(Word::getOriginalWord)
                .collect(Collectors.joining(" "));
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public void setExecuteDate(LocalDateTime time) {
        executeDate = time;
    }

    public LocalDateTime getExecuteDate() {
        return executeDate;
    }

    public LocalDateTime getCreatedWhen() {
        return createdWhen;
    }
}
