package servlet;

/**
 * Created by JoyHwong on 16/6/3.
 * copyright @ 2016 All right reserved.
 * follow me on github https://github.com/JoyHwong
 */
public class Item implements Comparable<Item>{
    private String item;
    private float spend;

    public Item(String item, float spend) {
        this.item = item;
        this.spend = spend;
    }

    public String getItem() {
        return item;
    }

    public float getSpend() {
        return spend;
    }

    @Override
    public int compareTo(Item item) {
        if (spend > item.spend) {
            return 1;
        }

        if (spend < item.spend) {
            return -1;
        }
        return 0;
    }
}
