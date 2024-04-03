public class ArgWrap {

  private Boolean _boolean;
  private Integer _integer;
  private String _string;
  private FileRead _fileRead;

  protected ArgWrap() {}

  protected ArgWrap(Boolean bool,
    Integer integer,
    String string,
    FileRead fileRead) {
    _boolean=bool;
    _integer=integer;
    _string=string;
    _fileRead=fileRead;
  }

  public ArgWrap(boolean bool)      { this(bool,null,null,null); }
  public ArgWrap(int integer)       { this(null,integer,null,null); }
  public ArgWrap(String string)     { this(null,null,string,null); }
  public ArgWrap(FileRead fileRead) { this(null,null,null,fileRead); }

  public boolean bool() {
    if (_boolean==null)
      Error.fatal("ArgWrap.bool()");
    return _boolean;
  }

  public int integer() {
    if (_integer==null)
      Error.fatal("ArgWrap.integer()");
    return _integer;
  }

  public String string() {
    if (_string==null)
      Error.fatal("ArgWrap.string()");
    return _string;
  }

  public FileRead fileRead() {
    if (_fileRead==null)
      Error.fatal("ArgWrap.fileRead()");
    return _fileRead;
  }

}
