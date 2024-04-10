// FactoryMethod(107): ConcreteCreator
// Adapter(139): Adapter

import java.io.*;

public class JavaBufferedReader implements FileRead {

  private String _fn;
  private BufferedReader _f;
  private boolean _eof;
  private int _ln;

  public JavaBufferedReader(String filename) {
    _fn=filename;
    _f=null;
    _eof=false;
    _ln=0;
  }

  private void open() {
    if (_f!=null)
      return;
    try {
      _f=new BufferedReader(new FileReader(_fn));
    } catch (FileNotFoundException e) {
      Error.usage("JavaBufferedReader.open(): "+e);
    }
    _eof=false;
    _ln=0;
  }

  private void close() {
    if (_f!=null)
      try {
        _f.close();
      } catch (IOException e) {
        Error.fatal("JavaBufferedReader.close(): "+e);
      }
    _f=null;
    _eof=false;
    _ln=0;
  }

  public void init() { close(); }

  public String read() {
    if (_eof)
      return null;
    open();
    String line=null;
    try {
      line=_f.readLine();
    } catch (IOException e) {
      Error.fatal("JavaBufferedReader.read(): "+e);
    }
    if (line==null)
      _eof=true;
    _ln++;
    return line;
  }

  public String toString() { return _fn+":"+_ln; }

  public static void main(String[] args) {
    FileRead f=new JavaBufferedReader("JavaBufferedReader.java");
    String line;
    while ((line=f.read())!=null)
      System.out.println(line);
  }

}
