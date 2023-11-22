// FactoryMethod(107): Creator

import java.util.*;

public class FileIter implements Iterable<String> {
      
    private static FileIter f;
    private static FileIterator<String> fi;

    public Iterator<String> iterator() {
        fi=new FileIterator<String>();
	return fi;
    }

    public static FileIter read() {
	f=new FileIter();
	return f;
    }

}

class FileIterator<T> implements Iterator<String> {
      
    private FileRead file;

    public FileIterator() {
	String filename="file";
	String s=System.getenv("JavaFileRead");
	if (s!=null && s.equals("Scanner"))        file=new JavaScanner(filename);
	if (s!=null && s.equals("BufferedReader")) file=new JavaBufferedReader(filename);
	if (file==null)                            file=new JavaBufferedReader(filename);
    }

    public boolean hasNext() { return !file.eof(); }
    public String next()     { return file.read(); }

}
