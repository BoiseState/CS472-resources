// Interpreter(243): Client/NonterminalExpression
// Visitor(331): ConcreteElement

public class NodeRoot extends Node {

  private Node grammar;

  public NodeRoot(Lexer lexer) {
    l=lexer;
    try {
      grammar=parse();
      if (!l.done())
        throw new ParseException(l,"extra tokens");
    } catch (ParseException e) {
      Error.fatal(e+"");
    }
  }

  public Node parse() throws ParseException {
    return new NodeGrammar().parse();
  }

  public TreeIterator<Node> createIterator() { return ci(grammar); }

  public void accept(NodeVisitor v) { v.visit(this); }

}
