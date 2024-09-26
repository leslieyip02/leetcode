import java.util.*;

class MyCalendar {
    private TreeMap<Integer, Integer> intervals;

    public MyCalendar() {
        this.intervals = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (intervals.containsKey(start)) {
            return false;
        }

        Integer before = intervals.floorKey(start);
        if (before != null) {
            if (start < intervals.get(before)) {
                return false;
            }
        }

        Integer after = intervals.ceilingKey(start);
        if (after != null) {
            if (end > after) {
                return false;
            }
        }

        intervals.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
