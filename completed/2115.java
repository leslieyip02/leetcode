class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>();
        for (String supply : supplies) {
            available.add(supply);
        }

        Queue<Integer> indices = new LinkedList<>();
        for (int i = 0; i < recipes.length; i++) {
            indices.add(i);
        }

        List<String> possible = new ArrayList<>();
        int size = -1;
        while (available.size() > size) {
            size = available.size();

            int current = indices.size();
            for (int i = 0; i < current; i++) {
                boolean ok = true;
                int index = indices.poll();
                for (String ingredient : ingredients.get(index)) {
                    if (!available.contains(ingredient)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) {
                    available.add(recipes[index]);
                    possible.add(recipes[index]);
                } else {
                    indices.add(index);
                }
            }
        }
        return possible;
    }
}
