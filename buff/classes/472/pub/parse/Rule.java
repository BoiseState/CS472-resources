public class Rule {

    private LHS _lhs;
    private RHS _rhs;

    public Rule(LHS lhs, RHS rhs) { _lhs=lhs; _rhs=rhs; }

    public LHS lhs() { return _lhs; }
    public RHS rhs() { return _rhs; }

    public boolean epsilon() { return _rhs.epsilon(); }

    public boolean equals(Rule rule) {
	return _lhs.equals(rule._lhs) && _rhs.equals(rule._rhs);
    }

    public String toString(String rhs) {
	return _lhs+" : "+rhs+";";
    }

    public String toString(String sep, int pos) {
	return toString(_rhs.toString(sep,pos)+" ");
    }

    public String toString() {
	return toString(epsilon() ? "" : _rhs+" ");
    }

}
