package p6;

import java.util.ArrayList;

public class Set {
    private final ArrayList<Integer> set = new ArrayList<>() ;

    public void insert(int n) {
        if (!set.contains(n)) {
            set.add(n);
        }
    }

    public int get(int idx) {
        return set.get(idx);
    }

    public boolean contains(int n) {
        for (Integer integer : set) {
            if (integer == n) {
                return true;
            }
        }
        return false;
    }

    public void remove(int n) {
        if (set.contains(n)) {
            set.remove(this.getIdx(n));
        }
    }

    public void empty() {
        set.clear();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            str.append(set.get(i)).append(" ");
        }
        return str.toString();
    }

    public int size() {
        return set.size();
    }

    public Set combine(Set add) {
        Set combinedSet = new Set();
        int temp;

        for (Integer integer : set) {
            combinedSet.insert(integer);
        }

        for (int i = 0; i < add.size(); i++) {
            temp = add.get(i);
            if (!combinedSet.contains(temp)) {
                combinedSet.insert(temp);
            }
        }

        return combinedSet;
    }

    public Set subtract(Set dif) {
        Set differenceSet = new Set();
        int temp;

        for (int i = 0; i < this.size(); i++) {
            temp = this.get(i);
            if (!dif.contains(temp)) {
                differenceSet.insert(temp);
            }
        }

        return differenceSet;
    }

    public Set intersect(Set inter) {
        Set intersectionSet = new Set();
        int temp;

        for (int i = 0; i < this.size(); i++) {
            temp = this.get(i);
            if (inter.contains(temp)) {
                intersectionSet.insert(temp);
            }
        }

        return intersectionSet;
    }

    private int getIdx(int n) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i) == n) {
                return i;
            }
        }
        return -1;
    }
}
