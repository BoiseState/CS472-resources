// Singleton(127).Singleton
// Observer(293).Subject

public class Model extends Subject {

  private static Model instance=null;
  private State state;

  private Model() {
    super();
    state=new State();
  }

  static public Model instance() {
    if (instance==null)
      instance=new Model();
    return instance;
  }

  public State getState() { return state; }

  public void setState(State state) {
    this.state=state;
    update();
  }

}
