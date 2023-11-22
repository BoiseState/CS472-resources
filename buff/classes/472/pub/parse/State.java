public class State implements Comparable<State> {

    private int _s;

    public State(int s) { _s=s; }

    public int compareTo(State state)  { return _s-state._s; }

    public boolean equals(State state) {
	return compareTo(state)==0;
    }

    public int inx() { return _s; }

    public String toString() {
	return _s+"";
    }

}
