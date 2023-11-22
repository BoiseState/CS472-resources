import java.util.*;

public class Grammar implements Iterable<Rule> {

    private Vector<Rule> _grammar;

    public Grammar() { _grammar=new Vector<Rule>(); }

    public Grammar(Node root) {
	this();
	NodeVisitor v=new NodeToGrammarVisitor(this);
     	TreeIterator<Node> i=new PostorderIterator<Node>(root);
 	for (i.init(); !i.done(); i.next())
 	    i.item().accept(v);
    }

    public void add(Rule rule) { _grammar.add(rule); }
    public Rule get(int inx)   { return _grammar.get(inx); }

    public LHS start() {
	return _grammar.size()>0 ? _grammar.get(0).lhs() : null;
    }
    
    private String format(int n, int width) {
	String r=""+n;
	width-=r.length();
	while (width-->0) r=" "+r;
	return r;
    }

    public String toString() {
	String s="";
	int i=0;
	for (Rule r: this)
	    s+=format(i++,2)+") "+r+"\n";
	return s;
    }

    public Iterator<Rule> iterator() { return _grammar.iterator(); }

    public int inx(Rule rule) {
	return _grammar.indexOf(rule);
    }

}
