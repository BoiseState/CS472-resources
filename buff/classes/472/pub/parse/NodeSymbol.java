// Interpreter(243): NonterminalExpression
// Flyweight(195): FlyweightFactory
// Flyweight(195): ConcreteFlyweight
// Visitor(331): ConcreteElement

import java.util.*;

// symbol  : id ;
//         | kw ;

public class NodeSymbol extends Node {

    private String symbol;

    private static Hashtable<String,NodeSymbol> pool;

    public static NodeSymbol newNodeSymbol() {
	if (pool==null)
	    pool=new Hashtable<String,NodeSymbol>();
	String key=l.item().lex();
	NodeSymbol node=pool.get(key);
	if (node==null) {
	    node=new NodeSymbol(key); // share String, too
	    pool.put(key,node);
	}
	return node;
    }

    private NodeSymbol(String s) { symbol=s; }

    public Node parse() throws ParseException {
	if      (l.item().tok().equals("id"))  eat("id");
	else if (l.item().tok().equals("kw"))  eat("kw");
	else if (l.item().tok().equals("num")) eat("num");
	else throw new ParseException(l,"expected: id, kw, or num");
	return this;
    }

    public TreeIterator<Node> createIterator() {
	return new NullIterator<Node>();
    }

    public void accept(NodeVisitor v) { v.visit(this); }

    public String getSymbol() { return symbol; }

}
