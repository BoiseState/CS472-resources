// Command(233): ConcreteCommand

public class LRActionShift implements LRAction {

    private State _state;

    public LRActionShift(State state) { _state=state; }

    public Config<LRStackItem> execute(Config<LRStackItem> last, LRPT lrpt) {
	Config<LRStackItem> curr=last.clone();
	last.setAction("shift: "+_state);
	curr.push(new LRStackItem(_state,curr.next()));
	curr.eat();
	return curr;
    }

    public boolean equals(Object o) {
	if (!(o instanceof LRActionShift))
	    return false;
	LRActionShift action=(LRActionShift)o;
	return _state.equals(action._state);
    }

    public String toString() { return "s"+_state; }

}
