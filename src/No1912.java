import java.util.*;

public class No1912 {
    public static void main(String[] args) {
        No1912 o = new No1912();
        o.temp();
    }

    private void temp() {
        MovieRentingSystem o = new MovieRentingSystem(1, new int[][]{{0, 1, 3}, {0, 5, 3}, {0, 7, 3}, {0, 6, 3}, {0, 2, 3}, {0, 3, 3}, {0, 4, 3}, {0, 8, 3}});
        o.rent(0, 1);
        System.out.println(o.report());//[0,1]
        o.rent(0, 4);
        System.out.println(o.report());//[0,1],[0,4]
        o.rent(0, 3);
        System.out.println(o.report());//[0,1],[0,3],[0,4]
        o.rent(0, 2);
        o.rent(0, 6);
        o.rent(0, 7);
        System.out.println(o.report());//[0,1],[0,2],[0,3],[0,4],[0,6]
//        o.print();
    }

    class MovieRentingSystem {
        private final Set<int[]> rentSet;
        private final Map<Integer, Set<int[]>> unrentRecord = new HashMap<>();
        private final Map<Long, int[]> metaInfo = new HashMap<>();

        //shop || movie || price
        public MovieRentingSystem(int n, int[][] entries) {
            this.rentSet = constructTreeSet();
            for (int[] entry : entries) {
                int shop = entry[0];
                int movie = entry[1];
                int price = entry[2];
                long key = encode(shop, movie);
                int[] info = new int[]{shop, movie, price};

                unrentRecord.computeIfAbsent(movie, k -> constructTreeSet());
                unrentRecord.get(movie).add(info);

                metaInfo.put(key, info);
            }
        }

        private long encode(final int shop, final int movie) {
            return ((long) shop << 40) | ((long) movie << 20);
        }

        private Set<int[]> constructTreeSet() {
            return new TreeSet<>(
                    (a, b) -> {
                        int priceA = a[2];
                        int priceB = b[2];
                        if (priceA != priceB) {
                            return Integer.compare(priceA, priceB);
                        }
                        int shopA = a[0];
                        int shopB = b[0];
                        if (shopA != shopB) {
                            return Integer.compare(shopA, shopB);
                        }
                        int movieA = a[1];
                        int movieB = b[1];
                        return Integer.compare(movieA, movieB);
                    }
                    /*
                    * if (a[0] != b[0]) return a[0] - b[0]; // shop
    if (a[1] != b[1]) return a[1] - b[1]; // movie
    return a[2] - b[2];    */
            );
        }

        public List<Integer> search(int movie) {
            Set<int[]> set = unrentRecord.get(movie);
            if (set == null) {
                return new ArrayList<>();
            }

            List<Integer> ans = new ArrayList<>();
            int index = 0;
            for (int[] rent : set) {
                ans.add(rent[0]);
                index++;
                if (index == 5) {
                    break;
                }
            }
            return ans;
        }

        public void rent(int shop, int movie) {
            long key = encode(shop, movie);
            int[] info = metaInfo.get(key);

//            System.out.println("adding " + Arrays.toString(info));
            unrentRecord.get(movie).remove(info);
/*            for (int[] rent : rentSet) {
                System.out.println(Arrays.toString(rent));
            }*/
            rentSet.add(info);
        }

        public void drop(int shop, int movie) {
            long key = encode(shop, movie);
            int[] info = metaInfo.get(key);
            unrentRecord.get(movie).add(info);


            rentSet.remove(info);
        }

        //shop, movie
        public List<List<Integer>> report() {
            List<List<Integer>> ans = new ArrayList<>();
            int index = 0;
            for (int[] rent : rentSet) {
                ans.add(Arrays.asList(rent[0], rent[1]));
                index++;
                if (index == 5) {
                    break;
                }
            }
            return ans;
        }

        private void print() {
            for (int[] rent : rentSet) {
                System.out.println(Arrays.toString(rent));
            }
        }
    }
} 
