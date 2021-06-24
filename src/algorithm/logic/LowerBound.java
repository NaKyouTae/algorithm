package algorithm.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LowerBound<T extends Object> extends Object {
    public List<T> list = new ArrayList<>();

    public LowerBound(){

    }

    public int lower(T idx) {
        int low = 0;
        int high = list.size();

        while(low < high) {
            final int mid = low + (high - low)/2;
            if((int) idx <= (int) list.get(mid)) {
                high = mid;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    public void add(T item) {
        list.add(item);
    }

    public void remove(T item) {
        list.remove(item);
    }

    public void sort(Comparator<T> compare) {
        list.sort(compare);
    }
}
