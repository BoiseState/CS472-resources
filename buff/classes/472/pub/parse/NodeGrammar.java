// Interpreter(243): NonterminalExpression
// Visitor(331): ConcreteElement

// grammar : ruleset ;
//         | ruleset grammar ;

public class NodeGrammar extends Node {

    private Node ruleset,grammar;

    public Node parse() throws ParseException {
	ruleset=new NodeRuleset().parse();
	try {
	    grammar=new NodeGrammar().parse();
	} catch (ParseException e) {}
	return this;
    }

    public TreeIterator<Node> createIterator() { return ci(ruleset,grammar); }

    public void accept(NodeVisitor v) { v.visit(this); }

}
