package Recycling;

import java.util.ArrayList;
import java.util.List;

public abstract class RecyclingBin<T extends Garbage> {

    private int size;
    private List<T> garbageList;

    public RecyclingBin(int size) {
        this.size = size;
        this.garbageList = new ArrayList<>();
    }

    public int getSize() {
        return size;
    }

    public List<T> getGarbageList() {
        return garbageList;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setGarbageList(List<T> garbageList) {
        this.garbageList = garbageList;
    }

    public abstract void recycle();

    public void addRecycle(Garbage garbage) {
         
            garbageList.add((T) garbage);
            size += garbage.getAmount();
        
    }


}

