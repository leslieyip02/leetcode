import java.util.*;

class MyHashMap {
    private static final int MAX = (int) 1e6 + 1;
    private int[] values;

    public MyHashMap() {
        this.values = new int[MyHashMap.MAX];
        Arrays.fill(this.values, -1);
    }

    public void put(int key, int value) {
        this.values[key] = value;
    }

    public int get(int key) {
        return this.values[key];
    }
    
    public void remove(int key) {
        this.values[key] = -1;
    }
}

class Solution {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1, 2);
        int param_2 = obj.get(1);
        System.out.println(param_2);
        obj.remove(1);
    }
}
