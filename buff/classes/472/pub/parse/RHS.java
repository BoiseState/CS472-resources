import java.util.*;

public class RHS implements Iterable<Symbol> {

    private Vector<Symbol> _v;

    public RHS()         { _v=new Vector<Symbol>(); }
    public RHS(Symbol s) { this(); add(s); }

    public void add(Symbol s) { _v.add(s); }

    public boolean epsilon() { return size()==0; }

    public Symbols symbols() {
	Symbols symbols=new Symbols();
	for (Symbol s: this)
	    symbols.add(s);
	return symbols;
    }

    public boolean equals(RHS rhs) {
	if (size()!=rhs.size())
	    return false;
	for (int i=0; i<size(); i++)
	    if (!get(i).equals(rhs.get(i)))
		return false;
	return true;
    }

    public String toString(String sep, int pos) {
	String res="";
	String space="";
	for (Symbol s: this) {
	    if (pos--==0) {
		res+=space+sep;
		space=" ";
	    }
	    res+=space+s;
	    space=" ";
	}
	if (pos--==0)
	    res+=space+sep;
	return res;
    }

    public String toString() {
	String res="";
	String space="";
	for (Symbol s: this) {
	    res+=space+s;
	    space=" ";
	}
	return res;
    }

    public Iterator<Symbol> iterator() { return _v.iterator(); }

    public Symbol get(int i) {
	try {
	    return _v.get(i);
	} catch (ArrayIndexOutOfBoundsException e) {
	    return null;
	}
    }

    public int size() { return _v.size(); }
    public Symbol head() { return get(0); }
    public RHS tail() { return suffix(1); }

    public RHS suffix(int start) {
	RHS rhs=new RHS();
	for (; start<size(); start++)
	    rhs.add(get(start));
	return rhs;
    }

}
