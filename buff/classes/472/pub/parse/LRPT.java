// Aho, Sethi, and Ullman; page 227-228

import java.util.*;

public class LRPT {

    private Map2<State,Symbol,LRAction> _action;
    private Map2<State,Symbol,State> _goto;

    private Grammar _grammar;
    private Symbols _terminals;
    private Symbols _nonterminals;
    private SoSoItem _sosoi;

    public LRPT(Grammar grammar,
		Symbols symbols,
		Symbols terminals,
		Symbols nonterminals,
		First first,
		Follow follow) {
	_grammar=grammar;
	_terminals=terminals;	    // for toString()
	_nonterminals=nonterminals; // for toString()
	Goto go=new Goto();
	_sosoi=new SoSoItem(grammar,symbols,go);
  	computeGoto(go);
  	computeAction(follow);
    }

    public LRAction getAction(State state, Symbol symbol) {
	return _action.get(state,symbol);
    }

    public State getGoto(State state, Symbol symbol) {
	return _goto.get(state,symbol);
    }

    public Grammar grammar() { return _grammar; }
    public Symbols terminals() { return _terminals; }

    private void computeGoto(Goto go) {
	_goto=new Map2<State,Symbol,State>();
	for (KeyPair<SoItem,Symbol> kp: go) {
	    SoItem soitem=kp.k1();
	    Symbol symbol=kp.k2();
	    State from=_sosoi.get(soitem);
	    State to=_sosoi.get(go.get(soitem,symbol));
	    _goto.put(from,symbol,to);
	}
    }

    private void computeAction(Follow follow) {
	_action=new Map2<State,Symbol,LRAction>();
	// Step 2
	for (SoItem soitem: _sosoi) {
	    State from=_sosoi.get(soitem);
	    for (Item item: soitem) {
		Symbol a=item.symbol();
		if (a!=null) {                                     // Step 2a
		    if (_terminals.contains(a))
			_action.put(from,a,
				    new LRActionShift(_goto.get(from,a)));
		} else if (_sosoi.accept(item)) {                  // Step 2c
		    _action.put(from,Symbol.eof(),
				new LRActionAccept());
		} else {                                           // Step 2b
		    Rule rule=item.rule();
		    for (Symbol b: follow.get(rule.lhs().symbol()))
			_action.put(from,b,new LRActionReduce(rule,_grammar));
		}
	    }
	}
    }

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

    private String line(SoItem soitem, int swidth, int ewidth) {
	String s="";
	State from=_sosoi.get(soitem);
	s+=right(from.toString(),swidth);
	LRAction action;
	String entry;
	Symbol eof=Symbol.eof();
	State to;
	for (Symbol symbol: _terminals) {
	    action=_action.get(from,symbol);
	    entry=(action==null ? "" : action.toString());
	    s+=right(entry,Math.max(symbol.length(),ewidth)+1);
	}
	action=_action.get(from,eof);
	entry=(action==null ? "" : action.toString());
	s+=right(entry,Math.max(eof.length(),ewidth)+1);
	for (Symbol symbol: _nonterminals) {
	    to=_goto.get(from,symbol);
	    entry=(to==null ? "" : to.toString());
	    s+=right(entry,Math.max(symbol.length(),ewidth)+1);
	}
	s+="\n";
	return s;
    }

    public String toStringActionGoto() {
	int swidth=3;
	int ewidth=3;
	String s="";
	s+=right("",swidth);
	for (Symbol symbol: _terminals)
	    s+=right(symbol.toString(),Math.max(symbol.length(),ewidth)+1);
	String eof=Symbol.eof().toString();
	s+=right(eof,Math.max(eof.length(),ewidth)+1);
	for (Symbol symbol: _nonterminals)
	    s+=right(symbol.toString(),Math.max(symbol.length(),ewidth)+1);
	s+="\n";
	String[] a=new String[_sosoi.size()];;
	for (SoItem soitem: _sosoi)
	    a[_sosoi.get(soitem).inx()]=line(soitem,swidth,ewidth);
	for (String t: a)
	    s+=t;
	return s;
    }

    public String toString() {
	String s="";
	s+=_sosoi.toString();
	s+=toStringActionGoto();
	return s;
    }

}
