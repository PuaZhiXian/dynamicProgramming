import java.util.ArrayList;
import java.util.List;

public class No2942 {
    public static void main(String[] args) {
        No2942 obj = new No2942();

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> lt = new ArrayList<>();

        for (int j = 0; j <words.length ; j++) {
            if(words[j].contains(String.valueOf(x))){
                lt.add(j);
            }
        }

        return lt;

    }
}
