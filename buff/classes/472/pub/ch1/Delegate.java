public class Delegate {

  public int complexMethod(Delegator r) {
    int data=r.get_data();
    data=321;                   // do complex stuff to data
    return data;
  }

}
