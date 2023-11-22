public class LRStackItem {

    private State _state;
    private Symbol _symbol;

    public LRStackItem(State state, Symbol symbol) {
	_symbol=symbol;
	_state=state;
    }

    public State state()   { return _state; }
    public Symbol symbol() { return _symbol; }

    public String toString() {
	return _symbol.toString()+" "+_state.toString();
    }

}
