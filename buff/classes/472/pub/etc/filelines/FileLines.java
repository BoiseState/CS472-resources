// FactoryMethod(107): Creator

import java.util.*;

public class FileLines implements Iterable<String> {
      
    private String fn;

    public FileLines()            { this(null); }
    public FileLines(String name) { fn=name; }

    public Iterator<String> iterator() { return new FileIterator<>(fn); }

}

class FileIterator<T> implements Iterator<String> {
      
    private FileRead file;
    private String line;

    public FileIterator(String name) {
	String s=System.getenv("JavaFileRead");
	if (s==null) s="Scanner";
	if (s.equals("Scanner"))        file=new JavaScanner(name);
	if (s.equals("BufferedReader")) file=new JavaBufferedReader(name);
	next();
    }

    public String  curr()    { return line; }
    public boolean hasNext() { return line!=null; }

    public String next() {
	String ret=line;
	line=file.read();
	return ret;
    }

}
