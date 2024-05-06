import java.util.*;

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        HashMap<String, Long> popularity = new HashMap<>();
        HashMap<String, Integer> mostPopular = new HashMap<>();
        for (int i = 0; i < creators.length; i++) {
            if (!popularity.containsKey(creators[i])) {
                popularity.put(creators[i], (long) views[i]);
                mostPopular.put(creators[i], i);
            } else {
                popularity.put(creators[i], popularity.get(creators[i]) + views[i]);
                int j = mostPopular.get(creators[i]);
                if (views[i] > views[j] || (views[i] == views[j] && ids[i].compareTo(ids[j]) < 0)) {
                    mostPopular.put(creators[i], i);
                }
            }
        }

        long most = 0;
        List<List<String>> answer = new ArrayList<>();
        for (var entry : popularity.entrySet()) {
            if (entry.getValue() > most) {
                answer.clear();
                most = entry.getValue();
            }

            if (entry.getValue() == most) {
                String creator = entry.getKey();
                answer.add(Arrays.asList(creator, ids[mostPopular.get(creator)]));
            }
        }
        return answer;
    }
}
