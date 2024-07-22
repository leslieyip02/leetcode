import java.util.*;

class Solution {
    private class Person implements Comparable<Person> {
        public String name;
        private int height;

        private Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

        @Override
        public int compareTo(Person other) {
            return other.height - this.height;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        Person[] people = new Person[names.length];
        for (int i = 0; i < names.length; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people);
        for (int i = 0; i < names.length; i++) {
            names[i] = people[i].name;
        }
        return names;
    }
}
