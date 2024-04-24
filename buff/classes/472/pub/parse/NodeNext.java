// Interpreter(243): NonterminalExpression
// Visitor(331): ConcreteElement

// next    : "|" symbols ";" ;

public class NodeNext extends Node {

  private Node symbols;

  public Node parse() throws ParseException {
    eat("|");
    symbols=new NodeSymbols().parse();
    eat(";");
    return this;
  }

  public TreeIterator<Node> createIterator() { return ci(symbols); }

  public void accept(NodeVisitor v) { v.visit(this); }

}
