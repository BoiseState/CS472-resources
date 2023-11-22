// Prototype(117): ConcretePrototype

import java.util.*;

public class Symbols implements Iterable<Symbol>, SetMapData<Symbol,Symbols> {

    private String _eps="^";

    private Set<Symbol> _symbols;
    
    public Symbols() { _symbols=new TreeSet<Symbol>(); }

    public Symbols add(Symbol symbol) {
	_symbols.add(symbol);
	return this;
    }

    public Symbols add(Symbols symbols) {
	for (Symbol s: symbols)
	    _symbols.add(s);
	return this;
    }

    public boolean contains(Symbol symbol) {
	return _symbols.contains(symbol);
    }

    public void rem(Symbol symbol) {
	_symbols.remove(symbol);
    }

    public Symbols rem(Symbols symbols) {
	for (Symbol s: symbols)
	    _symbols.remove(s);
	return this;
    }

    public int size() { return _symbols.size(); }

    public String toString() {
	String r="{";
	String sep="";
	for (Symbol s: this) {
	    r+=sep+(s.isEps() ? _eps : s);
	    sep=",";
	}
	return r+"}";
    }

    public String toSingles() {
	String r="";
	String sep="";
	for (Symbol s: this) {
	    if (s.single()) {
		r+=sep+s.singlize();
		sep=" ";
	    }
	}
	return r;
    }

    public Iterator<Symbol> iterator() { return _symbols.iterator(); }

    public Symbols newData() { return new Symbols(); }

    public Symbol augment(Symbol oldStart) {
	Symbol newStart=oldStart;
	do {
	    oldStart=newStart;
	    newStart=new Symbol(newStart.toString()+"'");
	} while (contains(newStart));
	return newStart;
    }

}
