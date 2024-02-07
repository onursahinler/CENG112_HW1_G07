package Recycling;

import java.util.ArrayList;
import java.util.List;

public class TrashCan {
    private int size;
    private List<Garbage> contents;

    public TrashCan() {
        this.size = size;
        contents = new ArrayList<>();
    }

    public boolean add(Garbage garbage) {
        if (garbage == null) {
            return false;
        }
        if (getCurrentSize() + garbage.getAmount() > size) {
            return false;
        }
        return contents.add(garbage);
    }

    public boolean remove(Garbage garbage) {
        return contents.remove(garbage);
    }

    public int getCurrentSize() {
        int currentSize = 0;
        for (Garbage garbage : contents) {
            currentSize += garbage.getAmount();
        }
        return currentSize;
    }

    public List<Garbage> getContents() {
        return contents;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

	public void updateTrashCan() {
		// TODO Auto-generated method stub
		
	}
}

