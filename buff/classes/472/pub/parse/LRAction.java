// Command(233): Command

interface LRAction {

    Config<LRStackItem> execute(Config<LRStackItem> last, LRPT lrpt);

}
