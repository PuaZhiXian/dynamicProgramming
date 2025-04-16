import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class No726 {
    public static void main(String[] args) {
        No726 obj = new No726();
//        System.out.println(obj.countOfAtoms("K4(ON(SO3)2)2)"));
//        System.out.println(obj.countOfAtoms("K4(ON(SO3)2)2)K3"));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            if(i%2==0){
                sb.append("O");
            }else{
                sb.append("H");
            }
        }
        System.out.println(sb.toString());
    }

    public String countOfAtoms(String formula) {
        Stack<Pair<String, Integer>> stack = new Stack<>();
        int l = formula.length();
        for (int i = 0; i < l; ) {
            if (formula.charAt(i) == '(') {
                stack.add(new Pair<>("(", 0));
                i++;
            } else if (formula.charAt(i) == ')') {
                i++;
                StringBuilder cnt = new StringBuilder();
                while (i < l && Character.isDigit(formula.charAt(i))) {
                    cnt.append(formula.charAt(i++));
                }
                int intCnt = cnt.toString().isEmpty() ? 1 : Integer.parseInt(cnt.toString());

                Map<String, Integer> map = new HashMap<>();
                while (!stack.isEmpty() && !stack.peek().getKey().equals("(")) {
                    Pair<String, Integer> cur = stack.pop();
                    map.put(cur.getKey(), map.getOrDefault(cur.getKey(), 0) + cur.getValue() * intCnt);
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }

                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    stack.add(new Pair<>(entry.getKey(), entry.getValue()));
                }

            } else if (Character.isUpperCase(formula.charAt(i))) {
                StringBuilder element = new StringBuilder(formula.charAt(i) + "");
                i++;
                while (i < l && Character.isLowerCase(formula.charAt(i))) {
                    element.append(formula.charAt(i++));
                }

                StringBuilder cnt = new StringBuilder();
                while (i < l && Character.isDigit(formula.charAt(i))) {
                    cnt.append(formula.charAt(i++));
                }
                int intCnt = cnt.toString().isEmpty() ? 1 : Integer.parseInt(cnt.toString());

                stack.add(new Pair<>(element.toString(), intCnt));
            }
        }

        Map<String, Integer> sortedMap = new TreeMap<>();
        while (!stack.isEmpty()) {
            Pair<String, Integer> cur = stack.pop();
            sortedMap.put(cur.getKey(), sortedMap.getOrDefault(cur.getKey(), 0) + cur.getValue());
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) {
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
