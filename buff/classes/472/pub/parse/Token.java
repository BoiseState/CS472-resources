public class Token {

    private String _token;
    private String _lexeme;

    public Token(String token, String lexeme) {
	_token=token;
	_lexeme=lexeme;
    }

    public String tok() { return _token; } 
    public String lex() { return _lexeme; }

    public boolean equals(Token t) { return _token.equals(t._token); }

    public String toString() {
	return "<"+tok()+","+lex()+">";
    }

}
