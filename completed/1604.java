import java.util.*;

class Solution {
    private class Time implements Comparable<Time> {
        private int hour;
        private int minute;

        public Time(String time) {
            String[] segments = time.split(":");
            this.hour = Integer.parseInt(segments[0]);
            this.minute = Integer.parseInt(segments[1]);
        }

        public boolean isWithinHour(Time other) {
            if (this.hour - other.hour >= 2) {
                return false;
            }

            if (this.hour - other.hour == 1) {
                return this.minute <= other.minute;
            }

            return true;
        }

        @Override
        public int compareTo(Time other) {
            return this.hour == other.hour
                ? this.minute - other.minute
                : this.hour - other.hour;
        }
    }

    private class Log implements Comparable<Log> {
        public String name;
        private Time time;

        public Log(String name, String time) {
            this.name = name;
            this.time = new Time(time);
        }

        @Override
        public int compareTo(Log other) {
            return this.time.compareTo(other.time);
        }
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Log[] logs = new Log[keyName.length];
        for (int i = 0; i < keyName.length; i++) {
            logs[i] = new Log(keyName[i], keyTime[i]);
        }
        Arrays.sort(logs);

        SortedSet<String> flagged = new TreeSet<String>();
        Map<String, Deque<Time>> workers = new HashMap<>();
        for (Log log : logs) {
            workers.computeIfAbsent(log.name, _ -> new ArrayDeque<>());
            Deque<Time> entries = workers.get(log.name);
            entries.addLast(log.time);
            if (entries.size() > 3) {
                entries.removeFirst();
            }
            if (entries.size() == 3) {
                Time oldest = entries.getFirst();
                Time latest = entries.getLast();
                if (latest.isWithinHour(oldest)) {
                    flagged.add(log.name);
                }
            }
        }

        List<String> result = new ArrayList<>();
        for (String name : flagged) {
            result.add(name);
        }
        return result;
    }
}
