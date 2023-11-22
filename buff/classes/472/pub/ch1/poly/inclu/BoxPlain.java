public class BoxPlain<Item> implements Box<Item> {

    private Item item;

    public void put(Item item) {
	this.item=item;
    }

    public Item get() {
	Item item=this.item;
	this.item=null;
	return item;
    }

}
