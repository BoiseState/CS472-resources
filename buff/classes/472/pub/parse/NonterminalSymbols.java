public class NonterminalSymbols extends Symbols {

  public NonterminalSymbols(Grammar grammar) {
    super();
    for (Rule rule: grammar)
      add(rule.lhs().symbol());
  }

}
