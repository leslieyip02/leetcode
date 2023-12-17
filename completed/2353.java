import java.util.*;

class FoodRatings {

    class Food implements Comparable<Food> {
        private String name;
        private int rating;

        public Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food other) {
            return this.rating == other.rating
                ? this.name.compareTo(other.name)
                : other.rating - this.rating;
        }
    }

    private HashMap<String, String> foodToCuisine;
    private HashMap<String, Integer> foodToRating;
    private HashMap<String, TreeSet<Food>> cuisines;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foodToCuisine = new HashMap<>();
        this.foodToRating = new HashMap<>();
        this.cuisines = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            this.foodToCuisine.put(foods[i], cuisines[i]);
            this.foodToRating.put(foods[i], ratings[i]);
            if (!this.cuisines.containsKey(cuisines[i])) {
                this.cuisines.put(cuisines[i], new TreeSet<>());
            }
            TreeSet<Food> ranked = this.cuisines.get(cuisines[i]);
            ranked.add(new Food(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = this.foodToCuisine.get(food);
        Food current = new Food(food, this.foodToRating.get(food));
        TreeSet<Food> ranked = this.cuisines.get(cuisine);
        ranked.remove(current);
        ranked.add(new Food(food, newRating));
        this.foodToRating.put(food, newRating);
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> ranked = this.cuisines.get(cuisine);
        return ranked.first().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
