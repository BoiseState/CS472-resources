// Aho, Sethi, and Ullman; page 189

public class First extends SetMap<Symbol,Symbols> {

    public First(Grammar grammar, Symbols terminals) {
	super("FIRST",new Symbols());
	// Step 1
	for (Symbol symbol: terminals)
	    put(symbol,symbol);
	// Step 2
	for (Rule rule: grammar)
	    if (rule.epsilon())
		put(rule.lhs().symbol(),Symbol.eps());
	// Step 3
	boolean done=false;
	while (!done) {
	    done=true;
	    for (Rule rule: grammar)
		for (Symbol symbol: rule.rhs()) {
		    if (add(rule.lhs().symbol(),get(symbol)))
			done=false;
		    if (!get(symbol).contains(Symbol.eps()))
			break;
		}
	}
    }

    public Symbols get(RHS rhs) {
	Symbols symbols=new Symbols();
	for (Symbol x: rhs) {
	    Symbols first=get(x);
	    symbols.add(first);
	    if (!first.contains(Symbol.eps()))
		break;
	}
	if (symbols.size()==0)
	    symbols.add(Symbol.eps());
	return symbols;
    }

}
