// Interpreter(243): NonterminalExpression
// Visitor(331): ConcreteElement

// rest    : next ;
//         | next rest ;

public class NodeRest extends Node {

    private Node next,rest;

    public Node parse() throws ParseException {
	next=new NodeNext().parse();
	try {
	    rest=new NodeRest().parse();
	} catch (ParseException e) {}
	return this;
    }

    public TreeIterator<Node> createIterator() { return ci(next,rest); }

    public void accept(NodeVisitor v) { v.visit(this); }

}

