public class ArgFileRead extends Arg {

  private FileRead _file;

  public void init(Args args) {
    if (!args.hasCurr())
      Error.fatal(toString());
    _val=args.curr();
    args.next();
  }

  public ArgWrap get() {
    if (_file==null)
      _file=JavaFile.createFileRead(val());
    return new ArgWrap(_file);
  }

}
