import java.util.*;

public class No2115 {
    public static void main(String[] args) {
        No2115 obj = new No2115();
        System.out.println(obj.findAllRecipes(
                new String[]{"bread"},
                Collections.singletonList(Arrays.asList("yeast", "flour")),
                new String[]{"yeast", "flour", "corn"}
        ));

//        Set<String> set = new HashSet<>(Arrays.asList("yeast", "flour", "corn"));
//        List<String> lt = Arrays.asList("yeast", "flour");
//        System.out.println(set.containsAll(lt));

    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> created = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(supplies));

        for (int i = 0; i < recipes.length; i++) {
            map.put(recipes[i], ingredients.get(i));
        }

        List<String> remove = new ArrayList<>();
        Set<String> totalR = map.keySet();
        for (String s : totalR) {
            List<String> j = map.get(s);
            Set<String> miss = missing(j, set);
            for (String s2 : miss) {
                if (!totalR.contains(s2)) {
                    remove.add(s);
                    break;
                }
            }
        }

        for (String s : remove) {
            map.remove(s);
        }

        boolean createdNew = true;
        while (createdNew) {
            createdNew = false;
            remove = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (set.containsAll(entry.getValue())) {
                    set.add(entry.getKey());
                    remove.add(entry.getKey());
                    created.add(entry.getKey());
                }
            }

            if (!remove.isEmpty()) {
                for (String s : remove) {
                    map.remove(s);
                }
                createdNew = true;
            }
        }

        return created;
    }

    private Set<String> missing(List<String> in, Set<String> sup) {
        Set<String> ans = new HashSet<>();
        for (String i : in) {
            if (!sup.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}
