// FactoryMethod(107): Creator

public class JavaFile {

    private JavaFile() {}

    public static FileRead createFileRead(String filename) {
	FileRead product;
	String s=System.getenv("JavaFileRead");
	if (s!=null && s.equals("Scanner"))
	    product=new JavaScanner(filename);
	else if (s!=null && s.equals("BufferedReader"))
	    product=new JavaBufferedReader(filename);
	else
	    product=new JavaBufferedReader(filename);
	return product;
    }

}
