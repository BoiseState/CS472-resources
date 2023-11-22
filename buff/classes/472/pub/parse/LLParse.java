// Aho, Sethi, and Ullman; page 187

public class LLParse {

    private Configs<LLStackItem> _configs;

    public LLParse(FileRead file, LLPT llpt) {
	Config<LLStackItem> last=new Config<LLStackItem>
	    (new Input(file,llpt.terminals().toSingles()));
	last.push(new LLStackItem(Symbol.eof()));
	last.push(new LLStackItem(llpt.grammar().start().symbol()));
	_configs=new Configs<LLStackItem>();
	_configs.add(last);
	while(last.stackSize()>1 || last.inputSize()>1) {
	    if (Args.instance().get("--debug-parse").bool())
		System.out.println(last);
	    Symbol x=last.top().symbol();
	    Symbol a=last.next();
	    Config<LLStackItem> curr=last.clone();
	    if (llpt.terminals().contains(x) || x.isEof()) {
		if (!x.equals(a)) Error.fatal("LLParse: parse error 1");
		curr.pop();
		curr.eat();
	    } else {
		Integer inx=llpt.get(x,a);
		if (inx==null) Error.fatal("LLParse: parse error 2");
		curr.pop();
		Rule rule=llpt.grammar().get(inx.intValue());
		RHS rhs=rule.rhs();
		for (int i=rhs.size()-1; i>=0 ; i--)
		    curr.push(new LLStackItem(rhs.get(i)));
		last.setAction(rule.toString());
	    }
	    _configs.add(curr);
	    last=curr;
	}
    }

    public String toString() {
	return _configs.toString();
    }

}
