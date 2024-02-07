package Recycling;

public interface IBag<T> {
	public boolean add(T newItem);
	public boolean isEmpty();
	public	boolean isFull();
	public T removeByIndex(int index);
	public T remove();
	public T remove(T item);
	public int getItemCount();
	public int getIndexOf(T item);
	public boolean contains(T item);
	public void displayItems();
	public void dump();
	public boolean transferTo(IBag<T> targetBag, T item);
	boolean transferTo(Bag<Garbage> targetBag, Garbage item);
}

