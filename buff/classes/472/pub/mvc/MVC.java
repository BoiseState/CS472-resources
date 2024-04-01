// javac MVC.java && java MVC

public class MVC {

  private Model model;
  private View view;
  private Controller controller;

  public MVC() {
    model=Model.instance();
    view=new View(model);
    controller=new Controller(model);
    view.addKeyListener(controller); // for Java SDK keystrokes
  }

  public static void main(String[] args) { new MVC(); }

}
