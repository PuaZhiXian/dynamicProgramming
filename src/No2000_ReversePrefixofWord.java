public class No2000_ReversePrefixofWord {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {
        if(word.length()==1){
            return word;
        }
        int n = word.indexOf(ch);
        String result = "";
        String front = word.substring(0, n + 1);
        String back = word.substring(n + 1);
        for (int i = front.length() - 1; i >= 0; i--) {
            result += front.charAt(i);
        }
        result += back;
        return result;
    }
}
