import java.util.*;

public class Lexer {

    private FileRead _file;
    private Set<String> _singles;
    private String _line;
    private boolean _quoteSingles;
    private boolean _eof;
    private Token _token;
    private Set<String> _ws;

    public Lexer(FileRead file, String singles, boolean quoteSingles) {
	_file=file;
	_singles=new HashSet<String>();
	_quoteSingles=quoteSingles;
	Scanner s=new Scanner(singles);
	while (s.hasNext()) _singles.add(s.next());
	init();
    }

    public void init() {
	_file.init();
	_line="";
	_eof=false;
	_token=null;
	_ws=new HashSet<String>();
	_ws.add(" "); _ws.add("\n"); _ws.add("\t");
	next();
    }

    private boolean read() {
	return (_line=_file.read())!=null;
    }

    private void many(Set<String> s) {
	int i=0;
	for (; i<_line.length() && s.contains(_line.charAt(i)+""); i++);
	_line=_line.substring(i);
    }
    
    private String manyNot(Set<String> s) {
	int i=0;
	for (; i<_line.length() && !s.contains(_line.charAt(i)+""); i++);
	if (i==0) return null;
	String res=_line.substring(0,i);
	_line=_line.substring(i);
	return res;
    }

    private void skipAfter(char c) {
	int i=0;
	for (; i<_line.length() && c!=_line.charAt(i); i++);
	_line=_line.substring(0,i);
    }

    private String quote(String token) {
	if (_quoteSingles)
	    token="\""+token+"\"";
	return token;
    }

    public void next() {
	if (done()) return;
	many(_ws);
	String lexeme;
	while ((lexeme=manyNot(_ws))==null) {
	    if (read()) {
		skipAfter('#');
		many(_ws);
	    } else {
		_eof=true;
		return;
	    }
	}
	if (_singles.contains(lexeme))
	    _token=new Token(quote(lexeme),lexeme);
	else if (lexeme.charAt(0)=='"')
	    _token=new Token("kw",lexeme);
	else if (lexeme.charAt(0)>='0' && lexeme.charAt(0)<='9')
	    _token=new Token("num",lexeme);
	else
	    _token=new Token("id",lexeme);
    }

    public Token eat(Token t) {
	if (!t.equals(item()))
	    return null;
	next();
	return item();
    }

    public boolean done() { return _eof; }
    public Token item() { return _token; }
    public String toString() { return _file.toString(); }

}
