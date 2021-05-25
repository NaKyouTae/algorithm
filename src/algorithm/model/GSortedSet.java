package algorithm.model;

public class GSortedSet<T> {
    private int max;
    private int num;
    private T[] set;

    @SuppressWarnings("unchecked")
    public GSortedSet(int capacity) {
        this.num = 0;
        this.max = capacity;
        try {
            this.set = (T[]) new Object[max];
        } catch (Exception e) {
            max = 0;
        }
    }

    public int capacity() {
        return this.max;
    }

    public int size() {
        return this.num;
    }

    public int indexOf(T data) {
        for (int i = 0; i < num; i++) {
            if (this.set[i] == data) return i;
        }
        return -1;
    }

    public boolean contains(T data) {
        return (indexOf(data) == -1) ? false : true;
    }

    public boolean add(T data) {
        if (num >= max || contains(data)) {
            return false;
        } else {
            this.set[num++] = data;
            return true;
        }
    }

    public boolean remove(T data) {
        int idx;
        if (num <= 0 || (idx = indexOf(data)) == -1) {
            return false;
        } else {
            this.set[idx] = null;
            return true;
        }
    }

    public void copyTo(GSortedSet<T> s) {
        int n = (s.max > this.num) ? num : s.max;

        for (int i = 0; i < n; i++) {
            s.set[i] = this.set[i];
        }
        s.num = n;
    }

    public void copyFrom(GSortedSet<T> s) {
        int n = (s.num > max) ? max : s.num;

        for (int i = 0; i < n; i++) {
            this.set[i] = s.set[i];
        }

        this.num = n;
    }

    public boolean equalTo(GSortedSet<T> s) {
        if (this.num != s.num) {
            return false;
        }

        for (int i = 0; i < this.num; i++) {
            int j = 0;
            for (; j < s.num; j++) {
                if (set[i] == s.set[j]) break;
            }
            if (j == s.num) {
                return false;
            }
        }
        return true;
    }

    public void unionOf(GSortedSet<T> s, GSortedSet<T> t) {
        copyFrom(s);
        for (int i = 0; i < t.num; i++)
            add(t.set[i]);
    }

    public String toString() {
        if (this.num == 0) return "집합이 비어 있습니다.";

        if (this.num < 9) {
            insertSort();
        } else {
            quickSort(0, this.num - 1);
        }

        StringBuilder sb = new StringBuilder("{ ");
        for (int i = 0; i < num; i++) {
            sb.append(this.set[i] + " ");
        }
        sb.append("}");

        return sb.toString();
    }

    public boolean isEmpty() {
        return (this.num == 0) ? true : false;
    }

    public boolean isFull() {
        return (this.num == max) ? true : false;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        this.num = 0;
        this.set = (T[]) new Object[this.max];
    }


    public boolean union(GSortedSet<T> data) {
        boolean flag = false;

        for (int i = 0; i < data.num; i++) {
            if (add(data.set[i]) == true) {
                flag = true;
            }
        }

        return flag;
    }

    public boolean retain(GSortedSet<T> data) {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (data.contains(set[i]) == false) {
                int sIdx = indexOf(set[i]);
                this.set[sIdx] = null;
                count++;
//				remove(set[i]);
                flag = true;
            }
        }

        num -= count;

        @SuppressWarnings("unchecked")
        T[] n = (T[]) new Object[num];
        int j = 0;

        for (int i = 0; i < max; i++) {
            if (this.set[i] != null)
                n[j++] = this.set[i];
        }

        this.set = n;

        return flag;
    }

    public boolean remove(GSortedSet<T> data) {
        boolean flag = false;
        int count = 0;
        for (int i = 0; i < num; i++) {
            if (data.contains(set[i])) {
                int sIdx = indexOf(set[i]);
                this.set[sIdx] = null;
                count++;
//				remove(set[i]);
                flag = true;
            }
        }

        num -= count;

        @SuppressWarnings("unchecked")
        T[] n = (T[]) new Object[num];
        int j = 0;

        for (int i = 0; i < max; i++) {
            if (this.set[i] != null) {
                n[j++] = this.set[i];
            }
        }

        this.set = n;

        return flag;
    }

    public boolean isSubSetOf(GSortedSet<T> data) {
        boolean flag = false;

        for (int i = 0; i < data.num; i++) {
            if (contains(data.set[i])) {
                flag = true;
            } else {
                flag = false;
            }
        }

        return (flag == true && data.num == this.num) ? true : false;
    }

    public boolean isProperSubsetOf(GSortedSet<T> data) {
        boolean flag = false;

        for (int i = 0; i < data.num; i++) {
            if (contains(data.set[i])) {
                flag = true;
            } else {
                flag = false;
            }
        }

        return (flag == true && data.num != this.num) ? true : false;
    }

    public void intersectionOf(GSortedSet<T> s, GSortedSet<T> t) {
        clear();
        for (int i = 0; i < s.num; i++) {
            if (t.contains(s.set[i]))
                add(s.set[i]);
        }
    }

    public void differenceOf(GSortedSet<T> s, GSortedSet<T> t) {
        clear();
        for (int i = 0; i < s.num; i++) {
            if (!t.contains(s.set[i]))
                add(s.set[i]);
        }
    }

    public void insertSort() {
        for (int i = 1; i < num; i++) {
            int j;
            T temp = this.set[i];
            for (j = i; j > 0 && (int) this.set[j - 1] > (int) temp; j--) {
                this.set[j] = this.set[j - 1];
            }
            this.set[j] = temp;
        }
    }

    public void quickSort(int left, int right) {
        int pl = left;
        int pr = right;
        int c = (int) this.set[(pl + pr) / 2];

        do {
            while ((int) this.set[pl] < c) pl++;
            while ((int) this.set[pr] > c) pr--;
            if (pl <= pr) {
                swap(pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quickSort(left, pr);
        if (right > pl) quickSort(pl, right);
    }

    public void swap(int x, int y) {
        T temp = this.set[x];
        this.set[x] = this.set[y];
        this.set[y] = temp;
    }
}
