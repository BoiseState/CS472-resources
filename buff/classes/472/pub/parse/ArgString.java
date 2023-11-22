public class ArgString extends Arg {

    public void init(Args args) {
	if (!args.hasCurr())
	    Error.fatal(this.toString());
	_val=args.curr();
	args.next();
    }

    public ArgWrap get() {
	return new ArgWrap(val());
    }

}
