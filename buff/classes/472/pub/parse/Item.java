public class Item implements Comparable<Item> {

    private Rule _rule;
    private int _pos;

    public Item(Rule rule, int pos) { _rule=rule; _pos=pos; }
    public Item(Rule rule)          { this(rule,0); }
    public Item(Item item)          { this(item.rule(),item.pos()); }

    public Rule rule() { return _rule; }
    public int pos()   { return _pos; }

    public Symbol symbol() {
	return _rule.rhs().get(_pos);
    }

    public Item move() {
	if (symbol()!=null)
	    _pos++;
	return this;
    }

    public boolean equals(Item item) {
	return rule().equals(item.rule()) && pos()==item.pos();
    }

    public int compareTo(Item item) {
	return toString().compareTo(item.toString());
    }

    public String toString() {
	return _rule.toString(".",_pos);
    }

}
