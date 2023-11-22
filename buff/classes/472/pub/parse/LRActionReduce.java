// Command(233): ConcreteCommand

public class LRActionReduce implements LRAction {

    private Rule _rule;
    private Grammar _grammar;

    public LRActionReduce(Rule rule, Grammar grammar) {
	_rule=rule;
	_grammar=grammar;
    }

    public Config<LRStackItem> execute(Config<LRStackItem> last, LRPT lrpt) {
	Config<LRStackItem> curr=last.clone();
	last.setAction("reduce: "+_rule);
	for (int i=_rule.rhs().size(); i>0; i--)
	    curr.pop();
	State state=curr.top().state();
	Symbol symbol=_rule.lhs().symbol();
	curr.push(new LRStackItem(lrpt.getGoto(state,symbol),symbol));
	return curr;
    }

    public boolean equals(Object o) {
	if (!(o instanceof LRActionReduce))
	    return false;
	LRActionReduce action=(LRActionReduce)o;
	return _rule.equals(action._rule);
    }

    public String toString() { return "r"+_grammar.inx(_rule); }

}
