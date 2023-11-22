// Command(233): Invoker

public class LRParse {

    Configs<LRStackItem> _configs;

    public LRParse(FileRead file, LRPT lrpt) {
	Config<LRStackItem> last=new Config<LRStackItem>
	    (new Input(file,lrpt.terminals().toSingles()));
	last.push(new LRStackItem(new State(0),Symbol.eof()));
	_configs=new Configs<LRStackItem>();
	_configs.add(last);
	while (true) {
	    if (Args.instance().get("--debug-parse").bool())
		System.out.println(last);
	    LRAction action=lrpt.getAction(last.top().state(),last.next());
	    if (action==null)
		Error.fatal("LRParse: parse error");
	    Config<LRStackItem> curr=action.execute(last,lrpt);
	    if (curr==last)
		break;
	    _configs.add(curr);
	    last=curr;
	}
    }

    public String toString() {
	return _configs.toString();
    }

}
