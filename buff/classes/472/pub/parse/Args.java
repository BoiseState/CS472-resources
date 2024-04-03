// Singleton(127): Singleton

import java.util.*;

public class Args {

  private static Args _instance=null;
  private ArgMap _args;
  private String[] _argv;
  private int _pos;

  private Args(String[] argv) {
    _args=new ArgMap();
    _argv=argv;
    _pos=0;
  }

  public static Args instance(String[] argv) {
    if (_instance==null)
      _instance=new Args(argv);
    return instance();
  }

  public static Args instance() {
    return _instance;
  }

  public void add(Arg arg,
    String name,
    String nick,
    String desc,
    String def) {
    arg.set(_args,name,nick,desc,def);
  }

  public ArgWrap get(String arg) {
    return _args.get(arg).get();
  }

  protected String curr() { return _argv[_pos]; }

  protected boolean hasCurr() { return _pos<_argv.length; }

  private int pos() { return _pos; }

  protected void next() {
    if (!hasCurr())
      Error.fatal("Args.next(): insufficient arguments");
    _pos++;
  }

  public void init() {
    while (hasCurr()) {
      Arg a=_args.get(curr());
      if (a==null)
        Error.usage("unknown argument: \""+curr()+
          "\" at position: "+pos());
      next();
      a.init(this);
    }
  }

  public String toString() {
    String s="";
    SortedSet<Arg> args=new TreeSet<Arg>();
    for (Arg a: _args)
      args.add(a);
    for (Arg a: args)
      s+=a;
    return s;
  }

}
