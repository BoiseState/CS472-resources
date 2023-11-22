// Command(233): Receiver

import java.util.*;

public class Config<StackItem> {

    private Stack<StackItem> _stack;
    private Input _input;
    private String _action;

    public Config(Input input) {
	_stack=new Stack<StackItem>();
	_input=input;
	_action="";
    }

    public int stackSize()        { return _stack.size(); }
    public StackItem top()        { return _stack.peek(); }
    public void push(StackItem i) { _stack.push(i); }
    public void pop()             { _stack.pop(); }

    public int inputSize() { return _input.size(); }
    public void eat()      { _input.eat(); }
    public Symbol next()   { return _input.symbol(); }

    public void setAction(String action) { _action=action; }

    public Config<StackItem> clone() {
	Config<StackItem> c=new Config<StackItem>(_input.clone());
	for (StackItem i: _stack)
	    c.push(i);
	return c;
    }

    public String stackToString() {
	String s="";
	String sep="";
	for (StackItem i: _stack) {
	    s+=sep+i.toString();
	    sep=" ";
	}
	return s;
    }

    public String inputToString() {
	String s="";
	String sep="";
	for (Token t: _input) {
	    s+=sep+t.tok();
	    sep=" ";
	}
	return s;
    }

    public String actionToString() { return _action; }

    public String toString() {
	return stackToString()+" "+inputToString()+" "+actionToString();
    }

}
