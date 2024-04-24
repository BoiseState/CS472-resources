// Visitor(331): Visitor

interface NodeVisitor {

  void visit(Node e);
  void visit(NodeGrammar e);
  void visit(NodeRuleset e);
  void visit(NodeFirst e);
  void visit(NodeRest e);
  void visit(NodeNext e);
  void visit(NodeSymbols e);
  void visit(NodeSymbol e);

}

