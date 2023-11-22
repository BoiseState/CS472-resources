class ParseException extends Exception {
    public ParseException(Lexer l, String msg) {
	super("GrammarRoot.parse():\n"+
	      "    "+l+"\n"+
	      "    "+msg);
    }
}

