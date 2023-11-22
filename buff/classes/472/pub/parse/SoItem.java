// Aho, Sethi, and Ullman; page 223-224

import java.util.*;

public class SoItem implements Comparable<SoItem>, Iterable<Item> {

    private Item _item0;
    private Set<Item> _s;

    private Grammar _grammar;

    private SoItem() {
	_item0=null;
	_s=new TreeSet<Item>();
    }

    public SoItem(Grammar grammar, Symbols symbols) {
	this();
	_grammar=grammar;
	Symbol oldStart=_grammar.start().symbol();
	Symbol newStart=symbols.augment(oldStart);
	_item0=new Item(new Rule(new LHS(newStart),new RHS(oldStart)));
	add(_item0);
	closure();
    }

    public SoItem(SoItem soitem, Symbol symbol) {
	this();
	_grammar=soitem._grammar;
	go(soitem,symbol);
    }

    public int size()                   { return _s.size(); }
    private boolean contains(Item item) { return _s.contains(item); }
    private void add(Item item)         { _s.add(item); }

    public boolean equals(Object o) {
	if (!(o instanceof SoItem))
	    return false;
	SoItem soitem=(SoItem)o;
	return compareTo(soitem)==0;
    }

    public int compareTo(SoItem soitem) {
	return toString().compareTo(soitem.toString());
    }

    private SoItem closure() {
	boolean done=false;
	while (!done) {
	    done=true;
	    SoItem soitem=new SoItem();
	    for (Item item: this)
		for (Rule rule: _grammar) {
		    Symbol l=rule.lhs().symbol();
		    Symbol r=item.rule().rhs().get(item.pos());
		    if (l.equals(r)) {
			Item i=new Item(rule);
			if (!soitem.contains(i) && !contains(i)) {
			    soitem.add(i);
			    done=false;
			}
		    }
		}
	    for (Item item: soitem)
		add(item);
	}
	return this;
    }

    private SoItem go(SoItem soitem, Symbol symbol) {
	for (Item item: soitem)
	    if (symbol.equals(item.symbol()))
		add(new Item(item).move());
	closure();
	return this;
    }

    public boolean accept(Item item) {
	return item.equals(new Item(_item0.rule(),1));
    }

    public Iterator<Item> iterator() { return _s.iterator(); }

    public String toString() {
	String s="";
	for (Item item: this)
	    s+="    "+item+"\n";
	return s;
    }

}
