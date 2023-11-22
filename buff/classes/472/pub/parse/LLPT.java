// Aho, Sethi, and Ullman; page 190

import java.util.*;

public class LLPT {

    private Map2<Symbol,Symbol,Integer> _pt;

    private Grammar _grammar;
    private Symbols _terminals;
    private Symbols _nonterminals;

    public LLPT(Grammar grammar,
		Symbols symbols,
		Symbols terminals,
		Symbols nonterminals,
		First first,
		Follow follow) {
	_grammar=grammar;
	_terminals=terminals;	    // for toString()
	_nonterminals=nonterminals; // for toString()
	_pt=new Map2<Symbol,Symbol,Integer>();
	// Step 1
	for (Rule rule: grammar) {
	    int inx=grammar.inx(rule);
	    for (Symbol a: first.get(rule.rhs()))
		if (!a.isEps())
		    _pt.put(rule.lhs().symbol(),a,inx);     // Step 2
		else
		    for (Symbol b: follow.get(rule.lhs().symbol()))
			_pt.put(rule.lhs().symbol(),b,inx); // Step 3
	}
    }

    public Integer get(Symbol s1, Symbol s2) { return _pt.get(s1,s2); }

    public Grammar grammar() { return _grammar; }
    public Symbols terminals() { return _terminals; }

    private String right(String s, int n) {
	for (int i=n-s.length(); i>0; i--)
	    s=" "+s;
	return s;
    }

    private String left(String s, int n) {
	for (int i=n-s.length(); i>0; i--)
	    s+=" ";
	return s;
    }

    private String head(Symbol s, int ewidth) {
	return right(s.toString(),Math.max(s.length(),ewidth)+1);
    }
	    
    private String entry(Symbol n, Symbol t, int ewidth) {
	Integer inx=_pt.get(n,t);
	return right((inx==null ? "" : inx.toString()),
		     Math.max(t.length(),ewidth)+1);
    }

    private String line(Symbol nonterminal, int swidth, int ewidth) {
	String s="";
	s+=left(nonterminal.toString(),swidth+1);
	for (Symbol terminal: _terminals)
	    s+=entry(nonterminal,terminal,ewidth);
	s+=entry(nonterminal,Symbol.eof(),ewidth);
	return s.trim()+"\n";
    }

    public String toString() {
	int swidth=3;
	int ewidth=3;
	String s="";
	for (Symbol symbol: _nonterminals)
	    swidth=Math.max(symbol.length(),swidth);
	s+=right("",swidth+1);
	for (Symbol terminal: _terminals)
	    s+=head(terminal,ewidth);
	s+=head(Symbol.eof(),ewidth);
	s+="\n";
	for (Symbol nonterminal: _nonterminals)
	    s+=line(nonterminal,swidth,ewidth);
	return s;
    }

}
