public class LHS {

    private Symbol _s;

    public LHS(Symbol s) { _s=s; }

    public Symbol symbol() { return _s; }

    public boolean equals(LHS lhs) { return symbol().equals(lhs.symbol()); }

    public String toString() { return _s.toString(); }

}
