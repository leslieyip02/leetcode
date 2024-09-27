import java.util.*;

class MyCalendarTwo {
    private class Booking {
        private int start;
        private int end;

        public Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isOverlapping(Booking other) {
            return Math.max(this.start, other.start) < Math.min(this.end, other.end);
        }
    }

    private List<Booking> singleBookings;
    private List<Booking> doubleBookings;;

    public MyCalendarTwo() {
        this.singleBookings = new ArrayList<>();
        this.doubleBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        Booking newBooking = new Booking(start, end);
        for (Booking booking : doubleBookings) {
            if (booking.isOverlapping(newBooking)) {
                return false;
            }
        }

        for (Booking booking : singleBookings) {
            if (booking.isOverlapping(newBooking)) {
                Booking overlapBooking = new Booking(
                    Math.max(booking.start, start),
                    Math.min(booking.end, end)
                );
                doubleBookings.add(overlapBooking);
            }
        }
        singleBookings.add(newBooking);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
