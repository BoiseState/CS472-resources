public class ArgBool extends Arg {

    public void init(Args args) {
	if (args.hasCurr()) {
	    String s=args.curr();
	    if (s.equalsIgnoreCase("true") || s.equalsIgnoreCase("false")) {
		_val=s;
		args.next();
		return;
	    }
	}
	_val=val().equalsIgnoreCase("true") ? "false" : "true";
    }

    public ArgWrap get() {
	return new ArgWrap(val().equalsIgnoreCase("true"));
    }

}
