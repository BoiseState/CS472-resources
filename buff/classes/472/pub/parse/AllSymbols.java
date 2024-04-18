public class AllSymbols extends Symbols {

  public AllSymbols(Grammar grammar) {
    super();
    for (Rule rule: grammar) {
      add(rule.lhs().symbol());
      add(rule.rhs().symbols());
    }
  }

}
