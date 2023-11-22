class Foo{}
class Bar{}

public class ArgWrap1 extends ArgWrap {

    private Foo _foo;
    private Bar _bar;

    protected ArgWrap1(Foo foo, Bar bar) {
	_foo=foo;
	_bar=bar;
    }

    public ArgWrap1(boolean bool) { super(bool,null,null,null); }
    //...

    public ArgWrap1(Foo foo) { this(foo,null); }
    public ArgWrap1(Bar bar) { this(null,bar); }

    public Foo foo() {
	if (_foo==null) Error.fatal("ArgWrap1.foo()");
	return _foo;
    }

    public Bar bar() {
	if (_bar==null) Error.fatal("ArgWrap1.bar()");
	return _bar;
    }

}
