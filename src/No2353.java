import javafx.util.Pair;

import java.util.*;

public class No2353 {
    public static void main(String[] args) {
        No2353 o = new No2353();
        o.temp();
    }

    private void temp() {

        FoodRatings a = new FoodRatings(
                new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"},
                new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"},
                new int[]{2, 6, 18, 6, 5}
        );
        a.changeRating("qnvseohnoe", 11);
        System.out.println(a.highestRated("fajbervsj"));
        a.changeRating("emgqdbo", 3);
        a.changeRating("jmvfxjohq", 9);
        a.changeRating("emgqdbo", 14);
        System.out.println(a.highestRated("fajbervsj"));
        System.out.println(a.highestRated("snaxol"));
    }

    class FoodRatings {
        Map<String, Integer> foodRatingMap = new HashMap<>();
        Map<String, String> foodCuiMap = new HashMap<>();
        Map<String, TreeSet<Object[]>> cuiRank = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                foodRatingMap.put(foods[i], ratings[i]);
                foodCuiMap.put(foods[i], cuisines[i]);

                TreeSet<Object[]> treeSet = cuiRank.get(cuisines[i]);
                if (treeSet == null) {
                    treeSet = new TreeSet<>(
                            (a, b) -> {
                                int ratingA = (int) a[1];
                                int ratingB = (int) b[1];
//                                Integer.parseInt((String) b[1]);

                                if (ratingA != ratingB) {
                                    return Integer.compare(ratingB, ratingA);
                                }
                                String nameA = (String) a[0];
                                String nameB = (String) b[0];
                                return nameA.compareTo(nameB);
                            }
                    );

                }

                treeSet.add(new Object[]{foods[i], ratings[i]});
                cuiRank.put(cuisines[i], treeSet);
            }

        }

        public void changeRating(String food, int newRating) {
            Object[] objects = new Object[]{food, foodRatingMap.get(food)};
            foodRatingMap.put(food, newRating);
            String cuisine = foodCuiMap.get(food);

            TreeSet<Object[]> treeSet = cuiRank.get(cuisine);
            treeSet.remove(objects);
            treeSet.add(new Object[]{food, newRating});
        }

        public String highestRated(String cuisine) {
            for (Object[] o : cuiRank.get(cuisine)) {
                return (String) o[0];
            }
            return "";
        }
    }

}

