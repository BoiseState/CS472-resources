public class Pair<Left,Rite> {

  private Left left;
  private Rite rite;

  public Pair(Left left, Rite rite) {
    putLeft(left);
    putRite(rite);
  }

  public Left getLeft() { return left; }
  public Rite getRite() { return rite; }

  public void putLeft(Left left) { this.left=left; }
  public void putRite(Rite rite) { this.rite=rite; }

  public String toString() { return "<"+getLeft()+","+getRite()+">"; }

}
