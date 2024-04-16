// Command(233): Command

public class Arg implements Comparable<Arg> {

  protected String _name;
  protected String _nick;
  protected String _desc;
  protected String _def;
  protected String _val;

  public void set(ArgMap args,
    String name,
    String nick,
    String desc,
    String def) {
    _name=name;
    _nick=nick;
    _desc=desc;
    _def=def;
    args.put(name,this);
    if (nick!=null)
      args.put(nick,this);
  }

  protected String val() {
    return _val==null ? _def : _val;
  }

  public void init(Args args) {
  }

  public ArgWrap get() {
    return null;
  }

  public String toString() {
    String s="";
    s+=_name;
    if (_nick!=null)
      s+=" ("+_nick+")";
    s+=" "+_desc+"\n";
    if (_def!=null)
      s+="    "+"default: \""+_def+"\"\n";
    if (_val!=null)
      s+="    "+"value:   \""+_val+"\"\n";
    return s;
  }

  public int compareTo(Arg a) {
    return _name.compareTo(a._name);
  }

}
