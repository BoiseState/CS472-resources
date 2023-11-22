public class BoxMagic<Item> implements Box<Item> {

    private Item item;

    public void put(Item item) {
	this.item=item;
    }

    public Item get() {
	return item;
    }

}
