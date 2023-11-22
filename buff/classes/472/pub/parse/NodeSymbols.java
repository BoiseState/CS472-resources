// Interpreter(243): NonterminalExpression
// Visitor(331): ConcreteElement

// symbols : ;
//         | symbol symbols ;

public class NodeSymbols extends Node {

    private Node symbol,symbols;

    public Node parse() throws ParseException {
	try {
	    symbol=NodeSymbol.newNodeSymbol().parse();
	    symbols=new NodeSymbols().parse();
	    return this;
	} catch (ParseException e) {}
	return null;
    }

    public TreeIterator<Node> createIterator() { return ci(symbol,symbols); }

    public void accept(NodeVisitor v) { v.visit(this); }

}

