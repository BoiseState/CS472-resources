// Aho, Sethi, and Ullman; page 189

public class Follow extends SetMap<Symbol,Symbols> {

    public Follow(Grammar grammar,
		  Symbols symbols,
		  Symbols nonterminals,
		  First first) {
	super("FOLLOW",new Symbols());
	// Step 1
	put(grammar.start().symbol(),Symbol.eof());
	// Step 2
	for (Rule rule: grammar) {
	    RHS rhs=rule.rhs();
	    for (int i=0; i<rhs.size()-1; i++) {
		RHS suffix=rhs.suffix(i);
		if (nonterminals.contains(suffix.head())) {
		    Symbols s=first.get(suffix.tail());
		    s.rem(Symbol.eps());
		    add(suffix.head(),s);
		}
	    }
	}
	// Step 3
	boolean done=false;
	while (!done) {
	    done=true;
	    for (Rule rule: grammar) {
		RHS rhs=rule.rhs();
		for (int i=0; i<rhs.size(); i++) {
		    RHS suffix=rhs.suffix(i);
		    if (suffix.size()==1
			|| first.get(suffix.tail()).contains(Symbol.eps()))
			if (nonterminals.contains(suffix.head())
			    && add(suffix.head(),get(rule.lhs().symbol())))
			    done=false;
		}
	    }
	}
    }

}
