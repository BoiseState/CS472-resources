// Interpreter(243): AbstractExpression
// Flyweight(195): Flyweight
// Visitor(331): Element

import java.util.*;

public abstract class Node implements TreeIteratee<Node> {

    protected static Lexer l;

    public abstract Node parse() throws ParseException;

    protected void eat(String t) throws ParseException {
	if (l.eat(new Token(t,t))==null)
	    throw new ParseException(l,"expected: "+t);;
    }

    protected TreeIterator<Node> ci(Node a, Node b) {
	Vector<Node> v=new Vector<Node>();
	if (a!=null) v.add(a);
	if (b!=null) v.add(b);
	return new VectorIterator<Node>(v);
    }

    protected TreeIterator<Node> ci(Node a) { return ci(a,null); }

    public abstract TreeIterator<Node> createIterator();

    public abstract void accept(NodeVisitor v);

}
