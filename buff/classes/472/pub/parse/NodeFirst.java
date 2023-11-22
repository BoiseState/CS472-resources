// Interpreter(243): NonterminalExpression
// Visitor(331): ConcreteElement

// first   : symbol ":" symbols ";" ;

public class NodeFirst extends Node {

    private Node symbol,symbols;

    public Node parse() throws ParseException {
	symbol=NodeSymbol.newNodeSymbol().parse();
	eat(":");
	symbols=new NodeSymbols().parse();
	eat(";");
	return this;
    }

    public TreeIterator<Node> createIterator() { return ci(symbol,symbols); }

    public void accept(NodeVisitor v) { v.visit(this); }

}

