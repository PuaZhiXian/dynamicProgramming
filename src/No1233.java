import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1233 {
    public static void main(String[] args) {
        No1233 o = new No1233();
        System.out.println(o.removeSubfolders(new String[]{"/a/b/c", "/a/b/ca", "/a/b/d"}));
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
//        System.out.println(Arrays.toString(folder));
        List<String> ans = new ArrayList<>();
        int index = 0;
        for (String str : folder) {
            boolean have = false;
            for (int i = index; i < ans.size(); i++) {
                index = i;
                if (str.startsWith(ans.get(i)) && str.charAt(ans.get(i).length()) == '/') {
                    have = true;
                    break;
                }
            }
            if (!have) {
                ans.add(str);
            }
        }


        return ans;
    }
}
