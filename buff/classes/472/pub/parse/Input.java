import java.util.*;

public class Input implements Iterable<Token> {

    private Vector<Token> _input;

    private Input() {}

    public Input(FileRead file, String singles) {
	_input=new Vector<Token>();
	for (Lexer l=new Lexer(file,singles,true); !l.done(); l.next())
	    _input.add(l.item());
	String eof=Symbol.eof().toString();
	_input.add(new Token(eof,eof));
    }

    public Symbol symbol() { return new Symbol(_input.firstElement().tok()); }
    public int size()      { return _input.size(); }
    public void eat()      { _input.remove(0); }

    public Input clone() {
	Input input=new Input();
	input._input=new Vector<Token>();
	for (Token t: this)
	    input._input.add(t);
	return input;
    }

    public String toString() {
	String r="";
	String sep="";
	for (Token t: this) {
	    r+=sep+t;
	    sep=" ";
	}
	return r;
    }

    public Iterator<Token> iterator() { return _input.iterator(); }

}
