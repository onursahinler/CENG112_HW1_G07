package Recycling;

import java.util.ArrayList;

public class GlassRecycleBin extends RecyclingBin<Glass> implements IBag<Garbage> {
    private ArrayList<Garbage> items;
    private static final String TYPE = "Paper";

    public GlassRecycleBin(int size) {
        super(size);
    }

    @Override
    public boolean add(Garbage newItem) {
        if (newItem.getType().equals(TYPE)) {
            return items.add(newItem);
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public Garbage removeByIndex(int index) {
        return items.remove(index);
    }

    @Override
    public Garbage remove() {
        return items.remove(items.size() - 1);
    }

    @Override
    public Garbage remove(Garbage item) {
        items.remove(item);
        return item;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getIndexOf(Garbage item) {
        return items.indexOf(item);
    }

    @Override
    public boolean contains(Garbage item) {
        return items.contains(item);
    }

    @Override
    public void displayItems() {
        for (Garbage item : items) {
            System.out.println(item.toString());
        }
    }

    @Override
    public void dump() {
        items.clear();
    }

    @Override
    public boolean transferTo(Bag<Garbage> targetBag, Garbage item) {
        if (targetBag.getClass().equals(GlassRecycleBin.class)&& item.getType().equals(TYPE)) {
            return targetBag.add(item);
        }
        return false;
    }

	@Override
	public boolean transferTo(IBag<Garbage> targetBag, Garbage item) {
		return false;
	}

	@Override
	public void recycle() {
		// TODO Auto-generated method stub
		
	}
}
