// Singleton(127): Singleton

public class Symbol implements Comparable<Symbol> {

    private String _s;

    private static Symbol _eps;
    private static Symbol _eof;
    private static Symbol _tos;

    public static Symbol eps() {
	if (_eps==null)
	    _eps=new Symbol("");
	return _eps;
    }

    public static Symbol eof() {
	if (_eof==null)
	    _eof=new Symbol("$");
	return _eof;
    }

    public Symbol(String s) { _s=s; }

    public boolean isEps()          { return equals(eps()); }
    public boolean isEof()          { return equals(eof()); }
    public int compareTo(Symbol s)  { return _s.compareTo(s._s); }

    public boolean equals(Object o) {
	if (!(o instanceof Symbol))
	    return false;
	Symbol s=(Symbol)o;
	return s!=null && compareTo(s)==0;
    }

    public boolean single() {
	int l=_s.length();
	return l>=3 &&
	       _s.substring(0,1).equals("\"") && 
               _s.substring(l-1,l).equals("\"");
    }

    public Symbol singlize() {
	int l=_s.length();
	return new Symbol(_s.substring(1,l-1));
    }

    public int length() { return _s.length(); }

    public String toString() { return _s; }

}
