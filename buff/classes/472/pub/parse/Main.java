public class Main {

  public static void initArgs(String[] argv) {
    Args args=Args.instance(argv);
    args.add(new ArgFileRead(),"--grammar","-g","<file> #name of grammar file","grammar");
    args.add(new ArgFileRead(),"--string","-s","<file> #name of file containing string to parse","string");
    args.add(new ArgString(),"--singles",null,"<string> #single-character tokens (space separated)",": ; |");
    args.add(new ArgBool(),"--debug-symbols",null,"<true/false> #print details during symbol analysis","false");
    args.add(new ArgBool(),"--table-lr",null,"<true/false> #build LR table","true");
    args.add(new ArgBool(),"--parse-lr",null,"<true/false> #parse using LR table","true");
    args.add(new ArgBool(),"--table-ll",null,"<true/false> #build LL table","false");
    args.add(new ArgBool(),"--parse-ll",null,"<true/false> #parse using LL table","false");
    args.add(new ArgBool(),"--debug-parse",null,"<true/false> #print details during string parsing","false");
    args.add(new ArgUsage(),"--usage","-u","#show usage",null);
    args.init();
  }

  public static void main(String[] argv) {
    initArgs(argv);
    Args args=Args.instance();

    Lexer lexer=new Lexer(args.get("--grammar").fileRead(),
      args.get("--singles").string(),
      false);
    Node root=new NodeRoot(lexer);
    Grammar grammar=new Grammar(root);
    System.out.println(grammar);

    Symbols symbols=new AllSymbols(grammar);
    Symbols nonterminals=new NonterminalSymbols(grammar);
    Symbols terminals=new TerminalSymbols(grammar);
    if (args.get("--debug-symbols").bool()) {
      System.out.println("terminals="+terminals);
      System.out.println("nonterminals="+nonterminals);
      System.out.println("symbols="+symbols);
      System.out.println();
    }

    First first=new First(grammar,terminals);
    Follow follow=new Follow(grammar,symbols,nonterminals,first);
    System.out.println(first);
    System.out.println(follow);

    if (args.get("--table-ll").bool()) {
      LLPT llpt=new LLPT(grammar,
        symbols,terminals,nonterminals,
        first,follow);
      System.out.println(llpt);
      if (args.get("--parse-ll").bool()) {
        LLParse llp=new LLParse(args.get("--string").fileRead(),llpt);
        System.out.println(llp);
      }
    }

    if (args.get("--table-lr").bool()) {
      LRPT lrpt=new LRPT(grammar,
        symbols,terminals,nonterminals,
        first,follow);
      System.out.println(lrpt);
      if (args.get("--parse-lr").bool()) {
        LRParse lrp=new LRParse(args.get("--string").fileRead(),lrpt);
        System.out.println(lrp);
      }
    }

  }

}
