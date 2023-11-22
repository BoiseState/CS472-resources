// Visitor(331): ConcreteVisitor

public class NodeToGrammarVisitor implements NodeVisitor {

    private Grammar _grammar;

    private LHS lhs;
    private RHS rhs;

    public NodeToGrammarVisitor(Grammar grammar) {
	_grammar=grammar;
	lhs=null;
	rhs=new RHS();
    }

    public void visit(Node e) {}

    public void visit(NodeGrammar e) {}

    public void visit(NodeRuleset e) {
	lhs=null;
    }

    public void visit(NodeFirst e) {
	_grammar.add(new Rule(lhs,rhs));
	rhs=new RHS();
    }

    public void visit(NodeRest e) {}

    public void visit(NodeNext e) {
	_grammar.add(new Rule(lhs,rhs));
	rhs=new RHS();
    }

    public void visit(NodeSymbols e) {}

    public void visit(NodeSymbol e) {
	if (lhs==null)
	    lhs=new LHS(new Symbol(e.getSymbol()));
	else
	    rhs.add(new Symbol(e.getSymbol()));
    }

}
