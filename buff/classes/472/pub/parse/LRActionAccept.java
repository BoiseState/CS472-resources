// Command(233): ConcreteCommand

public class LRActionAccept implements LRAction {

    public Config<LRStackItem> execute(Config<LRStackItem> last, LRPT lrpt) {
	last.setAction("accept");
	return last;
    }

    public boolean equals(Object o) {
	if (!(o instanceof LRActionAccept))
	    return false;
	return true;
    }

    public String toString() { return "acc"; }

}
