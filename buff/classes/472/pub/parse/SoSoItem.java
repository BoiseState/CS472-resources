// Aho, Sethi, and Ullman; page 224

import java.util.*;

public class SoSoItem implements Iterable<SoItem> {

    private SoItem _state0;
    private Map<SoItem,State> _m;

    private SoSoItem() {
	_state0=null;
	_m=new TreeMap<SoItem,State>();
    }

    public SoSoItem(Grammar grammar, Symbols symbols, Goto go) {
	this();
	int inx=0;
	put(_state0=new SoItem(grammar,symbols),new State(inx++));
	boolean done=false;
	while (!done) {
	    done=true;
	    SoSoItem sosoitem=new SoSoItem();
	    for (SoItem from: this)
		for (Symbol symbol: symbols) {
		    SoItem to=new SoItem(from,symbol);
		    if (to.size()>0) {
			State state=get(to);
			if (state==null)
			    state=sosoitem.get(to);
			if (state==null) {
			    sosoitem.put(to,new State(inx++));
			    done=false;
			}
			go.put(from,symbol,to);
		    }
		}
	    for (SoItem soitem: sosoitem)
		put(soitem,sosoitem.get(soitem));
	}
    }

    private void put(SoItem soitem, State state) {
	if (_state0==null)
	    _state0=soitem;
	_m.put(soitem,state);
    }

    public State get(SoItem soitem) { return _m.get(soitem); }
    public int size()               { return _m.size(); }

    public boolean accept(Item item) { return _state0.accept(item); }

    public Iterator<SoItem> iterator() { return _m.keySet().iterator(); }

    public String toString() {
	String[] a=new String[size()];;
	for (SoItem soitem: this)
	    a[get(soitem).inx()]="I"+get(soitem)+":\n"+soitem+"\n";
	String s="";
	for (String t: a)
	    s+=t;
	return s;
    }

}
