public class LLStackItem {

    private Symbol _symbol;

    public LLStackItem(Symbol symbol) { _symbol=symbol; }

    public Symbol symbol() { return _symbol; }

    public String toString() { return _symbol.toString(); }

}
