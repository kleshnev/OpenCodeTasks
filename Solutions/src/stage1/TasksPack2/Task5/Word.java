package stage1.TasksPack2.Task5;

public class Word {
    private final char[] symbols;

    public Word(String word) {
        if (word == null || word.equals("")) {
            throw new IllegalArgumentException("Строка не может быть пустой");
        }
        symbols = word.toCharArray();
    }

    public int getSymbolsCount() {
        return symbols.length;
    }

    public String getOriginalWord() {
        return String.valueOf(symbols);
    }

}
