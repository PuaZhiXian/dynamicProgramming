public class No1061 {
    public static void main(String[] args) {
        No1061 obj = new No1061();


    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] parent = new int[26];
        int[] size = new int[26];
        int[] smallest = new int[26];

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
            size[i] = 1;
            smallest[i] = i;
        }

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            int root1 = find(c1[i] - 'a', parent);
            int root2 = find(c2[i] - 'a', parent);
            if (root1 != root2) {
                if (size[root2] > size[root1]) {
                    parent[root1] = root2;
                    parent[c1[i] - 'a'] = root2;
                    size[root2]++;

                    smallest[root2] = min(smallest[root1], smallest[root2], c1[i] - 'a', c2[i] - 'a');
                } else {
                    parent[root2] = root1;
                    parent[c2[i] - 'a'] = root1;
                    size[root1]++;

                    smallest[root1] = min(smallest[root1], smallest[root2], c1[i] - 'a', c2[i] - 'a');
                }
            }
        }

        StringBuilder str = new StringBuilder();
        char[] query = baseStr.toCharArray();
        for (int i = 0; i < query.length; i++) {
            int group = find(query[i] - 'a', parent);
            str.append((char) (smallest[group] + 'a'));
        }

        return str.toString();
    }

    public int find(int i, int[] parent) {
        int root = parent[i];

        if (parent[root] != root) {
            return parent[i] = find(root, parent);
        }

        return root;
    }

    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        return min;
    }
}
