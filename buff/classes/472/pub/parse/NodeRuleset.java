// Interpreter(243): NonterminalExpression
// Visitor(331): ConcreteElement

// ruleset : first ;
//         | first rest ;

public class NodeRuleset extends Node {

    private Node first,rest;

    public Node parse() throws ParseException {
	first=new NodeFirst().parse();
	try {
	    rest=new NodeRest().parse();
	} catch (ParseException e) {}
	return this;
    }

    public TreeIterator<Node> createIterator() { return ci(first,rest); }

    public void accept(NodeVisitor v) { v.visit(this); }

}

