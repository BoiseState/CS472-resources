import java.util.*;

public class Configs<StackItem> {

    private Vector<Config<StackItem>> _v;

    public Configs() { _v=new Vector<Config<StackItem>>(); }

    public void add(Config<StackItem> config) { _v.add(config); }

    public Config<StackItem> last() { return _v.lastElement(); }

    private String right(String s, int len) {
	while (s.length()<len)
	    s=" "+s;
	return s;
    }

    private String left(String s, int len) {
	while (s.length()<len)
	    s=s+" ";
	return s;
    }

    public String toString() {
	Vector<Vector<String>> lines=new Vector<Vector<String>>();
	int swidth=0;
	int iwidth=0;
	int i=1;
	for (Config c: _v) {
	    Vector<String> line=new Vector<String>();
	    line.add(right("(" + i++ + ")",4));
	    String stack=c.stackToString();
	    line.add(stack);
	    swidth=Math.max(swidth,stack.length());
	    String input=c.inputToString();
	    line.add(input);
	    iwidth=Math.max(iwidth,input.length());
	    line.add(c.actionToString());
	    lines.add(line);
	}
	String r="";
	for (Vector<String> line: lines) {
	    r+=line.get(0)+" ";
	    r+=left(line.get(1),swidth)+"    ";
	    r+=left(line.get(2),iwidth)+"    ";
	    r+=line.get(3);
	    r+="\n";
	}
	return r;
    }

}
