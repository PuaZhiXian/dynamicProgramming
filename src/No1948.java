import java.util.*;

public class No1948 {
    public static void main(String[] args) {
        No1948 o = new No1948();
//        temp.add(Arrays.asList("a"));
//        temp.add(Arrays.asList("c"));
//        temp.add(Arrays.asList("d"));
//        temp.add(Arrays.asList("a", "b"));
//        temp.add(Arrays.asList("c", "b"));
//        temp.add(Arrays.asList("d", "a"));
        /*List<List<String>> temp = new ArrayList<>();
        temp.add(Arrays.asList("a", "b"));
        temp.add(Arrays.asList("c", "d"));
        temp.add(Arrays.asList("c"));
        temp.add(Arrays.asList("a"));
        System.out.println(o.deleteDuplicateFolder(temp));*/

        List<List<String>> temp = new ArrayList<>();
        temp.add(Arrays.asList("b"));
        temp.add(Arrays.asList("f"));
        temp.add(Arrays.asList("f", "r"));
        temp.add(Arrays.asList("f", "r", "g"));
        temp.add(Arrays.asList("f", "r", "g", "c"));
        temp.add(Arrays.asList("f", "r", "g", "c", "r"));
        temp.add(Arrays.asList("f", "o"));
        temp.add(Arrays.asList("f", "o", "x"));
        temp.add(Arrays.asList("f", "o", "x", "t"));
        temp.add(Arrays.asList("f", "o", "x", "d"));
        temp.add(Arrays.asList("f", "o", "l"));
        temp.add(Arrays.asList("l"));
        temp.add(Arrays.asList("l", "q"));
        temp.add(Arrays.asList("c"));
        temp.add(Arrays.asList("h"));
        temp.add(Arrays.asList("h", "t"));
        temp.add(Arrays.asList("h", "o"));
        temp.add(Arrays.asList("h", "o", "d"));
        temp.add(Arrays.asList("h", "o", "t"));

        System.out.println(o.deleteDuplicateFolder(temp));

    }

    boolean debug = true;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        //to solve same subfolder but diff order >> eg [A][B] != [B][A]
        paths.sort(Comparator.comparing(
                list -> list,
                (a, b) -> {
                    int n = Math.min(a.size(), b.size());
                    for (int i = 0; i < n; i++) {
                        int cmp = a.get(i).compareTo(b.get(i));
                        if (cmp != 0) return cmp;
                    }
                    return Integer.compare(a.size(), b.size());
                }
        ));
        Map<String, Trie> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), genTrie(path, map.get(path.get(0))));
        }

        print(map);
        Map<String, Trie> strMap = new HashMap<>();
        for (Trie trie : map.values()) {
            removeDup(trie, strMap);
        }

        print(map.values());
        List<List<String>> ans = new ArrayList<>();

        for (Trie trie : map.values()) {
            List<List<String>> t = genAns(trie);
            if (t != null) {
                ans.addAll(t);
            }
        }

//        ans.sort(Comparator.comparing(
//                list -> list,
//                (a, b) -> {
//                    int n = Math.min(a.size(), b.size());
//                    for (int i = 0; i < n; i++) {
//                        int cmp = a.get(i).compareTo(b.get(i));
//                        if (cmp != 0) return cmp;
//                    }
//                    return Integer.compare(a.size(), b.size());
//                }
//        ));

        return ans;
    }

    private List<List<String>> genAns(Trie trie) {
        if (trie == null) {
            return null;
        }
        if (trie.isRemoved) {
            return null;
        }
        List<List<String>> children = new ArrayList<>();
        if (trie.map.isEmpty()) {
            children.add(Arrays.asList(trie.cur));
            return children;
        }

        for (Trie child : trie.map.values()) {
            List<List<String>> c = genAns(child);
            if (c != null) {
                children.addAll(c);
            }
        }

        List<List<String>> finalAns = new ArrayList<>();
        for (List<String> child : children) {
            List<String> t = new ArrayList<>();
            t.add(trie.cur);
            t.addAll(child);
            finalAns.add(t);
        }
        finalAns.add(Arrays.asList(trie.cur));


        return finalAns;
    }


    private String removeDup(Trie root, Map<String, Trie> strMap) {
        if (root == null) {
            return "";
        }
        String cur = root.cur;
        if (root.map.isEmpty()) {
            return cur;
        }
        String gen = "";

        for (Trie trie : root.map.values()) {
            gen += removeDup(trie, strMap);
        }

        if (strMap.containsKey(gen)) {
            root.isRemoved = true;
            strMap.get(gen).isRemoved = true;
        } else {
            strMap.put(gen, root);
        }

        return cur + "[" + gen + "]";
    }

    private Trie genTrie(List<String> path, Trie root) {
        if (root == null) {
            root = new Trie(path.get(0));
        }
        Trie temp = root;
        for (int i = 1; i < path.size(); i++) {
            temp = temp.add(path.get(i));
        }

        return root;
    }


    private void print(Object obj) {
        if (debug) {
            System.out.println(obj);
        }
    }

    class Trie {
        boolean isRemoved;
        String cur;
        Map<String, Trie> map;

        public Trie(String cur) {
            this.cur = cur;
            map = new HashMap<>();
        }

        public Trie add(String str) {
            if (map.containsKey(str)) {
                return map.get(str);
            }
            Trie newTrie = new Trie(str);
            map.put(str, newTrie);
            return newTrie;
        }

        @Override
        public String toString() {
            StringBuilder children = new StringBuilder();
            for (Trie trie : map.values()) {
                children.append(trie.toString());
            }
            return String.format("cur > %s , isRemoved: %s  %s", cur, isRemoved, (children.length() > 0) ? ", map : [ " + children + " ]" : "");
        }
    }
}
