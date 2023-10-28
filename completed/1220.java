import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    HashMap<Integer, Long> a;
    HashMap<Integer, Long> e;
    HashMap<Integer, Long> i;
    HashMap<Integer, Long> o;
    HashMap<Integer, Long> u;

    private long chooseA(int n) {
        if (!a.containsKey(n)) {
            a.put(n, this.chooseE(n - 1));
        }
        return a.get(n);
    }

    private long chooseE(int n) {
        if (!e.containsKey(n)) {
            e.put(n, (this.chooseA(n - 1) + this.chooseI(n - 1)) % Solution.M);
        }
        return e.get(n);
    }

    private long chooseI(int n) {
        if (!i.containsKey(n)) {
            long ways = (this.chooseA(n - 1) + this.chooseE(n - 1)) % Solution.M;
            ways = (ways + this.chooseO(n - 1)) % Solution.M;
            ways = (ways + this.chooseU(n - 1)) % Solution.M;
            i.put(n, ways);
        }
        return i.get(n);
    }

    private long chooseO(int n) {
        if (!o.containsKey(n)) {
            o.put(n, (this.chooseI(n - 1) + this.chooseU(n - 1)) % Solution.M);
        }
        return o.get(n);
    }

    private long chooseU(int n) {
        if (!u.containsKey(n)) {
            u.put(n, this.chooseA(n - 1));
        }
        return u.get(n);
    }

    public int countVowelPermutation(int n) {
        a = new HashMap<>();
        a.put(1, 1L);
        e = new HashMap<>();
        e.put(1, 1L);
        i = new HashMap<>();
        i.put(1, 1L);
        o = new HashMap<>();
        o.put(1, 1L);
        u = new HashMap<>();
        u.put(1, 1L);

        long ways = (this.chooseA(n) + this.chooseE(n)) % Solution.M;
        ways = (ways + this.chooseI(n)) % Solution.M;
        ways = (ways + this.chooseO(n)) % Solution.M;
        ways = (ways + this.chooseU(n)) % Solution.M;
        return (int) ways;
    }

    public static void main(String[] args) {
        // int n = 1;
        // int n = 2;
        // int n = 5;
        int n = 158;

        Solution solution = new Solution();
        System.out.println(solution.countVowelPermutation(n));
    }
}
