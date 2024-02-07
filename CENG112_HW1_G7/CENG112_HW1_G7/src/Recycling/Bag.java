package Recycling;

import java.util.ArrayList;
import java.util.List;

public class Bag<T> implements IBag<T> {
    private final List<T> items;
    private final int capacity;
    
    public Bag(int capacity) {
        this.capacity = capacity;
        items = new ArrayList<>();
    }
    
    public boolean add(T newItem) {
        if (isFull()) {
            return false;
        }
        items.add(newItem);
        return true;
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public boolean isFull() {
        return items.size() >= capacity;
    }
    
    public T removeByIndex(int index) {
        if (index < 0 || index >= items.size()) {
            return null;
        }
        return items.remove(index);
    }
    
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        return items.remove(items.size() - 1);
    }
    
    public T remove(T item) {
        int index = items.indexOf(item);
        if (index == -1) {
            return null;
        }
        return items.remove(index);
    }
    
    public int getItemCount() {
        return items.size();
    }
    
    public int getIndexOf(T item) {
        return items.indexOf(item);
    }
    
    public boolean contains(T item) {
        return items.contains(item);
    }
    
    public void displayItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }
    
    public void dump() {
        items.clear();
    }
    
    public boolean transferTo(Bag<T> targetBag, T item) {
        if (!contains(item) || targetBag.isFull()) {
            return false;
        }
        remove(item);
        targetBag.add(item);
        return true;
    }



	@Override
	public boolean transferTo(Bag<Garbage> targetBag, Garbage item) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean transferTo(IBag<T> targetBag, T item) {
		// TODO Auto-generated method stub
		return false;
	}
}
