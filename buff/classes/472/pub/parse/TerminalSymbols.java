public class TerminalSymbols extends Symbols {

    public TerminalSymbols(Grammar grammar) {
	super();
	add(new AllSymbols(grammar));
	rem(new NonterminalSymbols(grammar));
    }

}
