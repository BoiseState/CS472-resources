// FactoryMethod(107): ConcreteCreator
// Adapter(139): Adapter

import java.util.*;
import java.io.*;

public class JavaScanner implements FileRead {

    private String _fn;
    private Scanner _s;
    private boolean _eof;
    private int _ln;

    public JavaScanner(String filename) {
	_fn=filename;
	_s=null;
	_eof=false;
	_ln=0;
    }

    private void open() {
	if (_s!=null) return;
	try {
	    _s=new Scanner(new File(_fn));
	} catch (FileNotFoundException e) {
	    Error.usage("JavaScanner.open(): "+e);
	}
	_eof=false;
	_ln=0;
    }

    private void close() {
	if (_s!=null)
	    _s.close();
	_s=null;
	_eof=false;
	_ln=0;
    }

    public boolean eof() { return _eof; }

    public void init() { close();}

    public String read() {
	if (_eof) return null;
	open();
	String line=null;
	if (_s.hasNextLine())
	    line=_s.nextLine();
	if (line==null)
	    _eof=true;
	_ln++;
	return line;
    }

    public String toString() { return _fn+":"+_ln; }

    public static void main(String[] args) {
	FileRead f=new JavaScanner("JavaScanner.java");
	String line;
	while ((line=f.read())!=null)
	    System.out.println(line);
    }

}
