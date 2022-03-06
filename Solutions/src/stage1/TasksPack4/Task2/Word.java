package stage1.TasksPack4.Task2;

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

    public char[] getSymbols() {
        return symbols;
    }

    public String getOriginalWord() {
        return String.valueOf(symbols);
    }

}
