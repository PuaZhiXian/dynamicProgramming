import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No386 {

    public static void main(String[] args) {
        No386 obj = new No386();
        System.out.println(obj.lexicalOrder(13));
    }

    public List<Integer> lexicalOrder(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i + 1);
        }
        Arrays.sort(arr);

        List<Integer> a = new ArrayList<>();
        for (String s: arr){
            a.add(Integer.parseInt(s));
        }

        return a;
    }

}
